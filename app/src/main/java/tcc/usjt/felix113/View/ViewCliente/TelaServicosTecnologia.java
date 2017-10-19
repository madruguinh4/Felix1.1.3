package tcc.usjt.felix113.View.ViewCliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tcc.usjt.felix113.R;

import static android.R.layout.simple_list_item_1;

public class TelaServicosTecnologia extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Animação ", "Desenvolvimento Java", "Audio e Video ", "Criação de Logos ", "Ilustruação", "Marketing Online","Diagramador", "Convites","Moldelagem 2D e 3D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_servios_tecnologia);

        listView = (ListView) findViewById(R.id.ListViewServicosTecnologia);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);
    }
}
