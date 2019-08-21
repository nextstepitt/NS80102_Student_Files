// CardInfo.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import java.sql.Date;

public class CardInfo {

    private String name;
    private String cardNumber;
    private Date expires;
    private int ccv;

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
}
