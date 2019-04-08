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
        linkedList.add(34);
        linkedList.add(45);
        linkedList.add(13);
        linkedList.add(64);
        linkedList.add(85);
        linkedList.add(81);

        System.out.println("Linked List value :" + linkedList.toString());
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
        // tail last data
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
