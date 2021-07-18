package com.flowyk.clvowatch.productUpload;

import com.flowyk.clvowatch.Watch;
import com.flowyk.clvowatch.persistence.Persister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductFetcher {

    private final Persister persister;

    @Autowired
    public ProductFetcher(Persister persister) {
        this.persister = persister;
    }

    public Watch load(String title) {
        return persister.loadProduct(title);
    }
}
