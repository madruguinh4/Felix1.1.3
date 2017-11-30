package tcc.usjt.felix113.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.ViewCliente.TelaCadastro;
import tcc.usjt.felix113.View.ViewProfissional.TelaCadastroProfissional;

public class SelecaoDeTipoDeCadastro extends AppCompatActivity {

    ImageView cliente, profissional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecao_de_tipo_de_cadastro);



        cliente = (ImageView)findViewById(R.id.imageViewCliente);
        profissional=(ImageView)findViewById(R.id.imageViewProfissional);


        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelecaoDeTipoDeCadastro.this, TelaCadastro.class);
                startActivity(intent);
            }
        });

        profissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelecaoDeTipoDeCadastro.this, TelaCadastroProfissional.class);
                startActivity(intent);

            }
        });

    }
}
