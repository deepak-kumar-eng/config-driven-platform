package com.platform.domain.validation.rules;

import com.platform.domain.model.Device;
import com.platform.domain.model.Threshold;
import com.platform.domain.validation.ValidationResult;
import com.platform.domain.validation.ValidationRule;

public class ThresholdOrderRule implements ValidationRule {

    @Override
    public ValidationResult validate(Device device) {
        Threshold threshold = device.getThreshold();

        if (threshold.getMinValue() >= threshold.getMaxValue()) {
            return ValidationResult.failure(
                "MinValue must be less than MaxValue"
            );
        }

        return ValidationResult.success();
    }
}