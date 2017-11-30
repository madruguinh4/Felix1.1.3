package tcc.usjt.felix113.View.ViewProfissional;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.R;


public class TelaCadastroProfissional extends AppCompatActivity {
    ProgressDialog dialog;
    String name, lastname, phone, mail, key, keyconfirme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_profissional);

        final EditText nomeprof = (EditText) findViewById(R.id.editCadProfNome);
        final EditText sobrenomeprof = (EditText) findViewById(R.id.editCadProfSobrenome);
        final EditText emailprof = (EditText) findViewById(R.id.editCadProfEmail);
        final EditText telefoneprof = (EditText) findViewById(R.id.editCadProfTelefone);
        final EditText senhaprof = (EditText) findViewById(R.id.editCadProfSenha);
        final EditText confirmeSenhaprof = (EditText) findViewById(R.id.editCadProfConfirmeSenha);
        Button btnCadastrar = (Button) findViewById(R.id.btnCadProfCdastar);


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new ProgressDialog(TelaCadastroProfissional.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();

                final Profissional profissional = new Profissional();

                profissional.setNome(nomeprof.getText().toString());
                profissional.setSobrenome(sobrenomeprof.getText().toString());
                profissional.setEmail(emailprof.getText().toString());
                profissional.setTelefone(telefoneprof.getText().toString());
                profissional.setSenha(senhaprof.getText().toString());


                name = nomeprof.getText().toString();
                lastname = sobrenomeprof.getText().toString();
                mail = emailprof.getText().toString();
                phone = telefoneprof.getText().toString();
                key = senhaprof.getText().toString();
                keyconfirme = confirmeSenhaprof.getText().toString();

                if (validaLogin(name, lastname,mail, phone, key, keyconfirme)) {
                    cadastro(profissional);
                }

            }
        });
    }

    private boolean validaLogin(String name, String lastname, String mail, String phone, String key, String keyconfirme) {
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
        if (phone == null || phone.trim().length() == 0) {
            Toast.makeText(this, "O campo TELEFONE não pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (key == null || key.trim().length() == 0) {
            Toast.makeText(this, "O campo SENHA não pode estar vazio", Toast.LENGTH_SHORT).show();
            dialog.cancel();

            return false;
        }
        if (keyconfirme == null || keyconfirme.trim().length() == 0) {
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


    private void cadastro(Profissional profissional) {
        try {
            APICaller apiCaller = new APICaller();
            boolean call = apiCaller.call(profissional);
            if (call) {
                dialog.cancel();
                Intent intent = new Intent(TelaCadastroProfissional.this, TelaLoginProfissional.class);
                startActivity(intent);
            } else {
                System.out.println("not success");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}