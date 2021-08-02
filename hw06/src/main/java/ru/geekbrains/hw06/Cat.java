package ru.geekbrains.hw06;

public class Cat extends Animal{

    private String name; //кличка
    private static int counter = 0; //счетчик

    {
        counter++;
    }

    public Cat(){
        super.setName("кот");
        this.name = Integer.toString(counter);
    }

    public Cat(String name) {
        super.setName("кот");
        this.name = name;
    }

    @Override
    public void run(int distance) {
        distance = Math.max(Math.min(distance, 200), 0);
        System.out.printf("%s %s пробежал %d м\n", super.getName(), this.name, distance);
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s %s не умеет плавать\n", super.getName(), this.name);
    }

    public static int getCounter(){
        return counter;
    }

    @Override
    public String toString() {
        return super.getName() + " " + this.name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
