// SalesOrderTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SalesOrderTests {

    private SalesOrder salesOrder1;
    private SalesOrder salesOrder2;

    @BeforeEach
    public void setup() {

        salesOrder1 = new SalesOrder();
        salesOrder1.setSalesOrderId(1);
        salesOrder1.setCustomerId(1);
        salesOrder1.setPaymentTypeId(1);

        salesOrder2 = new SalesOrder();
        salesOrder2.setSalesOrderId(1);
        salesOrder2.setCustomerId(1);
        salesOrder2.setPaymentTypeId(1);
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(salesOrder1, salesOrder2);
    }

    @Test
    public void assertIsNotEqual() {

        salesOrder2.setCustomerId(2);
        assertNotEquals(salesOrder1, salesOrder2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(salesOrder1.hashCode(), salesOrder2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        salesOrder2.setCustomerId(2);
        assertNotEquals(salesOrder1.hashCode(), salesOrder2.hashCode());
    }
}
