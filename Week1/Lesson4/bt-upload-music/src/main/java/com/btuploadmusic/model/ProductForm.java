package com.btuploadmusic.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private int id;
    private String title;
    private String artist;
    private String category;
    private MultipartFile music;

    public ProductForm() {
    }

    public ProductForm(int id, String title, String artist, String category, MultipartFile music) {
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

    public MultipartFile getMusic() {
        return music;
    }

    public void setMusic(MultipartFile music) {
        this.music = music;
    }
}
