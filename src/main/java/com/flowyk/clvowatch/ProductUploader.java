package com.flowyk.clvowatch;

public class ProductUploader {

    public UploadResult upload(Watch product) {
        ValidationResult validationResult = validate(product);
        if (validationResult.isSuccess()) {
            return SuccessResult.getInstance();
        } else {
            return validationResult;
        }
    }

    ValidationResult validate(Watch product) {
        ValidationResult result = new ValidationResult();
        if (product.getTitle() == null) {
            result.failed("missing_title");
        }

        return result;
    }
}
