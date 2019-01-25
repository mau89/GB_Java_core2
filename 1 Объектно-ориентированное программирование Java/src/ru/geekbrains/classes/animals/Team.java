package ru.geekbrains.classes.animals;

import ru.geekbrains.classes.Participant;
import ru.geekbrains.classes.Robot;

public class Team {
    Participant[] participants;
    private String name;

    public String getName() {
        return name;

    }


    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public void showResults() {
        for (Participant participant1 : participants
        ) {
            System.out.println(participant1);
        }
    }


}
