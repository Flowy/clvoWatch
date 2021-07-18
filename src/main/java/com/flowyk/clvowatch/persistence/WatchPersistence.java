package com.flowyk.clvowatch.persistence;

import com.flowyk.clvowatch.Fountain;
import com.flowyk.clvowatch.Price;
import com.flowyk.clvowatch.Watch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Objects;

@Entity(name = "watch")
class WatchPersistence {
    @Id
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer price;

    @Column
    private String description;

    @Lob
    @Column
    private String fountain;

    static WatchPersistence from(Watch product) {
        WatchPersistence result = new WatchPersistence();
        result.setTitle(product.getTitle());
        result.setPrice(product.getPrice().getValue());
        result.setDescription(product.getDescription());
        result.setFountain(product.getFountain().getValue());
        return result;
    }

    Watch intoWatch() {
        return new Watch()
                .setTitle(title)
                .setPrice(new Price(price))
                .setDescription(description)
                .setFountain(new Fountain(fountain));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public WatchPersistence setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public WatchPersistence setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getFountain() {
        return fountain;
    }

    public WatchPersistence setFountain(String fountain) {
        this.fountain = fountain;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WatchPersistence that = (WatchPersistence) o;
        return Objects.equals(title, that.title) && Objects.equals(price, that.price) && Objects.equals(description, that.description) && Objects.equals(fountain, that.fountain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, description, fountain);
    }
}
