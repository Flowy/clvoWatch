package com.flowyk.clvowatch;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Watch watch = (Watch) o;
        return Objects.equals(title, watch.title) && Objects.equals(price, watch.price) && Objects.equals(description, watch.description) && Objects.equals(fountain, watch.fountain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, description, fountain);
    }
}
