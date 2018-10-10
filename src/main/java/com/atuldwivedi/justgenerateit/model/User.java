package com.atuldwivedi.justgenerateit.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Optional.ofNullable;

public class User {
    private String name;
    private List<Address> addresses;

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
}
