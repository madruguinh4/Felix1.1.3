package tcc.usjt.felix113;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class FramentServicosAgendados extends Fragment {

    private ListView lista;
    private View FragmentBuscarServico;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentBuscarServico = inflater.inflate(R.layout.frament_servicos_agendados, container, false);



        ListView lista = (ListView) FragmentBuscarServico.findViewById(R.id.ListServicosAgendados);
        ArrayList<ListViewServicosAgendadosCustom> listViewServicosAgendadosCustoms = adicionarServicos();
        //ArrayAdapter adapter= new ServicosAgendadosAdapter(this, adicionarServicos());
       // lista.setAdapter(adapter);

        return FragmentBuscarServico;
    }

    private ArrayList<ListViewServicosAgendadosCustom> adicionarServicos() {
        ArrayList<ListViewServicosAgendadosCustom> listViewServicosAgendadosCustoms = new ArrayList<ListViewServicosAgendadosCustom>();
        ListViewServicosAgendadosCustom e  = new ListViewServicosAgendadosCustom("Contrução",
                "Pedreiro de fundação", R.drawable.pedro);
                 listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Pintor Interno",
                "Pintor interno de casa e predios ", R.drawable.david);
        listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Encanador",
                "Encanador domestico", R.drawable.george);
        listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Faxineira",
                "Diarista de casa de empresas", R.drawable.ste);
        listViewServicosAgendadosCustoms.add(e);

        e = new ListViewServicosAgendadosCustom("Eletricista",
                "Eletricista Predial", R.drawable.caique);
        listViewServicosAgendadosCustoms.add(e);


        e = new ListViewServicosAgendadosCustom("Faxineira",
                "Diarista de casa", R.drawable.jessica);
        listViewServicosAgendadosCustoms.add(e);


        return listViewServicosAgendadosCustoms;
    }


}
