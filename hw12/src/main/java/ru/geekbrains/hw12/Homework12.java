package ru.geekbrains.hw12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Homework12 {

    static final int SIZE = 10000000;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("введите число потоков:");
        int n = scanner.nextInt();
        scanner.close();

        arrayCalculate1();
        new Homework12().arrayCalculate2(n);
    }

    //вычисление маасива в одном потоке
    public static void arrayCalculate1() {

        float[] arr = new float[SIZE];
        for (int i  = 0; i < SIZE; i++) {
            arr[i] = 1f;
        }
        long time1 = System.currentTimeMillis();
        for (int i  = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long time2 = System.currentTimeMillis();
        System.out.printf("выполнение метода arrayCalculate1 в одном потоке заняло %d миллисекунд\n", time2 - time1);
    }

    //вычисление массива в n потоках
    public void arrayCalculate2(int n) {
        float[] arr = new float[SIZE];
        for (int i  = 0; i < SIZE; i++) {
            arr[i] = 1f;
        }
        long time1 = System.currentTimeMillis();
        int newSize = SIZE / n;
        int newSizeLast = SIZE - newSize * (n - 1); //на случай если массив нельзя разделить на равные части

        ArrayList<float[]> arrList = new ArrayList<>();
        //разделение массива на несколько
        for (int i = 0, pos = 0; i < n; i++, pos += newSize) {
            float[] arr01;
            if (i == n -1) {
                arr01 = new float[newSizeLast];
                System.arraycopy(arr, pos, arr01, 0, newSizeLast);
            }
            else {
                arr01 = new float[newSize];
                System.arraycopy(arr, pos, arr01, 0, newSize);
            }
            arrList.add(arr01);
        }

        //запуск обработки массивов в потоках
        Thread[] myThreads = new Thread[n];
        for (int i = 0; i < n; i++) {
            myThreads[i] = new MyThread(arrList.get(i));
            myThreads[i].start();
        }
        for (Thread myThread : myThreads) {
            try {
                myThread.join();
            }
            catch (InterruptedException ex)
            {
                System.out.println("Выполнение потока было прервано.");
            }
        }

        //склейка массивов в один
        for (int i = 0, pos = 0; i < n; i++, pos += newSize) {
            if (i == n -1) {
                System.arraycopy(arrList.get(i), 0, arr, pos, newSizeLast);
            }
            else {
                System.arraycopy(arrList.get(i), 0, arr, pos, newSize);
            }
        }

        long time2 = System.currentTimeMillis();
        System.out.printf("выполнение метода arrayCalculate2 в %d потоках заняло %d миллисекунд\n", n, time2 - time1);
    }

    class MyThread extends Thread {

        float[] arr;

        public MyThread(float[] arr) {
            this.arr = arr;
        }

        @Override
        public void run() {
            for (int i  = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }


}
