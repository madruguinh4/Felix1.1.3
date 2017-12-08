package tcc.usjt.felix113;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tcc.usjt.felix113.Model.Profissional;

/**
 * Created by alan0 on 23/08/2017.
 */

public class ServicosAgendadosAdapter extends ArrayAdapter<Profissional> {

    private final Context context;
    private final List<Profissional> elementos;

    public ServicosAgendadosAdapter(Context context, List<Profissional> elementos) {
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

        profissao.setText(elementos.get(position).getNome());
        descricao.setText(elementos.get(position).getTelefone());
        imagem.setImageResource(R.drawable.david);
        nota.setText(elementos.get(position).getMediaProfisional().toString());
        return rowView;
    }


}
