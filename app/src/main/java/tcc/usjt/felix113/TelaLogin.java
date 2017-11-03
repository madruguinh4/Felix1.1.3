package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.usjt.felix113.View.ViewCliente.TelaCliente;

import tcc.usjt.felix113.View.SelecaoDeTipoDeCadastro;
import tcc.usjt.felix113.Present.Usuario;
import tcc.usjt.felix113.Model.ValidaUsuario;


import static tcc.usjt.felix113.R.layout.tela_login;

public class TelaLogin extends AppCompatActivity {



    EditText editEmail, editSenha;
    Button btnLogin;
    TextView txtCadastro, txtEsqueci;
    String nome, senha;
    ValidaUsuario validaUsuario;


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

                Intent abrirTelaSelecaoCadastro = new Intent(TelaLogin.this, SelecaoDeTipoDeCadastro.class);
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

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                Usuario usuario = new Usuario();
                usuario.setEmail(email);
                usuario.setSenha(senha);

                Toast.makeText(TelaLogin.this, "Voce esta aqui" +usuario.getEmail()+usuario.getSenha(), Toast.LENGTH_SHORT).show();

                if(validaLogin(email,senha)){
                    dbLogin(email,senha);
                }
            }
        });

    }
    private boolean validaLogin(String email, String senha){
        if(email == null || email.trim().length() == 0){
            Toast.makeText(this, "O campo email não pode estar vazio", Toast.LENGTH_SHORT).show();
            return  false;
        }

        return true;
    }

    private void dbLogin(final String email, final String senha){

        try {
            Call<Usuario>call= validaUsuario.validaemailsenha(email, senha);
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    if (response.isSuccessful()) {
                        Usuario usuario = response.body();
                        if (usuario.getEmail().equals(2)) {
                            Toast.makeText(TelaLogin.this, "E-mail correto", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(TelaLogin.this, "Erro tente novamentte ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    Toast.makeText(TelaLogin.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
