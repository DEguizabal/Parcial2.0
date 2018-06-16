package com.example.uno.parcial20.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uno.parcial20.Objects.TopPlayers;
import com.example.uno.parcial20.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVATopPlayers extends RecyclerView.Adapter<RVATopPlayers.MyViewHolder>{

    private Context context;
    private List<TopPlayers> TopPlayersDataList;

    public RVATopPlayers(Context context, List<TopPlayers> topPlayersDataList){
        this.context = context;
        TopPlayersDataList = topPlayersDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.top_player_item, parent, false);
        MyViewHolder holder = new MyViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.TopPlayerName.setText(TopPlayersDataList.get(position).getName());
        holder.TopPlayerGame.setText(TopPlayersDataList.get(position).getGame());
        holder.TopPlayerBio.setText(TopPlayersDataList.get(position).getbiografia());

        if(TopPlayersDataList.get(position).getavatar() != "No image found"){
            Picasso.with(context).load(TopPlayersDataList.get(position).getavatar()).into(holder.TopPlayerImage);
        }
    }

    @Override
    public int getItemCount() {
        return TopPlayersDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView TopPlayerName;
        private TextView TopPlayerGame;
        private TextView TopPlayerBio;
        private ImageView TopPlayerImage;

        public MyViewHolder(View itemView){
            super(itemView);

            TopPlayerName = (TextView) itemView.findViewById(R.id.player_name);
            TopPlayerGame = (TextView) itemView.findViewById(R.id.player_game);
            TopPlayerBio = (TextView) itemView.findViewById(R.id.player_bio);
            TopPlayerImage = (ImageView) itemView.findViewById(R.id.player_image);
        }
    }
}
