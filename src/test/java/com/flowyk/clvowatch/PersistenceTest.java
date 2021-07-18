package com.flowyk.clvowatch;

import com.flowyk.clvowatch.persistence.Persister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersistenceTest {

    @Autowired
    Persister persister;

    @Test
    void persistence() {
        Watch origin = new Watch()
                .setTitle("Prim")
                .setPrice(new Price(250000))
                .setDescription("A watch with a water fountain picture")
                .setFountain(new Fountain("R0lGODlhAQABAIAAAAUEBA"));
        persister.saveProduct(origin);
        Watch result = persister.loadProduct(origin.getTitle());
        Assertions.assertEquals(origin, result);
    }

}
