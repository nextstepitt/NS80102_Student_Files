// CreditCardValidatorTests.cs
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.services;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apiguardian.api.API;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

// @API(status = EXPERIMENTAL)
public class CreditCardValidatorTests {

    private CreditCardValidator cardValidator;

    @BeforeEach
    public void setup() {

        cardValidator = new CreditCardValidator();
    }

    @TestFactory
    public Stream<DynamicTest> failsWithNoCardNumber() {

        return Arrays.asList(
                DynamicTest.dynamicTest("fails with empty card number",
                        () -> assertFalse(cardValidator.validateCardNumber(""))),
                DynamicTest.dynamicTest("fails with null card number",
                        () -> assertThrows(NullPointerException.class, () -> { cardValidator.validateCardNumber(null); }))
        ).stream();
    }

    @Test
    public void acceptsValidCardNumber() {

        assertTrue(cardValidator.validateCardNumber("378282246310005"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"378282246310006", "37828224631000a", "37828224631000$", "37828224631000A"})
    void rejectsInvalidCardNumbers(String cardNumber) {

        assertFalse(cardValidator.validateCardNumber(cardNumber));
    }

    @RepeatedTest(3)
    public void exampleLatencyTest() {

        assertTimeout(Duration.ofMillis(1000), () -> { Thread.sleep(500); });
    }
}
