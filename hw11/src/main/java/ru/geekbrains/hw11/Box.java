package ru.geekbrains.hw11;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<F extends Fruit> {

    private ArrayList<F> fruits = new ArrayList<>();
    private static int counter = 0;
    private final int ID;

    {
        counter++;
    }

    public Box() {
        ID = counter;
    }

    //положить в коробку 1 фрукт
    public void add(F fruit) {
        if (fruits.isEmpty() || fruits.get(0).getClass() == fruit.getClass()) {
            fruits.add(fruit);
            System.out.printf("в коробку №%d положили 1 %s\n", ID, fruit.getName());
        } else {
            switch (fruit.getClass().getSimpleName()) {
                case "Apple":
                    System.out.println("в коробку с апельсинами нельзя положить яблоки");
                    break;
                case "Orange":
                    System.out.println("в коробку с яблоками нельзя положить апельсины");
                    break;
            }
        }
    }

    //положить в коробку фрукты из массива
    public void add(F[] arrFruits) {
        if (arrFruits.length > 0) {
            if (fruits.isEmpty() || fruits.get(0).getClass() == arrFruits[0].getClass()) {
                fruits.addAll(Arrays.asList(arrFruits));
                switch (arrFruits[0].getClass().getSimpleName()) {
                    case "Apple":
                        System.out.printf("в коробку №%d положили несколько яблок: %d\n", ID, arrFruits.length);
                        break;
                    case "Orange":
                        System.out.printf("в коробку №%d положили несколько апельсинов: %d\n", ID, arrFruits.length);
                        break;
                }
            } else {
                switch (arrFruits[0].getClass().getSimpleName()) {
                    case "Apple":
                        System.out.println("в коробку с апельсинами нельзя положить яблоки");
                        break;
                    case "Orange":
                        System.out.println("в коробку с яблоками нельзя положить апельсины");
                        break;
                }
            }
        }
    }

    //положить в коробку фрукты из списка
    public void add(ArrayList<F> listFruits) {
        if (!listFruits.isEmpty()) {
            if (fruits.isEmpty() || fruits.get(0).getClass() == listFruits.get(0).getClass()) {
                fruits.addAll(listFruits);
                switch (listFruits.get(0).getClass().getSimpleName()) {
                    case "Apple":
                        System.out.printf("в коробку №%d положили несколько яблок: %d\n", ID, listFruits.size());
                        break;
                    case "Orange":
                        System.out.printf("в коробку №%d положили несколько апельсинов: %d\n", ID, listFruits.size());
                        break;
                }
            } else {
                switch (listFruits.get(0).getClass().getSimpleName()) {
                    case "Apple":
                        System.out.println("в коробку с апельсинами нельзя положить яблоки");
                        break;
                    case "Orange":
                        System.out.println("в коробку с яблоками нельзя положить апельсины");
                        break;
                }
            }
        }

    }

    public float getWeight() {
        if (!fruits.isEmpty()) {
            return fruits.get(0).getWEIGHT() * (float)fruits.size();
        } else {
            return 0;
        }
    }

    public boolean compare (Box<F> another) {
        return this.getWeight() == another.getWeight();
    }


    public ArrayList<F> getFruits() {
        return fruits;
    }

    public int getID() {
        return ID;
    }

    public void moveAll(Box<F> another) {
        if (!fruits.isEmpty()) {
            another.add(fruits);
            fruits.clear();
        } else {
            System.out.printf("из коробки №%d нечего переложить\n", ID);
        }
    }

    public void getInfo() {
        if (!fruits.isEmpty()) {
            System.out.printf("в коробке №%d лежит фрукт %s в количестве %d шт. вес коробки равен %f ед.\n",
                    ID, fruits.get(0).getName(), fruits.size(), getWeight());
        } else {
            System.out.printf("коробка №%d пуста. вес коробки 0 ед.\n", ID);
        }
    }


}
