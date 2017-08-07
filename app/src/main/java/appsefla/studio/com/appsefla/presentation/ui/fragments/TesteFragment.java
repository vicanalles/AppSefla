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

public class TesteFragment extends Fragment {

    public TesteFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teste_layout, container, false);
        TextView txt = (TextView) view.findViewById(R.id.page_text_label);
        txt.setText("Hello Tela 2");

        return view;
    }
}
