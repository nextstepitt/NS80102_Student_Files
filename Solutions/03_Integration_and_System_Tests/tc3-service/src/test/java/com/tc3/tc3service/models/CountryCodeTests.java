// CountryCodeTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CountryCodeTests {

    private CountryCode countryCode1;
    private CountryCode countryCode2;

    @BeforeEach
    public void setup() {

        countryCode1 = new CountryCode();
        countryCode1.setCountryCodeId("us");
        countryCode1.setName("United States");

        countryCode2 = new CountryCode();
        countryCode2.setCountryCodeId("us");
        countryCode2.setName("United States");
    }

    @Test
    public void assertsIsEqual() {} {

        assertEquals(countryCode1, countryCode2);
    }

    @Test
    public void assertsIsNotEqual() {

        countryCode2.setName("Mexico");
        assertNotEquals(countryCode1, countryCode2);
    }

    @Test
    public void assertsSameHashIsEqual() {

        assertEquals(countryCode1.hashCode(), countryCode2.hashCode());
    }

    @Test
    public void assertsDifferentHashIsNotEqual() {

        countryCode2.setName("Mexico");
        assertNotEquals(countryCode1.hashCode(), countryCode2.hashCode());
    }

}
