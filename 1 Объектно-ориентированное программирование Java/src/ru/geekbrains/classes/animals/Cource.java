package ru.geekbrains.classes.animals;

import ru.geekbrains.classes.Participant;
import ru.geekbrains.classes.obstacles.Cross;
import ru.geekbrains.classes.obstacles.Obstacle;
import ru.geekbrains.classes.obstacles.Wall;
import ru.geekbrains.classes.obstacles.Water;

public class Cource {
    Obstacle[] obstacles;

    public Cource(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }


    public void doIt(Team team) {
        System.out.println("Команда: " + team.getName() + "! на дистанции!");
        Participant[] participants = team.participants;
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                obstacle.doIt(participant);
                if (!participant.isOnDistance()) {
                    break;
                }
            }
        }
    }

}
