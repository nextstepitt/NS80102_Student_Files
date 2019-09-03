// CreditCardValidatorTests.cs
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreditCardValidatorTests {

    private CreditCardValidator cardValidator;

    @BeforeEach
    public void setup() {

        cardValidator = new CreditCardValidator();
    }

    @Test
    public void failsWithEmptyCardNumber() {

        assertFalse(cardValidator.validateCardNumber(""));
    }

    @Test
    public void failsWithNullCardNumber() {

        assertThrows(NullPointerException.class, () -> { cardValidator.validateCardNumber(null); });
    }

    @Test
    public void acceptsValidCardNumber() {

        assertTrue(cardValidator.validateCardNumber("378282246310005"));
    }

    @Test
    public void rejectsInvalidCardNumber() {

        assertFalse(cardValidator.validateCardNumber("378282246310006"));
    }

    @Test
    public void rejectsLowerCaseLetterInCardNumber() {

        assertFalse(cardValidator.validateCardNumber("37828224631000a"));
    }

    @Test
    public void rejectsSymbolInCardNumber() {

        assertFalse(cardValidator.validateCardNumber("37828224631000$"));
    }

    @Test
    public void rejectsUpperCaseLetterInCardNumber() {

        assertFalse(cardValidator.validateCardNumber("37828224631000A"));
    }
}
