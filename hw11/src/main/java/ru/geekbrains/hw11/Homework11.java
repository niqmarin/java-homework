package ru.geekbrains.hw11;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework11 {

    public static void main(String[] args) {

        Integer[] arr01 = {1, 1, 2, 3, 5, 8, 13, 21};
        String[] arr02 = {"mango", "peach", "lemon", "pear", "blueberry"};

        System.out.println("--- задание 1 ---");
        System.out.println("поменяем местами элементы массивов:");
        System.out.println(Arrays.toString(arr01));
        ArrayNewM.changeElements(arr01, 1, 7); //меняем местами 1 и 21
        System.out.println(Arrays.toString(arr01));
        System.out.println(Arrays.toString(arr02));
        ArrayNewM.changeElements(arr02, 4, 3); //меняем местами pear и blueberry
        System.out.println(Arrays.toString(arr02));
        System.out.println();

        System.out.println("--- задание 2 ---");
        System.out.println("запишем массив в ArrayList:");
        ArrayList<Integer> arrayList01 = ArrayNewM.arrayToList(arr01);
        System.out.println(arrayList01);
        ArrayList<String> arrayList02 = ArrayNewM.arrayToList(arr02);
        System.out.println(arrayList02);
        System.out.println();

        System.out.println("--- задание 3 ---");
        Box box01 = new Box();
        box01.getInfo();
        Apple apple01 = new Apple();
        Orange orange01 = new Orange();
        box01.add(apple01);
        box01.add(orange01);
        for (int i = 0; i <8; i++) {
            box01.add(new Apple());
        }
        box01.getInfo();
        System.out.println();

        Box<Orange> box02 = new Box<>();
        for (int i = 0; i < 6; i++) {
            box02.add(new Orange());
        }
        box02.getInfo();
        if (box02.compare(box01)) {
            System.out.printf("коробки №%d и №%d весят одинаково\n", box02.getID(), box01.getID());
        }
        System.out.println();

        Box<Apple> box03 = new Box<>();
        box03.add(new Apple());
        box03.add(new Apple());
        box03.getInfo();
        box01.moveAll(box03);
        box01.getInfo();
        box03.getInfo();
        box01.moveAll(box03);
    }

}

class ArrayNewM<T> {

    //метод меняет местами элементы массива
    public static <T> void changeElements(T[] array, int i, int j) {
        if (i >= 0 && i < array.length && j >= 0 && j < array.length) {
            T buf = array[i];
            array[i] = array[j];
            array[j] = buf;
        } else {
            System.out.println("введены неорректные значения элементов массива");
        }
    }

    //метод записывает массив в список
    public static <T> ArrayList<T> arrayToList (T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}