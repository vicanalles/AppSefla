package appsefla.studio.com.appsefla.presentation.ui.activity;

import android.content.res.ColorStateList;
import android.graphics.Color;
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

    private TabLayout tabs;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        pager = (ViewPager) findViewById(R.id.pager);

        //método que seta o título da toolbar
        setToolbarTitle();

        final int[] imageResId = {
                R.drawable.ic_action_home,
                R.drawable.ic_action_book,
                R.drawable.ic_photo_library,
                R.drawable.ic_format_list_bulleted,
                R.drawable.ic_notifications,
                R.drawable.ic_contact_mail
        };

        tabs = (TabLayout) findViewById(R.id.tabs);

        //seta o adapter
        pager.setAdapter(new TabsPagerAdapter(getSupportFragmentManager(), this));
        tabs.setBackgroundColor(Color.parseColor("#7CB342"));
        tabs.setTabTextColors(ColorStateList.valueOf(Color.BLACK));
        tabs.setSelectedTabIndicatorColor(Color.BLACK);
        tabs.setupWithViewPager(pager);

        for(int i = 0; i < imageResId.length; i++){
            tabs.getTabAt(i).setIcon(imageResId[i]);
        }
    }

    public void setToolbarTitle(){
        TextView titleToolbar = (TextView) findViewById(R.id.toolbar_text);
        titleToolbar.setText(R.string.backdrop_title);
    }
}
