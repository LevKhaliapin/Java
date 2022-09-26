package com.company;

public class MyQueue<T> {

    //ДЗ_2_Реализовать циклическую очередь на основе массива.

    public static void main(String[] args) throws Exception {

        MyQueue<Integer> queue = new MyQueue<>();
//        queue.print();

        queue.offer(1);
        queue.poll();
        queue.offer(2);
        queue.poll();
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);

        System.out.println("size - " + queue.size);

        System.out.println("first - " + queue.element());


    }

    private T[] array;
    private int capacity;
    private int size;
    private int head;
    private int tail;

    public MyQueue() {
        capacity = 5;
        size = 0;
        array = (T[]) new Object[capacity];
        head = 0;
        tail = 0;

    }

    public T element() {
        if (size == 0) {
            return null;
        }
        return array[head];
    }

    public boolean offer(T object) {
        if (size == capacity) {
            return false;
        }
        array[tail++] = object;
        if (tail == size) {
            tail = 0;
        }
        size++;
        return true;
    }

    public T poll() {
        if (size == 0) {
            return null;
        }
        T object = array[head];
        size--;
        if (size == 0) {
            head = 0;
            tail = 0;
        } else head++;
        if (head == tail) return null;

        if (head >= capacity) head = 0;
        return object;
    }

    public void reset() {
        size = 0;
        head = 0;
        tail = 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        if (size == 0) System.out.println("Очередь пуста");
        for (int i = head; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}
