package org.example.race;

import java.util.Random;

public class Car implements Runnable {
    private final int numberOfRounds;
    private final int carNumber;
    private int currentRound;
    private int time;
    private final static Random random = new Random();

    public Car(int numberOfRounds, int carNumber) {
        this.numberOfRounds = numberOfRounds;
        this.carNumber = carNumber;
        time = 0;
        currentRound = 1;
    }

    public double getTime() {
        return time;
    }

    private void addTime(int time) {
        this.time += time;
    }

    @Override
    public void run() {
        while (currentRound <= numberOfRounds) {
            int neededTime = random.nextInt(100);
            try {
                Thread.sleep(neededTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentRound++;
            addTime(neededTime);
        }
    }

    @Override
    public String toString() {
        return "Wagen " + carNumber + " Zeit: " + time + "ms";
    }
}
