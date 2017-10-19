package tcc.usjt.felix113.View.ViewCliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        listView = (ListView)findViewById(R.id.ListViewServicosPessoal);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

    }
}
