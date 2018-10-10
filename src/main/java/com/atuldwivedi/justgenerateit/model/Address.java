package com.atuldwivedi.justgenerateit.model;

public class Address {
    private String street;
    private Long pin;

    private Amount amount;

    public Address(String street, Long pin, Amount amount) {
        this.street = street;
        this.pin = pin;
        this.amount = amount;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +

                ", pin=" + pin +
                ", amount=" + amount +
                '}';
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }
}
