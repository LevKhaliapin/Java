package com.company;

///TODO
    /* Implement in PersonLinkedList
    1. Person get(int index)
    2. remove (int index)
    3. add(Person p, int index)
     */


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("p1", 35);
        Person p2 = new Person("p2", 27);
        Person p3 = new Person("p3", 30);
        Person p4 = new Person("p4", 11);
        Person p5 = new Person("p5", 99);
        Person p6 = new Person("p6", 65);
        Person p7 = new Person("p7", 33);

        Person p8 = new Person("wetergergv", 35);
        Person p9 = new Person("ere", 27);
        Person p10 = new Person("we", 30);
        Person p11 = new Person("q", 11);
        Person p12 = new Person("234454", 99);
        Person p13 = new Person("gfgdgf", 65);
        Person p14 = new Person("fdsfs", 33);


        PersonLinkedList myList = new PersonLinkedList();
        myList.add(p1);
        myList.add(p2);
        myList.add(p3);
        myList.add(p4);
        myList.add(p5);
        myList.add(p6);
        System.out.println(myList.size());
        myList.print();

        System.out.println("=========== 1.Person get(int index) ============");
        System.out.println(myList.getPerson(-1));
        System.out.println(myList.getPerson(0));
        System.out.println(myList.getPerson(1));
        System.out.println(myList.getPerson(8));

        System.out.println("=========== 2.remove (int index) ============");
        myList.remove(-1);
        myList.remove(2);
        myList.remove(22);
        myList.remove(p6);
        myList.print();
        System.out.println(myList.size());

        System.out.println("=========== 3.add(Person p, int index) ============");
        myList.add(p7, 22);
        myList.print();
        System.out.println(myList.size);


        System.out.println("=========== 4.фильтр по кол-ву букв в имени (до применения) ============");
        List<Person> myList2 = new ArrayList<>();
        myList2.clear();
        myList2.add(p8);
        myList2.add(p9);
        myList2.add(p10);
        myList2.add(p11);
        myList2.add(p12);
        myList2.add(p13);
        myList2.add(p14);
        System.out.println(myList2.size());
        System.out.println(myList2.toString());
        System.out.println("=========== после применения ============");
        System.out.println(getPersonWithShortName(myList2));
        System.out.println(myList2.size());

        System.out.println("=========== toArray ============");
        printArray(toArray(myList2));
    }

    public static List<Person> getPersonWithShortName(List<Person> list) {
        List<Person> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            if (p != null && p.getName().length() < 4) {
                newList.add(p);
            }
        }
        return newList;

    }

    public static List<Person> getPersonWithShortName2(List<Person> list) {
        List<Person> newList = new ArrayList<>();
        for (Person p : list) {
            if (p != null && p.getName().length() < 4) {
                newList.add(p);
            }
        }
        return newList;
    }

    public static String[] toArray(List<Person> list) {
        if (list == null) return new String[0];
        String[] result = new String[list.size()];
        int index = 0;
        for (Person p : list) {
            result[index++] = (p != null) ? p.getName() : null;
        }
        return result;
    }

    public static void printArray(String[] array) {
        for(String s : array) {
            System.out.println(s);
        }
    }
}
