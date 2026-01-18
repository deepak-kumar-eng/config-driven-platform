package com.platform.domain.model;

public class Threshold {
    private final int minValue;
    private final int maxValue;

    public Threshold(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}