package com.example.uno.parcial20.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uno.parcial20.Objects.News;
import com.example.uno.parcial20.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterNews extends RecyclerView.Adapter<RecyclerViewAdapterNews.MyViewHolder>{

    private Context context;
    private List<News> NewsListData;

    public RecyclerViewAdapterNews(Context context, List<News> NewsListData){
        this.context = context;
        this.NewsListData = NewsListData;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.newsTitle.setText(NewsListData.get(position).getTitle());
        holder.newsSubtitle.setText(NewsListData.get(position).getGame());

        if(NewsListData.get(position).getCoverImage() != "No image found"){
            Picasso.with(context).load(NewsListData.get(position).getCoverImage()).into(holder.newsImage);
        }
    }

    @Override
    public int getItemCount() {
        return NewsListData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView newsTitle;
        private TextView newsSubtitle;
        private ImageView newsImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            newsTitle = (TextView) itemView.findViewById(R.id.news_title);
            newsSubtitle = (TextView) itemView.findViewById(R.id.news_subtitle);
            newsImage = (ImageView) itemView.findViewById(R.id.news_image);

        }
    }
}
