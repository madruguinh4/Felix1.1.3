package tcc.usjt.felix113;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tcc.usjt.felix113.Present.Usuario;
import tcc.usjt.felix113.View.ViewCliente.TelaCliente;

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


                            Intent voltaTelaIncial = new Intent(TelaCadastro.this, TelaCliente.class);
                            startActivity(voltaTelaIncial);



            }
        });

    }

}




