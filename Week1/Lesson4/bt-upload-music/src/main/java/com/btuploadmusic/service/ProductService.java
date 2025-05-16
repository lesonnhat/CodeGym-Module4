package com.btuploadmusic.service;

import com.btuploadmusic.model.Song;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{

    private final List<Song> songs;

    public ProductService() {
        songs = new ArrayList<>();
    }

    @Override
    public List<Song> findAll() {
        return songs;
    }

    @Override
    public Song findById(int id) {
        return songs.get(id);
    }

    @Override
    public void save(Song music) {
        songs.add(music);
    }

    @Override
    public void update(int id, Song song) {
        int index = songs.indexOf(findById(id));
        songs.set(index, song);
    }

    @Override
    public void remove(int id) {
        songs.remove(findById(id));
    }
}
