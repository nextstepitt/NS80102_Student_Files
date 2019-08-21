// PaymentTypeTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PaymentTypeTests {

    private PaymentType PaymentType1;
    private PaymentType PaymentType2;

    @BeforeEach
    public void setup() {

        PaymentType1 = new PaymentType();
        PaymentType1.setPaymentTypeId(1);
        PaymentType1.setName("Credit");

        PaymentType2 = new PaymentType();
        PaymentType2.setPaymentTypeId(1);
        PaymentType2.setName("Credit");
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(PaymentType1, PaymentType2);
    }

    @Test
    public void assertsIsNotEqual() {

        PaymentType2.setName("Cash");
        assertNotEquals(PaymentType1, PaymentType2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(PaymentType1.hashCode(), PaymentType2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        PaymentType2.setName("Cash");
        assertNotEquals(PaymentType1.hashCode(), PaymentType2.hashCode());
    }
}
