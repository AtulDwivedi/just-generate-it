package com.atuldwivedi.justgenerateit.model;

public class Currency {
    private String id;

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id='" + id + '\'' +
                '}';
    }

    public Currency(String id) {
        this.id = id;
    }

    public Currency() {
    }

    public void setId(String id) {
        this.id = id;
    }
}
