package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tcc.usjt.felix113.Model.ServicoContratado;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.ServicosContratadosAdapter;
import tcc.usjt.felix113.View.APIServicoCaller;

public class TelaListaServicosRealizados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lista_servicos_realizados);

        final ListView lista = (ListView)findViewById(R.id.ListServicosRealizados);
        final List<ServicoContratado> list = adicionarServicos();

        ArrayAdapter adapter = new ServicosContratadosAdapter(this, list);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent =new Intent(TelaListaServicosRealizados.this, TelaAvaliaServico.class );
                intent.putExtra("nome",list.get(i).getProfissional().getNome());
                intent.putExtra("id", list.get(i).getId());
                startActivity(intent);
            }
        });

    }

    private List<ServicoContratado> adicionarServicos() {

        List<ServicoContratado> s = new ArrayList<>();

        try {
            SharedPreferences pref = getSharedPreferences("cliente", 0);
            long id = pref.getLong("id", 0L);
            APIServicoCaller api = new APIServicoCaller();
            s = api.contratados(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
}
