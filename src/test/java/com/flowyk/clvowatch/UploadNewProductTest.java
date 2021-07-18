package com.flowyk.clvowatch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UploadNewProductTest {

    @Test
    void uploadNewProduct() {
        Watch product = new Watch()
                .setTitle("Prim")
                .setPrice(new Price(250000))
                .setDescription("A watch with a water fountain picture")
                .setFountain(new Fountain("R0lGODlhAQABAIAAAAUEBA"));
        UploadResult result = ProductUploader.upload(product);
        Assert.isTrue(result != null && result.isSuccess(), "Uploading failed");
    }
}
