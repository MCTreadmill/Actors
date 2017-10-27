package com.example.androiddevelopment.actors.providers;

import com.example.androiddevelopment.actors.models.Actor;
import com.example.androiddevelopment.actors.models.Film;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 27.10.17..
 */

public class ActorProvider {

    public static List<Actor> getActors() {

        ArrayList<Film> films0 = new ArrayList<>();

        List<Actor> actors = new ArrayList<>();

        actors.add(new Actor(0, "Christoph Waltz",
                "Christoph Waltz is an Austrian-German actor. " +
                        "He is known for his works with American filmmaker Quentin Tarantino. " +
                        "He was born in Vienna and for each performance with Tarrantino, " +
                        "he won an Academy Award, a BAFTA Award, and a Golden Globe Award for Best Supporting Actor.",
                "ChristophWaltz.jpg", 9.5, new Date("1956-10-04"), films0));

        return actors;
    }

    public static List<String> getActorNames() {

        List<String> names = new ArrayList<>();
        names.add("Christoph Waltz");

        return names;
    }

    public static Actor getActorById(int id) {

        ArrayList<Film> films0 = new ArrayList<>();

        Actor christophWaltz = new Actor(0, "Christoph Waltz",
                "Christoph Waltz is an Austrian-German actor. " +
                        "He is known for his works with American filmmaker Quentin Tarantino. " +
                        "He was born in Vienna and for each performance with Tarrantino, " +
                        "he won an Academy Award, a BAFTA Award, and a Golden Globe Award for Best Supporting Actor.",
                "ChristophWaltz.jpg", 9.5, new Date("1956-10-04"), films0);

        switch (id) {
            case 0:
                return new Actor(0, "Christoph Waltz",
                        "Christoph Waltz is an Austrian-German actor. " +
                                "He is known for his works with American filmmaker Quentin Tarantino. " +
                                "He was born in Vienna and for each performance with Tarrantino, " +
                                "he won an Academy Award, a BAFTA Award, and a Golden Globe Award for Best Supporting Actor.",
                        "ChristophWaltz.jpg", 9.5, new Date("1956-10-04"), films0);
            default:
                return null;
        }


    }
}
