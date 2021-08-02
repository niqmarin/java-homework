package ru.geekbrains.hw06;

public class Animal {

    private String name; //название
    private static int counter = 0; //счетчик

    {
        counter++;
    }

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public void run(int distance) {
        distance = Math.max(distance, 0);
        System.out.printf("%s пробежал %d м\n", this.name, distance);
    }

    public void swim(int distance) {
        distance = Math.max(distance, 0);
        System.out.printf("%s проплыл %d м\n", this.name, distance);
    }

    @Override
    public String toString() {
        return "животное " + this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }
}
