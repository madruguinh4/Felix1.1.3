package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import tcc.usjt.felix113.R;

public class TelaAvaliaServico extends AppCompatActivity {
    RatingBar rb ;
    TextView nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_avalia_servico);


        Button button = (Button)findViewById(R.id.btnTelaAvaliaServicoSalvar);

        rb=  (RatingBar)findViewById(R.id.rdAvaliaServico);
        nota= (TextView)findViewById(R.id.txtNota);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                nota.setText("Nota: "+rating);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaAvaliaServico.this, TelaCliente.class);
                startActivity(intent);
            }
        });
    }
}
