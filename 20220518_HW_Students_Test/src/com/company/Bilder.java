package com.company;

import java.util.Arrays;

public class Bilder {
    public ReturnArray getSort (int choice) {
        switch (choice) {
            case 1:
                return Arrays.toString;
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
