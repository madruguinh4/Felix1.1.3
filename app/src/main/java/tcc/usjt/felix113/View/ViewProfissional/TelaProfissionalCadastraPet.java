package tcc.usjt.felix113.View.ViewProfissional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tcc.usjt.felix113.R;

import static android.R.layout.simple_list_item_1;

public class TelaProfissionalCadastraPet extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Passeador de Cães ", "Banho e Tosa", "Hospedagem", "Taxi ", "Adestrador ", "Veterináio"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_cadastra_pet);


        listView = (ListView) findViewById(R.id.ListViewProfPet);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

    }
}
