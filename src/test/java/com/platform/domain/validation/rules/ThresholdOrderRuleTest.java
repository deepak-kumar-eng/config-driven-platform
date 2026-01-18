package com.platform.domain.validation.rules;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.platform.domain.model.Device;
import com.platform.domain.model.Threshold;
import com.platform.domain.validation.ValidationResult;

public class ThresholdOrderRuleTest {

    @Test
    void shouldPassWhenMinIsLessThanMax() {
        Device device = new Device(new Threshold(40, 180));
        ThresholdOrderRule rule = new ThresholdOrderRule();

        ValidationResult result = rule.validate(device);

        assertTrue(result.isValid());
    }

    @Test
    void shouldFailWhenMinIsGreaterThanOrEqualToMax() {
        Device device = new Device(new Threshold(200, 100));
        ThresholdOrderRule rule = new ThresholdOrderRule();

        ValidationResult result = rule.validate(device);

        assertFalse(result.isValid());
        assertEquals(
            "MinValue must be less than MaxValue",
            result.getMessage()
        );
    }
}
