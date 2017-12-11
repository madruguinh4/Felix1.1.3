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
import tcc.usjt.felix113.Model.ServicoContratado;

/**
 * Created by alan0 on 23/08/2017.
 */

public class ServicosContratadosAdapter extends ArrayAdapter<ServicoContratado> {

    private final Context context;
    private final List<ServicoContratado> elementos;

    public ServicosContratadosAdapter(Context context, List<ServicoContratado> elementos) {
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

        profissao.setText(elementos.get(position).getProfissional().getNome());
        descricao.setText(elementos.get(position).getProfissional().getTelefone());
        imagem.setImageResource(R.drawable.david);
        nota.setText(elementos.get(position).getProfissional().getMediaProfisional().toString());
        return rowView;
    }


}
