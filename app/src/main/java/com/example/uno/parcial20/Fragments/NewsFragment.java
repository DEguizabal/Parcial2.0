package com.example.uno.parcial20.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uno.parcial20.Adapters.RecyclerViewAdapterNews;
import com.example.uno.parcial20.Interface.RequestHelper;
import com.example.uno.parcial20.Objects.News;
import com.example.uno.parcial20.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.uno.parcial20.Activities.Login.globalToken;

public class NewsFragment extends Fragment {

    private View v;
    private RequestHelper requestHelper;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<List<News>> call;
    private List<News> auxList = null;
    private List<News> listNewsSend;
    private RecyclerView newsRecycler;

    private String title;
    private String body;
    private String game;
    private String image;
    private String description;
    private String created_date;

    public NewsFragment() {
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.news_fragment, container, false);

        loadNews(v);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void loadNews(final View v) {

        baseUrl = "http://gamenewsuca.herokuapp.com/";

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        requestHelper = retrofit.create(RequestHelper.class);

        call = requestHelper.getNewsRequest("Bearer " + globalToken);

        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                auxList = response.body();
                listNewsSend = new ArrayList<>();

                for (int i = 0; i < auxList.size(); i++) {
                    if (auxList.get(i).getTitle() == null) {
                        title = "No Encontrado";
                    } else {
                        title = auxList.get(i).getTitle();
                    }
                    if (auxList.get(i).getBody() == null) {
                        body = "No Encontrado";
                    } else {
                        body = auxList.get(i).getBody();
                    }
                    if (auxList.get(i).getGame() == null) {
                        game = "No Encontrado";
                    } else {
                        game = auxList.get(i).getGame();
                    }
                    if (auxList.get(i).getCoverImage() == null) {
                        image = "No Encontrado";
                    } else {
                        image = auxList.get(i).getCoverImage();
                    }
                    if (auxList.get(i).getDescription() == null) {
                        description = "No Encontrao";
                    } else {
                        description = auxList.get(i).getDescription();
                    }
                    if (auxList.get(i).getCreated_date() == null) {
                        created_date = " No Encontrado";
                    } else {
                        created_date = auxList.get(i).getCreated_date();
                    }
                    listNewsSend.add(new News(auxList.get(i).get_id()
                            , title
                            , body
                            , game
                            , image
                            , description
                            , created_date
                            , auxList.get(i).get__v()));
                }
                newsRecycler = (RecyclerView) v.findViewById(R.id.news_recyclerview);
                RecyclerViewAdapterNews recyclerViewAdapter = new RecyclerViewAdapterNews(getContext(), listNewsSend);

                GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (position % 3 == 0) {
                            return 2;
                        } else {
                            return 1;
                        }
                    }
                });

                newsRecycler.setLayoutManager(gridLayoutManager);
                newsRecycler.setAdapter(recyclerViewAdapter);

            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {

            }
        });
    }

}
