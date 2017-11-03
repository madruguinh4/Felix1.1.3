package tcc.usjt.felix113.View.ViewCliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        rb=  (RatingBar)findViewById(R.id.rdAvaliaServico);
        nota= (TextView)findViewById(R.id.txtNota);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                nota.setText("Nota: "+rating);
            }
        });
    }
}
