package appsefla.studio.com.appsefla.presentation.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import appsefla.studio.com.appsefla.R;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentContato;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentNovidades;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentProdutos;
import appsefla.studio.com.appsefla.presentation.ui.fragments.FragmentServicos;
import appsefla.studio.com.appsefla.presentation.ui.fragments.HomeFragment;
import appsefla.studio.com.appsefla.presentation.ui.fragments.SobreFragment;

/**
 * Created by Vinicius Canalles on 09/08/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    private int[] imageResId = {
            R.drawable.ic_action_home,
            R.drawable.ic_action_book,
            R.drawable.ic_photo_library,
            R.drawable.ic_format_list_bulleted,
            R.drawable.ic_notifications,
            R.drawable.ic_contact_mail
    };

    public TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;

        switch (position) {
            case 0:
                frag = new HomeFragment();
                break;
            case 1:
                frag = new SobreFragment();
                break;
            case 2:
                frag = new FragmentProdutos();
                break;
            case 3:
                frag = new FragmentServicos();
                break;
            case 4:
                frag = new FragmentNovidades();
                break;
            case 5:
                frag = new FragmentContato();
                break;
        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        if(frag != null){
            frag.setArguments(b);
        }

        return frag;
    }




    @Override
    public int getCount() {
        return imageResId.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
