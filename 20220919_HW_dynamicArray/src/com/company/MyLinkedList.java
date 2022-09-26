package com.company;

public class MyLinkedList<T> {

    // 	Реализовать LinkedList  (addLast, addFirst, add(index), remove(index), print, find)

    public static void main(String[] args) {

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.print();
        System.out.println(linkedList.find(2));


    }

    private Node first;
    private Node last;
    private int size = 0;


    public void addLast(T object) {
        if (size == 0) {
            first = new Node(null, object, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, object, null);
            secondLast.next = last;
        }
        size++;
    }

    public void addFirst(T object) {
        if (size == 0) {
            first = new Node(null, object, null);
            last = first;
        } else {
            Node secondFirst = first;
            first = new Node(null, object, secondFirst);
            secondFirst.previous = first;
        }
        size++;
    }

    public void add(T object, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addLast(object);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, object, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public boolean remove(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }


    public int find(T object) {      // не доделал метод.
        if (size == 0) return -1;
        int count = 0;
        while (!first.equals(object)) {
            if (first == null) return -1;
            first = first.next;
            count++;
        }
        return count;
    }

    public void print() {
        if (size == 0) System.out.println("LinkedList пуст");
        while (first != null) {
            System.out.println(first.value + " ");
            first = first.next;
        }
    }


    class Node<T> {
        Node<T> previous;
        T value;
        Node<T> next;

        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }


}
