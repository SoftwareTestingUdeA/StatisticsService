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
}
