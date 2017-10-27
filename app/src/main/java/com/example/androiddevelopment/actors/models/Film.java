package com.example.androiddevelopment.actors.models;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class Film {

    private int id;
    private String Name;
    private int Year;
    private Actor actor;

    public Film() {

    }

    public Film(int id, String name, int year, Actor actor) {
        this.id = id;
        Name = name;
        Year = year;
        this.actor = actor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
