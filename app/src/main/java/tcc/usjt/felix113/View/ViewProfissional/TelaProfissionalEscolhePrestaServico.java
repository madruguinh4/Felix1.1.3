package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tcc.usjt.felix113.R;

public class TelaProfissionalEscolhePrestaServico extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_escolhe_presta_servico);


        TextView nome = (TextView)findViewById(R.id.textView5);
        TextView telefone = (TextView)findViewById(R.id.textView8);

        Button btnSim = (Button)findViewById(R.id.bntSim);
        Button btnNao = (Button)findViewById(R.id.btnNao);


        final Intent intent = getIntent();
        final String name = (String)intent.getSerializableExtra("nome");
        final String phone = (String)intent.getSerializableExtra("telefone");

        nome.setText(name);
        telefone.setText(phone);

        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TelaProfissionalEscolhePrestaServico.this, TelaProfissional.class);
                startActivity(intent);
            }
        });
        btnNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (TelaProfissionalEscolhePrestaServico.this, TelaProfissional.class);
                startActivity(intent);
            }
        });
    }
}
