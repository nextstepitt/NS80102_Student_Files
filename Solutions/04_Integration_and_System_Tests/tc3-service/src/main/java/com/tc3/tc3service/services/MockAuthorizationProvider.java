package com.tc3.tc3service.services;

import com.tc3.tc3service.models.CardInfo;

import java.math.BigDecimal;
import java.util.UUID;

public class MockAuthorizationProvider implements IAuthorizationProvider {

    public String authorize(BigDecimal amount, CardInfo cardInfo) {

        String result = null;

        // The point of this mock is to return an authorization for one CardInfo, and no authorization
        // for anything else.

        if (cardInfo.getCardNumber() == "378282246310005") {

            return (UUID.randomUUID()).toString();
        }

        return result;
    }
}
