package com.atuldwivedi.justgenerateit.model;

public class Amount {
    private Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public Amount(Currency currency) {
        this.currency = currency;
    }

    public Amount() {
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency=" + currency +
                '}';

    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
