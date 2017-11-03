package tcc.usjt.felix113.View.ViewProfissional;

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

public class TelaProfssionalCadastraVeiculos extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Mecânico ", "Auto Elétrica", "Instalador de Som", "Guincho ", "Funilaria ", "Martelinho de Ouro", "Borracheiro",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profssional_cadastra_servicos_veiculos);

        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView) findViewById(R.id.ListViewProfCadastraVeiculo);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaProfssionalCadastraVeiculos.this, TelaFinalizandoCadastroProfissional.class );

                startActivity(intent);
            }
        });
    }
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Mecânico");
        dados.add("Auto Elétrica");
        dados.add("Instalador de Som");
        dados.add("Guincho");
        dados.add("Funilaria");
        dados.add("Martelinho de Ouro");
        dados.add("Borracheiro");
        return dados;
    }

}
