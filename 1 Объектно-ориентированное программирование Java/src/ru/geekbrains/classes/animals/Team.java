package ru.geekbrains.classes.animals;

import ru.geekbrains.classes.Participant;
import ru.geekbrains.classes.Robot;

public class Team {
    Participant[] participants;
    private String name;

    public String getName() {
        return name;

    }


    public Team(String name) {
        this.name = name;

        this.participants = new Participant[]{
                new Cat("Барсик", 10, 12, 0),
                new Dog("Дружок", 20, 5, 15),
                new Cat("Мурзик", 9, 14, 0),
                new Robot("Вертер", 50, 50, 50),
        };

    }

    public void showResults() {
        for (Participant participant1 : participants
        ) {
            System.out.println(participant1);

        }
    }


}
