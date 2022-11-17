package ru.geekbrains.catch_the_drop;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class lessFour {
    public static final String FIRST_MAP_SYMBOL = "%";
    public static final String SPACE_MAP_SYMBOL = " ";
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static int SIZE;
    public static int ws;
    public static int turnsCount = 0;
    public static int columnNumber;
    public static int rowNumber;
    //    public static int x = 0;
//    public static int y = 0;
    public static char[][] MAP = new char[SIZE][SIZE];
    public static final char D_empty = '*';
    public static final char D_Human = 'X';
    public static final char D_ii = 'O';

    public static void main(String[] args) {
        startPlayGame();

    }

    public static void startPlayGame() {
        do {
            System.out.println("   Игра начинается! Удачи!");
            init();
            printMap();
            playGame();
        } while (inContinueGame());
    }

    private static void init() {
        turnsCount = 0;
        SIZE = getSizeFromUser();
        ws = getWinSize();
        mapDraw();

    }

    private static int getSizeFromUser() {
        System.out.println("Необходимо ввести размер игрового поля: ");
        return getValidNumberFromScanner(3,9);

    }


    private static int getWinSize() {
        if (SIZE <= 5 && SIZE > 3) {
            return 3;
        } else if (SIZE <= 10 && SIZE > 5) {
            return 4;
        }
        return 5;

    }


    private static boolean inContinueGame() {
        System.out.println(" Начать заново? Y/N:");
        return switch (scanner.next()) {
            case "Y", "y" -> true;
            default -> false;
        };
    }

    private static void mapDraw() {
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = D_empty;

            }
        }
    }

    private static void printMap() {

        printHeaderMap();
        printBodyMap();
    }

    private static void printBodyMap() {
       for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + SPACE_MAP_SYMBOL);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP_SYMBOL);
            }
            System.out.println();
        }
    }

    private static void printHeaderMap() {
        System.out.print(FIRST_MAP_SYMBOL + SPACE_MAP_SYMBOL);
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + SPACE_MAP_SYMBOL);
        }
        System.out.println();
    }

    private static void playGame() {
        while (true) {
            humanTurn();
            printMap();
           // System.out.println( columnNumber + rowNumber + D_Human + " Метод PlayGame");
            if (checkEnd(D_Human)) {

                break;
            }
            iiTurn();
            printMap();
            //System.out.println( columnNumber + rowNumber + D_ii);
            if (checkEnd(D_ii)) {

                break;
            }

        }

    }

    private static boolean checkEnd(char symb) {
        //System.out.println( x + y + symb + " метод CheckEnd");
        if (checkWin(symb)) {
            if (symb == D_Human) {
                System.out.println("УРА! Победа игрока!");
            } else {
                System.out.println("Победа компьтера!");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;

        }
        return false;
    }

    private static boolean checkDraw() {
        return turnsCount >= SIZE * SIZE;
    }
    private static boolean checkWin ( char symb) {
        if (checkLine(symb)) {
            return true;
        } else if (checkDiagonal(symb)) {
            return true;
        }
        return false;
    }



//    private static boolean checkWin(int x, int y, char symb) {
//        //System.out.println(x + y + symb + " Метод checkWin");
//        if (checkLine (x,y,0,1, symb) >= ws) {
//            return true;
//        } else if (checkLine(x,y,0,-1,symb) >= ws) {
//            return true;
//        } else  if (checkLine(x,y,1,1,symb) >= ws) {
//            return true;
//        } else  if (checkLine(x,y,1,-1,symb) >= ws){
//            return true;
//        }
//        return false;
//    }

//   private static boolean check (int x, int y, char symbol) {
//        System.out.println(x + y + symbol + " Метод check");
//        return MAP[x][y] == symbol;
  // }
//   private static int checkLine (int x, int y, int dx, int dy, char symb){
//        int total = 0;
//        System.out.println(x + y + symb +" До цикла");
//        x+=dx;
//        y+=dy;
//        while (x>0 && x< SIZE && y>0 && y<SIZE){
//            if (check(x,y,symb)){
//                total ++;
//                System.out.println(x + y + total + symb + " В цикле цикла");
//            } else {
//                break;
//            }
//            x+=dx;
//            y+=dy;
//        } return total;
//
//   }

//
//            while (y + i * di >= 0 && y + i * di < SIZE && x + i * di >= 0 && x + i * di < SIZE)
//                if (MAP[y + i * di][x + i * di] == symbol) {
//                    t++;
//                } else if (MAP[y - i * di][x - i * di] == symbol) {
//                    t++;
//
//                }
//        }
//        if (t == ws) {
//            return true;
//        } else {
//            return false;
//        }
//    }


    private static boolean checkDiagonal(char sym) {
        int temp = 0;
        int temp1 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (MAP[i][i] == sym)//проверка победы по главной диагонали
            {
                temp++;
            }
            if (MAP[SIZE - i - 1][i] == sym)//проверка победы по побочной диагонали
            {
                temp1++;
            }
        }
        if (temp >= ws) {
            return true;
        } else if (temp1 >= ws) {
            return true;
        }
        return false;

    }

    private static boolean checkLine(char sym) {//проверка победы по горизонтали и вертикали
        int temp;
        int temp1;
        for (int i = 0; i < SIZE; i++) {
            temp = 0;
            temp1 = 0;
            for (int j = 0; j < SIZE; j++) {
                //проверка горизонтали
                if (MAP[i][j] == sym) {
                    temp++;
                    if (temp == ws)//кол-во крестиков или ноликов необходимых для победы
                    {
                        return true;
                    }
                }
                //проверка вертикали
                if (MAP[i][j] == sym) {
                    temp1++;
                    if (temp1 == ws) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int getValidNumberMapLineFromScanner() {
        return getValidNumberFromScanner(1, SIZE)-1;
    }

    private static int getValidNumberFromScanner(int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                if (isNumberValid(n, min, max)) {
                    return n;
                }
                System.out.printf("Ошибка! Введенное число %s не принадлежит интервалу от %s до %s%n", n, min, max);

            } else {
                System.out.printf(" Ошибка! Введенное число %s не целое число.%n", scanner.next());
            }
        }


    }

    private static boolean isNumberValid(int n, int min, int max) {
        return n >= min && n <= max;
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;
        while (true) {
            System.out.println(" Ход игрока!");
            System.out.print("Введите координату строки: ");

            rowNumber = getValidNumberMapLineFromScanner();
            System.out.print("Введите координату столбца: ");
            columnNumber = getValidNumberMapLineFromScanner();
            if (isSellFree(rowNumber, columnNumber)) {
                break;

            }
            System.out.printf("Ячейка с координатами %s : %s уже занята. Введите другие координаты. %n", rowNumber + 1, columnNumber + 1);

        }

        MAP[rowNumber][columnNumber] = D_Human;
        turnsCount++;


    }

    private static boolean isSellFree(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == D_empty;
    }

    private static void iiTurn() {
        int rowNumber;
        int columnNumber;
        System.out.println(" Ход компьютера!");
        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
            if (isSellFree(rowNumber, columnNumber)) {
                break;
            }
        } while (!isSellFree(rowNumber, columnNumber));
        MAP[rowNumber][columnNumber] = D_ii;
        turnsCount++;
    }
}

