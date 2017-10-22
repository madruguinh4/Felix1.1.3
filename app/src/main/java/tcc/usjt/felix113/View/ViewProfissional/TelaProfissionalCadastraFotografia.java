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

public class TelaProfissionalCadastraFotografia extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
     String [] servicos = {"Eventos Corporativos", "Eventos infantis", "Casamento", "Batizado", "Aniversários"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_cadastra_fotografia);


        Intent intent = getIntent();
        final String nomerecebe = (String)intent.getSerializableExtra("nome");
        final String sobrenomerecebe = (String)intent.getSerializableExtra("sobrenome");
        final String emailrecebe = (String)intent.getSerializableExtra("email");
        final String telefonerecebe = (String)intent.getSerializableExtra("telefone");
        final String senharecebe = (String)intent.getSerializableExtra("senha");
        final String confirmesenharecebe = (String)intent.getSerializableExtra("confirmesenha");
        final String fotografiarecebe =(String)intent.getSerializableExtra("fotografia");


        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView) findViewById(R.id.ListViewProfFotografia);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(getApplication(), "" +servicos.get(position).toString(), Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(TelaProfissionalCadastraFotografia.this, TelaFinalizandoCadastroProfissional.class );


               intent = intent.putExtra("nome", nomerecebe);
                intent = intent.putExtra("sobrenome", sobrenomerecebe);
                intent = intent.putExtra("email", emailrecebe);
                intent = intent.putExtra("telefone", telefonerecebe);
                intent = intent.putExtra("senha", senharecebe);
                intent = intent.putExtra("confirmesenha", confirmesenharecebe);
                intent = intent.putExtra("fotografia", fotografiarecebe);
                intent = intent.putExtra("servico" ,servicos.get(position).toString() );


                startActivity(intent);
            }
        });


    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Eventos Corporativos");
        dados.add("Eventos infantis");
        dados.add("Casamento");
        dados.add("Batizado");
        dados.add("Aniversários");
        return dados;
    }


}
