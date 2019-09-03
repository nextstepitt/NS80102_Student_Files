// ProductTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductTests {

    private Product product1;
    private Product product2;

    @BeforeEach
    public void setup() {

        product1 = new Product();
        product1.setProductId(1);
        product1.setProductTypeId(1);

        product2 = new Product();
        product2.setProductId(1);
        product2.setProductTypeId(1);
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(product1, product2);
    }

    @Test
    public void assertsIsNotEqual() {

        product2.setProductTypeId(2);
        assertNotEquals(product1, product2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        product2.setProductTypeId(2);
        assertNotEquals(product1.hashCode(), product2.hashCode());
    }

}
