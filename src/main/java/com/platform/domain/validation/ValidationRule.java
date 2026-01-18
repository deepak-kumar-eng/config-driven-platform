package com.platform.domain.validation;

import com.platform.domain.model.Device;

public interface ValidationRule {
    ValidationResult validate(Device device);
}
