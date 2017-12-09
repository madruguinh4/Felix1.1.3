package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import tcc.usjt.felix113.View.ViewCliente.TelaLogin;

public class SelecaoTipoLogin extends AppCompatActivity {

    ImageView cliente, profissional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecao_de_tipo_login);



        cliente = (ImageView)findViewById(R.id.imageViewCliente);
        profissional=(ImageView)findViewById(R.id.imageViewProfissional);


        cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelecaoTipoLogin.this, TelaLogin.class);
                startActivity(intent);
            }
        });

        profissional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelecaoTipoLogin.this, TelaLoginProfissional.class);
                startActivity(intent);

            }
        });

    }
}
