package com.company;

import java.util.*;

public class Main {

    /*
    ДЗ
    Дан Map и List из строк. Если все элементы List содержатся в нашем Map, то сформировать новое значение.
     */

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "The class ");
        map.put("b", "is start ");
        map.put("c", "is finish ");
        map.put("d", "is interest ");
        map.put("i", "is good ");
        map.put("f", "is very good ");

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");

        for (String s : map.values()) {
            System.out.println(s);
        }

        createEntryIfKeysPresent(map, list);
        System.out.println(map);

    }

    public static void createEntryIfKeysPresent(Map<String, String> map, List<String> list) {
        if (list == null || list.isEmpty() || map == null || map.isEmpty()) return;

        Set<String> set = new HashSet<>(list);

        if (map.keySet().containsAll(set)) {
            StringBuilder sumKeys = new StringBuilder();  // Тут Java сама предложила StringBuilder...
            StringBuilder sumValues = new StringBuilder();
            for (String key : set) {
                sumKeys.append(key);
                sumValues.append(map.get(key));
            }
            map.put(sumKeys.toString(), sumValues.toString());
        }
    }
}
