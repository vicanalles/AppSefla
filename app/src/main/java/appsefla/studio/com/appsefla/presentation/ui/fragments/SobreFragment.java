package appsefla.studio.com.appsefla.presentation.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appsefla.studio.com.appsefla.R;

/**
 * Created by Vinicius Canalles on 07/08/2017.
 */

public class SobreFragment extends Fragment {

    public SobreFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sobre, container, false);
        TextView txt = (TextView) view.findViewById(R.id.text_view_fragment_sobre);
        txt.setText("Fragment Sobre");

        return view;
    }
}
