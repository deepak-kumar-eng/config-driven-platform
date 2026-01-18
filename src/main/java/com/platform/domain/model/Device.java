package com.platform.domain.model;

public class Device {

    private final Threshold threshold;
    private final Metadata metadata;

    public Device(Threshold threshold, Metadata metadata) {
        this.threshold = threshold;
        this.metadata = metadata;
    }

    public Threshold getThreshold() {
        return threshold;
    }

    public Metadata getMetadata() {
        return metadata;
    }
}