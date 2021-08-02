package ru.geekbrains.hw06;

public class Dog extends Animal{
    private String name; //кличка
    private static int counter = 0; //счетчик

    {
        counter++;
    }

    public Dog(){
        super.setName("пёс");
        this.name = Integer.toString(counter);
    }

    public Dog(String name) {
        super.setName("пёс");
        this.name = name;
    }

    @Override
    public void run(int distance) {
        distance = Math.max(Math.min(distance, 500), 0);
        System.out.printf("%s %s пробежал %d м\n", super.getName(), this.name, distance);
    }

    @Override
    public void swim(int distance) {
        distance = Math.max(Math.min(distance, 10), 0);
        System.out.printf("%s %s проплыл %d м\n", super.getName(), this.name, distance);
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
