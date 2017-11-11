package tcc.usjt.felix113.View.ViewProfissional;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tcc.usjt.felix113.Present.UsuarioProfissional;
import tcc.usjt.felix113.R;

public class TelaFinalizandoCadastroProfissional extends AppCompatActivity {

    ProgressDialog dialog;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_finalizando_cadastro_profissional);

        TextView servico, categoria;


       final Intent intent = getIntent();
       final String Sub = (String)intent.getSerializableExtra("subCategoria");
       final String Categoria = (String)intent.getSerializableExtra("Categoria");

        servico = (TextView)findViewById(R.id.textViewCadastroServico);
        categoria = (TextView)findViewById(R.id.textViewCadastrocategoria);
        Button btn = (Button)findViewById(R.id.btnCadastrarFinalProfissional);

         servico.setText(Sub);
         categoria.setText(Categoria);



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



                        Intent intent = new Intent(TelaFinalizandoCadastroProfissional.this, TelaProfissional.class);
                        startActivity(intent);


            }
        });
    }
}

