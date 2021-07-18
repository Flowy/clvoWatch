package com.flowyk.clvowatch.api;

import com.flowyk.clvowatch.Fountain;
import com.flowyk.clvowatch.Price;
import com.flowyk.clvowatch.Watch;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class APITransformer {
    Watch from(WatchAPI watchAPI) {
        return new Watch()
                .setTitle(watchAPI.title)
                .setPrice(Optional.ofNullable(watchAPI.price)
                        .map(Price::new)
                        .orElse(null)
                )
                .setDescription(watchAPI.description)
                .setFountain(Optional.ofNullable(watchAPI.fountain)
                        .map(Fountain::new)
                        .orElse(null)
                );
    }

    WatchAPI from(Watch watch) {
        WatchAPI result = new WatchAPI();
        result.title = watch.getTitle();
        result.price = Optional.ofNullable(watch.getPrice()).map(Price::getValue).orElse(null);
        result.description = watch.getDescription();
        result.fountain = Optional.ofNullable(watch.getFountain()).map(Fountain::getValue).orElse(null);
        return result;
    }

}
