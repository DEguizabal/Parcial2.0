package com.example.uno.parcial20.Objects;

public class News {
    private String imageNews;
    private String titleNews;
    private String subtitleNews;
    private boolean favoriteNews;
    private int newsID;

    public News(String imageNews, String titleNews, String subtitleNews, boolean favoriteNews, int newsID) {
        this.imageNews = imageNews;
        this.titleNews = titleNews;
        this.subtitleNews = subtitleNews;
        this.favoriteNews = favoriteNews;
        this.newsID = newsID;
    }

    public String getimageNews() {

        return imageNews;
    }

    public void setimageNews(String imageNews) {
        this.imageNews = imageNews;
    }

    public String gettitleNews() {
        return titleNews;
    }

    public void settitleNews(String titleNews) {
        this.titleNews = titleNews;
    }

    public String getSubtitleNews() {
        return subtitleNews;
    }

    public void setSubtitleNews(String subtitleNews) {
        this.subtitleNews = subtitleNews;
    }

    public boolean isFavoriteNews() {
        return favoriteNews;
    }

    public void setFavoriteNews(boolean favoriteNews) {
        this.favoriteNews = favoriteNews;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }
}
