package ru.geekbrains.hw04;


import java.util.Random;
import java.util.Scanner;

public class Homework0403 {

    static final char DOT_HUMAN = 'X'; //символ игрока
    static final char DOT_AI = 'O'; //символ компьютера
    static final char DOT_EMPTY = '*'; //символ пусого поля
    static final Scanner SCANNER = new Scanner(System.in);
    static final Random RANDOM = new Random();
    static char[][] field; //массив, хранящий текущее состояние игрового поля
    static int fieldSizeX; //ширина игрового поля (кол-во столбцов j)
    static int fieldSizeY; //высота игрового поля (кол-во строк i)
    static int winLine; //длина ряда одинаковых символов для победы
    static int winSum; //вспомогательная переменная для подсчета символов при проверке на победу
    static int xHU, yHU, xAI, yAI; //переменные для записи хода игрока и компьютера

    //инициализация массива, содержащего игровое поле
    static void initialise() {
        //установка размеров игрового поля
        fieldSizeX = 5;
        fieldSizeY =5;
        winLine = 4;
        //заполнение массива символами пустого поля
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    //отрисовка игрового поля
    static void printField() {
        System.out.print("*");
        for (int j = 0; j < fieldSizeX; j++) {
            System.out.print("  " + (j + 1));
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print("  " + field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //проверка ввода на корректность
    static boolean isCellValid(int i, int j){
        return j >=0 && j < fieldSizeX && i >= 0 && i < fieldSizeY;
    }

    //проверка того, что поле для ввода пустое
    static boolean isCellEmpty(int i, int j){
        return field[i][j] == DOT_EMPTY;
    }

    //ход игрока
    static void humanTurn() {
        do {
            System.out.print("введите координаты хода в формате X Y через пробел:\t");
            xHU = SCANNER.nextInt() - 1;
            yHU = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(yHU, xHU) || !isCellEmpty(yHU, xHU));
        field[yHU][xHU] = DOT_HUMAN;
    }

    //ход компьютера
    static void aiTurn(int x, int y) {
        //присвоение рандомных значений на случай, если околопобедных клеток не найдётся
        do {
            xAI = RANDOM.nextInt(fieldSizeX);
            yAI = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(yAI, xAI));

        //поиск хода игрока который приведет к победе и его блокировка
        for (int preWinLine = 2; preWinLine <= winLine; preWinLine++){
            for (int i = Math.max(0, y - (preWinLine - 1)); i <= Math.min(fieldSizeY - 1, y + (preWinLine - 1)); i++) {
                for (int j = Math.max(0, x - (preWinLine - 1)); j <= Math.min(fieldSizeX - 1, x + (preWinLine - 1)); j++) {
                    if (field[i][j] == DOT_EMPTY) {
                        field[i][j] = DOT_HUMAN;
                        if (checkWin(DOT_HUMAN, i, j, preWinLine)) {
                            xAI = j;
                            yAI = i;
                        }
                        field[i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        field[yAI][xAI] = DOT_AI;
    }

    //проверка победы
    static boolean checkWin(char dot, int y, int x, int winLine) {
        boolean isWin = false;
        //ограничение области поиска на winLine клеток вокруг точки последнего хода
        for (int i = Math.max(0, y - (winLine - 1)); i <= Math.min(fieldSizeY - 1, y + (winLine - 1)); i++) {
            for (int j = Math.max(0, x - (winLine - 1)); j <= Math.min(fieldSizeX - 1, x + (winLine - 1)); j++) {
                if (field[i][j] == dot) {
                    if (checkCellWin(dot, i, j, winLine)) {
                        isWin = true;
                    }
                }
            }
        }
        return isWin;
    }

    //проверка победы для клетки по 4 направлениям (конечно же я воспользовалась подсказкой с вебинара)
    static boolean checkCellWin(char dot, int i, int j, int winLine) {
        boolean isWin = false;

        ///region проверка победы по горизонтали
        if (j >= 0 && j + winLine - 1 < fieldSizeX) {
            winSum = 1;
            for (int m = 1; m < winLine; m++) {
                if (field[i][j + m] == dot) {
                    winSum++;
                }
            }
            if (winSum == winLine) {
                isWin = true;
            }
        }
        ///endregion

        ///region проверка победы по вертикали
        if (i>= 0 && i + winLine - 1 < fieldSizeY) {
            winSum = 1;
            for (int m = 1; m < winLine; m++) {
                if (field[i + m][j] == dot) {
                    winSum++;
                }
            }
            if (winSum == winLine) {
                isWin = true;
            }
        }
        ///endregion

        ///region проверка победы по диагонали лево верх - право низ
        if (j >= 0 && j + winLine - 1 < fieldSizeX && i >= 0 && i + winLine - 1 < fieldSizeY) {
            winSum = 1;
            for (int m = 1; m < winLine; m++) {
                if (field[i + m][j + m] == dot) {
                    winSum++;
                }
            }
            if (winSum == winLine) {
                isWin = true;
            }
        }
        ///endregion

        ///region проверка победы по диагонали лево низ - право верх
        if (j >= 0 && j + winLine - 1 < fieldSizeX && i - (winLine - 1) >=0 && i < fieldSizeY) {
            winSum = 1;
            for (int m = 1; m < winLine; m++) {
                if (field[i - m][j + m] == dot) {
                    winSum++;
                }
            }
            if (winSum == winLine) {
                isWin = true;
            }
        }
        ///endregion

        return isWin;
    }

    //проверка на заполненность поля
    static boolean checkFieldFull(){
        for (int i = 0; i < fieldSizeY; i++){
            for (int j = 0; j < fieldSizeX; j++){
                if (isCellEmpty(i, j))
                    return false;
            }
        }
        return true;
    }

    //проверка состояния игры
    static boolean gameChecks(char dot, int y, int x, String s){
        if (checkWin(dot, y, x, winLine))
        {
            System.out.println(s);
            return true;
        }
        if (checkFieldFull()) {
            System.out.println("ничья");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("~ консольная игра \"крестики-нолики\" ~");
        System.out.println("!! предупреждение !!");
        System.out.println("если вводить вместо чисел другие символы, программа выдаст ошибку и завершит работу");
        while (true) {
            initialise();
            printField();
            while (true){
                humanTurn();
                printField();
                if (gameChecks(DOT_HUMAN, yHU, xHU, "~ вы победили ~"))
                    break;
                aiTurn(xHU, yHU);
                printField();
                if (gameChecks(DOT_AI, yAI, xAI, "победил компьютер"))
                    break;
            }
            System.out.print("сыграем еще раз? (Y - да): ");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }
}
