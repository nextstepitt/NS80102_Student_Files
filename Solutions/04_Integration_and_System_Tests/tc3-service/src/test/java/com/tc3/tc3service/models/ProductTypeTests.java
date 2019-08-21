// ProductTypeTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProductTypeTests {

    private ProductType productType1;
    private ProductType productType2;

    @BeforeEach
    public void setup() {

        productType1 = new ProductType();
        productType1.setProductTypeId(1);
        productType1.setName("Beverage");

        productType2 = new ProductType();
        productType2.setProductTypeId(1);
        productType2.setName("Beverage");
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(productType1, productType2);
    }

    @Test
    public void assertsIsNotEqual() {

        productType2.setName("Pastry");
        assertNotEquals(productType1, productType2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(productType1.hashCode(), productType2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        productType2.setName("Pastry");
        assertNotEquals(productType1.hashCode(), productType2.hashCode());
    }
}
