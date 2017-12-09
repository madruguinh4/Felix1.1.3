package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tcc.usjt.felix113.ClienteCustom;
import tcc.usjt.felix113.IndicacaoAdapter;
import tcc.usjt.felix113.IndicacaoCustom;
import tcc.usjt.felix113.ListViewServicosAgendadosCustom;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.ViewProfissional.ClienteAgendadosAdapter;
import tcc.usjt.felix113.ServicosAgendadosAdapter;

public class TelaIndicacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_indicacao);

       final List<IndicacaoCustom> list = adicionarServicos();
        ListView lista = (ListView) findViewById(R.id.ListIndicacao);


        ArrayAdapter adapter = new IndicacaoAdapter(this, list);
        lista.setAdapter(adapter);

    }

    private ArrayList<IndicacaoCustom> adicionarServicos() {

        ArrayList<IndicacaoCustom> indicacaoCustoms = new ArrayList<IndicacaoCustom>();
        IndicacaoCustom e  = new IndicacaoCustom("Contrução",
                "Pedreiro de fundação", R.drawable.pedro,"2");
        indicacaoCustoms.add(e);

        e = new IndicacaoCustom("Pintor Interno",
                "Pintor interno de casa e predios ", R.drawable.david, "2");
        indicacaoCustoms.add(e);

        e = new IndicacaoCustom("Encanador",
                "Encanador domestico", R.drawable.george, "5");
        indicacaoCustoms.add(e);

        e = new IndicacaoCustom("Faxineira",
                "Diarista de casa de empresas", R.drawable.ste, "3");
        indicacaoCustoms.add(e);


        return indicacaoCustoms;
    }
}

