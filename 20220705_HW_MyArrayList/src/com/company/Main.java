package com.company;

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

        EmployeeTeamList teamList = new EmployeeTeam();
        teamList.add(p1);
        teamList.add(p2);
        teamList.add(p3);
        teamList.add(q1);
        teamList.add(q2);
        teamList.add(q3);

        System.out.println(teamList);

        System.out.println(teamList.find(q1));

        System.out.println(teamList.size());

        System.out.println(teamList.get(3));
    }
}
