package ru.geekbrains.hw08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Locale;

public class Homework08 {

    public static void main(String[] args) {
        //создаем два текстовых файла
        File jfFile = new File(".\\junkfood.txt");
        try {
            if (jfFile.createNewFile()) {
                System.out.println("файл junkfood.txt успешно создан");
            }
            else {
                System.out.println("файл junkfood.txt уже существует");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        File frFile = new File(".\\fruits.txt");
        try {
            if (frFile.createNewFile()) {
                System.out.println("файл fruits.txt успешно создан");
            }
            else {
                System.out.println("файл fruits.txt уже существует");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //записываем в файлы текст
        try {
            FileWriter writer = new FileWriter(jfFile);
            writer.write("Fish and chips\nSandwich\nPita\nHamburger\nFried chicken\nFrench fries\nOnion ring\n");
            writer.write("Chicken nugget\nTaco\nPizza\nHot dog\nIce cream");
            writer.close();
            System.out.println("данные успешно записаны в файл junkfood.txt");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            FileWriter writer = new FileWriter(frFile);
            writer.write("Apple\nWatermelon\nOrange\nPear\nCherry\nStrawberry\nNectarine\n");
            writer.write("Grape\nMango\nBlueberry\nPomegranate\nPlum\nBanana\nRaspberry\nMandarin");
            writer.close();
            System.out.println("данные успешно записаны в файл fruits.txt");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //объединяем файлы
        File newFile = mergeFiles(jfFile, frFile);

        //ищем слово в новом файле
        String word = "apple";
        /*if (searchWord(word, newFile)) {
            System.out.println("файл содержит слово " + word);
        } else {
            System.out.println("файл не содержит слово " + word);
        }*/
        searchWord(word, newFile);

        //ищем слово в папке
        File dir = new File(".\\");
        searchWordInDirectory(word, dir);

    }

    //склеивание двух файлов в третий
    public static File mergeFiles (File f1, File f2) {
        //вычленяем имена файлов без расширения
        StringBuilder  f1Name = new StringBuilder();
        f1Name.append(f1.getName(), 0, f1.getName().indexOf('.'));
        StringBuilder  f2Name = new StringBuilder();
        f2Name.append(f2.getName(), 0, f2.getName().indexOf('.'));
        File newFile = new File(".\\"+f1Name+"-"+f2Name+".txt");

        try {
            //читаем-записываем из первого файла
            FileReader reader = new FileReader(f1);
            int i = -1;
            char[] buf = new char[50];
            FileWriter writer = new FileWriter(newFile);
            while ((i = reader.read(buf)) != -1) {
                String s = new String(buf, 0, i);
                writer.write(s);
                writer.flush();
            }

            writer.write("\n");
            writer.flush();

            //читаем-записываем из второго файла
            reader = new FileReader(f2);
            i = -1;
            writer = new FileWriter(".\\"+f1Name+"-"+f2Name+".txt", true);
            while ((i = reader.read(buf)) != -1) {
                String s = new String(buf, 0, i);
                writer.write(s);
                writer.flush();
            }
            reader.close();
            writer.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return newFile;
    }

    //поиск слова в файле
    public static boolean searchWord (String word, File file) {
        boolean isFound = false;
        try {
            FileReader reader = new FileReader(file);
            int i = -1;
            char[] buf = new char[250];
            while ((i = reader.read(buf)) != -1){
                String s = new String(buf, 0, i);
                if (s.toLowerCase().contains(word)){
                    isFound = true;
                    break;
                }
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (isFound) {
            System.out.printf("файл %s содержит слово %s\n", file.getName(), word);
        } else {
            System.out.printf("файл %s не содержит слово %s\n", file.getName(), word);
        }
        return isFound;
    }

    //поиск слова в папке с нескольими файлами
    public static void searchWordInDirectory (String word, File dir) {
        System.out.printf("\nпоиск слова %s в файлах папки %s:\n", word, dir.getName());
        File[] files = dir.listFiles();
        for (int j = 0; j < files.length; j++) {
            if (files[j].isFile()) {
                searchWord(word, files[j]);
            }
        }
    }

}
