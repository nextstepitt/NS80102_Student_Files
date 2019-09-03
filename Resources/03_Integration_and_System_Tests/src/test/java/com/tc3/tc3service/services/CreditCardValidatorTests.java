// CreditCardValidatorTests.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.services;

import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Stream;

import com.tc3.tc3service.models.CardInfo;

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
    private CardInfo cardInfo;

    @BeforeEach
    public void setup() {

        cardValidator = new CreditCardValidator();
        cardInfo = new CardInfo() {{ setName("John Q Public"); setCardNumber("378282246310005"); setCcv(168); setExpires(new java.sql.Date(System.currentTimeMillis())); }};
    }

    @TestFactory
    public Stream<DynamicTest> rejectsWithNoCardNumber() {

        return Arrays.asList(
                DynamicTest.dynamicTest("fails with empty card number",
                        () -> { cardInfo.setCardNumber(""); assertFalse(cardValidator.validateCardInfo(cardInfo)); }),
                DynamicTest.dynamicTest("fails with null card number",
                        () -> { cardInfo.setCardNumber(null); assertThrows(NullPointerException.class, () -> { cardValidator.validateCardInfo(cardInfo); }); })
        ).stream();
    }

    @Test
    public void acceptsValidCardNumber() {

        cardInfo.setCardNumber("378282246310005");
        assertTrue(cardValidator.validateCardInfo(cardInfo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"378282246310006", "37828224631000a", "37828224631000$", "37828224631000A"})
    void rejectsInvalidCardNumbers(String cardNumber) {

        cardInfo.setCardNumber(cardNumber);
        assertFalse(cardValidator.validateCardInfo(cardInfo));
    }

    @RepeatedTest(3)
    public void exampleLatencyTest() {

        assertTimeout(Duration.ofMillis(1000), () -> { Thread.sleep(500); });
    }

    @Test
    @Tag("expirationDate")
    public void rejectsPastExpirationDate() {

        Calendar check = Calendar.getInstance();
        check.add(Calendar.MONTH, -1);
        cardInfo.setExpires(new java.sql.Date(check.getTimeInMillis()));

        assertFalse(cardValidator.validateCardInfo(cardInfo));
    }

    @Test
    @Tag("expirationDate")
    public void rejectsFutureExpirationDatePastFiveYears() {

        Calendar check = Calendar.getInstance();
        check.add(Calendar.YEAR, 5);
        check.add(Calendar.MONTH, 1);
        check.set(Calendar.DAY_OF_MONTH, 1);
        cardInfo.setExpires(new java.sql.Date(check.getTimeInMillis()));

        assertFalse(cardValidator.validateCardInfo(cardInfo));
    }

    @Test
    @Tag("expirationDate")
    public void acceptsCurrentDateAsExpirationDate() {

        Calendar check = Calendar.getInstance();
        cardInfo.setExpires(new java.sql.Date(check.getTimeInMillis()));

        assertTrue(cardValidator.validateCardInfo(cardInfo));
    }

    @Test
    @Tag("expirationDate")
    public void acceptsFutureExpirationDateFiveYearsFromToday() {

        Calendar check = Calendar.getInstance();
        check.add(Calendar.YEAR, 5);
        check.set(Calendar.DAY_OF_MONTH, 1);
        cardInfo.setExpires(new java.sql.Date(check.getTimeInMillis()));

        assertTrue(cardValidator.validateCardInfo(cardInfo));
    }

    @ParameterizedTest
    @Tag("providers")
    @ValueSource(strings = { "342964675289387", "378282246310005", "4012888888881881", "2221001223630333", "2720991223630331", "5105105105105100", "5200828282828210", "5339241745970476", "5455330760000018", "5506922400634930" })
    public void acceptsSupportedProviders(String cardNumber) {

        cardInfo.setCardNumber(cardNumber);
        assertTrue(cardValidator.validateCardInfo(cardInfo));
    }

    @ParameterizedTest
    @Tag("providers")
    @ValueSource(strings = { "2220991223630336", "2721001223630338", "30569309025904" })
    public void rejectsUnsupportedProviders(String cardNumber) {

        cardInfo.setCardNumber(cardNumber);
        assertFalse(cardValidator.validateCardInfo(cardInfo));
    }
}
