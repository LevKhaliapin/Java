package com.company;

public class DynamicArray<T> {

    //ДЗ_1_Реализовать динамический массив (операции add, remove(index), get(index), find, print) и стек на основе этого массива.

    public static void main(String[] args) throws Exception {

        DynamicArray<Integer> array = new DynamicArray();
        array.add(1);
        array.add(44);
        array.add(2);
        array.add(6);
        array.add(76);
        array.push(55);

        array.print();
        System.out.println("================size================");
        System.out.println(array.getSize());

        System.out.println("================find================");
        System.out.println(array.find(44));
        System.out.println(array.find(33));

        System.out.println("================remove================");
        System.out.println(array.remove(7));
        array.print();

        System.out.println("================pop================");
        System.out.println(array.pop());

        System.out.println("================peek================");
        System.out.println(array.peek());
    }

    private T[] array;
    private int capacity;
    private int size;

    public DynamicArray() {
        capacity = 10;
        size = 0;
        array = (T[]) new Object[capacity];

    }

    public void add(T object) {
        if (size >= capacity) {
            increaseSize();
        }
        array[size] = object;
        size++;
    }

    public void increaseSize() {
        T[] newArray = (T[]) new Object[capacity * 2];
        capacity *= 2;
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean remove(int index) {
        if (index < size) {
            for (int i = index + 1; i < size; i++) {
                array[i - 1] = array[i];
            }
            size--;
            return true;
        }
        return false;
    }

    public T get(int index) throws Exception {
        if (index < 0 || index >= size) {
            new Exception("Индекс отсутствует");
        }
        return array[index];
    }

    public int getSize() {
        return size;
    }

    public int find(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) return i;
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

// методы для Стэка

    public void push(T object) {
        if (size >= capacity) {
            increaseSize();
        }
        array[size] = object;
        size++;
    }

    public T pop() {
        T object = array[size - 1];
        size--;
        return object;
    }

    public T peek() {
        return array[size - 1];
    }
}






