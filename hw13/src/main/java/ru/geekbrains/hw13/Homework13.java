package ru.geekbrains.hw13;

import java.util.concurrent.CyclicBarrier;

public class Homework13 {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(cyclicBarrier, race, 20 + (int)(Math.random() * 10));
            System.out.println(cars[i].getName() + ", скорость " + cars[i].getSpeed());
        }
        System.out.println();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка");
        Thread[] carThreads = new Thread[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            carThreads[i] = new Thread(cars[i]);
            carThreads[i].start();
        }
        //System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась");
        for (Thread carThread : carThreads) {
            try {
                carThread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась");

    }
}


