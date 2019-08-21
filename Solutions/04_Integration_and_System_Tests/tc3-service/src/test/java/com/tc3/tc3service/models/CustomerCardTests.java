// CustomerCardTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerCardTests {

    private CustomerCard customerCard1;
    private CustomerCard customerCard2;

    @BeforeEach
    public void setup() {

        customerCard1 = new CustomerCard();
        customerCard1.setCustomerCardId(1);
        customerCard1.setCustomerId(1);

        customerCard2 = new CustomerCard();
        customerCard2.setCustomerCardId(1);
        customerCard2.setCustomerId(1);
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(customerCard1, customerCard2);
    }

    @Test
    public void assertsIsNotEqual() {

        customerCard2.setCustomerId(2);
        assertNotEquals(customerCard1, customerCard2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(customerCard1.hashCode(), customerCard2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        customerCard2.setCustomerId(2);
        assertNotEquals(customerCard1.hashCode(), customerCard2.hashCode());
    }

}
