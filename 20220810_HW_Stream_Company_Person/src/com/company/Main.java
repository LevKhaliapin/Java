package com.company;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    /*
    First level: Дан список Company (String title, List employee).
    Person {String name, int age, List emails, String city}.
    Необходимо, используя Stream вывести всех работников предприятия, старше 50 лет в порядке убывания возраста .


    Second level: Дан список Company (String title, List employee).
    Person {String name, int age, List emails, String city}.
    Необходимо, используя Stream сформировать список всех емэйлов, всех работников из Берлина.
     */

    public static void main(String[] args) {
        Person p1 = new Person("Ivan", 26, new ArrayList<>(List.of("ivan@mail.ru", "ivan@gmail.com")), "Berlin");
        Person p2 = new Person("Petr", 36, new ArrayList<>(List.of("petr@mail.ru", "petr@gmail.com")), "Bern");
        Person p3 = new Person("Lena", 46, new ArrayList<>(List.of("lena@mail.ru", "lena@gmail.com")), "Berlin");
        Person p4 = new Person("Viktor", 56, new ArrayList<>(List.of("viktor@mail.ru", "viktor@gmail.com")), "Paris");
        Person p5 = new Person("p5", 77, new ArrayList<>(List.of("p5@mail.ru", "p5@gmail.com")), "London");
        Person p6 = new Person("p6", 33, new ArrayList<>(List.of("p6@mail.ru", "p6@gmail.com")), "Paris");
        Person p7 = new Person("p7", 66, new ArrayList<>(List.of("p7@mail.ru", "p7@gmail.com")), "Berlin");
        Person p8 = new Person("p8", 58, new ArrayList<>(List.of("p8@mail.ru", "p8@gmail.com")), "Paris");
        Person p11 = new Person("p11", 26, new ArrayList<>(List.of("p11@mail.ru", "p11@gmail.com")), "Berlin");
        Person p12 = new Person("p12", 36, new ArrayList<>(List.of("p12@mail.ru", "p12@gmail.com")), "Bern");
        Person p13 = new Person("p13", 46, new ArrayList<>(List.of("p13@mail.ru", "p13@gmail.com")), "Berlin");
        Person p14 = new Person("p14", 56, new ArrayList<>(List.of("p14@mail.ru", "p14@gmail.com")), "Paris");
        Person p15 = new Person("p15", 77, new ArrayList<>(List.of("p15@mail.ru", "p15@gmail.com")), "London");
        Person p16 = new Person("p16", 33, new ArrayList<>(List.of("p16@mail.ru", "p16@gmail.com")), "Paris");
        Person p17 = new Person("p17", 66, new ArrayList<>(List.of("p17@mail.ru", "p17@gmail.com")), "Berlin");
        Person p18 = new Person("p18", 58, new ArrayList<>(List.of("p18@mail.ru", "p18@gmail.com")), "Paris");

        List<Person> employee1 = new ArrayList<>();
        employee1.add(p1);
        employee1.add(p2);
        employee1.add(p3);
        employee1.add(p4);
        employee1.add(p5);
        employee1.add(p6);
        employee1.add(p7);
        employee1.add(p8);
        employee1.add(p11);
        employee1.add(p12);
        employee1.add(p13);
        employee1.add(p14);
        employee1.add(p15);
        employee1.add(p16);
        employee1.add(p17);
        employee1.add(p18);

        System.out.println("=======employee1========");
        System.out.println(employee1);

        Company company1 = new Company("Company1", employee1);

        System.out.println("========company1=======");
        System.out.println(company1);

        List<String> sortedAge = Stream.of(company1)
                .flatMap(c -> c.getEmployee().stream())
                .sorted(Comparator.comparing(p -> p.getAge()))
                .filter(p -> p.getAge()>50)
                .map(p -> p + "")
                .collect(Collectors.toList());

        System.out.println(sortedAge);

        List<String> listEmails = Stream.of(company1)
                .flatMap(c -> c.getEmployee().stream())
                .filter(p -> p.getCity().contains("Berlin"))
                .flatMap(p -> p.getEmail().stream())
                .collect(Collectors.toList());

        System.out.println(listEmails);
        


    }
}
