package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ServicosAgendados2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicos_agendados2);

        Intent intent = getIntent();
        String profi = (String) intent.getSerializableExtra("profissao");
        String descri = (String) intent.getSerializableExtra("descricao");
        ImageView imagem = (ImageView) intent.getSerializableExtra("imagem");


        TextView profissao = (TextView)findViewById(R.id.txtServicosAgendados2Profissao);
        TextView descricao = (TextView)findViewById(R.id.txtServicosAgendados2Descricao);
        ImageView imageView = (ImageView)findViewById(R.id.imageServicosAgendados2);



        profissao.setText(profi);
        descricao.setText(descri);




    }
}
