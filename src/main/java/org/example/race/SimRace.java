package org.example.race;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SimRace {
    private final int numberOfCars;
    private final int numberOfRounds;

    public SimRace(int numberOfCars, int numberOfRounds) {
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
    }

    public void startRace() {
        List<Car> carList = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            Car car = new Car(numberOfRounds, i);
            carList.add(car);
        }

        for (Car car : carList) {
            Thread thread = new Thread(car);
            thread.start();
            threadList.add(thread);
        }

        while (isAnyCarIsStillRunning(threadList)) {
        }
        System.out.println("**** Endstand nach " + numberOfRounds + " Runden ****");
        carList = carList.stream().sorted(Comparator.comparingDouble(Car::getTime)).toList();
        int currentRank = 1;
        for (Car car : carList) {
            System.out.println(currentRank + ". Platz: " + car);
            currentRank++;
        }
    }

    public boolean isAnyCarIsStillRunning(List<Thread> threadList) {
        for (Thread thread : threadList) {
            if (thread.isAlive()) {
                return true;
            }
        }
        return false;
    }
}
