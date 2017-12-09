package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tcc.usjt.felix113.R;

public class TelaCancelaServicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cancela_servicos);

        Button button = (Button)findViewById(R.id.buttonCancelarServico);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCancelaServicos.this, TelaCliente.class);
                startActivity(intent);
            }
        });
    }
}
