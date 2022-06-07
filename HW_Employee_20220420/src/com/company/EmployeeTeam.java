package com.company;

import java.util.Arrays;

public class EmployeeTeam {
    private int capacity = 2;  // размер массива
    private int curIndex = 0; // начальное значение
    Employee[] team = new Employee[capacity];

    public void add(Employee e) {
        if (curIndex == capacity) {
            increaseToSize(capacity * 2);
        }
        team[curIndex++] = e;
    }

    private void increaseToSize(int size) {
        if (size > capacity) {
            Employee[] temp = new Employee[size];
            for (int i = 0; i < team.length; i++) {
                temp[i] = team[i];
            }
            capacity = size;
            team = temp;
        }
    }

    public Employee[] getTeam() {
        return team;
    }

    public int size() {             // кол-во рабочих в команде (The int size() method that returns how many Employees in the team)
        int count = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i] != null) {
                count += 1;
            }
        }
        return count;
    }

    public Employee get(int index) {  // Показывает работник по индексу (The Employee get(int index) method that return the Employee with the given index)
        return team[index];
    }

    public void remove(int index) {  // удаление работника по индексу
        if (index >= size()) {
            System.out.println("Сотрудника с данным индексом не существует");
        } else if (index == size() - 1) {
            team[index] = null;
        } else {
            team[index] = team[size() - 1];
            team[size() - 1] = null;
        }
    }

    public void remove(String name) { // удаление работника по имени
        for (int i = 0; i < size(); i++) {
            if (team[i].getName().equals(name)) {
                if (i == size() - 1) {
                    team[i] = null;
                } else {
                    team[i] = team[size() - 1];
                    team[size() - 1] = null;
                }
                return;
            }
        }
        System.out.println("Сотрудника с данным именем не существует");
    }

    public void teamNames() {
        for (int i = 0; i < size(); i++) {
            System.out.println(team[i].getName());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeTeam)) return false;

        EmployeeTeam that = (EmployeeTeam) o;

        if (capacity != that.capacity) return false;
        if (curIndex != that.curIndex) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(getTeam(), that.getTeam());
    }

    @Override
    public int hashCode() {
        int result = capacity;
        result = 31 * result + curIndex;
        result = 31 * result + Arrays.hashCode(getTeam());
        return result;
    }

    public int find(Employee e) {
        for (int i = 0; i < team.length; i++) {
            if (team.equals(e)) {
                return i;
            }
        }
        return -1;
    }

}
