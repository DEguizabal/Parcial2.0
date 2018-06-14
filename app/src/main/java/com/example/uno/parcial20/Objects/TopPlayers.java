package com.example.uno.parcial20.Objects;

public class TopPlayers {

    private String pic;
    private String _id;
    private String name;
    private String bio;
    private String game;
    private int __v;

    public TopPlayers(String pic, String _id, String name, String bio, String game, int __v){
        this.pic = pic;
        this._id = _id;
        this.name = name;
        this.bio = bio;
        this.game = game;
        this.__v = __v;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
