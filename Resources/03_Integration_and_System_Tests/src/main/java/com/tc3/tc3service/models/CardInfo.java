// CardInfo.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import java.sql.Date;
import java.util.Objects;

public class CardInfo {

    private String name;
    private String cardNumber;
    private Date expires;
    private int ccv;

    public CardInfo() {
    }

    public CardInfo(String name, String cardNumber, Date expires, int ccv) {

        this.name = name;
        this.cardNumber = cardNumber;
        this.expires = expires;
        this.ccv = ccv;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCardNumber() {

        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {

        this.cardNumber = cardNumber;
    }

    public Date getExpires() {

        return expires;
    }

    public void setExpires(Date expires) {

        this.expires = expires;
    }

    public int getCcv() {

        return ccv;
    }

    public void setCcv(int ccv) {

        this.ccv = ccv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardInfo cardInfo = (CardInfo) o;
        return ccv == cardInfo.ccv &&
                Objects.equals(name, cardInfo.name) &&
                Objects.equals(cardNumber, cardInfo.cardNumber) &&
                Objects.equals(expires, cardInfo.expires);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cardNumber, expires, ccv);
    }
}
