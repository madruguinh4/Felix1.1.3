package tcc.usjt.felix113.View.ViewProfissional;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import tcc.usjt.felix113.Model.SubcategoriaCasa;
import tcc.usjt.felix113.R;

public class TelaFinalizandoCadastroProfissional extends AppCompatActivity {

    ProgressDialog dialog;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_finalizando_cadastro_profissional);

        final TextView servico, categoria;


       final Intent intent = getIntent();
       final String Sub = (String)intent.getSerializableExtra("subCategoria");
       final String Categoria = (String)intent.getSerializableExtra("Categoria");

        servico = (TextView)findViewById(R.id.textViewCadastroServico);
        categoria = (TextView)findViewById(R.id.textViewCadastrocategoria);
        Button btn = (Button)findViewById(R.id.btnCadastrarFinalProfissional);

         servico.setText(Sub);
         categoria.setText(Categoria);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new ProgressDialog(TelaFinalizandoCadastroProfissional.this);
                dialog.setMessage("Carregando...");
                dialog.setCancelable(false);
                dialog.show();
                SharedPreferences pref = getSharedPreferences("profissional", 0);
                long id = pref.getLong("id", 0L);
                System.out.println("sub: " + Sub + "id: " + id);
                create(id,Sub);
                Intent intent = new Intent(TelaFinalizandoCadastroProfissional.this, TelaProfissional.class);
                startActivity(intent);
            }
        });
    }

    private void create(Long id,String categoria){

        try {
            boolean success = false;
            APICaller apiCaller = new APICaller();
            SubcategoriaCasa subcategoriaCasa = apiCaller.call(id);
            if(subcategoriaCasa != null){
                subcategoriaCasa.set(categoria,"1");
                success = apiCaller.callUpdate(subcategoriaCasa);
            }else{
                subcategoriaCasa = new SubcategoriaCasa();
                subcategoriaCasa.setIdProfissional(id);
                subcategoriaCasa.set(categoria,"1");
                success = apiCaller.call(subcategoriaCasa);
            }

            if(!success){
                Toast.makeText(this, "Erro tente novamentte ", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

