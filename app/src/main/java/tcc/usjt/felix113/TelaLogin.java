package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tcc.usjt.felix113.View.ViewCliente.TelaCliente;

import static tcc.usjt.felix113.R.layout.tela_login;

public class TelaLogin extends AppCompatActivity {



    EditText editEmail, editSenha;
    Button btnLogin;
    TextView txtCadastro, txtEsqueci;
    String nome, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tela_login);


        editEmail = (EditText) findViewById(R.id.ediEmail1);
        editSenha = (EditText) findViewById(R.id.editSenha1);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtCadastro = (TextView) findViewById(R.id.txtCadastro);
        txtEsqueci = (TextView)findViewById(R.id.textView2);



        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirTelaSelecaoCadastro = new Intent(TelaLogin.this, TelaCadastro.class);
                startActivity(abrirTelaSelecaoCadastro);
            }
        });


        txtEsqueci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaLogin.this, TelaCliente.class);
                startActivity(intent);
            }
        });


    }


}
