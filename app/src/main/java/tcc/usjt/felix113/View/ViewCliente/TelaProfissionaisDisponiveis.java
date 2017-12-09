package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.ServicosAgendadosAdapter;
import tcc.usjt.felix113.View.ViewProfissional.APICaller;

public class TelaProfissionaisDisponiveis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissionais_disponiveis);

        ListView lista = (ListView)findViewById(R.id.ListProfDisponiveis);

        String categoria = (String)getIntent().getSerializableExtra("categoria");
        final List<Profissional> list = adicionarServicos(categoria);

        ArrayAdapter adapter = new ServicosAgendadosAdapter(this, list);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(TelaProfissionaisDisponiveis.this, TelaContrataProfissional.class );

                intent.putExtra("profissao", list.get(i).getNome());
                intent.putExtra("descricao", list.get(i).getTelefone());
                intent.putExtra("Imagem", list.get(i).getMediaProfisional());
                startActivity(intent);
            }
        });
    }
    private List<Profissional> adicionarServicos(String categoria) {

        APICaller apiCaller = new APICaller();
        List<Profissional> profissionalList = null;
        try {
            profissionalList = apiCaller.categoria(categoria);
            for (Profissional profissional:profissionalList) {
                System.out.println(profissional.getMediaProfisional() + " " + profissional.getNome());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return profissionalList;
    }
}
