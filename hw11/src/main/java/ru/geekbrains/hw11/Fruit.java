package ru.geekbrains.hw11;

public abstract class Fruit {
    private final String name;

    public String getName() {
        return name;
    }

    public abstract float getWEIGHT();

    public Fruit(String name) {
        this.name = name;
    }

}

class Apple extends Fruit {
    private final float WEIGHT = 1.0f;

    public float getWEIGHT() {
        return WEIGHT;
    }

    public Apple() {
        super("яблоко");
    }
}

class Orange extends Fruit {
    private final float WEIGHT = 1.5f;

    public float getWEIGHT() {
        return WEIGHT;
    }

    public Orange() {
        super("апельсин");
    }
}

