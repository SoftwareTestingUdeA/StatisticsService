package com.udea.testing.program1.statisticsService.model;

import java.util.List;

public class NumberSet {
    String uuid;
    List<Double> set;
    NumberLinkedList list;
    Double mean;
    Double stdDeviation;

    public NumberSet() {
        mean = 0.0;
        stdDeviation = 0.0;
    }

    public List<Double> getSet() {
        return set;
    }

    public void setSet(List<Double> set) {
        this.set = set;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public NumberLinkedList getList() {
        return list;
    }

    public void setList(NumberLinkedList list) {
        this.list = list;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Double getStdDeviation() {
        return stdDeviation;
    }

    public void setStdDeviation(Double stdDeviation) {
        this.stdDeviation = stdDeviation;
    }

    public void calculateMean() {
        Node node = this.getList().getFirst();
        this.setMean(0.0);
        while (node != null) {
            this.mean = this.mean + node.getNumber();
            node = node.getLink();
        }

        this.mean = this.mean / this.getList().getSize();
    }

    public void calculateStdDeviation() {
        Node node = this.getList().getFirst();
        this.setStdDeviation(0.0);
        while (node != null) {
            this.stdDeviation = this.stdDeviation + Math.pow(node.getNumber() - this.getMean(), 2.0);
            node = node.getLink();
        }
        this.stdDeviation = Math.sqrt(stdDeviation / (this.getList().getSize() - 1));
    }

    public void generateList() {
        this.setList(new NumberLinkedList());
        if (null != set)
            for (Double d : set) {
                this.getList().insert(d);
            }
    }
}
