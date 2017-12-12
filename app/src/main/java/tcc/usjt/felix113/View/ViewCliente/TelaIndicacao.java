package tcc.usjt.felix113.View.ViewCliente;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tcc.usjt.felix113.IndicacaoAdapter;
import tcc.usjt.felix113.Model.ServicoContratado;
import tcc.usjt.felix113.ProfissionalCustom;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.View.APIServicoCaller;

public class TelaIndicacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_indicacao);

       final List<ServicoContratado> list = adicionarServicos();
        ListView lista = (ListView) findViewById(R.id.ListIndicacao);

        ArrayAdapter adapter = new IndicacaoAdapter(this, list);
        lista.setAdapter(adapter);

    }

    private List<ServicoContratado> adicionarServicos() {

        APIServicoCaller apiServicoCaller = new APIServicoCaller();
        List<ServicoContratado> profissional = new ArrayList<>();
        try {
            profissional = apiServicoCaller.profissional();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return profissional;
    }
}

