package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;

import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.APIServicoCaller;

public class TelaAvaliaServico extends AppCompatActivity {
    RatingBar rb ;
    TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_avalia_servico);
        Intent intent = getIntent();
        final Long id = (Long) intent.getSerializableExtra("id");


        Button button = (Button)findViewById(R.id.btnTelaAvaliaServicoSalvar);

        rb=  (RatingBar)findViewById(R.id.rdAvaliaServico);
        nota= (TextView)findViewById(R.id.txtNota);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                nota.setText("Nota: "+ rating);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int nota = (int)rb.getRating();
                if(update(id,nota)) {
                    Intent intent = new Intent(TelaAvaliaServico.this, TelaCliente.class);
                    startActivity(intent);
                }
            }
        });


    }
    private boolean update(Long id,int nota) {
        boolean s = false;
        try {
            APIServicoCaller apiServicoCaller = new APIServicoCaller();
            s = apiServicoCaller.update(id, nota);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }
}
