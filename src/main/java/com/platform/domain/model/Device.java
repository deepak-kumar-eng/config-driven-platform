package com.platform.domain.model;

public class Device {

    private final Threshold threshold;

    public Device(Threshold threshold) {
        this.threshold = threshold;
    }

    public Threshold getThreshold() {
        return threshold;
    }
}
