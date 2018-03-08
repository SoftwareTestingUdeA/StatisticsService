package com.udea.testing.program1.statisticsService.model;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
public class Node {
    private Double number;
    private Node link;

    public Node() {
        this.number = 0.0;
        this.link = null;
    }

    public Node(Double number, Node link) {
        this.number = number;
        this.link = link;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}