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

public class TelaProfissionalCadastraPet extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Passeador de Cães ", "Banho e Tosa", "Hospedagem", "Taxi ", "Adestrador ", "Veterináio"};
    String pet = "Pet";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_cadastra_pet);

        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView) findViewById(R.id.ListViewProfPet);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaProfissionalCadastraPet.this, TelaFinalizandoCadastroProfissional.class );
                intent.putExtra("subCategoria", servicos.get(position).toString() );
                intent.putExtra("Categoria", pet );

                startActivity(intent);
            }
        });


    }
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Passeador de Cães");
        dados.add("Banho e Tosa");
        dados.add("Hospedagem");
        dados.add("Taxi");
        dados.add("Adestrador");
        dados.add("Veterináio");
        return dados;
    }
}
