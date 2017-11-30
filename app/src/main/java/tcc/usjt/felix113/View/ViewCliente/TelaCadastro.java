package tcc.usjt.felix113.View.ViewCliente;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import tcc.usjt.felix113.Model.Cliente;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.TelaLogin;

public class TelaCadastro extends AppCompatActivity {

    ProgressDialog dialog;
    String name, lastname, phone, mail, key, keyconfirme;


    public TelaCadastro() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        final EditText nome = (EditText)findViewById(R.id.editCadNome);
        final EditText sobrenome = (EditText) findViewById(R.id.editCadSobrenome);
        final EditText email = (EditText) findViewById(R.id.editCadEmail);
        final EditText telefone = (EditText) findViewById(R.id.editCadTelefone);
        final EditText senha = (EditText) findViewById(R.id.editCadSenha);
        final EditText confirmSenha = (EditText) findViewById(R.id.editCadConfirmeSenha);
        Button btnCadastrar = (Button) findViewById(R.id.btnCadCdastar);


//evento para adicionar novos usuarios a tabela de usuarios
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(TelaCadastro.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();

                final Cliente cliente = new Cliente();

                cliente.setNome(nome.getText().toString());
                cliente.setSobrenome(sobrenome.getText().toString());
                cliente.setEmail(email.getText().toString());
                cliente.setTelefone(telefone.getText().toString());
                cliente.setSenha(senha.getText().toString());

                //
                name = nome.getText().toString();
                lastname = sobrenome.getText().toString();
                mail = email.getText().toString();
                phone = telefone.getText().toString();
                key = senha.getText().toString();
                keyconfirme= confirmSenha.getText().toString();

              if (validaLogin(name, lastname,mail, phone, key, keyconfirme)) {
                    cadastro(cliente);
                }
            }
        });


    }


    private boolean validaLogin(String name, String lastname,String mail, String phone, String key, String keyconfirme) {
        if (name == null || name.trim().length() == 0) {
            Toast.makeText(this, "O campo NOME não pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (lastname == null || lastname.trim().length() == 0) {
            Toast.makeText(this, "O campo SOBRENOMEnão pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (mail == null || mail.trim().length() == 0) {
            Toast.makeText(this, "O campo E-MAIL não pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (phone== null || phone.trim().length() == 0) {
            Toast.makeText(this, "O campo TELEFONE não pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (key== null || key.trim().length() == 0) {
            Toast.makeText(this, "O campo SENHA não pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (keyconfirme== null || keyconfirme.trim().length() == 0 ) {
            Toast.makeText(this, "O campo CONFIRME SENHA não pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (!keyconfirme.equals(key)) {
            Toast.makeText(this, "O campo SENHA e CONFIRME SENHA não são iguais", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }


        return true;
    }

    private void cadastro(Cliente cliente) {
            try {
            APICaller apiCaller = new APICaller();
            boolean call = apiCaller.call(cliente);
            if (call) {
                dialog.cancel();
                Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
                startActivity(intent);
            } else {
                System.out.println("not success");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}




