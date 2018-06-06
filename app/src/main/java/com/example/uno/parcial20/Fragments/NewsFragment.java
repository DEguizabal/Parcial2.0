package com.example.uno.parcial20.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uno.parcial20.Adapters.RecyclerViewAdapterNews;
import com.example.uno.parcial20.Objects.News;
import com.example.uno.parcial20.R;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment  extends Fragment {

    View v;
    private RecyclerView RVnews;
    private List<News> listNews;

    public NewsFragment() {
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.news_fragment,container,false);

        RVnews = v.findViewById(R.id.news_recyclerview);
        RecyclerViewAdapterNews recyclerViewAdapter = new  RecyclerViewAdapterNews(getContext(), listNews);
        RVnews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        RVnews.setAdapter(recyclerViewAdapter);
        return v;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listNews = new ArrayList<>();
        listNews.add(new News("imagen","TituloNoticia1","SubNoticia1",false,1));
        listNews.add(new News("imagen","TituloNoticia2","SubNoticia2",false,2));
        listNews.add(new News("imagen","TituloNoticia3","SubNoticia3",false,3));
        listNews.add(new News("imagen","TituloNoticia4","SubNoticia4",false,4));
        listNews.add(new News("imagen","TituloNoticia5","SubNoticia5",false,5));
        listNews.add(new News("imagen","TituloNoticia6","SubNoticia6",false,6));
        listNews.add(new News("imagen","TituloNoticia7","SubNoticia7",false,7));
        listNews.add(new News("imagen","TituloNoticia8","SubNoticia8",false,8));
        listNews.add(new News("imagen","TituloNoticia9","SubNoticia9",false,9));
        listNews.add(new News("imagen","TituloNoticia10","SubNoticia10",false,10));
    }

}
