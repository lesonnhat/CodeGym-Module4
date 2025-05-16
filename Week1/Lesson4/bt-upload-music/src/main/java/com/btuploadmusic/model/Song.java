package com.btuploadmusic.model;

public class Song {
    private int id;
    private String title;
    private String artist;
    private String category;
    private String music;

    public Song() {
    }

    public Song(int id, String title, String artist, String category, String music) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.music = music;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }
}
