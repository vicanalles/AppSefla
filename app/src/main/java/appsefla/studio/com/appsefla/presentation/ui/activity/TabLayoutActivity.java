package appsefla.studio.com.appsefla.presentation.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import appsefla.studio.com.appsefla.R;
import appsefla.studio.com.appsefla.presentation.ui.adapter.TabsPagerAdapter;

/**
 * Created by Vinicius Canalles on 04/08/2017.
 */

public class TabLayoutActivity extends AppCompatActivity{

    DrawerLayout drawerMain;
    TabLayout tabs;
    ViewPager pager;
    TabsPagerAdapter adapter;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        tabs = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new TabsPagerAdapter(getSupportFragmentManager());

        //método que seta o título da toolbar
        setToolbarTitle();

        //seta o adapter
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
    }

    public void setToolbarTitle(){
        TextView titleToolbar = (TextView) findViewById(R.id.toolbar_text);
        titleToolbar.setText(R.string.backdrop_title);
    }
}
