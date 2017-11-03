package tcc.usjt.felix113.View;

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
import tcc.usjt.felix113.Present.UsuarioProfissional;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.ViewProfissional.TelaCadastrarServicos;
import tcc.usjt.felix113.Model.CadastraProfissionalRest;



public class TelaCadastroProfissional extends AppCompatActivity {
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_profissional);

        final EditText nomeprof = (EditText)findViewById(R.id.editCadProfNome);
        final EditText sobrenomeprof = (EditText)findViewById(R.id.editCadProfSobrenome);
        final EditText emailprof = (EditText)findViewById(R.id.editCadProfEmail);
        final EditText telefoneprof = (EditText)findViewById(R.id.editCadProfTelefone);
        final EditText senhaprof = (EditText)findViewById(R.id.editCadProfSenha);
        final EditText confirmeSenhaprof = (EditText)findViewById(R.id.editCadProfConfirmeSenha);
        Button btnCadastrar = (Button)findViewById(R.id.btnCadProfCdastar);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            //    Intent intent = new Intent(TelaCadastroProfissional.this, TelaCadastrarServicos.class);
                  /*
                intent.putExtra("nome", nome.getText().toString());
                intent.putExtra("sobrenome", sobrenome.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("telefone", telefone.getText().toString());
                intent.putExtra("senha", senha.getText().toString());
                intent.putExtra("confirmesenha", confirmeSenha.getText().toString());
                */

                dialog = new ProgressDialog(TelaCadastroProfissional.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();

                UsuarioProfissional usuarioProfissional = new UsuarioProfissional();

                usuarioProfissional.setNome(nomeprof.getText().toString());
                usuarioProfissional.setSobrenome(sobrenomeprof.getText().toString());
                usuarioProfissional.setEmail(emailprof.getText().toString());
                usuarioProfissional.setTelefone(telefoneprof.getText().toString());
                usuarioProfissional.setSenha(senhaprof.getText().toString());


                CadastraProfissionalRest cadastroProfissionalRest = CadastraProfissionalRest.retrofit.create(CadastraProfissionalRest.class);
                final Call<Void> call = cadastroProfissionalRest.inserePessoa(usuarioProfissional);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (dialog.isShowing())
                            dialog.dismiss();

                        Toast.makeText(getBaseContext(), "Usuario Cadastro com Sucesso", Toast.LENGTH_SHORT).show();
                        Intent voltaTelaIncial = new Intent(TelaCadastroProfissional.this, TelaCadastrarServicos.class);
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
    }
}
