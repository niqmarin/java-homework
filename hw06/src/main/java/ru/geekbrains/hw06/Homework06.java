package ru.geekbrains.hw06;

public class Homework06 {

    public static void main(String[] args) {
        Animal animal01 = new Animal("жираф");
        Animal animal02 = new Animal("крокодил");
        System.out.println(animal01.toString());
        System.out.println(animal02.toString());
        animal01.run(320);
        animal02.swim(118);
        System.out.println();

        Animal cat01 = new Cat("Маркиз");
        Cat cat02 = new Cat("Пират");
        System.out.println(cat01.toString());
        System.out.println(cat02.toString());
        cat01.run(500);
        cat02.swim(20);
        Cat cat03 = new Cat();
        System.out.println(cat03.toString());
        cat03.setName("Батон");
        System.out.println(cat03.toString());
        System.out.println();

        Dog dog01 = new Dog("Бобик");
        dog01.swim(8);
        Dog dog02 = new Dog();
        System.out.println(dog02.toString());
        dog02.setName("Лёнчик");
        dog02.run(250);
        System.out.println();

        int animalCounter = Animal.getCounter();
        System.out.println("животных создано: " + animalCounter);
        int catCounter = Cat.getCounter();
        System.out.println("котов создано: " + catCounter);
        int dogCounter = Dog.getCounter();
        System.out.println("собак создано: " + dogCounter);
    }
}
