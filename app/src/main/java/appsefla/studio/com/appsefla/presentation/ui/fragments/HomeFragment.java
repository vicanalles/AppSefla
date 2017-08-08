package appsefla.studio.com.appsefla.presentation.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appsefla.studio.com.appsefla.R;

/**
 * Created by Vinicius Canalles on 04/08/2017.
 */

public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView txt = (TextView) view.findViewById(R.id.page_number_label);
        txt.setText("Fragment Home");

        return view;
    }
}
