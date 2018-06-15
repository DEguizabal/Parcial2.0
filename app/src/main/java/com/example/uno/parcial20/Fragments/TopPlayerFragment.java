package com.example.uno.parcial20.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uno.parcial20.Adapters.RecyclerViewAdapterTopPlayers;
import com.example.uno.parcial20.Interface.RequestHelper;
import com.example.uno.parcial20.Objects.TopPlayers;
import com.example.uno.parcial20.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.uno.parcial20.Activities.Login.globalToken;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class TopPlayerFragment extends Fragment{

    private View v;
    private RequestHelper requestHelper;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<List<TopPlayers>> call;
    private List<TopPlayers> auxList = null;
    private  List<TopPlayers> listPlayersSend;
    private RecyclerView topPlayersRecyclerView;

    private String avatar;
    private String name;
    private String biografia;
    private String game;
    private String __v;

    public TopPlayerFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.top_players_fragment,container,false);
        loadTopPlayers(v);

        return v;
    }

    public void  loadTopPlayers(final View v){

        baseUrl = "http://gamenewsuca.herokuapp.com/";

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        requestHelper = retrofit.create(RequestHelper.class);

        call = requestHelper.getTopPlayersRequest("Bearer " + globalToken);

        call.enqueue(new Callback<List<TopPlayers>>() {
            @Override
            public void onResponse(Call<List<TopPlayers>> call, Response<List<TopPlayers>> response) {
                auxList = response.body();
                listPlayersSend = new ArrayList<>();

                for (int i = 0; i<auxList.size(); i++){
                    if (auxList.get(i).getavatar() == null){
                        avatar = "No Encontrado";
                    }else {
                        avatar = auxList.get(i).getavatar();
                    }
                    if (auxList.get(i).getName() == null){
                        name ="No Encontrado";
                    }else {
                        name = auxList.get(i).getName();
                    }
                    if (auxList.get(i).getbiografia() == null){
                        biografia = "No Encontrado";
                    }else {
                        biografia = auxList.get(i).getbiografia();
                    }
                    if (auxList.get(i).getGame() == null){
                        game = "No Encontrado";
                    }else {
                        game = auxList.get(i).getGame();
                    }

                    listPlayersSend.add(new TopPlayers(avatar, auxList.get(i).get_id(), name, biografia, game, auxList.get(i).get__v()));
                }

                topPlayersRecyclerView = (RecyclerView) v.findViewById(R.id.top_players_recyclerview);
                RecyclerViewAdapterTopPlayers recyclerViewAdapter = new RecyclerViewAdapterTopPlayers(getContext(), listPlayersSend);
                topPlayersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                topPlayersRecyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<TopPlayers>> call, Throwable t) {

            }
        });
    }
}
