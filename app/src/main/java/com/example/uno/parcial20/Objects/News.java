package com.example.uno.parcial20.Objects;

public class News {

    private String _id;
    private String title;
    private String body;
    private String game;
    private String Image;
    private String description;
    private String created_date;
    private int __v;


    public News(String _id, String title, String body, String game, String image, String description, String created_date, int __v) {
        this._id = _id;
        this.title = title;
        this.body = body;
        this.game = game;
        this.Image = image;
        this.description = description;
        this.created_date = created_date;
        this.__v = __v;


    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

}
