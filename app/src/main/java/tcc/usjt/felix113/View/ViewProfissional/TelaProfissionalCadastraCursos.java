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

public class TelaProfissionalCadastraCursos extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Idiomas (ingles)", "Dança Forró", "Artes Marciais Judo ", "Musica Violão", "Culinária", "Artesanato"};
    String curso =  "Curso";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_cadastra_cursos);

        final ArrayList<String> servicos  = preencherDados();
        listView = (ListView)findViewById(R.id.ListViewProfCursos);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaProfissionalCadastraCursos.this, TelaFinalizandoCadastroProfissional.class );
                intent.putExtra("subCategoria", servicos.get(position).toString() );
                intent.putExtra("Categoria", curso );

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
