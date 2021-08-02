package ru.geekbrains.hw03;

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Homework03 {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int g;


    ///region угадывание числа
    static void guessNumber () {
        System.out.println("~ угадайте число за три попытки ~");
        System.out.println("введите число от 0 до 9");
        do {                                    //играем пока не выберем 0 нет
            int x = rand.nextInt(10);
            for (int i = 1; i <= 3; i++) {      //играем три попытки
                String message = "попытка " + i + ":\t";
                g = getNumberFromScanner(message, 0, 9); //неверный ввод не считается за попытку
                if (x == g) {
                    System.out.println("~ вы угадали ~");
                    break;
                } else if (i == 3 && x < g) {
                    System.out.format("загаданное число меньше %d. вы проиграли\n ", g);
                } else if (x < g) {
                    System.out.println("загаданное число меньше " + g);
                } else if (i == 3 && x > g) {
                    System.out.format("загаданное число больше %d. вы проиграли\n ", g);
                } else {
                    System.out.println("загаданное число больше " + g);
                }
            }
            g = getNumberFromScanner("сыграем снова? ( 1 – да, 0 – нет)\t", 0, 1);
        } while (g == 1);
    }
    ///endregion

    ///region угадывание слова
    static void guessWord () {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
        "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
        "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
        "pear", "pepper", "pineapple", "pumpkin", "potato"}; //25

        System.out.println("~ угадайте слово ~");
        do {                               //играем пока не выберем 0 нет
            String xWord = words[rand.nextInt(words.length)];
            //System.out.println(xWord);   //вывод слова на случай если лень угадывать
            System.out.println("попробйте угадать слово:");
            String gWord = sc.nextLine();
            String hintWord = "";

            while (true) {                  //играем пока не угадаем
                if (xWord.equals(gWord)) {
                    System.out.println("~ вы угадали ~");
                    break;
                } else {
                    for (int i = 0; i < Math.min(xWord.length(), gWord.length()); i++) { //выбираем меньшую из двух длин, чтобы не налететь на ошибку
                        if (xWord.charAt(i) == gWord.charAt(i)) {           //если буква совпала, печатаем в подсказку её
                            hintWord += gWord.charAt(i);
                        } else {
                            hintWord += "*";                                //если нет - звёздочку
                        }
                    }
                    hintWord = addStars(hintWord);
                    if (hintWord.equals("***************")){
                        System.out.println("вы совсем не угадали :( попробуйте ещё раз:");
                    } else {
                        System.out.println("вы угадали некоторые буквы, попробуйте ещё раз:");
                        System.out.println("подсказка:\t" + hintWord);
                    }
                }
                gWord = sc.nextLine();
                hintWord = "";
            }
            g = getNumberFromScanner("сыграем снова? ( 1 – да, 0 – нет)\t", 0, 1);
        }
        while (g == 1);
    }
    ///endregion

    ///region получение числа от сканера в заданных пределах с проверками и сообщением
    static int getNumberFromScanner(String message, int min, int max) {
        int n = 0;
        System.out.print(message);
        boolean isOk = false;
        do {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                sc.nextLine();
                if (n >= min && n <= max ) {
                    isOk = true;
                } else {
                    System.out.print("число выходит за указанные пределы\n" + message);
                }
            } else {
                sc.nextLine();
                System.out.print("это не число\n" + message);
            }
        }
        while (!isOk);
        return n;
    }
    ///endregion

    ///region добавление в хвост звёздочек до длины в 15 символов
    static String addStars (String word) {
        String starredWord = word;
        for(int i = word.length(); i < 15; i++) {
            starredWord += "*";
        }
        return starredWord;
    }
    ///endregion

    public static void main(String[] args) {

        System.out.println("~ добро пожаловать в мир консольных развлечений ~");
        boolean fExit = false;
        while (!fExit) {
            System.out.println("1 - игра \"угадай число\"");
            System.out.println("2 - игра \"Угадай слово\"");
            System.out.print("выберите игру (0 - выход из программы):\t");
            if (sc.hasNextInt()){
                int no = sc.nextInt();
                sc.nextLine();
                switch (no){
                    case 0:
                        System.out.println("~ до свидания ~");
                        fExit = true;
                        break;
                    case 1:
                        guessNumber();
                        break;
                    case 2:
                        guessWord();
                        break;
                    default:
                        System.out.println("нет игры с таким номером\nпожалуйста, повторите попытку ввода");

                }
            }
            else{
                System.out.println("это не число\nпожалуйста, повторите попытку ввода");
                sc.nextLine();
            }
        }
        sc.close();

    }


}

