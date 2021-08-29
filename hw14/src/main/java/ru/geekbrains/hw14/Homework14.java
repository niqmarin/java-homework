package ru.geekbrains.hw14;

public class Homework14 {

    public static void main(String[] args) {



    }

    public static int[] arrayAfter4 (int[] arr) throws RuntimeException {
        boolean contains4 = false;
        int pos4 = 0;
        for(int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                pos4 = i;
                contains4 = true;
                break;
            }
        }
        int resArrSize;
        int[] resArr;
        if (!contains4) {
            throw new RuntimeException("Массив не содержит 4.");
        }
        else if (pos4 == arr.length - 1) {
            throw new RuntimeException("Массив не содержит элементов после последней 4.");
        } else {
            resArrSize = arr.length - pos4 - 1;
            resArr = new int[resArrSize];
            System.arraycopy(arr, pos4 + 1, resArr, 0, resArrSize);
        }
        return resArr;
    }

    public static boolean array1n4 (int[] arr) {
        boolean contains4 = false;
        boolean contains1 = false;
        boolean only1n4 = true;

        for (int a : arr) {
            switch (a) {
                case 1:
                    contains1 = true;
                    break;
                case 4:
                    contains4 = true;
                    break;
                default:
                    only1n4 = false;
                    break;
            }
        }
        return contains1 && contains4 && only1n4;
    }

}
