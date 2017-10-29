package com.example.androiddevelopment.actors.providers;

import com.example.androiddevelopment.actors.models.Actor;
import com.example.androiddevelopment.actors.models.Film;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class FilmProvider {

    public static List<Film> getFilms() {

        ArrayList<Film> films0 = new ArrayList<>();

        Actor christophWaltz = new Actor(0, "Christoph Waltz",
                "Christoph Waltz is an Austrian-German actor. " +
                        "He is known for his works with American filmmaker Quentin Tarantino. " +
                        "He was born in Vienna and for each performance with Tarrantino, " +
                        "he won an Academy Award, a BAFTA Award, and a Golden Globe Award for Best Supporting Actor.",
                "ChristophWaltz.jpg", 9.5, new Date("1956-10-04"), films0);

        List<Film> films = new ArrayList<>();
        films.add(new Film(0, "Inglorious Basterds", 2009, christophWaltz));
        films.add(new Film(1, "Django Unchained", 2012, christophWaltz));
        films.add(new Film(2, "James Bond Spectre", 2015, christophWaltz));

        return films;
    }

    public static List<String> getFilmNames() {

        List<String> names = new ArrayList<>();
        names.add("Inglorious Basterds");
        names.add("Django Unchained");
        names.add("James Bond Spectre");

        return names;
    }

    public static List<Integer> getFilmYears() {

        List<Integer> years = new ArrayList<>();
        years.add(2009);
        years.add(2012);
        years.add(2015);

        return years;
    }

    public static Film getFilmsById(int id) {

        ArrayList<Film> films0 = new ArrayList<>();

        Actor christophWaltz = new Actor(0, "Christoph Waltz",
                "Christoph Waltz is an Austrian-German actor. " +
                        "He is known for his works with American filmmaker Quentin Tarantino. " +
                        "He was born in Vienna and for each performance with Tarrantino, " +
                        "he won an Academy Award, a BAFTA Award, and a Golden Globe Award for Best Supporting Actor.",
                "ChristophWaltz.jpg", 9.5, new Date("1956-10-04"), films0);

        switch (id) {
            case 0:
                return new Film(0, "Inglorious Basterds", 2009, christophWaltz);
            case 1:
                return new Film(1, "Django Unchained", 2012, christophWaltz);
            case 2:
                return new Film(2, "James Bond Spectre", 2015, christophWaltz);
            default:
                return null;
        }
    }
}
