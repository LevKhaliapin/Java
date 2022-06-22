package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person("Ivan", 35);
        Person p2 = new Person("Petr", 23);
        Person p3 = new Person("Elena", 27);
        Person p4 = new Person("Vasiliy", 41);
        Person p5 = new Person("Artem", 27);
        Person p6 = new Person("Alex", 35);
        Person p7 = new Person("Alex", 30);
        Person p8 = new Person("Niko", 25);
        Person p9 = new Person("Viktoria", 35);
        Person p10 = new Person("Svetlana", 19);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);
        personList.add(p7);
        personList.add(p8);
        personList.add(p9);
        personList.add(p10);

        for (Person person : personList) {
            System.out.println(person);
        }

        System.out.println(countAge(personList));
        System.out.println(listAge(personList));

    }

    /*
    First level: Дан список Person {name,age}
    Необходимо сформировать map, где ключ возраст, а значение - количество людей данного возраста.
     */

    public static Map<Integer, Integer> countAge(List<Person> list) {
        Map<Integer, Integer> result = new HashMap<>();
        if (list == null || list.isEmpty()) return result;
        for (int i = 0; i < list.size(); i++) {
            Integer j = result.getOrDefault(list.get(i).getAge(), 0);
            result.put(list.get(i).getAge(), j + 1);
        }
        return result;
    }

    /*
    Second level: Дан список Person {name,age}
    Необходимо сформировать map, где ключ возраст, а значение - список людей данного возраста.
     */
    
    public static Map<Integer, List<Person>> listAge(List<Person> list) {
        Map<Integer, List<Person>> result = new HashMap<>();
        if (list == null || list.isEmpty()) return result;
        for (int i = 0; i < list.size(); i++) {
            List<Person> list1 = new ArrayList<Person>();
            list1.add(list.get(i));
            for (int j = 1; j < list.size(); j++ ) {
                if (list.get(i).getAge() == list.get(j).getAge()){
                    list1.add(list.get(j));
                }
            }
            result.put(list.get(i).getAge(), new ArrayList<>(new HashSet<>(list1)));
        }
        return result;
    }
}
