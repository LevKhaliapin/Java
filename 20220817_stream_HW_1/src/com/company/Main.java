package com.company;

import java.util.*;
import java.util.List;


/*

First level: Дан List. Необходимо найти значение элемента максимально близкого к некоторому заданному значению N.

 */

public class Main {

    public static void main(String[] args) {

        List<Integer> list = List.of(4, 7, 1, -6, 77, 12, -54);

        System.out.println("Ближайшее число: " + closeNumber(10, list));

    }

    public static int closeNumber(int n, List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : list) {
            map.put(Math.abs(n - i), i);
        }
        //map.forEach((k, v) -> System.out.println(k + " = " + v));
        return map.entrySet().stream().min(Map.Entry.comparingByKey()).get().getValue();
    }

}
