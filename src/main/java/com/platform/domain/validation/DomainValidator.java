package com.platform.domain.validation;

import java.util.List;

import com.platform.domain.model.Device;

public class DomainValidator {

    private final List<ValidationRule> rules;

    public DomainValidator(List<ValidationRule> rules) {
        this.rules = rules;
    }

    public ValidationResult validate(Device device) {
        for (ValidationRule rule : rules) {
            ValidationResult result = rule.validate(device);
            if (!result.isValid()) {
                return result; // fail fast
            }
        }
        return ValidationResult.success();
    }
}