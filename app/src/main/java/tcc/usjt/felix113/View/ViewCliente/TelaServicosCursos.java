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

public class TelaServicosCursos extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Professor Particular", "Idiomas (ingles)", "Dança", "Artes Marciais ", "Musica ", "Culinária", "Artesanato","Esportes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_servicos_cursos);

        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView)findViewById(R.id.ListViewCursos);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaServicosCursos.this, TelaProfissionaisDisponiveis.class );

                startActivity(intent);
            }
        });



    }
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Idiomas (ingles)");
        dados.add("Dança Forró");
        dados.add("Artes Marciais Judo");
        dados.add("Musica Violão");
        dados.add("Culinária");
        dados.add("Artesanato");
        return dados;
    }
}
