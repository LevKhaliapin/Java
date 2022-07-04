package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] arr1 = new int[10][10];
        int[][] arr2 = new int[2][2];
        int[][] arr3 = null;

        myDeepToString(arr1);

        List<String> list = new ArrayList<>();
        list.add("1fs2");
        list.add("543");
        list.add("582g");
        list.add("8876");
        list.add("1876.5");
        System.out.println(list);
        System.out.println(conversionToInt(list));

    }

    /*
    First level: 1_1.    Допустим, Ваш метод должен получить массив int размером 10x10 элементов.
    Необходимо, что бы ваш метод бросал IllegalArgumentException если размер переданного массива некорректен или вместо массива пришел null.
     */

    public static void myDeepToString(int[][] arr) {
        if (arr == null || arr.length != 10 || arr[0].length != 10) {
            throw new IllegalArgumentException();
        }
        System.out.println(Arrays.deepToString(arr));
    }

    /*
    First level: 1_2.    Есть List. Все элементы в нем должны быть целые числа, но некоторые данные повреждены (например, содержат символы).
    Необходимо преобразовать данный список в List. При этом вывести на экран детализированный список «ошибок»
    т.е. в каких ячейках и какие значения не были преобразованы.
    Подсказка: необходимо использовать метод Integer.parseInt и обрабатывать его эксэпшены.

     */

    public static List<Integer> conversionToInt(List<String> list) {
        List<Integer> res = new ArrayList<>();
        if(list == null || list.isEmpty()) return res;

        for (int i = 0; i < list.size(); i++) {
            try {
                res.add(Integer.parseInt(list.get(i)));
            } catch (NumberFormatException e) {
                System.out.println("Ячейка " + i + " со значением " + list.get(i) + " не была преобразована");
            }
        }
        return res;
    }

}
