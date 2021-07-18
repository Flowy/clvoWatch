package com.flowyk.clvowatch.productUpload;

import com.flowyk.clvowatch.Watch;
import com.flowyk.clvowatch.persistence.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUploader {

    private final UploadValidator uploadValidator;
    private final Persister persister;

    @Autowired
    public ProductUploader(UploadValidator uploadValidator, Persister persister) {
        this.uploadValidator = uploadValidator;
        this.persister = persister;
    }

    public UploadResult upload(Watch product) {
        ValidationResult validationResult = uploadValidator.validate(product);

        if (!validationResult.isSuccess()) {
            return validationResult;
        }

        persister.saveProduct(product);

        return SuccessResult.getInstance();
    }

}
