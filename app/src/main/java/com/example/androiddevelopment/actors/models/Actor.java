package com.example.androiddevelopment.actors.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class Actor {

    private int id;
    private String name;
    private String biography;
    private String image;
    private double rating;
    private Date doB;
    private List<Film> films;

    public Actor() {
        films = new ArrayList<>();
    }

    public Actor(int id, String name, String biography, String image, double rating, Date doB, List<Film> films) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.image = image;
        this.rating = rating;
        this.doB = doB;
        this.films = films;

        films = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return name;
    }
}
