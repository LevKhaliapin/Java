package com.company;


public class Main {

    public static void main(String[] args) {

        System.out.println("1 - " + fibonacciThroughRecursion(1));
        System.out.println("2 - " + fibonacciThroughRecursion(2));
        System.out.println("3 - " + fibonacciThroughRecursion(3));
        System.out.println("4 - " + fibonacciThroughRecursion(4));
        System.out.println("5 - " + fibonacciThroughRecursion(5));
        System.out.println("6 - " + fibonacciThroughRecursion(6));
        System.out.println("7 - " + fibonacciThroughRecursion(7));
        System.out.println("8 - " + fibonacciThroughRecursion(8));
        System.out.println("9 - " + fibonacciThroughRecursion(9));
        System.out.println("10 - " + fibonacciThroughRecursion(10));
        System.out.println("11 - " + fibonacciThroughRecursion(11));
        System.out.println("12 - " + fibonacciThroughRecursion(12));
        System.out.println("20 - " + fibonacciThroughRecursion(20));
        System.out.println("30 - " + fibonacciThroughRecursion(30));
        System.out.println("47 - " + fibonacciThroughRecursion(47)); // с числом 47 уже долговато грузит:)


        System.out.println("1 - " + fibonacciThroughCycle(1));
        System.out.println("2 - " + fibonacciThroughCycle(2));
        System.out.println("3 - " + fibonacciThroughCycle(3));
        System.out.println("4 - " + fibonacciThroughCycle(4));
        System.out.println("5 - " + fibonacciThroughCycle(5));
        System.out.println("6 - " + fibonacciThroughCycle(6));
        System.out.println("7 - " + fibonacciThroughCycle(7));
        System.out.println("8 - " + fibonacciThroughCycle(8));
        System.out.println("9 - " + fibonacciThroughCycle(9));
        System.out.println("10 - " + fibonacciThroughCycle(10));
        System.out.println("11 - " + fibonacciThroughCycle(11));
        System.out.println("12 - " + fibonacciThroughCycle(12));
        System.out.println("20 - " + fibonacciThroughCycle(20));
        System.out.println("30 - " + fibonacciThroughCycle(30));
        System.out.println("40 - " + fibonacciThroughCycle(40));
        System.out.println("50 - " + fibonacciThroughCycle(50));
        System.out.println("100 - " + fibonacciThroughCycle(100));
        System.out.println("164 - " + fibonacciThroughCycle(164)); // далее ограничено значение long
        System.out.println(Long.MAX_VALUE);

        System.out.println("164 - " + fibonacciThroughCycleArray(164));

    }


    /*
    ДЗ_1
   Посчитать число фибоначчи (сумма двух предыдущих)
     */

    public static long fibonacciThroughRecursion(int n) {
        if (n <= 1) return n;
        else return fibonacciThroughRecursion(n - 1) + fibonacciThroughRecursion(n - 2);

    }

    public static long fibonacciThroughCycle(int n) {
        if (n <= 1) return n;
        long result = 0;
        long cur_num_2 = 0;
        long cur_num_1 = 1;
        long temp = cur_num_1;

        for (int i = 1; i < n; i++) {
            result = cur_num_1 + cur_num_2;
            cur_num_1 = result;
            cur_num_2 = temp;
            temp = cur_num_1;
        }

        return result;
    }

    public static long fibonacciThroughCycleArray(int n) {
        long[] arr = new long[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }


    public static int pow(int a, int n) {
        if (a == 0) return 0;
        if (n == 0) return 1;
        else return (a * pow(a, n - 1));
    }

}
