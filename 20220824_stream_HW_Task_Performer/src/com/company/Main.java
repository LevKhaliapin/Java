package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;


public class Main {


    public static void main(String[] args) {

        Task task1 = new Task(1, "t01", 5, "done");
        Task task2 = new Task(2, "t02", 2, "not done");
        Task task3 = new Task(3, "t03", 1, "done");
        Task task4 = new Task(4, "t04", 2, "not done");
        Task task5 = new Task(5, "t05", 3, "not done");
        Task task6 = new Task(6, "t06", 4, "done");
        Task task7 = new Task(7, "t07", 3, "not done");
        Task task8 = new Task(8, "t08", 5, "not done");
        Task task9 = new Task(9, "t09", 4, "not done");
        Task task10 = new Task(10, "t10", 2, "not done");
        Task task11 = new Task(11, "t11", 3, "done");
        Task task12 = new Task(12, "t12", 1, "not done");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);
        tasks.add(task6);
        tasks.add(task7);
        tasks.add(task8);
        tasks.add(task9);
        tasks.add(task10);
        tasks.add(task11);
        tasks.add(task12);

        List<Performer> performers = new ArrayList<>();
        performers.add(new Performer("Boris", "Berlin", task1));
        performers.add(new Performer("Vladimir", "Munich", task2));
        performers.add(new Performer("Ivan", "Stuttgart", task3));
        performers.add(new Performer("Petr", "Berlin", task4));
        performers.add(new Performer("Elena", "Berlin", task5));
        performers.add(new Performer("Maria", "Stuttgart", task6));
        performers.add(new Performer("Olga", "Berlin", task7));
        performers.add(new Performer("Andrej", "Munich", task8));


        /*
        ДЗ_№1
        Есть класс Task {int id, String title, int priority, String status} и класс Performer {String name, String city, Task task}.
        Дан List< Performer>.  Для всех задач, исполнители которых из Берлина,
        необходимо получить мапу, где ключом является id задачи, а значением title данной задачи.
        */

        Map<Integer, String> berlinerTasksMap = performers.stream()
                .filter(performer -> performer.getCity().equals("Berlin"))
                .map(Performer::getTask)
                .collect(toMap(Task::getId, Task::getTitle));
        System.out.println(berlinerTasksMap);


        /*
        ДЗ_№2
        Дан список Task {int id, String title, int priority, String status}.
        Необходимо получить мапу, где ключом является приоритет,
        а значением список не завершенных (статус завершенной задачи - «done»)  задач, данного приоритета.
         */

        Map<Integer, List<Task>> notDoneTasksMap = tasks.stream()
                .filter(task -> task.getStatus().equals("not done"))
                .collect(Collectors.groupingBy(Task::getPriority));

        notDoneTasksMap.forEach((k, v) -> System.out.println(k + " - " + v));
    }

}
