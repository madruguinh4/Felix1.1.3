package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import tcc.usjt.felix113.R;

public class TelaCadastrarServicos extends AppCompatActivity {

    private ImageView carro, casa, aprendizado, pessoal, tecnologia, pet, saude, fotografia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_cadastrar_servicos);



        carro = (ImageView)findViewById(R.id.imageViewTelaClienteCarro);
        casa = (ImageView)findViewById(R.id.imageViewTelaCLienteCasa);
        aprendizado = (ImageView)findViewById(R.id.imageViewTelaClienteCurso);
        pessoal = (ImageView)findViewById(R.id.imageViewTelaClientePessoal);
        tecnologia = (ImageView)findViewById(R.id.imageViewTelaClienteTecnologia);
        pet = (ImageView)findViewById(R.id.imageViewTelaClientePet);
        saude = (ImageView)findViewById(R.id.imageViewTelaClienteSaude);
        fotografia = (ImageView)findViewById(R.id.imageViewTelaClienteFotografia);

//recebendo dados atravez de intent para poder finalizar o cadastro do profissional


        Intent intent = getIntent();
        final String nomerecebe = (String)intent.getSerializableExtra("nome");
        final String sobrenomerecebe = (String)intent.getSerializableExtra("sobrenome");
        final String emailrecebe = (String)intent.getSerializableExtra("email");
        final String telefonerecebe = (String)intent.getSerializableExtra("telefone");
        final String senharecebe = (String)intent.getSerializableExtra("senha");
        final String confirmesenharecebe = (String)intent.getSerializableExtra("confirmesenha");




        carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfssionalCadastraVeiculos.class);
                startActivity(intent);


            }
        });
        casa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfissionalCadastraCasa.class);
                startActivity(intent);


            }
        });
        aprendizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfissionalCadastraCursos.class);
                startActivity(intent);


            }
        });
        pessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfissionalCadastraPessoal.class);
                startActivity(intent);


            }
        });
        tecnologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfissionalCadastraTecnologia.class);
                startActivity(intent);


            }
        });
        pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfissionalCadastraPet.class);
                startActivity(intent);


            }
        });
        saude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfissionalCadastraSaude.class);
                startActivity(intent);


            }
        });
        fotografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCadastrarServicos.this, TelaProfissionalCadastraFotografia.class);

                String fot = "Fotografia";

                intent = intent.putExtra("nome", nomerecebe);
                intent = intent.putExtra("sobrenome", sobrenomerecebe);
                intent = intent.putExtra("email", emailrecebe);
                intent = intent.putExtra("telefone", telefonerecebe);
                intent = intent.putExtra("senha", senharecebe);
                intent = intent.putExtra("confirmesenha", confirmesenharecebe);
                intent = intent.putExtra("fotografia", fot);


                startActivity(intent);


            }
        });

    }


}
