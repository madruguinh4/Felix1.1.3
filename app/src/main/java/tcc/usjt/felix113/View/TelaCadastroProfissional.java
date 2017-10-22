package tcc.usjt.felix113.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.ViewProfissional.TelaCadastrarServicos;


public class TelaCadastroProfissional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_profissional);

        final EditText nome = (EditText)findViewById(R.id.editCadNome);
        final EditText sobrenome = (EditText)findViewById(R.id.editCadProfSobrenome);
        final EditText email = (EditText)findViewById(R.id.editCadEmail);
        final EditText telefone = (EditText)findViewById(R.id.editCadTelefone);
        final EditText senha = (EditText)findViewById(R.id.editCadSenha);
        final EditText confirmeSenha = (EditText)findViewById(R.id.editCadConfirmeSenha);
        Button btnCadastrar = (Button)findViewById(R.id.btnCadCdastar);



        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastroProfissional.this, TelaCadastrarServicos.class);
                intent.putExtra("nome", nome.getText().toString());
                intent.putExtra("sobrenome", sobrenome.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("telefone", telefone.getText().toString());
                intent.putExtra("senha", senha.getText().toString());
                intent.putExtra("confirmesenha", confirmeSenha.getText().toString());
                startActivity(intent);
            }
        });
    }
}
