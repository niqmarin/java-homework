package ru.geekbrains.hw09;

public class Homework09 {

    public static void main(String[] args) {
        //массив неправильного размера
        String[][] arr01 = {{"25", "17", "86"},
                            {"-2", "356", "861"},
                            {"-65", "-5415", "21"}};
        //массив с символами вместо одного из чисел
        String[][] arr02 = {{"867", "-67", "345", "30259"},
                            {"ouch", "-588", "-332", "91"},
                            {"686", "-784", "1", "63"},
                            {"29", "11", "-37", "444"}};
        //коррекный массив
        String[][] arr03 = {{"3", "12", "-56", "-87"},
                            {"13", "21", "55", "89"},
                            {"-10", "571", "4", "6000"},
                            {"5", "117", "693", "-7"}};

        //такая громоздкая конструкция, чтобы за один запуск вывести результаты всех массивов
        try {
            System.out.println("Обработка первого массива:");
            System.out.println("Сумма элементов массива равна " + myArray44Sum(arr01));
        }
        catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.printf("Размер Вашего массива %d х %d\n", e.getI(), e.getJ());
            System.out.println();
        }
        catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
            System.out.printf("Данные в строке %d столбце %d не могут быть распознаны как чило: %s\n", e.getI()+1, e.getJ()+1, e.getS());
            System.out.println();
        }
        finally {
            try {
                System.out.println("Обработка второго массива:");
                System.out.println("Сумма элементов массива равна " + myArray44Sum(arr02));
            }
            catch (MyArraySizeException e) {
                System.out.println(e.getMessage());
                System.out.printf("Размер Вашего массива %d х %d\n", e.getI(), e.getJ());
                System.out.println();
            }
            catch (MyArrayDataException e) {
                System.out.println(e.getMessage());
                System.out.printf("Данные в строке %d столбце %d не могут быть распознаны как чило: %s\n", e.getI()+1, e.getJ()+1, e.getS());
                System.out.println();
            }
            finally {
                try {
                    System.out.println("Обработка третьего массива:");
                    System.out.println("Сумма элементов массива равна " + myArray44Sum(arr03));
                }
                catch (MyArraySizeException e) {
                    System.out.println(e.getMessage());
                    System.out.printf("Размер Вашего массива %d х %d\n", e.getI(), e.getJ());
                    System.out.println();
                }
                catch (MyArrayDataException e) {
                    System.out.println(e.getMessage());
                    System.out.printf("Данные в строке %d столбце %d не могут быть распознаны как чило: %s\n", e.getI()+1, e.getJ()+1, e.getS());
                    System.out.println();
                }
            }
        }

    }


public static int myArray44Sum(String[][] array) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;
        int n = 0;
        if (array.length == 4 && array[0].length == 4) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        n = Integer.parseInt(array[i][j]);
                        sum += n;
                    }
                    catch (NumberFormatException e) {
                        throw new MyArrayDataException ("Число введено некорректно", i, j, array[i][j]);
                    }
                }
            }
        }
        else {
            throw new MyArraySizeException("Размер массива отличается от необходимого 4 х 4", array.length, array[0].length);
        }
        return sum;
    }
}

class MyArrayException extends Exception {

    private int i, j;

    public MyArrayException(String message, int i, int j) {
        super(message);
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}

class MyArraySizeException extends MyArrayException {
    public MyArraySizeException(String message, int i, int j) {
        super(message, i, j);
    }
}

class MyArrayDataException extends MyArrayException {

    private String s;
    public MyArrayDataException(String message, int i, int j, String s) {
        super(message, i, j);
        this.s = s;
    }

    public String getS() {
        return s;
    }
}