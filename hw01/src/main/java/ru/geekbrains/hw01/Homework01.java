package ru.geekbrains.hw01;

public class Homework01 {


    public static void main(String[] args) {

        System.out.println("задание 1. раз программа запустилась, значит метод main прописан правильно\n");

        //region задание 2
        int a = 5361;
        short b = 2;
        long c;
        c = -9223372036854775808L;
        byte d = -118;
        float e = 64.1286f;
        double f = -354.1721;
        boolean g = false;
        char h = 'H';
        System.out.println("int a = " + a + "\nshort b = " + b + "\nlong c = " + c + "\nbyte d = " + d);
        System.out.println("float e = " + e + "\ndouble f = " + f + "\nboolean g = " + g + "\nchar h = " + h + "\n");
        //endregion

        float k = -13.26f, l = 175.314f, m = 57.371f;       //задание 3
        System.out.println("вычисление a * (b + (c / d)) = " + myCalc(e, k, l, m) + "\n");

        int z = -5350;                                      //задание 4
        System.out.println("сумма чисел в пределах от 10 до 20 включительно: " + myCheck(a, z) + "\n");

        myIsPositive(b);                                    //задание 5

        System.out.println("число отрицательное: " + myIsNegative(c) + "\n");       //задание 6

        String n = "Константин";                            //задание 7
        myHelloName(n);

        short y = 1900;                                     //задание 8
        myYearCheck(y);
    }

    //region задание 3.  a * (b + (c / d)), тип float

    static float myCalc(float a, float b, float c, float d) {
        System.out.println("задание 3.\na = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
        return a * (b + (c / d));
    }
    //endregion

    //region задание 4. сумма двух чисел лежит в пределах от 10 до 20 (включительно), true/false
    static boolean myCheck(int a, int b) {
        int sum = a + b;
        System.out.println("задание 4.\n" + a + " + " + b + " = " + sum);
        return (sum >= 10 && sum <= 20);
    }
    //endregion

    //region задание 5. число положительное или отрицательное (0 - положительное)
    static void myIsPositive(short a){
        System.out.println("задание 5.\nчисло " + a);
        if (a >= 0) {
            System.out.println("число положительное\n");
        } else {
            System.out.println("число отрицательное\n");
        }

    }
    //endregion

    //region задание 6. число отрицательное true/false
    static boolean myIsNegative(long a) {
        System.out.println("задание 6.\nчисло " + a);
        return (a < 0);
    }
    //endregion

    //region задание 7. вывести "Привет, указанное_имя!"
    static void myHelloName(String name){
        System.out.println("задание 7.\nПривет, " + name + "!\n");
    }
    //endregion

    //region задание 8. проверка года на високосность
    static void myYearCheck(short year) {
        System.out.println("задание 8.\nявляется ли год " + year + " високосным?");
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 ==0) {
                    System.out.println("да, " + year + " год - високосный");
                } else
                    System.out.println("нет, " + year + " год - не високосный");
            } else System.out.println("да, " + year + " год - високосный");
        } else System.out.println("нет, " + year + " год - не високосный");
    }
    //endregion

}
