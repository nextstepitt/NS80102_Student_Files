package com.tc3.tc3service.services;

import com.tc3.tc3service.models.CardInfo;

public interface ICreditCardValidator {

    boolean validateCardInfo(CardInfo cardInfo);
}
