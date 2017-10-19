package tcc.usjt.felix113.View.ViewProfissional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tcc.usjt.felix113.R;

import static android.R.layout.simple_list_item_1;

public class TelaProfssionalCadastraVeiculos extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Mecânico ", "Auto Elétrica", "Instalador de Som", "Guincho ", "Funilaria ", "Martelinho de Ouro", "Alarme Automotivo","Chaveiro", "Borracheiro","Higienização e Polimento"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profssional_cadastra_servicos_veiculos);


        listView = (ListView) findViewById(R.id.ListViewProfCadastraVeiculo);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);
    }
}
