package tcc.usjt.felix113.View.ViewProfissional;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.usjt.felix113.Model.CadastraProfissionalRest;
import tcc.usjt.felix113.Present.UsuarioProfissional;
import tcc.usjt.felix113.R;

public class TelaFinalizandoCadastroProfissional extends AppCompatActivity {

    ProgressDialog dialog;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_finalizando_cadastro_profissional);

        TextView nome, email, telefone, sobrenome, servico, categoria;

//recebendo dados de outra tela
  //     final Intent intent = getIntent();
  //     final String nomerecebe = (String)intent.getSerializableExtra("nome");
  //   final String sobrenomerecebe = (String)intent.getSerializableExtra("sobrenome");
  //      final String emailrecebe = (String)intent.getSerializableExtra("email");
  //      final String telefonerecebe = (String)intent.getSerializableExtra("telefone");
  //      final String senharecebe = (String)intent.getSerializableExtra("senha");
  //     final String confirmesenharecebe = (String)intent.getSerializableExtra("confirmesenha");
  //      final String fotografiarecebe = (String)intent.getSerializableExtra("fotografia");
   //     String servicorecebe = (String)intent.getSerializableExtra("servico");


      //  nome = (TextView)findViewById(R.id.textViewFinalizaCadastroProfissional1);
     //   sobrenome =(TextView)findViewById(R.id.textViewFinalizaCadastroProfissional2);
     //   email =(TextView)findViewById(R.id.textViewFinalizaCadastroProfissional3);
    //    telefone =(TextView)findViewById(R.id.textViewFinalizaCadastroProfissional4);
        servico = (TextView)findViewById(R.id.textViewCadastroServico);
        categoria = (TextView)findViewById(R.id.textViewCadastrocategoria);
        Button btn = (Button)findViewById(R.id.btnCadastrarFinalProfissional);



     //   nome.setText(nomerecebe);
  //      sobrenome.setText(sobrenomerecebe);
  //      email.setText(emailrecebe);
   //     telefone.setText(telefonerecebe);
   //     servico.setText(servicorecebe);
  //      categoria.setText(fotografiarecebe);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(TelaFinalizandoCadastroProfissional.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();
                UsuarioProfissional usuarioProfissional = new UsuarioProfissional();
       //         usuarioProfissional.setNome(nomerecebe);
        //        usuarioProfissional.setSobrenome(sobrenomerecebe);
       //         usuarioProfissional.setEmail(emailrecebe);
       //         usuarioProfissional.setTelefone(telefonerecebe);
        //        usuarioProfissional.setSenha(senharecebe);
            //    usuarioProfissional.setConfirmeSenha(confirmesenharecebe);
             //   usuarioProfissional.setFotografia(fotografiarecebe);


                CadastraProfissionalRest  cadastroProfissionalRest = CadastraProfissionalRest.retrofit.create(CadastraProfissionalRest.class);
                final Call<Void> call = cadastroProfissionalRest.inserePessoa(usuarioProfissional);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (dialog.isShowing())
                            dialog.dismiss();

                        Toast.makeText(getBaseContext(), "Usuario Cadastro com Sucesso", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TelaFinalizandoCadastroProfissional.this, TelaProfissional.class);
                        startActivity(intent);



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

