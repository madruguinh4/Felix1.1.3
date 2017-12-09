package tcc.usjt.felix113;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tcc.usjt.felix113.Model.Profissional;

/**
 * Created by alan0 on 23/08/2017.
 */

public class IndicacaoAdapter extends ArrayAdapter<Profissional> {

    private final Context context;
    private final List<Profissional> elementos;

    public IndicacaoAdapter(Context context, List<Profissional> elementos) {
        super(context, R.layout.linhaindicacao, elementos );
        this.context= context;
        this.elementos = elementos;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhaindicacao, parent, false);

        TextView profissao= (TextView) rowView.findViewById(R.id.txtlinhaindicacaoProfissao);
        TextView descricao= (TextView) rowView.findViewById(R.id.txtlinhaindicacaoDescricao);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagemindicacao);
        TextView nota = (TextView) rowView.findViewById(R.id.txtlinhaindicacaoNota);

        profissao.setText(elementos.get(position).getNome());
        descricao.setText(elementos.get(position).getTelefone());
        imagem.setImageResource(R.drawable.david);
        nota.setText(elementos.get(position).getMediaProfisional().toString());
        return rowView;
    }


}
