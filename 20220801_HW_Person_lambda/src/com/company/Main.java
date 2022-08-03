package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    /*
    First level: В программе задан список Person{ String fName, String lName, String email, String phone, Address address}.
    Address{String postcode, String city, String street, String house}
Реализовать следующие функции:
               -получить список всех ФИО
            -получить список всех e-mail
               -получить список всех телефонов
               -получить список всех адресов в виде строки адреса
Естественно, все вышеперечисленные функции может и должен реализовать один метод,
в который в качестве параметра должен приходить список Person и реализация необходимого способа обработки.
     */


    public static void main(String[] args) {
	    Person p1 = new Person("Ivanov", "Ivan", "ivan@mail.ru", "65463532", new Address("3344","Moscow", "st. Lenin", "10"));
	    Person p2 = new Person("Petrov", "Petr", "petr@mail.ru", "12314345", new Address("9999","Piter", "st. Kirova", "20"));
	    Person p3 = new Person("Sergeev", "Sergey", "sergey@mail.ru", "777665433", new Address("1122","Krasnodar", "st. Krasnaya", "30"));

        List<Person> people = new ArrayList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println(people);
        people.forEach(s -> System.out.println(s.getfName() + s.getlName()));
        people.forEach(s -> System.out.println(s.getEmail()));
        people.forEach(s -> System.out.println(s.getPhone()));
        people.forEach(s -> System.out.println(s.getAddress()));

    }

}
