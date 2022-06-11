package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
    HW 20220608:
    First level:  Дано два списка User. Реализовать метод List findDuplicates который вернет лист дубликатов.
     */

    public static void main(String[] args) {

        User user1_1 = new User("Ivan", 5);
        User user1_2 = new User("Petr", 2);
        User user1_3 = new User("Maksim", 7);
        User user1_4 = new User("Lena", 8);
        User user1_5 = new User("Viktoria", 1);

        User user2_1 = new User("Niko", 15);
        User user2_2 = new User("Roman", 12);
        User user2_3 = new User("Maksim", 7);
        User user2_4 = new User("Lena", 8);
        User user2_5 = new User("Alex", 11);

        List<User> list1 = Arrays.asList(user1_1,user1_2,user1_3,user1_4,user1_5);

        List<User> list2 = List.of(user2_1,user2_2,user2_3,user2_4,user2_5);

        System.out.println(findDuplicates(list1, list2));

    }

    public static List<User> findDuplicates(List<User> list1, List<User> list2) {
        List<User> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).getId() == list2.get(j).getId()) {
                    result.add(list1.get(i));
                }
            }
        }
        return result;
    }
}
