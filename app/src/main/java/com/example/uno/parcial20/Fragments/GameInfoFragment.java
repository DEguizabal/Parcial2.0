package com.example.uno.parcial20.Fragments;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uno.parcial20.Adapters.ViewPagerAdapter;
import com.example.uno.parcial20.R;

public class GameInfoFragment extends Fragment{
    private TabLayout TabLayoutMenu;
    private ViewPager Columns;
    private ViewPagerAdapter Elements;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.game_fragment, container, false);

        TabLayoutMenu = v.findViewById(R.id.tablayout_menu);
        Columns = (ViewPager) v.findViewById(R.id.view_pager);
        Elements = new ViewPagerAdapter(getChildFragmentManager());

        Elements.AddFragment(new GeneralFragment(), "GENERAL");
        Elements.AddFragment(new TopPlayerFragment(), "TOP PLAYERS");
        Elements.AddFragment(new ImageFragment(),"IMAGE");
        TabLayoutMenu.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#ffffff"));

        Columns.setAdapter(Elements);
        TabLayoutMenu.setupWithViewPager(Columns);

        android.support.v7.app.ActionBar ActionBarMenu = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ActionBarMenu.setElevation(0);

        return v;

    }
}
