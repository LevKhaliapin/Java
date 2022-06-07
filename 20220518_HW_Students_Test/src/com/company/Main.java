package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
	ДЗ:
	Создать класс студентов с именами, со средним баллом успеваемости, кол-во прогулянных занятий
	Вспомнить компораторы. Массив.
	Программа должна спрашивать в каком порядке сортировать массив.
	И выводить результаты сортировки.
	 */

    public static void main(String[] args) {

        Student st1 = new Student("Иван", 4.3, 3);
        Student st2 = new Student("Петя", 5, 0);
        Student st3 = new Student("Женя", 3.9, 4);
        Student st4 = new Student("Вася", 3.5, 7);

        Student[] students = {st1, st2, st3, st4};
        System.out.println(Arrays.toString(students));





    }
    public static int inputChoice() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Введите желаемый способ отображения массива");
            System.out.println("1 - Без сортировки  2 - Сортировка по имени  3 - Сортировка по рейтингу  4 - Сортировка по кол-ву пропусков");
            choice = input.nextInt();
        } while (choice < 1 || choice > 4);
        {
            switch (choice) {
                case 1:
                    System.out.println("Без сортировки");
                    System.out.println(Arrays.toString(students));
                    break;
                case 2:
                    Arrays.sort(students, new ComparatorByName());
                    System.out.println("Сортировка по имени: ");
                    System.out.println(Arrays.toString(students));
                    break;
                case 3:
                    Arrays.sort(students, new ComparatorByRating().reversed());
                    System.out.println("Сортировка по рейтингу: ");
                    System.out.println(Arrays.toString(students));
                    break;
                case 4:
                    Arrays.sort(students, new ComparatorByNumOfMissedClasses());
                    System.out.println("Сортировка по кол-ву пропусков: ");
                    System.out.println(Arrays.toString(students));
                    break;
            }

        }
    }
}
