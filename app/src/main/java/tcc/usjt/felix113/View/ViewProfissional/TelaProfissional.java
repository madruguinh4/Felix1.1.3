package tcc.usjt.felix113.View.ViewProfissional;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tcc.usjt.felix113.ClienteCustom;
import tcc.usjt.felix113.R;
public class TelaProfissional extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_profissional);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    //    final ClienteCustom clienteCustom = new ClienteCustom(null,null,null,null,null,null);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

// Preenche o List View da tela do Profissional

        final ArrayList<ClienteCustom> list = adicionarServicos();
        ListView lista = (ListView)findViewById(R.id.ListViewConteTelaProfissional);


        ArrayAdapter adapter = new ClienteAgendadosAdapter(this, list);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent (TelaProfissional.this, TelaProfissionalEscolhePrestaServico.class);

                intent.putExtra("nome", list.get(i).getNome());
                intent.putExtra("telefone", list.get(i).getTelefone());
                startActivity(intent);
            }
        });

    }

    private ArrayList<ClienteCustom> adicionarServicos() {

        ArrayList<ClienteCustom> clienteCustoms = new ArrayList<ClienteCustom>();
        ClienteCustom e  = new ClienteCustom("Juliana","123123");
        clienteCustoms.add(e);

        e = new ClienteCustom("Pedro",
                "1235677 ");
        clienteCustoms.add(e);
        e = new ClienteCustom("Maria",
                "65432 ");
        clienteCustoms.add(e);
        e = new ClienteCustom("Jose",
                "3456756 ");
        clienteCustoms.add(e);
        e = new ClienteCustom("Pedro",
                "4324324 ");
        clienteCustoms.add(e);

        return clienteCustoms;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_profissional, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.NavProfMeusServicos) {
            Intent intent = new Intent(TelaProfissional.this,TelaMeusServicos.class);
            startActivity(intent);
        } else if (id == R.id.navProfServicosAgendados) {
            Intent intent = new Intent(TelaProfissional.this,TelaCadastrarServicos.class);
            startActivity(intent);

        } else if (id == R.id.navProfAjuda) {
            Intent intent = new Intent(TelaProfissional.this,TelaProfissionalAjuda.class);
            startActivity(intent);

        } else if (id == R.id.navProfInfo) {

        } else if (id == R.id.navProfissionalSair) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
