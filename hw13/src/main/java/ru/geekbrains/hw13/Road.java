package ru.geekbrains.hw13;

public class Road extends Stage{

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car car) {
        try {
            System.out.println("  " + car.getName() + " начл этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000);
            System.out.println("  " + car.getName() + " закончил этап: " + description);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
