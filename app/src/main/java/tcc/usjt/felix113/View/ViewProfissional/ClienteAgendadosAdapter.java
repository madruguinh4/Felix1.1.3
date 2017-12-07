package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tcc.usjt.felix113.ClienteCustom;
import tcc.usjt.felix113.R;

/**
 * Created by alan0 on 07/12/2017.
 */

public class ClienteAgendadosAdapter extends ArrayAdapter<ClienteCustom> {
    private final Context context;
    private final ArrayList<ClienteCustom> elementos;

    public ClienteAgendadosAdapter(Context context, ArrayList<ClienteCustom> elementos) {
        super(context, R.layout.linha2, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha2, parent, false);

        TextView nome = (TextView) rowView.findViewById(R.id.txtNomeProfissionallinha2);
        TextView telefone = (TextView) rowView.findViewById(R.id.txtCategoriaProfissionallinha2);

        nome.setText(elementos.get(position).getNome());
        telefone.setText(elementos.get(position).getTelefone());

        return rowView;
    }
}
