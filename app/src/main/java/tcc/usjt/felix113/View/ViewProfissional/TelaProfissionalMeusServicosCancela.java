package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tcc.usjt.felix113.R;

public class TelaProfissionalMeusServicosCancela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_meus_servicos_cancela);


        TextView servico = (TextView)findViewById(R.id.txtServico);
        Button btn = (Button)findViewById(R.id.button2);

        final Intent intent = getIntent();
        final String service = (String)intent.getSerializableExtra("subCategoria");
          servico.setText(service);


          btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent =new Intent(TelaProfissionalMeusServicosCancela.this, TelaProfissional.class );
                  startActivity(intent);
              }
          });
    }
}
