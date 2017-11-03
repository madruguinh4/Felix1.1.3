package tcc.usjt.felix113.View.ViewCliente;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import tcc.usjt.felix113.FragmentTelaEditarPerfil;
import tcc.usjt.felix113.R;
import tcc.usjt.felix113.ServicosAgendados;

public class TelaCliente extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {



    private ImageView carro, casa, aprendizado, pessoal, tecnologia, pet, saude,fotografia ;

    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        carro = (ImageView)findViewById(R.id.imageViewTelaClienteCarro);
        casa = (ImageView)findViewById(R.id.imageViewTelaCLienteCasa);
        aprendizado = (ImageView)findViewById(R.id.imageViewTelaClienteCurso);
        pessoal = (ImageView)findViewById(R.id.imageViewTelaClientePessoal);
        tecnologia = (ImageView)findViewById(R.id.imageViewTelaClienteTecnologia);
        pet = (ImageView)findViewById(R.id.imageViewTelaClientePet);
        saude = (ImageView)findViewById(R.id.imageViewTelaClienteSaude);
        fotografia = (ImageView)findViewById(R.id.imageViewTelaClienteFotografia);


        carro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCliente.this, TelaServicosVeiculos.class);
                startActivity(intent);


            }
        });

        casa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(TelaCliente.this, TelaServicosCasa.class);
                startActivity(intent);

            }
        });
        aprendizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCliente.this, TelaServicosCursos.class);
                startActivity(intent);

            }
        });
        pessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCliente.this, TelaServicosPessoal.class);
                startActivity(intent);

            }
        });
        pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCliente.this, TelaServicosPet.class);
                startActivity(intent);

            }
        });
        tecnologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCliente.this, TelaServicosTecnologia.class);
                startActivity(intent);

            }
        });
        saude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCliente.this, TelaServicosSaude.class);
                startActivity(intent);

            }
        });
        fotografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaCliente.this, TelaServicoFotografia.class);
                startActivity(intent);


            }
        });

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
        getMenuInflater().inflate(R.menu.tela_cliente, menu);
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
        Fragment fragment = null;
        Boolean FragmentoSelecionado = false;

        FragmentManager fragmentManager = getSupportFragmentManager();
         if (id == R.id.navCliBuscaServico) {
            fragment = new FragmentTelaEditarPerfil();
            getSupportFragmentManager().beginTransaction().replace(R.id.FragmentTelaCliente, fragment).commit();

        } else if (id == R.id.navCliServicosAgendados) {
            Intent abrirTelaSelecaoCadastro = new Intent(TelaCliente.this, ServicosAgendados.class);
            startActivity(abrirTelaSelecaoCadastro);

        } else if (id == R.id.navCliAjuda) {


        } else if (id == R.id.navCliInfo) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
