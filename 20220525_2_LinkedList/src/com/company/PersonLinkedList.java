package com.company;


public class PersonLinkedList {

    int size = 0;
    Node first = null;
    Node end = null;


    /*
        3. add(Person p, int index)
     */
    public void add(Person p, int index) {
        if(index < 0 || index >=size) return;
        if (index == size) {
            add(p);
        }
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;
        Node newNode = new Node(p, prevNode, nextNode);
        nextNode.prev = newNode;
        if (prevNode != null) {
            prevNode.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    public void add(Person p) {
        if (first == null) {
            first = new Node(p, null, null);
            end = first;
        } else {
            Node newNode = new Node(p, end, null);
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.person);
            current = current.next;
        }
    }
    /*
        1. Person get(int index)
    */
    public Person getPerson(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getNode(index).person;
    }

    /*
        1.1 Node get(int index)
    */
    public Node getNode(int index) {
        Node current = first;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        }
        return current;
    }

     /*
        2.1 remove (int index)
     */
    public boolean remove(Person person) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (person.equals(node.person)) {
               return remove(i);
            }
            node = node.next;
        }
        size--;
        return true;
    }

    /*
     2. remove (int index)
    */
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node currentNode = getNode(index);
        Node prevNode = currentNode.prev;
        Node nextNode = currentNode.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            first = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            end = prevNode;
        }
        size--;
        return true;
    }

    class Node {
        Person person;
        Node prev;
        Node next;

        public Node(Person person, Node prev, Node next) {
            this.person = person;
            this.prev = prev;
            this.next = next;
        }

        public void setPerson(Person person) {
            this.person = person;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}
