package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import tcc.usjt.felix113.View.APIServicoCaller;
import tcc.usjt.felix113.View.ViewCliente.TelaCliente;

public class ServicosAgendados2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicos_agendados2);

        Intent intent = getIntent();
        Button btn = (Button)findViewById(R.id.button);





        final Long id = (Long) intent.getSerializableExtra("id");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delete(id)) {
                    Intent intent = new Intent(ServicosAgendados2.this, TelaCliente.class);
                    startActivity(intent);
                }
            }
        });

    }


    private boolean delete(Long id) {
        boolean s = false;
        try {
            APIServicoCaller apiServicoCaller = new APIServicoCaller();
            s = apiServicoCaller.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return s;
    }
}
