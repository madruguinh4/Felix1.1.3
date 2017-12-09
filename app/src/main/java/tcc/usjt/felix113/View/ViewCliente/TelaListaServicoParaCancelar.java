package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tcc.usjt.felix113.R;

public class TelaListaServicoParaCancelar extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lista_servico_para_cancelar);

        listView = (ListView)findViewById(R.id.ListServisoParaCancelar);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaListaServicoParaCancelar.this, TelaCancelaServicos.class );
                intent.putExtra("nome", listView.getItemAtPosition(position).toString() );
                startActivity(intent);
            }
        });



    }
}
