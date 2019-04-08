/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author rumee
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static LinkedList linkedList;

    public static void main(String[] args) {

        linkedList = new LinkedList();
        linkedList.add(11);
        linkedList.add(22);
        linkedList.add(33);
        linkedList.add(44);
        linkedList.add(55);
        linkedList.add(66);
        linkedList.add(77);
        System.out.println("Linked List value :" + linkedList.toString());
        //linkedList.remove();
        System.out.println("After :" + linkedList.toString());

        linkedList.removeAll(56);
        System.out.println("After :" + linkedList.toString());

    }
}

class LinkedList {

    private static int counter;
    private Node head;

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
        }
        Node nodeTemp = new Node(data);
        Node nodeCurrent = head;
        if (nodeCurrent != null) {
            while (nodeCurrent.getNext() != null) {
                nodeCurrent = nodeCurrent.getNext();
            }
            nodeCurrent.setNext(nodeTemp);
        }
        incrementCounter();
    }

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private static void decrementCounter() {
        counter--;
    }

    public Object get(int index) {
        if (index < 0) {
            return null;
        }
        Node nodeCurrent = null;
        if (head != null) {
            nodeCurrent = head.getNext();
            for (int i = 0; i < index; i++) {
                if (nodeCurrent.getNext() == null) {
                    return null;
                }
                nodeCurrent = nodeCurrent.getNext();
            }
            return nodeCurrent.getData();
        }
        return nodeCurrent;
    }

    public void remove() {
        Node nodeCurrent = head;
        if (head != null) {
            for (int i = 0; i < size() - 1; i++) {
                if (nodeCurrent.getNext() != null) {
                    nodeCurrent = nodeCurrent.getNext();
                }
            }
            nodeCurrent.setNext(nodeCurrent.getNext().getNext());
            decrementCounter();
        }
    }

    public void removeAll(int value) {
        Node nodeCurrent = head;
        for (int i = 0; i < size(); i++) {
            int data = (int) nodeCurrent.getNext().getData();
            if (value < data) {
                System.out.println("Large value: " + data);

            }
            nodeCurrent = nodeCurrent.getNext();
            nodeCurrent.setNext(nodeCurrent.getNext());
            // TODO.
        }

    }

    public int size() {
        return getCounter();
    }

    public String toString() {
        String output = "";
        if (head != null) {
            Node linkedListCurrent = head.getNext();
            while (linkedListCurrent != null) {
                output += "[" + linkedListCurrent.getData().toString() + "]";
                linkedListCurrent = linkedListCurrent.getNext();
            }
        }
        return output;
    }

    private class Node {

        Node next;
        Object data;

        public Node(Object dataValue) {
            next = null;
            data = dataValue;
        }

        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}
