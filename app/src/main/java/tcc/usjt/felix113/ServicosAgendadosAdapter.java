package tcc.usjt.felix113;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alan0 on 23/08/2017.
 */

public class ServicosAgendadosAdapter extends ArrayAdapter<ListViewServicosAgendadosCustom> {

    private final Context context;
    private final ArrayList<ListViewServicosAgendadosCustom> elementos;

    public ServicosAgendadosAdapter(Context context, ArrayList<ListViewServicosAgendadosCustom> elementos) {
        super(context, R.layout.linha, elementos );
        this.context= context;
        this.elementos = elementos;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView profissao= (TextView) rowView.findViewById(R.id.txtLinhaProfissao);
        TextView descricao= (TextView) rowView.findViewById(R.id.txtLinhaDescricao);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);
        TextView nota = (TextView) rowView.findViewById(R.id.txtLinhaNota);

        profissao.setText(elementos.get(position).getProfissao());
        descricao.setText(elementos.get(position).getDescricao());
        imagem.setImageResource(elementos.get(position).getImagem());
        nota.setText(elementos.get(position).getNota());
        return rowView;
    }


}
