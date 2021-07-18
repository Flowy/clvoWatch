package com.flowyk.clvowatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BooleanSupplier;

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


}
