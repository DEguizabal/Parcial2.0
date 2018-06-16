package com.example.uno.parcial20.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uno.parcial20.R;
import static com.example.uno.parcial20.Fragments.NewsFragment.listNewsSend;
/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class GeneralFragment extends Fragment{

    public GeneralFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.general_fragment, container, false);


    }


}
