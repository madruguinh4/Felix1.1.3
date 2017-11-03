package tcc.usjt.felix113.View.ViewProfissional;

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

public class TelaProfissionalCadastraSaude extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;
    String [] servicos = {"Acompanhante de Idoso ", "Enfermeira", "Fisioterapeuta", "Nutricionista", "Psicólogo","Cuidador"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional_cadastra_saude);

        final ArrayList<String> servicos  = preencherDados();

        listView = (ListView) findViewById(R.id.ListViewProfSaude);
        adapter = new ArrayAdapter<String>(this, simple_list_item_1, servicos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaProfissionalCadastraSaude.this, TelaFinalizandoCadastroProfissional.class );

                startActivity(intent);
            }
        });

    }
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Acompanhante de Idoso");
        dados.add("Enfermeira");
        dados.add("Fisioterapeuta");
        dados.add("Nutricionista");
        dados.add("Psicólogo");
        dados.add("Cuidador");
        return dados;
    }

}
