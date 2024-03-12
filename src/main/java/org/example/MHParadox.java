package org.example;

import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MHParadox {
    private static final RandomDataGenerator random = new RandomDataGenerator();

    public static void main(String[] args) {
        int numCycles = 1000;
        GameStatistics gameStatistics = playGames(numCycles);
        System.out.println("Статистика игры после " + numCycles + " циклов: ");
        Arrays.asList("Победы: " + gameStatistics.getWins(), "Поражения: " + gameStatistics.getLosses()).forEach(System.out::println);
    }
    private static GameStatistics playGames(int numCycles) {
        GameStatistics gameStatistics = new GameStatistics();
            for (int i = 0; i < numCycles; i++) {
                if (playGame()) {
                    gameStatistics.incrementWins();
                } else {
                    gameStatistics.incrementLosses();
                }
            }
            return gameStatistics;
    }

    private static boolean playGame() {

        int chosenDoor = random.nextInt(1, 3);
        int carBehindDoor = random.nextInt(1, 3);
        int openedDoor = findOpenedDoor(chosenDoor, carBehindDoor);

        return chosenDoor == carBehindDoor;
    }

    private static int findOpenedDoor(int chosenDoor, int carBehindDoor) {

        List<Integer> doors = new ArrayList<>();
        doors.add(1);
        doors.add(2);
        doors.add(3);

        doors.remove(Integer.valueOf(chosenDoor));
        doors.remove(Integer.valueOf(carBehindDoor));

        return doors.getFirst();
    }

}
