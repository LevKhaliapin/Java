package com.company;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Main {

    /*
    Second level: Дан список строк вида “параметр:значение” (например, “length:8”, “name:Jack”  и т.д).
    Используя стримы получить  map, где параметр – это ключ, его значение – значение.
    При этом, если в списке дважды встретился один и тот же параметр, то значения должны быть указаны через запятую, но без повторяющихся значений.
    Например:  “name:Nick”,“length:8”, “name:Jack”, “length:8” ->[ name - Nick,Jack ;  size-> 8]
     */

    public static void main(String[] args) {

        List<String> list = List.of("name:Nick", "length:8", "name:Jack", "length:8");

        Map<String, String> map = list.stream()
                .distinct()
                .collect(toMap(s -> s.substring(0, s.indexOf(":")), s -> s.substring(s.indexOf(":") + 1), (s1, s2) -> (s1.substring(s1.indexOf(":") + 1)) + "," + (s2.substring(s2.indexOf(":") + 1))));
        map.forEach((k, v) -> System.out.println(k + " - " + v));

    }

}
