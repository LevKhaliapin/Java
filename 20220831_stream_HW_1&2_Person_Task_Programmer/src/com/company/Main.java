package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Task task1 = new Task(1, "t1", 3, "Done");
        Task task2 = new Task(2, "t2", 2, "In Progress");
        Task task3 = new Task(3, "t3", 1, "ToDo");
        Task task4 = new Task(4, "t4", 4, "Canceled");
        Task task5 = new Task(5, "t5", 5, "ToDo");
        Task task6 = new Task(6, "t6", 3, "Canceled");
        Task task7 = new Task(7, "t7", 2, "Done");
        Task task8 = new Task(8, "t8", 3, "In Progress");
        Task task9 = new Task(9, "t9", 4, "Done");
        Task task10 = new Task(10, "t10", 1, "In Progress");
        Task task11 = new Task(11, "t11", 3, "In Progress");
        Task task12 = new Task(12, "t12", 3, "Canceled");

        Map<Person, List<Task>> personListMap = new HashMap<>();
        personListMap.put(new Person("Tom"), List.of(task1, task2, task3, task4));
        personListMap.put(new Person("Bob"), List.of(task5, task6, task7, task8));
        personListMap.put(new Person("Jane"), List.of(task9, task10, task11, task12));

        /*
	    ДЗ_№1
	    Дана мапа <Person, List<Task>> }. Необходимо получить мапу <Boolean, Task>,
	    где ключом, все не завершенные задачи будут относиться к ключу false, а все завершенные к ключу true.
	    Задачи со статусом “canceled” не должны учитываться.
        */

        Map<Boolean, List<Task>> booleanTaskMap = personListMap.values().stream()
                .flatMap(l -> l.stream().filter(t -> !t.getStatus().equals("Canceled")))
                .collect(Collectors.groupingBy(t -> t.getStatus().equals("Done")));

        System.out.println("=============ДЗ_№1=========");
        booleanTaskMap.forEach((k, v) -> System.out.println(k + " " + v));


        List<Programmer> programmerList = List.of(
                new Programmer("Nick", List.of("Java", "Kotlin")),
                new Programmer("Bill", List.of("C/С++", "PHP")),
                new Programmer("Mike", List.of("JavaScript", "Java")),
                new Programmer("Bob", List.of("PHP", "C/С++")),
                new Programmer("John", List.of("Kotlin", "Java")),
                new Programmer("Tom", List.of("Java", "PHP")),
                new Programmer("Andrew", List.of("JavaScript"))
        );

        /*
        ДЗ_№2
        Дан список  Programmer, у каждого из которых есть имя и список технологий,
        которыми он владеет, например, языки программирования.
        Необходимо получить мапу, где ключ название технологии, а значение список программистов ей владеющий.
	    */

        Map<String, List<Programmer>> mapProgrammingLanguage = programmerList.stream()
                // Работает не корректно. В map в значение заносятся не все программисты, а те, у которых скилл в листе стоит на первом месте.
                .collect(Collectors.groupingBy(p -> p.getSkills().stream().reduce(Objects::toString).get()));

        System.out.println("=============ДЗ_№2=============");
        mapProgrammingLanguage.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
