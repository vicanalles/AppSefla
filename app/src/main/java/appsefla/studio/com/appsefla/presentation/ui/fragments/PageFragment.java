package appsefla.studio.com.appsefla.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import appsefla.studio.com.appsefla.R;

/**
 * Created by Vinicius Canalles on 04/08/2017.
 */

public class PageFragment extends Fragment {

    private static final String ARG_PAGE_NUMBER = "page_number";

    public PageFragment() {

    }

    public static PageFragment newInstance(int page) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_layout, container, false);

        TextView txt = (TextView) view.findViewById(R.id.page_number_label);
        int page = getArguments().getInt(ARG_PAGE_NUMBER, -1);
        txt.setText(String.format("Page %d", page));

        return view;
    }
}
