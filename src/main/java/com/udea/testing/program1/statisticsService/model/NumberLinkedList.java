package com.udea.testing.program1.statisticsService.model;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.3
 */
public class NumberLinkedList {

    private Node first;
    private Node last;
    private Integer size;

    public NumberLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public NumberLinkedList(Node first, Node last, Integer size) {
        this.first = first;
        this.size = size;
        this.last = last;
        if (last == null) {
            this.last = first;
        }
        if (first == null) {
            this.first = last;
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst() {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast() {
        this.last = last;
    }

    public Integer getSize() {
        if (size == 0 || null == size) {
            calculateSize();
        }
        return size;
    }

    public Boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public void insert(Double value) {
        Node node = new Node(value, null);
        if (first == null) {
            first = node;
            last = first;
            return;
        }
        last.setLink(node);
        last = node;
    }

    public void clearList() {
        first = null;
        last = null;
    }

    private void calculateSize() {
        Node node = first;
        while (node != null) {
            this.size = this.size + 1;
            node = node.getLink();
        }
    }
}