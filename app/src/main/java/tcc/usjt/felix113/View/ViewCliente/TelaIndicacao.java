package tcc.usjt.felix113.View.ViewCliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tcc.usjt.felix113.IndicacaoAdapter;
import tcc.usjt.felix113.ProfissionalCustom;
import tcc.usjt.felix113.R;

public class TelaIndicacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_indicacao);

       final List<ProfissionalCustom> list = adicionarServicos();
        ListView lista = (ListView) findViewById(R.id.ListIndicacao);

        ArrayAdapter adapter = new IndicacaoAdapter(this, list);
        lista.setAdapter(adapter);

    }

    private ArrayList<ProfissionalCustom> adicionarServicos() {

        ArrayList<ProfissionalCustom> profissionalCustoms = new ArrayList<ProfissionalCustom>();
        ProfissionalCustom e  = new ProfissionalCustom( R.drawable.david,"Fulano","123321","3");
        profissionalCustoms.add(e);

        e = new ProfissionalCustom( R.drawable.david,"Fulano","123321","3");
        profissionalCustoms.add(e);

        e = new ProfissionalCustom( R.drawable.david,"Fulano","123321","3");
        profissionalCustoms.add(e);

        return profissionalCustoms;
    }
}

