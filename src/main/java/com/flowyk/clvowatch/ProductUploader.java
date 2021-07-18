package com.flowyk.clvowatch;

public class ProductUploader {

    private UploadValidator uploadValidator = new UploadValidator();

    public UploadResult upload(Watch product) {
        ValidationResult validationResult = uploadValidator.validate(product);
        if (validationResult.isSuccess()) {
            return SuccessResult.getInstance();
        } else {
            return validationResult;
        }
    }

}
