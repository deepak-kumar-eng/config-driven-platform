package com.platform.domain.model;

public class Metadata {

    private final String manufacturer;
    private final String version;

    public Metadata(String manufacturer, String version) {
        this.manufacturer = manufacturer;
        this.version = version;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getVersion() {
        return version;
    }
}