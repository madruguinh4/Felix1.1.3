package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import tcc.usjt.felix113.R;

public class TelaCadastrarServicos extends AppCompatActivity {

    private ImageView carro, casa, aprendizado, pessoal, tecnologia, pet, saude ;

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


    }

}
