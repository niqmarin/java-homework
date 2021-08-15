package ru.geekbrains.hw10;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.TreeSet;

public class Homework10 {

    public static void main(String[] args) {

        ///region задание 1
        System.out.println("--- задание 1 ---");
        String[] fruits = {"apple", "peach", "orange", "lemon", "blueberry", "pear", "raspberry", "peach", "lemon",
                "blueberry", "nectarine", "orange", "peach", "pear", "mango", "blueberry",
                "mango", "mango", "peach"};

        TreeSet<String> uniqueFruits = new TreeSet<>();
        TreeMap<String, Integer> statFruits  = new TreeMap<>();
        for (String fruit : fruits) {
            uniqueFruits.add(fruit);
            if (statFruits.containsKey(fruit)) {
                statFruits.put(fruit, statFruits.get(fruit) + 1);
            } else {
                statFruits.put(fruit, 1);
            }
        }

        System.out.println("список уникальных слов из массива:");
        for (String uniqueFruit : uniqueFruits) {
            System.out.println(uniqueFruit);
        }
        System.out.println();

        System.out.println("частота встречаемости слов в массиве:");
        for (Map.Entry<String, Integer> statFruit : statFruits.entrySet()) {
            System.out.println(statFruit.getKey() + "\t" + statFruit.getValue());
        }
        System.out.println();
        ///endregion

        ///region задание 2
        System.out.println("--- задание 2 ---");
        PhoneBook phoneBook01 = new PhoneBook();
        phoneBook01.add("84956325842", "Тритциев");
        phoneBook01.add("89104645855", "Леруашкина");
        phoneBook01.add("89103323232", "Иванов");
        phoneBook01.add("84997573198", "Иванов");
        phoneBook01.add("89174236365", "Маслякова");
        phoneBook01.add("89263874119", "Воробьева");
        phoneBook01.add("89658748563", "Мурзиков");
        //повторный ввод номера
        phoneBook01.add("84956325842", "Румянцева");
        phoneBook01.change("84956325842", "Румянцева");
        System.out.println();
        phoneBook01.get("Иванов");
        System.out.println();
        phoneBook01.get("Мурзиков");
        System.out.println();
        //поиск по фамилии, которой нет в справочнике
        phoneBook01.get("Сидоров");
        ///endregion
    }
}

class PhoneBook{
    private HashMap<String, String> phoneNumbers = new HashMap<>();

    public PhoneBook(String number,String surname) {
        phoneNumbers.put(number, surname);
    }

    public PhoneBook() {

    }

    public void add(String number,String surname) {
        if (phoneNumbers.containsKey(number)) {
            System.out.println("Номер уже есть в телефонной книге:");
            System.out.println(number + "\t" + phoneNumbers.get(number));
        } else {
            phoneNumbers.put(number, surname);
            System.out.printf("В телефонную книгу добавлена новая запись:\t%s\t%s\n", number, surname);
        }
    }

    public void get(String surname) {
        boolean exists = false;
        for (Map.Entry<String, String> entry : phoneNumbers.entrySet()) {
            if (entry.getValue().equals(surname)) {
                System.out.println(entry.getKey() + "\t" + surname);
                exists = true;
            }
        }
        if (!exists) {
            System.out.printf("Фамилии %s нет в телефонной книге\n", surname);
        }
    }

    public void change(String number,String surname) {
        if (phoneNumbers.containsKey(number)) {
            System.out.println("Запись изменена:");
            System.out.printf("%s\t%s", number, phoneNumbers.get(number));
            phoneNumbers.put(number, surname);
            System.out.printf("\t->\t%s\n", surname);
        } else {
            System.out.printf("Номера %s нет в телефонной книге\n", number);
        }
    }

}
