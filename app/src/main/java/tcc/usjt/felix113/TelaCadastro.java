package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class TelaCadastro extends AppCompatActivity {

    EditText editNome;
    EditText editSobrenome;
    EditText editEmail;
    EditText editTelefone;
    EditText editSenha;
    EditText editConfirmeSenha;
    Button btnCadastrar;
    RadioButton rdCadCliente;
    RadioButton rdCadProfssional;
    CompoundButton radioGroup1;

    public TelaCadastro() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        editNome = (EditText) findViewById(R.id.editCadNome);
        editSobrenome = (EditText) findViewById(R.id.editCadSobrenome);
        editEmail = (EditText) findViewById(R.id.editCadEmail);
        editTelefone = (EditText) findViewById(R.id.editCadTelefone);
        editSenha = (EditText) findViewById(R.id.editCadSenha);
        editConfirmeSenha = (EditText) findViewById(R.id.editCadConfirmeSenha);
        btnCadastrar = (Button) findViewById(R.id.btnCadCdastar);
        rdCadCliente = (RadioButton) findViewById(R.id.rdCadCliente);
        rdCadProfssional = (RadioButton) findViewById(R.id.rdCadProfissional);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rdCadCliente.isChecked()) {
                        Intent abrirTelaPrincipalCliente = new Intent(TelaCadastro.this, TelaCliente.class);
                        startActivity(abrirTelaPrincipalCliente);
                }if(rdCadProfssional.isChecked()){
                    Intent abrirTelaPrincipalCliente = new Intent(TelaCadastro.this, TelaProfissional.class);
                    startActivity(abrirTelaPrincipalCliente);
                }
            }

        });

    }
//
 //   spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
   //     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
   //         if (position == 0)
  //              spinner2.setEnabled(false);
    //        else
      //          spinner2.setEnabled(true);
       // }


   // public void onNothingSelected(AdapterView<?> parent) {

  //  }
//});



}
