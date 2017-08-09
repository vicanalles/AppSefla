package appsefla.studio.com.appsefla.presentation.ui.activity;

import android.app.Fragment;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import appsefla.studio.com.appsefla.R;
import appsefla.studio.com.appsefla.presentation.ui.adapter.ProdutosAdapter;
import appsefla.studio.com.appsefla.domain.models.Produto;
import appsefla.studio.com.appsefla.presentation.ui.adapter.TabsPagerAdapter;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentContato;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentNovidades;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentProdutos;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentServicos;
import appsefla.studio.com.appsefla.presentation.ui.fragments.HomeFragment;
import appsefla.studio.com.appsefla.presentation.ui.fragments.SobreFragment;

public class ProdutoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //private RecyclerView recyclerView;
    private ProdutosAdapter adapter;
    private List<Produto> produtoList;
    private TabLayout tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setToolbarTitle();

        pager = (ViewPager) findViewById(R.id.pager);
        produtoList = new ArrayList<>();
        adapter = new ProdutosAdapter(this, produtoList);

        //recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        /*RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();*/

        /*try {
            Glide.with(this).load(R.drawable.bmw_720).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_main);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(Color.BLACK);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
        navigationView.setItemIconTintList(ColorStateList.valueOf(Color.BLACK));

        final int[] imageResId = {
            R.drawable.ic_action_home,
            R.drawable.ic_action_book,
            R.drawable.ic_photo_library,
            R.drawable.ic_format_list_bulleted,
            R.drawable.ic_notifications,
            R.drawable.ic_contact_mail
        };

        tabs = (TabLayout) findViewById(R.id.tabs);

        pager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager(), this));
        tabs.setBackgroundColor(Color.parseColor("#7CB342"));
        tabs.setTabTextColors(ColorStateList.valueOf(Color.BLACK));
        tabs.setSelectedTabIndicatorColor(Color.BLACK);
        tabs.setupWithViewPager(pager);

        for(int i = 0; i < imageResId.length; i++){
            tabs.getTabAt(i).setIcon(imageResId[i]);
        }

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void setToolbarTitle(){
        TextView titleToolbar = (TextView) findViewById(R.id.toolbar_text);
        titleToolbar.setText(R.string.backdrop_title);
    }
    /*
    Initializing collapsing toolbar
    Will show and hide toolbar title on scroll
     */

    /*private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.camaro,
                R.drawable.corvette,
                R.drawable.ct6,
                R.drawable.db77,
                R.drawable.gallardo,
                R.drawable.mustang,
                R.drawable.paganni_zonda,
                R.drawable.porsche_911,
                R.drawable.vyron};

        Produto p = new Produto("Camaro", 13, covers[0]);
        produtoList.add(p);

        p = new Produto("Corvette", 8, covers[1]);
        produtoList.add(p);

        p = new Produto("CT6", 11, covers[2]);
        produtoList.add(p);

        p = new Produto("DB77", 12, covers[3]);
        produtoList.add(p);

        p = new Produto("Gallardo", 14, covers[4]);
        produtoList.add(p);

        p = new Produto("Mustang", 1, covers[5]);
        produtoList.add(p);

        p = new Produto("Paganni Zonda", 11, covers[6]);
        produtoList.add(p);

        p = new Produto("Porsche 911", 14, covers[7]);
        produtoList.add(p);

        p = new Produto("Vyron", 17, covers[8]);
        produtoList.add(p);

        adapter.notifyDataSetChanged();
    }*/

    /*public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge){
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; //item column

            if(includeEdge){
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;

                if(position < spanCount){
                    outRect.top = spacing;
                }
                outRect.bottom = spacing;
            }else{
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
                if (position >= spanCount){
                    outRect.top = spacing;
                }
            }
        }
    }*/

    /*private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_main);
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
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_main);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
