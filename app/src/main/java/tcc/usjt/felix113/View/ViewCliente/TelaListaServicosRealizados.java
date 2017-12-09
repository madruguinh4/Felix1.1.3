package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tcc.usjt.felix113.R;

public class TelaListaServicosRealizados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lista_servicos_realizados);

        final ListView lista = (ListView)findViewById(R.id.ListServicosRealizados);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent =new Intent(TelaListaServicosRealizados.this, TelaAvaliaServico.class );
                intent.putExtra("nome",lista.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });

    }
}
