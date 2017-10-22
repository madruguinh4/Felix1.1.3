package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import tcc.usjt.felix113.R;

public class TelaFinalizandoCadastroProfissional extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_finalizando_cadastro_profissional);

        TextView nome, email, telefone, sobrenome, servico, categoria;

//recebendo dados de outra tela
        Intent intent = getIntent();
        String nomerecebe = (String)intent.getSerializableExtra("nome");
        String sobrenomerecebe = (String)intent.getSerializableExtra("sobrenome");
        String emailrecebe = (String)intent.getSerializableExtra("email");
        String telefonerecebe = (String)intent.getSerializableExtra("telefone");
        String senharecebe = (String)intent.getSerializableExtra("senha");
        String confirmesenharecebe = (String)intent.getSerializableExtra("confirmesenha");
        String fotografiarecebe = (String)intent.getSerializableExtra("fotografia");
        String servicorecebe = (String)intent.getSerializableExtra("servico");


        nome = (TextView)findViewById(R.id.textViewFinalizaCadastroProfissional1);
        sobrenome =(TextView)findViewById(R.id.textViewFinalizaCadastroProfissional2);
        email =(TextView)findViewById(R.id.textViewFinalizaCadastroProfissional3);
        telefone =(TextView)findViewById(R.id.textViewFinalizaCadastroProfissional4);
        servico = (TextView)findViewById(R.id.textViewCadastroServico);
        categoria = (TextView)findViewById(R.id.textViewCadastrocategoria);



        nome.setText(nomerecebe);
        sobrenome.setText(sobrenomerecebe);
        email.setText(emailrecebe);
        telefone.setText(telefonerecebe);
        servico.setText(servicorecebe);
        categoria.setText(fotografiarecebe);
    }
}
