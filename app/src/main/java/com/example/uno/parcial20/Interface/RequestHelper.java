package com.example.uno.parcial20.Interface;

import com.example.uno.parcial20.Objects.News;
import com.example.uno.parcial20.Objects.TopPlayers;
import com.example.uno.parcial20.Objects.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RequestHelper {

    @FormUrlEncoded
    @POST("login")
    Call<User> loginRequest(@Field("user") String username, @Field("password") String password);

    @GET("news")
    Call<List<News>> getNewsRequest(@Header("Authorization") String token);

    @GET("players")
    Call<List<TopPlayers>> getTopPlayersRequest(@Header("Authorization") String token);


}
