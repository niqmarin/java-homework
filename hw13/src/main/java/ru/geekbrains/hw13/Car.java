package ru.geekbrains.hw13;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable{

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private CyclicBarrier cyclicBarrier;
    private static boolean start;
    private static boolean first;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(CyclicBarrier cyclicBarrier, Race race, int speed) {
        this.cyclicBarrier = cyclicBarrier;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "участник №" + CARS_COUNT;
    }

    @Override
    public void run() {
        //начало подготовки
        try {
            System.out.println("  " + this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //ждем, пока все подготовятся, чтобы одновременно начать
        try {
            System.out.println("  " + this.name + " готов");
            this.cyclicBarrier.await();
            if (!start) {
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась");
                start = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //поехали по препятствиям гонки
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        //если у двух машин одинаковая скорость, получаеся два победителя, я не придумала, как это победить
        if (!first) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> " + name + " ПОБЕДИЛ");
            first = true;
        }
    }
}
