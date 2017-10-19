package tcc.usjt.felix113.View.ViewCliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tcc.usjt.felix113.R;

import static android.R.layout.simple_list_item_1;
import static tcc.usjt.felix113.R.layout.tela_servicos_casa;


public class TelaServicosCasa extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Eletricista ", "Pintor", "Diarista", "Cozinheira", "Passadeira", "Encanador", "Chaveiro","Jardineiro", "Motorista"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tela_servicos_casa);

        listView = (ListView) findViewById(R.id.ListServicosCasa);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);
    }
}
