package com.atuldwivedi.justgenerateit.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;

public class User {
    public User() {
    }

    private String name;
    private List<Address> addresses;

    public User(String name, List<Address> addresses, String lastName) {
        this.name = name;
        this.addresses = addresses;
        this.lastName = lastName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", addresses=" + addresses +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getCurrencyIds() {
        Set<String> currencyIds = new HashSet<>();
        ofNullable(this).map(User::getAddresses).ifPresent(a -> a.forEach(ad -> {
            ofNullable(ad).map(Address::getAmount).map(Amount::getCurrency).map(Currency::getId).ifPresent(currencyIds::add);
        }));
        return currencyIds;
    }

    public Set<String> getAllStrings() {
        Set<String> currencyIds = new HashSet<>();
        ofNullable(this)
                .ifPresent(data -> {
                    ofNullable(data.getName()).ifPresent(name -> currencyIds.add(name));
                    ofNullable(data.getLastName()).ifPresent(lastName -> currencyIds.add(lastName));
                    ofNullable(data.getAddresses())
                            .ifPresent(a -> a.forEach(ad -> {
                                ofNullable(ad)
                                        .map(Address::getAmount)
                                        .map(Amount::getCurrency)
                                        .map(Currency::getId).
                                        ifPresent(currencyIds::add);
                            }));
                });
        return currencyIds;
    }
}
