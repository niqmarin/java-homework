package ru.geekbrains.hw02;

public class Homework02 {

    static int p = 0; //для задания 6, чтобы запомнить место

    public static void main(String[] args) {

        ///region задание 1 - замена значений 0 на 1 и 1 на 0
        System.out.println("задание 1");
        int[] arr1 = {0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0};
        printArrayLine(arr1);
        for (int i = 0; i < arr1.length; i++) {
            switch (arr1[i]) {
                case 0: arr1[i] = 1;
                    break;
                case 1: arr1[i] = 0;
                    break;
            }
        }
        printArrayLine(arr1);
        System.out.println();

        ///endregion

        ///region задание 2 - заполнение пустого массива в цикле. массив размером 8, значения 0 3 6 9 12 15 18 21
        System.out.println("задание 2");
        int[] arr2 = new int[8];
        for (int i = 0, j = 0; i < arr2.length; i++, j += 3) {
            arr2[i] = j;
        }
        printArrayLine(arr2);
        System.out.println();

        ///endregion

        ///region задание 3 - элементы массива меньше 6 умножить на 2
        System.out.println("задание 3");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArrayLine(arr3);
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        printArrayLine(arr3);
        System.out.println();
        ///endregion

        ///region задание 4 - заполнение диагональных элементов квадратного массива в цикле
        System.out.println("задание 4");
        int[][] arr4 = new int[7][7];
        System.out.println("заполняем главную диагональ");
        for (int i = 0; i < arr4.length; i++){
            arr4[i][i] = 1;
        }
        printArrayTable(arr4);
        System.out.println("заполняем вторую диагональ");
        for (int i = 0, j = arr4.length-1; i < arr4.length; i++, j--){
              arr4[i][j] = 1;
        }
        printArrayTable(arr4);
        System.out.println();
        ///endregion

        ///region задание 5 - поиск максимального и минимального элементов массива
        System.out.println("задание 5");
        int[] arr5 = {5, 8, 56, -1, 4, 0, 36, -57, 12, 103, 90, 2, -15};
        int max5 = arr5[0];
        int min5 = arr5[0];
        for (int o: arr5) {
            if (o > max5) {
                max5 = o;
            }
            if (o < min5) {
                min5 = o;
            }
        }
        printArrayLine(arr5);
        System.out.println("масимальный элемент массива: " + max5);
        System.out.println("минимальный элемент массива: " + min5);
        System.out.println();
        ///endregion

        /// region задание 6 - поиск метса, в котором суммы левой и правой частей массива равны
        System.out.println("задание 6");
        int[] arr6 = {4, 2, 1, 5, 3, 14, 1};
        if (myCheckBalance(arr6)) {
            //System.out.println(Arrays.toString(arr3));
            System.out.println("место, в котором суммы левой и правой частей массива равны:");
            for (int i = 0; i < arr6.length; i++) {
            System.out.print(arr6[i] + "\t");
                if (i == p) {
                    System.out.print("||\t");
                }
            }
        } else {
            System.out.println("места, в котором суммы левой и правой частей массива равны, не существует.");
        }
        System.out.println();
        System.out.println();
        ///endregion

        ///region задание 7 - сдвиг массива
        System.out.println("задание 7");
        int[] arr71 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr72 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = -13;
        printArrayLine(arr71);
        //сдвигаем массив двумя разными способами, результаты должны совпасть
        arrayRShiftN(arr71, n);
        arrayRLShiftN(arr72, n);
        printArrayLine(arr71);
        printArrayLine(arr72);
        ///endregion

    }

    ///region вывод одномерного массива
    static void printArrayLine(int[] arr){
        for (int a : arr) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }
    ///endregion

    ///region вывод двумерного массива
    static  void printArrayTable(int[][] arr){
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
    ///endregion

    ///region задание 6
    //поиск места, в котором суммы левой и правой частей массива равны
    static boolean myCheckBalance(int[] arr) {
        boolean tf = false;
        if (arr.length > 1) { //если в массиве один элемент, то точно нет
            for(int i=0; i < arr.length-2; i++) {  //перебор массива и поиск места
                if (myArraySum(arr, 0, i) == myArraySum(arr, i+1, arr.length-1)) { //если оно нашлось
                    p = i;
                    tf = true;
                }
            }
        }
        return tf;
    }


    //сумма от a до b элементов массива, 0 <= a <= b <= arr.length
    static int myArraySum(int[] arr, int a, int b) {
        int res = 0;
        for (int i = a; i <= b; i++) {
            res = res + arr[i];
        }
        return res;
    }
    ///endregion

    ///region задание 7
    //сдвиг массива на n если используем только сдвиг ввправо
    static void arrayRShiftN(int[] arr, int n) {
        System.out.println("изначально n = " + n);
        while (n < 0 || n > arr.length) {
            if (Math.abs(n) >= arr.length) {	//уменьшаем количество сдвигов, если |n| больше длины массива
                n = n % arr.length;
                //System.out.println("|n| >= длины массива, теперь n = " + n);
            }
            if (n < 0) {			//вычисляем количество сдвигов вправо соотвующее сдвигам n влево
                n = arr.length + n;
                //System.out.println("n < 0, теперь n = " + n);
            }
        }
        if (n == 0) {
            System.out.println("сдвига не происходит");
        } else {
            for (int i = 0; i < n; i++) {
                arrayRightShift(arr);
            }
        }
    }

    //сдвиг массива на n если используем сдвиг ввправо и влево
    static void arrayRLShiftN(int[] arr, int n) {
        System.out.println("изначально n = " + n);
        while (Math.abs(n) >= arr.length) {	//уменьшаем количество сдвигов, если |n| больше длины массива
            n = n % arr.length;
            //System.out.println("|n| >= длины массива, теперь n = " + n);
        }
        if (n > 0) {            //если n > 0, сдвигаем массив вправо
            for (int i = 0; i < n; i++) {
                arrayRightShift(arr);
            }
        } else if (n < 0) {        //если n < 0, сдвигаем массив влево
            for (int i = n; i < 0; i++) {
                arrayLeftShift(arr);
            }
        } else {				//если n = 0, массив не сдвигается
            System.out.println("сдвига не происходит");
        }
    }

    //сдвиг массива на 1 вправо
    static void arrayRightShift(int[] arr) {
        int m = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = m;
    }

    //сдвиг массива на 1 влево
    static void arrayLeftShift(int[] arr) {
        int m = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
	        arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = m;
    }
    ///endregion

}