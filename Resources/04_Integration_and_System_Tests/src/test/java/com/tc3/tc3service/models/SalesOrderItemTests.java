// SalesOrderItemTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SalesOrderItemTests {

    private SalesOrderItem salesOrderItem1;
    private SalesOrderItem salesOrderItem2;

    @BeforeEach
    public void setup() {

        salesOrderItem1 = new SalesOrderItem();
        salesOrderItem1.setSalesOrderItemId(1);
        salesOrderItem1.setSalesOrderId(1);
        salesOrderItem1.setProductId(1);

        salesOrderItem2 = new SalesOrderItem();
        salesOrderItem2.setSalesOrderItemId(1);
        salesOrderItem2.setSalesOrderId(1);
        salesOrderItem2.setProductId(1);
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(salesOrderItem1, salesOrderItem2);
    }

    @Test
    public void assertsIsNotEqual() {

        salesOrderItem2.setSalesOrderId(2);
        assertNotEquals(salesOrderItem1, salesOrderItem2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(salesOrderItem1.hashCode(), salesOrderItem2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        salesOrderItem2.setSalesOrderId(2);
        assertNotEquals(salesOrderItem1.hashCode(), salesOrderItem2.hashCode());
    }
}
