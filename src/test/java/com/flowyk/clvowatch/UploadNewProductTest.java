package com.flowyk.clvowatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UploadNewProductTest {

    private ProductUploader uploader = new ProductUploader();

    @Test
    void uploadNewProduct() {
        Watch product = new Watch()
                .setTitle("Prim")
                .setPrice(new Price(250000))
                .setDescription("A watch with a water fountain picture")
                .setFountain(new Fountain("R0lGODlhAQABAIAAAAUEBA"));
        UploadResult result = uploader.upload(product);
        Assertions.assertTrue(result.isSuccess(), "Upload result");
    }

    @Test
    void missingTitle() {
        Watch product = new Watch();
        UploadResult result = uploader.upload(product);
        Assertions.assertFalse(result.isSuccess(), "Upload result");
        Assertions.assertTrue(() -> result.failReasons().contains(ValidationResult.Fails.MISSING_TITLE), "Result contains correct error");
    }

    @Test
    void missingPrice() {
        Watch product = new Watch();
        UploadResult result = uploader.upload(product);
        Assertions.assertFalse(result.isSuccess(), "Upload result");
        Assertions.assertTrue(() -> result.failReasons().contains(ValidationResult.Fails.MISSING_PRICE), "Result contains correct error");
    }

    @Test
    void wrongFountainFormat() {
        Watch product = new Watch().setFountain(new Fountain("áR0lGODlhAQABAIAAAAUEB"));
        UploadResult result = uploader.upload(product);
        Assertions.assertFalse(result.isSuccess(), "Upload result");
        Assertions.assertTrue(() -> result.failReasons().contains(ValidationResult.Fails.UNKNOWN_FOUNTAIN_FORMAT), "Result contains correct error");
    }

}
