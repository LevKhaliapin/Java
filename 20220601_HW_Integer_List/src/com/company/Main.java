package com.company;

import java.util.ArrayList;
import java.util.List;

///TODO
/*
    1) У нас есть лист из Integer. Развернуть лист наоборот.
    2) У нас есть лист Integer, в котором каждый Integer встречается дважды. А для одного пары нет.
    Написать метод, который ищет тот Integer, для которого нет пары.
 */

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(6);
        list.add(33);
        list.add(11);
        list.add(6);
        list.add(33);
        list.add(7);
        list.add(999);
        list.add(11);
        for (int i : list) {
            System.out.println(i);
        }

        System.out.println("========== 1) turnList =========");
        List<Integer> list2 = turnList(list);
        for (int i : list2) {
            System.out.println(i);
        }

        System.out.println("========== 2) returnSingleNumberFromList =========");
        System.out.println(returnSingleNumberFromList(list));
    }


        /*
        ДЗ: 1) У нас есть лист из Integer. Развернуть лист наоборот.
         */

    public static List turnList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        int index = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(index - i));
        }
        return result;
    }

    /*
    ДЗ: 2) У нас есть лист Integer, в котором каждый Integer встречается дважды. А для одного пары нет.
    Написать метод, который ищет тот "Integer", для которого нет пары.
    */
    public static Integer returnSingleNumberFromList(List<Integer> list) {
        Integer result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (result.equals(list.get(i))) {
                list.remove(i);
                list.remove(0);
                if (list.size() > 1) {
                    i = 1;
                    result = list.get(0);
                } else {
                    return list.get(0);
                }
            }
        }
        return result;
    }
}



