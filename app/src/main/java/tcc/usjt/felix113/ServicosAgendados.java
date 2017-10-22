package tcc.usjt.felix113;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ServicosAgendados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicos_agendados);
        ListView lista = (ListView)findViewById(R.id.ListServicosAgendados);

        final ArrayList<ListViewServicosAgendadosCustom> list = adicionarServicos();

        ArrayAdapter adapter = new ServicosAgendadosAdapter(this, list);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent =new Intent(ServicosAgendados.this, ServicosAgendados2.class );

               intent.putExtra("profissao", list.get(i).getProfissao());
                intent.putExtra("descricao", list.get(i).getDescricao());
                intent.putExtra("Imagem", list.get(i).getImagem());
                startActivity(intent);
            }
        });

    }

    private ArrayList<ListViewServicosAgendadosCustom> adicionarServicos() {

        ArrayList<ListViewServicosAgendadosCustom> listViewServicosAgendadosCustoms = new ArrayList<ListViewServicosAgendadosCustom>();
        ListViewServicosAgendadosCustom e  = new ListViewServicosAgendadosCustom("Desenvolvedor de Banco de Dados SQLite",
                "Administrador Banco de dados", R.drawable.pedro);
        listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Desenvolvedor  Android",
                "Desenvolvedor de Aplicativos Android", R.drawable.david);
        listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Analista de Banco de Dados",
                "Analise e implementação de Banco de Dados", R.drawable.george);
        listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Analista Android",
                "Analista desenolvedor de Aplicativos Android", R.drawable.ste);
        listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Analista de Requesitos de Banco de Dados SQLite",
                "Analista Pleno de Requesitos e Gerenciador de Projetos ", R.drawable.caique);
        listViewServicosAgendadosCustoms.add(e);


        e = new ListViewServicosAgendadosCustom("Gerente de Projetos",
                "Gerencia projetos de desenvolvimento", R.drawable.jessica);
        listViewServicosAgendadosCustoms.add(e);

        return listViewServicosAgendadosCustoms;
    }
}
