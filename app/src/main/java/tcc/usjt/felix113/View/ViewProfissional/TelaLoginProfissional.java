package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.Present.Usuario;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.SelecaoDeTipoDeCadastro;

import static tcc.usjt.felix113.R.layout.tela_login;

public class TelaLoginProfissional extends AppCompatActivity {



    EditText editEmail, editSenha;
    Button btnLogin;
    TextView txtCadastroprof;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tela_login);


        editEmail = (EditText) findViewById(R.id.ediEmail1prof);
        editSenha = (EditText) findViewById(R.id.editSenha1prof);
        btnLogin = (Button)findViewById(R.id.btnLoginprof);
        txtCadastroprof =(TextView) findViewById(R.id.txtCadastroprof);



        txtCadastroprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent abrirTelaSelecaoCadastro = new Intent(TelaLoginProfissional.this, SelecaoDeTipoDeCadastro.class);
                startActivity(abrirTelaSelecaoCadastro);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setSenha(senha);

                if(validaLogin(email,senha)){
                    login(email,senha);
                }
            }
        });

    }
    private boolean validaLogin(String email, String senha){
        if(email == null || email.trim().length() == 0){
            Toast.makeText(this, "O campo email não pode estar vazio", Toast.LENGTH_SHORT).show();
            return  false;
        }
        if(senha == null || senha.trim().length() == 0){
            Toast.makeText(this, "O campo senha não pode estar vazio", Toast.LENGTH_SHORT).show();
            return  false;
        }

        return true;
    }

    private void login(String email, String senha){
        try {
            APICaller apiCaller = new APICaller();
            Profissional profissional = apiCaller.call(email, senha);
            if(profissional != null){
                SharedPreferences sp = getSharedPreferences("profissional", 0);
                SharedPreferences.Editor ed = sp.edit();
                ed.putLong("id", profissional.getId());
                ed.commit();
                Intent intent = new Intent(TelaLoginProfissional.this,TelaProfissional.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }





}
