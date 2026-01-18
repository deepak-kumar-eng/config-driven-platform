package com.platform.domain.validation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.platform.domain.model.Device;
import com.platform.domain.model.Metadata;
import com.platform.domain.model.Threshold;
import com.platform.domain.validation.rules.ThresholdOrderRule;

public class DomainValidatorTest {

    @Test
    void shouldFailFastWhenRuleFails() {
        DomainValidator validator = new DomainValidator(
                List.of(new ThresholdOrderRule())
        );

        Device device = new Device(
                new Threshold(200, 100),
                new Metadata("TestManufacturer", "1.0")
        );

        ValidationResult result = validator.validate(device);

        assertFalse(result.isValid());
        assertEquals("MinValue must be less than MaxValue", result.getMessage());
    }

    @Test
    void shouldPassWhenAllRulesPass() {
        DomainValidator validator = new DomainValidator(
                List.of(new ThresholdOrderRule())
        );

        Device device = new Device(
                new Threshold(40, 180),
                new Metadata("TestManufacturer", "1.0")
        );

        ValidationResult result = validator.validate(device);

        assertTrue(result.isValid());
    }
}