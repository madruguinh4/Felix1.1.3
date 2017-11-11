package tcc.usjt.felix113.View;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.R;


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

                Profissional profissional = new Profissional();

                profissional.setNome(nomeprof.getText().toString());
                profissional.setSobrenome(sobrenomeprof.getText().toString());
                profissional.setEmail(emailprof.getText().toString());
                profissional.setTelefone(telefoneprof.getText().toString());
                profissional.setSenha(senhaprof.getText().toString());

                makeRequest(profissional);

//                Intent voltaTelaIncial = new Intent(TelaCadastroProfissional.this, TelaCadastrarServicos.class);
//                startActivity(voltaTelaIncial);



            }
        });
    }

    public void makeRequest(Profissional profissional) {
        HttpURLConnection httpcon;
        ArrayList<String> result = null;
        try {

            httpcon = (HttpURLConnection) ((new URL("http://localhost:8888/api/profissional/").openConnection()));
            httpcon.setDoOutput(false);
            httpcon.setRequestMethod("POST");
            httpcon.setRequestProperty("Content-Type","application/json");

            ObjectMapper objectMapper = new ObjectMapper();
            String aux = objectMapper.writeValueAsString(profissional);
            byte[] outputInBytes = aux.getBytes("UTF-8");
            OutputStream os = httpcon.getOutputStream();
            os.write(outputInBytes);
            os.close();
            httpcon.connect();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
