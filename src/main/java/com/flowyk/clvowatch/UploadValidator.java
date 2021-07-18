package com.flowyk.clvowatch;

public class UploadValidator {

    public ValidationResult validate(Watch product) {
        ValidationResult result = new ValidationResult();
        if (product.getTitle() == null) {
            result.failed(ValidationResult.Fails.MISSING_TITLE);
        }

        return result;
    }
}
