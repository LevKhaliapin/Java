package com.company;

import java.util.ArrayList;

public class Main {

    /*
    ДЗ
Написать реализацию своего ArrayList (с любым типом) с методами: добавление элемента, size, поиск элемента, get по индексу.
     */

    public static void main(String[] args) {
        Programmer p1 = new Programmer("Ivan", 50000);
        Programmer p2 = new Programmer("Karl", 48000);
        Programmer p3 = new Programmer("Petr", 51000);

        QAEngineer q1 = new QAEngineer("Lena", 49000);
        QAEngineer q2 = new QAEngineer("Nikita", 52000);
        QAEngineer q3 = new QAEngineer("Oleg", 45000);

        EmployeeTeamList<Employee> teamList = new EmployeeTeam();
        EmployeeTeamList<Programmer> programmerList = new EmployeeTeam();
        EmployeeTeamList<QAEngineer> QAList = new EmployeeTeam();
        teamList.add(p1);
        teamList.add(p2);
        teamList.add(p3);
        teamList.add(q1);
        teamList.add(q2);
        teamList.add(q3);

        programmerList.add(p1);
        programmerList.add(p2);
        programmerList.add(p3);
        QAList.add(q1);
        QAList.add(q2);
        QAList.add(q3);

        System.out.println(programmerList);

        /*System.out.println(teamList);

        System.out.println(teamList.find(q1));

        System.out.println(teamList.size());

        System.out.println(teamList.get(3));*/
    }
}
