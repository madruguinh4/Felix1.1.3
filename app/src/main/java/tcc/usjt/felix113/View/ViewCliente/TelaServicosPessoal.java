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

public class TelaServicosPessoal extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Artesanato", "Cabelereiro", "Corte e Costura", "Manicure e Pedicure", "Maquiador ", "Personal Trainer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_servicos_pessoal);

        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView)findViewById(R.id.ListViewServicosPessoal);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaServicosPessoal.this, TelaProfissionaisDisponiveis.class );

                startActivity(intent);
            }
        });

    }
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Cabelereiro");
        dados.add("Corte e Costura");
        dados.add("Maquiador");
        dados.add("Pedicure");
        dados.add("Personal Trainer");
        return dados;
    }
}
