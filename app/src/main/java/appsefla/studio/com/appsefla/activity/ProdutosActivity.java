package appsefla.studio.com.appsefla.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import appsefla.studio.com.appsefla.R;
import appsefla.studio.com.appsefla.activity.MainActivity;
import appsefla.studio.com.appsefla.fragments.ProdutoFragment;
import appsefla.studio.com.appsefla.model.Produto;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ProdutosActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.produtos_drawer) DrawerLayout drawer;
    @BindView(R.id.nav_produtos_activity) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        ProdutoFragment frag = (ProdutoFragment) getSupportFragmentManager().findFragmentByTag("mainFrag");
        if(frag == null){
            frag = new ProdutoFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.rl_fragment_container, frag, "mainFrag");
            ft.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.nav_home){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else if(id == R.id.nav_servicos){
            startActivity(new Intent(this, ServicosActivity.class));
            finish();
        }else if(id == R.id.nav_sobre){
            startActivity(new Intent(this, SobreActivity.class));
            finish();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public List<Produto> getSetCarList(int qtd){
        String[] models = new String[]{"Gallardo", "Vyron", "Corvette", "Pagani Zonda", "Porsche 911 Carrera", "BMW 720i", "DB77", "Mustang", "Camaro", "CT6"};
        String[] brands = new String[]{"Lamborghini", " bugatti", "Chevrolet", "Pagani", "Porsche", "BMW", "Aston Martin", "Ford", "Chevrolet", "Cadillac"};
        int[] photos = new int[]{R.drawable.gallardo, R.drawable.vyron, R.drawable.corvette, R.drawable.paganni_zonda, R.drawable.porsche_911, R.drawable.bmw_720, R.drawable.db77, R.drawable.mustang, R.drawable.camaro, R.drawable.ct6};
        List<Produto> listAux = new ArrayList<>();

        for(int i = 0; i < qtd; i++){
            Produto c = new Produto( models[i % models.length], brands[ i % brands.length ], photos[i % models.length] );
            listAux.add(c);
        }
        return(listAux);
    }
}
