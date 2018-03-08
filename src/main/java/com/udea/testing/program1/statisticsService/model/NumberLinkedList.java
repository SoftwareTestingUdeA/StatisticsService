package com.udea.testing.program1.statisticsService.model;

public class NumberLinkedList {

    private Node first;
    private Node last;
    private Integer size;

    public NumberLinkedList() {
        first = null;
        last = null;
        size = null;
    }

    public NumberLinkedList(Node first, Node last) {
        this.first = first;
        this.last = last;
        this.size = size;
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
        if(size == null) {
            calculateSize();
        }
        return size;
    }

    public Boolean isEmpty() {
        if(first == null) {
            return true;
        }
        return false;
    }

    public void insert(Double value) {
        Node node = new Node(value, null);
        if(first == null) {
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
        while(node != null) {
            this.size++;
            node = node.getLink();
        }
    }
}