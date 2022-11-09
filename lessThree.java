package ru.geekbrains.catch_the_drop;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class lessThree {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();


    public static void main(String[] args) {
        System.out.println("Ex.1. ***************");
        byte[] myArrayByte = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(myArrayByte) + " -> ");
        metArrFlipElement(myArrayByte);
        System.out.println();
        System.out.println("Ex.2. ***************");
        int[] myArrayInt = new int[100];
        metArrFillElement (myArrayInt);
        System.out.println();
        System.out.println("Ex.3. ***************");
        int[] myMass = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(myMass) + " -> ");
        ArrElementMoreSix (myMass);
        System.out.println();
        System.out.println("Ex.4. ***************");
        int a = 7;
        daigonSquere (a);
        System.out.println();
        System.out.println("Ex.5. ***************");
        System.out.println("Enter the size of the array:");
        int len = scanner.nextInt();
        System.out.println("Enter the array value:");
        int initialValue = scanner.nextInt();
        createArray(len, initialValue);
        System.out.println();
        System.out.println("Ex.6. ***************");
        System.out.println("Enter the size of the array:");
        int l = scanner.nextInt();
        massMinMax (l);
        System.out.println();
        System.out.println("Ex.7. ***************");
        int [] massive7 = {6,4,3,1,4,2,6};
        System.out.println(Arrays.toString(massive7));
        System.out.println("Is there a place in the array where the sum of the left and right parts of the array are equal?");
        System.out.println(getArray(massive7));
        System.out.println();
        System.out.println("Ex.8. ***************");
        int[] massive = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Array before the changes:");
        System.out.println(Arrays.toString(massive));
        System.out.println("Array after the changes:");
        stepLeftRightArray(massive, -4);
    }

//        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//        С помощью цикла и условия заменить 0 на 1, 1 на 0;

    public static void metArrFlipElement (byte[] myArrayByte) {

    for (int i = 0; i < myArrayByte.length; i++) {
        if (myArrayByte[i] == 0) {
            myArrayByte[i] = 1;
        } else myArrayByte[i] = 0;
        //System.out.print(myArrayByte[i] + " / ");
    }
        System.out.println(Arrays.toString(myArrayByte));
}
    //    2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;

    public static void metArrFillElement (int [] myArrayInt) {
        for (int i = 0; i < myArrayInt.length; i++) {
            myArrayInt[i] = i + 1;
            //System.out.print(myArrayInt[i] + " / ");
        }
        System.out.println(Arrays.toString(myArrayInt));
    }

    //    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void ArrElementMoreSix (int [] myMass) {
        for (int i = 0; i < myMass.length; i++) {
            if (myMass[i] < 6) {
                myMass[i] = myMass[i] * 2;
            }
            //System.out.print(myMass[i] + " / ");
        }
        System.out.println(Arrays.toString(myMass));
    }

    //    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//        и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
//        если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких
//        элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];

    public static void daigonSquere(int a) {
        int[][] sqArr = new int[a][a];
        for (int i = 0; i < sqArr.length; i++) {
            for (int j = 0; j < sqArr.length; j++) {
                sqArr[i][j] = 0;
                if (i == j) {
                    sqArr[i][j] = 1;
                } else if (i != j) {
                    sqArr[i][a - i - 1] = 1;
                }
                //System.out.print(sqArr[i][j] + " / ");
            }
            //System.out.println();

        }
        Arrays.stream(sqArr).map(Arrays::toString).forEach(System.out::println);// нашла в интернете
    }

//        5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
//        типа int длиной len, каждая ячейка которого равна initialValue;

    public static void createArray(int len, int initialValue) {
        int[] massCreate = new int[len];
        for (int i = 0; i < massCreate.length; i++) {
            massCreate[i] = initialValue;
        }
        System.out.print("Your new array -> ");
        System.out.println(Arrays.toString(massCreate));
    }
//
//        6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    public static void massMinMax(int l) {
        int[] mass = new int[l];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt();
            System.out.print(mass[i] + " / ");
        }
        int massMax = mass[0];
        int massMin = mass[0];
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < massMin) {
                massMin = mass[i];
            }
            if (mass[i] > massMax) {
                massMax = mass[i];
            }
        }
        System.out.println();
        System.out.println("Your new random array -> ");
        System.out.println(Arrays.toString(mass));
        System.out.println("MAX in this array " + massMax);
        System.out.println("MIN in this array " + massMin);
    }

//        7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть
//       true, если в массиве есть место, в котором сумма левой и правой части массива равны.
//        **Примеры:
//       checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
//        checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

    public static boolean getArray(int[] myArray) {
        int sumLeft = 0;
        boolean a = false;
        int i = 0;
        while (a == false && i < myArray.length) {
            int sumRight = 0;
            sumLeft += myArray[i];
            i += 1;
            for (int j = i; j < myArray.length; j++) {
                sumRight += myArray[j];
            }
            if (sumLeft == sumRight) {
                a = true;
            } else a = false;
        }
        return a;
    }

    //        8. *** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
//        или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются
//        циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ]
//        при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
//        При каком n в какую сторону сдвиг можете выбирать сами.
    public static void stepLeftRightArray(int[] myArray, int step) {
        int a = 0;
        if (step > 0) {
            for (int j = 0; j < step; j++) {
                a = myArray[0];
                for (int i = 0; i < myArray.length - 1; i++) {
                    myArray[i] = myArray[i + 1];
                }
                myArray[myArray.length-1] = a;
                //System.out.println(Arrays.toString(myArray));
            }
        } else if (step < 0) {
            for (int j = step; j < 0; j++) {
                a = myArray[myArray.length-1];
                for (int i = myArray.length-1; i > 0; i--) {
                    myArray[i] = myArray[i - 1];
                }
                myArray[0] = a;
                //System.out.println(Arrays.toString(myArray));
            }
        } else {
            System.out.println(Arrays.toString(myArray));
        }
        System.out.println(Arrays.toString(myArray));
    } }

