package ru.geekbrains.hw13;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore semaphore = new Semaphore(Homework13.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println("  " + car.getName() + " готовится к этапу (ждет): " + description);
            //только половина учстников может въехать в тоннель
            semaphore.acquire();
            System.out.println("  " + car.getName() + " начл этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("  " + car.getName() + " закончил этап: " + description);
            semaphore.release();
        }
    }
}
