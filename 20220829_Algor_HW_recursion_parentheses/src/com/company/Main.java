package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        System.out.println(stringListWithParenthesis(1));
//        System.out.println(stringListWithParenthesis(2));
//        System.out.println(stringListWithParenthesis(3));
//        System.out.println(stringListWithParenthesis(4));

        System.out.println(intToString2(2));

//        System.out.println(stringListWithAdmissibleParenthesis(1));
//        System.out.println(stringListWithAdmissibleParenthesis(2));
//        System.out.println(stringListWithAdmissibleParenthesis(3));
//        System.out.println(stringListWithAdmissibleParenthesis(4));
//        System.out.println(stringListWithAdmissibleParenthesis(10));


    }

    /*
    ДЗ_2
   Скобочные последовательности допустимые
   n=2
   4
   ()()
   (())
   ((((
   ))))
   ()))
   ((()
     */


    public static String intToString(int num, int size) {
        StringBuilder result = new StringBuilder(" ");

        int rest = num;
        while (rest > 1) {
            if (rest % 2 == 0) result.insert(1, "(");
            else result.insert(1, ")");
            rest /= 2;
        }

        if (rest % 2 == 0) result.insert(1, "(");
        else result.insert(1, ")");

        while (result.length() < size + 1) result.insert(1, "(");

        return result.substring(1);
    }

    public static String intToString2(int num) {
        StringBuilder result = new StringBuilder(" ");

        if (num == 0) result.insert(1, "(");
        if (num == 1) result.insert(1, ")");

        intToString2(num / 2);
        if (num % 2 == 0) result.insert(1, "(");
        else result.insert(1, ")");

        while (result.length() < 5) result.insert(1, "(");

        return result.substring(1);
    }


    public static List<String> stringListWithParenthesis(int n) { // Лист с всеми скобками
        List<String> result = new ArrayList<>();
        int sizeList = (int) Math.pow(2, 2 * n);
        int sizeString = 2 * n;

        for (int i = 0; i < sizeList; i++) {
            String str = intToString(i, sizeString);
            result.add(str);
        }
        return result;

    }

    public static List<String> stringListWithAdmissibleParenthesis(int n) { // Лист с допустимыми скобками
        List<String> result = new ArrayList<>();
        int sizeList = (int) Math.pow(2, 2 * n);
        int sizeString = 2 * n;

        for (int i = 0; i < sizeList; i++) {
            String str = intToString(i, sizeString);
            if (checkStr(str)) result.add(str);
        }
        return result;
    }

    public static Boolean checkStr(String str) {  //проверка скобочной последовательности на допустимость
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(0) == '(') {
                if (str.charAt(i) == '(') sum++;
                else sum--;
                if (sum < 0) return false;
            } else return false;
        }
        return sum == 0;
    }
}
