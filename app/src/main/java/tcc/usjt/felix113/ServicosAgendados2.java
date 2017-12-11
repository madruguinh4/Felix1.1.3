package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import tcc.usjt.felix113.View.ViewCliente.TelaCliente;

public class ServicosAgendados2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicos_agendados2);

        Intent intent = getIntent();
        String profi = (String) intent.getSerializableExtra("profissao");
        String descri = (String) intent.getSerializableExtra("descricao");
        ImageView imagem = (ImageView) intent.getSerializableExtra("imagem");
        Button btn = (Button)findViewById(R.id.button);

        TextView profissao = (TextView)findViewById(R.id.txtServicosAgendados2Profissao);
        TextView descricao = (TextView)findViewById(R.id.txtServicosAgendados2Descricao);
        ImageView imageView = (ImageView)findViewById(R.id.imageServicosAgendados2);



        profissao.setText(profi);
        descricao.setText(descri);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicosAgendados2.this,TelaCliente.class);
                startActivity(intent);
            }
        });




    }
}
