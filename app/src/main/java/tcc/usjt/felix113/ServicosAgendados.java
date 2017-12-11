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

public class ServicosAgendados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicos_agendados);

/*
        ListView lista = (ListView)findViewById(R.id.ListServicosAgendados);

        String categoria = (String)getIntent().getSerializableExtra("categoria");
        final List<Profissional> list = adicionarServicos(categoria);

        ArrayAdapter adapter = new ServicosAgendadosAdapter(this, list);
        lista.setAdapter(adapter);
*/



        final List<ProfissionalCustom> list = adicionarServicos();
        ListView lista = (ListView) findViewById(R.id.ListServicosAgendados);

        ArrayAdapter adapter = new IndicacaoAdapter(this, list);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent =new Intent(ServicosAgendados.this, ServicosAgendados2.class );


                intent.putExtra("profissao", list.get(i).getNome());
                intent.putExtra("descricao", list.get(i).getTelefone());
                intent.putExtra("Imagem", list.get(i).getNota());
                startActivity(intent);
            }
        });

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
