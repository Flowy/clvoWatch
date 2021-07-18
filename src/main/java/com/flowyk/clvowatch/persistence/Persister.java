package com.flowyk.clvowatch.persistence;

import com.flowyk.clvowatch.Watch;

public interface Persister {
    void saveProduct(Watch product);
    Watch loadProduct(String title);
}
