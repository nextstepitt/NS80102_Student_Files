package com.tc3.tc3service.__doubles__;

import com.tc3.tc3service.models.CardInfo;
import com.tc3.tc3service.services.AuthorizationProvider;
import com.tc3.tc3service.services.IAuthorizationProvider;

import java.math.BigDecimal;
import java.util.UUID;

public class AuthorizationProviderStub implements IAuthorizationProvider {

    public String authorize(BigDecimal amount, CardInfo cardInfo) {

        String result = null;

        if ("378282246310005".equals(cardInfo.getCardNumber())) {

            result = (UUID.randomUUID()).toString();

        } else if ("2221001223630333".equals(cardInfo.getCardNumber())) {

            result = null;

        } else {

            throw new IllegalArgumentException();
        }

        return result;
    }
}
