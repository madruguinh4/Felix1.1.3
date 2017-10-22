package tcc.usjt.felix113;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.usjt.felix113.Model.CadastroPessoasRest;
import tcc.usjt.felix113.Present.Usuario;

public class TelaCadastro extends AppCompatActivity {

    ProgressDialog dialog;

    public TelaCadastro() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);


        final EditText nome = (EditText)findViewById(R.id.editCadNome);
        final EditText sobrenome = (EditText)findViewById(R.id.editCadSobrenome);
        final EditText email = (EditText)findViewById(R.id.editCadEmail);
        final EditText telefone = (EditText)findViewById(R.id.editCadTelefone);
        final EditText senha = (EditText)findViewById(R.id.editCadSenha);
        final EditText confirmeSenha = (EditText)findViewById(R.id.editCadConfirmeSenha);
        Button btnCadastrar = (Button)findViewById(R.id.btnCadCdastar);

   //     final RadioButton rdCadCliente = (RadioButton)findViewById(R.id.rdCadCliente);
        // rdCadProfssional = (RadioButton) findViewById(R.id.rdCadProfissional);
  //      final RadioButton rdCadProfissional  = (RadioButton)findViewById(R.id.rdCadProfissional);




//evento para adicionar novos usuarios a tabela de usuarios
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(TelaCadastro.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();
                Usuario usuario = new Usuario();
                usuario.setNome(nome.getText().toString());
                usuario.setSobrenome(sobrenome.getText().toString());
                usuario.setEmail(email.getText().toString());
                usuario.setTelefone(telefone.getText().toString());
                usuario.setSenha(senha.getText().toString());
                usuario.setConfirmeSenha(confirmeSenha.getText().toString());
/*
                if (rdCadCliente.isChecked()) {
                    int aux =1;
                    usuario.setTipoUsuario(aux);

                }else{
                    if(rdCadProfissional.isChecked()){
                        int aux=0;
                        usuario.setTipoUsuario(aux);
                    }
                }
*/
                CadastroPessoasRest cadastroPessoaRest = CadastroPessoasRest.retrofit.create(CadastroPessoasRest.class);
                final Call<Void> call = cadastroPessoaRest.inserePessoa(usuario);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (dialog.isShowing())
                            dialog.dismiss();

                            Toast.makeText(getBaseContext(), "Usuario Cadastro com Sucesso", Toast.LENGTH_SHORT).show();
                            Intent voltaTelaIncial = new Intent(TelaCadastro.this, TelaLogin.class);
                            startActivity(voltaTelaIncial);


                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {

                        if (dialog.isShowing())
                            dialog.dismiss();
                        Toast.makeText(getBaseContext(), "Não foi possível fazer a conexão", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

       /* btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdCadCliente.isChecked()) {
                Usuario uri = new Usuario();
                usuario.setTipoUsuario(Boolean.parseBoolean(String.valueOf(((RadioButton) rdCadCliente).isChecked())));
                    Intent abrirTelaPrincipalCliente = new Intent(TelaCadastro.this, TelaCliente.class);
                    startActivity(abrirTelaPrincipalCliente);
                }
                if (rdCadProfssional.isChecked()) {
                    Intent abrirTelaPrincipalCliente = new Intent(TelaCadastro.this, TelaProfissional.class);
                    startActivity(abrirTelaPrincipalCliente);
                }
            }

        }); */


    }

}




