package ru.geekbrains.catch_the_drop;

public class lessTwo {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println(twoSum(5, 14));
        System.out.println("-------------------------");
        System.out.println(signNum(40));
        System.out.println("-------------------------");
        System.out.println(signNumBool(10));
        System.out.println("-------------------------");
        repeatLine("ABRAKADABRA", 5);
        System.out.println("-------------------------");
        System.out.println(yearLeap(2400));
    }

    //    1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
    //    если да – вернуть true, в противном случае – false.
    public static String twoSum(int one, int two) {
        System.out.println("The sum of the numbers " + one + " and " + two + " lies in the interval [10;20]");
        if (one + two >= 10 && one + two <= 20) {
            return "Answer: True";
        } else {
            return "Answer: False";
        }
    }

    //        2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
    //        положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static String signNum(int Number) {
        System.out.println("The number " + Number + " is positive or negative?");
        if (Number >= 0) {
            return "Answer: Positive number";
        } else {
            return "Answer: Negative number";
        }

    }

    //        3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    //        если число отрицательное, и вернуть false если положительное.
    public static String signNumBool(int NumberB) {
        System.out.println("Is the number " + NumberB + " negative?");
        if (NumberB <= 0) {
            return "Answer: True";
        } else {
            return "Answer: False";
        }
    }

    //        4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать
    //        в консоль указанную строку, указанное количество раз;
    public static void repeatLine(String line, int repeat) {
        System.out.println("Repeat the text " + repeat + " times");
        int i = 0;
        while (i < repeat) {
            i++;
            System.out.println("Text " + line + " repeat a " + i + " times");
        }
    }

    //        5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean
    //        (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
    //        при этом каждый 400-й – високосный.
    public static boolean yearLeap(int year) {
        boolean d = true;
        System.out.println("Is the year "+ year + " leap?");
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return d = false;
            } else {
                return d = true;
            }
        } else {
            return d = false;
        }
    }
}




