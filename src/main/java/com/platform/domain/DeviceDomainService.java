package com.platform.domain;

import java.io.File;

import com.platform.domain.model.Device;
import com.platform.domain.parser.DeviceDomainParser;
import com.platform.domain.validation.DomainValidator;
import com.platform.domain.validation.ValidationResult;

public class DeviceDomainService {

    private final DeviceDomainParser parser;
    private final DomainValidator validator;

    public DeviceDomainService(DeviceDomainParser parser, DomainValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public ValidationResult validate(File xmlFile) {
        Device device = parser.parse(xmlFile);
        return validator.validate(device);
    }
}