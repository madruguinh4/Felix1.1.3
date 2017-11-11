package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tcc.usjt.felix113.R;
import tcc.usjt.felix113.TelaProfissionaisDisponiveis;

import static android.R.layout.simple_list_item_1;

public class TelaServicosTecnologia extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Animação ", "Desenvolvimento Java", "Audio e Video ", "Criação de Logos ", "Ilustruação", "Marketing Online","Diagramador", "Convites","Moldelagem 2D e 3D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_servios_tecnologia);

        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView) findViewById(R.id.ListViewServicosTecnologia);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaServicosTecnologia.this, TelaProfissionaisDisponiveis.class );

                startActivity(intent);
            }
        });
    }
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Animação");
        dados.add("Desenvolvimento Java");
        dados.add("Audio e Video");
        dados.add("Ilustruação");
        dados.add("Marketing Online");
        dados.add("Moldelagem 2D e 3D");
        return dados;
    }
}
