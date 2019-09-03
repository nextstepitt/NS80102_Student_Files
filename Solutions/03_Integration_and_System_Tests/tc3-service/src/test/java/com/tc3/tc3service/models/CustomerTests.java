// Customer.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerTests {

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void setup() {

        customer1 = new Customer();
        customer1.setCustomerId(1);

        customer2 = new Customer();
        customer2.setCustomerId(1);
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(customer1, customer2);
    }

    @Test
    public void assertsIsNotEqual() {

        customer2.setCustomerId(2);
        assertNotEquals(customer1, customer2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(customer1.hashCode(), customer2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        customer2.setCustomerId(2);
        assertNotEquals(customer1.hashCode(), customer2.hashCode());
    }
}
