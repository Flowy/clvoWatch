package com.flowyk.clvowatch;

public class Watch {
    private String title;
    private Price price;
    private String description;
    private Fountain fountain;

    public String getTitle() {
        return title;
    }

    public Watch setTitle(String title) {
        this.title = title;
        return this;
    }

    public Price getPrice() {
        return price;
    }

    public Watch setPrice(Price price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Watch setDescription(String description) {
        this.description = description;
        return this;
    }

    public Fountain getFountain() {
        return fountain;
    }

    public Watch setFountain(Fountain fountain) {
        this.fountain = fountain;
        return this;
    }
}
