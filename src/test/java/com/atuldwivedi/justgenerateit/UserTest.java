package com.atuldwivedi.justgenerateit;

import com.atuldwivedi.justgenerateit.model.Address;
import com.atuldwivedi.justgenerateit.model.Amount;
import com.atuldwivedi.justgenerateit.model.Currency;
import com.atuldwivedi.justgenerateit.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {

    @Test
    public void should_1() {
        User user = new User();
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("A", 1L, new Amount(new Currency("INR"))));
        addresses.add(new Address("B", 2L, new Amount(new Currency("EUR"))));
        addresses.add(new Address("C", 3L, new Amount(new Currency("INR"))));
        addresses.add(new Address("D", 4L, new Amount(new Currency("INR"))));
        addresses.add(new Address("E", 5L, new Amount()));
        addresses.add(new Address("F", 6L, null));
        addresses.add(null);
        addresses.add(new Address("G", 7L, new Amount(new Currency("USD"))));
        user.setAddresses(addresses);

        //when
        Set<String> actualCurrencyIds = user.getCurrencyIds();
        System.out.print(actualCurrencyIds);

        assertThat(actualCurrencyIds).isNotNull();
    }


}
