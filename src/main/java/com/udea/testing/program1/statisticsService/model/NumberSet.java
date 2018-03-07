package com.udea.testing.program1.statisticsService.model;

import java.util.LinkedList;

public class NumberSet {
    String uuid;
    LinkedList<Double> set;
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

    public LinkedList<Double> getSet() {
        return set;
    }

    public void setSet(LinkedList<Double> set) {
        this.set = set;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
