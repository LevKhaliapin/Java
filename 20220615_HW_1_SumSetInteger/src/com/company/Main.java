package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<Integer>();
        integerSet.add(5);
        integerSet.add(44);
        integerSet.add(21);
        integerSet.add(74);
        integerSet.add(9);
        integerSet.add(11);
        integerSet.add(76);
        System.out.println(integerSet);


        System.out.println(sumSetInteger(integerSet));


    }

    public static int sumSetInteger(Set<Integer> integerSet) {
        if (integerSet == null) return 0;
        else {
            int sum = 0;
            for (int i :
                    integerSet) {
                sum += i;
            }
            return sum;
        }
    }

}
