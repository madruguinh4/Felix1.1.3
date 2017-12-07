package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import tcc.usjt.felix113.R;

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


        TextView profissao = (TextView)findViewById(R.id.txtContrataProfissionalProfissao);
        TextView descricao = (TextView)findViewById(R.id.txtContrataProfissionalDescricao);
        ImageView imageView = (ImageView)findViewById(R.id.imageTelaContrataPofissional);



        profissao.setText(profi);
        descricao.setText(descri);

        btn = (Button)findViewById(R.id.buttonContrataProfissional);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TelaContrataProfissional.this, TelaCliente.class );
                startActivity(intent);
            }
        });
    }
}
