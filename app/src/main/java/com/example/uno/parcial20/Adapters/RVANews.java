package com.example.uno.parcial20.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uno.parcial20.Objects.News;
import com.example.uno.parcial20.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVANews extends RecyclerView.Adapter<RVANews.MyViewHolder>{

    private Context context;
    private List<News> NewsListData;

    public RVANews(Context context, List<News> NewsListData){
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
        holder.Body.setText(NewsListData.get(position).getBody());

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
        private TextView Body;

        public MyViewHolder(View itemView) {
            super(itemView);

            newsTitle = (TextView) itemView.findViewById(R.id.news_title);
            newsSubtitle = (TextView) itemView.findViewById(R.id.news_subtitle);
            Body = (TextView) itemView.findViewById(R.id.body);
            newsImage = (ImageView) itemView.findViewById(R.id.news_image);

        }
    }
}
