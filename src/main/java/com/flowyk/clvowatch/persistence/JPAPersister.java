package com.flowyk.clvowatch.persistence;


import com.flowyk.clvowatch.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class JPAPersister implements Persister {

    private final WatchRepository watchRepository;

    @Autowired
    public JPAPersister(WatchRepository watchRepository) {
        this.watchRepository = watchRepository;
    }

    @Override
    public void saveProduct(Watch product) {
        WatchPersistence entity = WatchPersistence.from(product);
        watchRepository.save(entity);
    }

    @Override
    public Watch loadProduct(String title) {
        Optional<WatchPersistence> entity = watchRepository.findById(title);
        return entity.map(WatchPersistence::intoWatch).orElse(null);
    }
}
