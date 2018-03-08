package com.udea.testing.program1.statisticsService.model;

public class NumberSet {
    String uuid;
    NumberLinkedList set;
    Double mean;
    Double stdDeviation;

    public Double getStdDeviation() {
        return stdDeviation;
    }

    public void setStdDeviation(Double stdDeviation) {
        this.stdDeviation = stdDeviation;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public NumberLinkedList getSet() {
        return set;
    }

    public void setSet(NumberLinkedList set) {
        this.set = set;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void calculateMean() {
        Node node = this.getSet().getFirst();
        while(node != null) {
            this.mean += node.getNumber();
            node.getLink();
        }
        this.mean /= this.getSet().getSize();
    }

    public void calculateStdDeviation() {
        Node node = this.getSet().getFirst();
        Double stdDeviation = 0.0;
        while(node != null) {
            this.mean += node.getNumber();
            this.stdDeviation += Math.pow(node.getNumber() - mean, 2);
            node.getLink();
        }
        this.stdDeviation = Math.sqrt(stdDeviation / this.getSet().getSize() - 1);
    }
}
