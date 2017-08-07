package appsefla.studio.com.appsefla.presentation.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import appsefla.studio.com.appsefla.presentation.ui.fragments.PageFragment;
import appsefla.studio.com.appsefla.presentation.ui.fragments.TesteFragment;

/**
 * Created by Vinicius Canalles on 04/08/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private String[] titles = {"TODOS", "TESTE"};

    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;

        if (position == 0) {
            frag = new PageFragment();
        }else if(position == 1){
            frag = new TesteFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);

        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (titles[position]);
    }
}
