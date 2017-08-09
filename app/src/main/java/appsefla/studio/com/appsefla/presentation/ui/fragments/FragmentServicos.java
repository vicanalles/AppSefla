package appsefla.studio.com.appsefla.presentation.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appsefla.studio.com.appsefla.R;

/**
 * Created by Vinicius Canalles on 09/08/2017.
 */

public class FragmentServicos extends Fragment{

    public FragmentServicos(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_servicos, container, false);
        TextView txt = (TextView) view.findViewById(R.id.text_view_fragment_servicos);
        txt.setText("Fragment Serviços");

        return view;
    }
}
