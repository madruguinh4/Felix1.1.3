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

        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView) findViewById(R.id.ListServicosCasa);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(TelaServicosCasa.this, TelaProfissionaisDisponiveis.class );
                intent.putExtra("categoria",preencherDados().get(position));

                startActivity(intent);
            }
        });




    }
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Eletricista");
        dados.add("Pintor");
        dados.add("Diarista");
        dados.add("Cozinheira");
        dados.add("Jardineiro");
        dados.add("Motorista");
        return dados;
    }



}
