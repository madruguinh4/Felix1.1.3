package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import tcc.usjt.felix113.Model.ServicoContratado;
import tcc.usjt.felix113.Model.Status;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.APIServicoCaller;

public class TelaContrataProfissional extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_contrata_profissional);

        Intent intent = getIntent();
        String profi = (String) intent.getSerializableExtra("profissao");
        String descri = (String) intent.getSerializableExtra("descricao");
        ImageView imagem = (ImageView) intent.getSerializableExtra("imagem");
        final Long idProfissional = (Long)intent.getSerializableExtra("id");
        final String categoria = (String)intent.getSerializableExtra("categoria");

        TextView profissao = (TextView)findViewById(R.id.txtContrataProfissionalProfissao);
        TextView descricao = (TextView)findViewById(R.id.txtContrataProfissionalDescricao);
        ImageView imageView = (ImageView)findViewById(R.id.imageTelaContrataPofissional);



        profissao.setText(profi);
        descricao.setText(descri);

        btn = (Button)findViewById(R.id.buttonContrataProfissional);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ServicoContratado servicoContratado = new ServicoContratado();
                servicoContratado.setIdProfissional(idProfissional);
                servicoContratado.setStatus(Status.AGENDADO.value());
                servicoContratado.setSubcategoria(categoria);

                SharedPreferences pref = getSharedPreferences("cliente", 0);
                long id = pref.getLong("id", 0L);
                servicoContratado.setIdCliente(id);
                if(create(servicoContratado)) {
                    Intent intent = new Intent(TelaContrataProfissional.this, TelaCliente.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(TelaContrataProfissional.this, "Erro", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public boolean create(ServicoContratado servicoContratado){
        APIServicoCaller api = new APIServicoCaller();
        try {
            boolean call = api.call(servicoContratado);
            return call;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
