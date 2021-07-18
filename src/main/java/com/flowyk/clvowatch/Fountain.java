package com.flowyk.clvowatch;

import java.util.Objects;

public class Fountain {
    private String value;

    public Fountain(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fountain fountain = (Fountain) o;
        return Objects.equals(value, fountain.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
