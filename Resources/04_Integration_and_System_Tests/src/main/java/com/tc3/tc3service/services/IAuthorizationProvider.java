package com.tc3.tc3service.services;

import com.tc3.tc3service.models.CardInfo;

import java.math.BigDecimal;

public interface IAuthorizationProvider {

    String authorize(BigDecimal amount, CardInfo cardInfo);
}
