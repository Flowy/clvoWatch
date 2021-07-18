package com.flowyk.clvowatch.productUpload;

import com.flowyk.clvowatch.Fountain;
import com.flowyk.clvowatch.Watch;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class UploadValidator {

    public ValidationResult validate(Watch product) {
        ValidationResult result = new ValidationResult();
        if (product.getTitle() == null) {
            result.failed(ValidationResult.Fails.MISSING_TITLE);
        }

        if (product.getPrice() == null) {
            result.failed(ValidationResult.Fails.MISSING_PRICE);
        }

        if (product.getFountain() != null) {
            validateFountain(product.getFountain(), result);
        }
        return result;
    }

    private void validateFountain(Fountain fountain, ValidationResult result) {
        if (!Base64.isBase64(fountain.getValue())) {
            result.failed(ValidationResult.Fails.UNKNOWN_FOUNTAIN_FORMAT);
        }
    }
}
