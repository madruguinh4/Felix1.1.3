package tcc.usjt.felix113;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.Model.ServicoContratado;
import tcc.usjt.felix113.View.ViewProfissional.APICaller;


public class ServicosAgendados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicos_agendados);

  /*      ListView lista = (ListView)findViewById(R.id.ListServicosAgendados);

        final List<ServicoContratado> list = adicionarServicos();

        ArrayAdapter adapter = new ServicosContratadosAdapter(this, list);
        lista.setAdapter(adapter);
*/




        final List<AgendadosCustom> list = adicionarServicos();
        ListView lista = (ListView) findViewById(R.id.ListServicosAgendados);

        ArrayAdapter adapter = new AgendadosAdapter(this, list);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(ServicosAgendados.this, ServicosAgendados2.class );
                intent.putExtra("id", list.get(i).getId());


                intent.putExtra("profissao", list.get(i).getNome());
                intent.putExtra("descricao", list.get(i).getTelefone());
                intent.putExtra("Imagem", list.get(i).getNota());


                startActivity(intent);
            }
        });

    }

    private List<ServicoContratado> adicionarServicos() {

        ArrayList<AgendadosCustom> agendadosCustoms = new ArrayList<AgendadosCustom>();
        AgendadosCustom e  = new AgendadosCustom( R.drawable.david,"Fulano","123321","3");
        agendadosCustoms.add(e);

        e = new AgendadosCustom( R.drawable.david,"Fulano","123321","3");
        agendadosCustoms.add(e);

        e = new AgendadosCustom( R.drawable.david,"Fulano","123321","3");
        agendadosCustoms.add(e);

        return null;
    }
}
