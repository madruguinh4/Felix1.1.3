package tcc.usjt.felix113.View.ViewCliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tcc.usjt.felix113.R;

import static android.R.layout.simple_list_item_1;

public class TelaServicoFotografia extends AppCompatActivity {


    ListView listView;
    ArrayAdapter<String> adapter;
    //    String [] servicos = {"Eventos Corporativos", "Eventos infantis", "Casamento", "Batizado", "Aniversários"};
    final ArrayList<String> servicos = preencherDados();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_servico_fotografia);

        listView = (ListView)findViewById(R.id.ListViewProfFotografia);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), servicos.get(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }
    private ArrayList<String> preencherDados(){
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Eventos Corporativos");
        dados.add("Eventos infantis");
        dados.add("Casamento");
        dados.add("Batizado");
        dados.add("Aniversários");
        return dados;
    }
}
