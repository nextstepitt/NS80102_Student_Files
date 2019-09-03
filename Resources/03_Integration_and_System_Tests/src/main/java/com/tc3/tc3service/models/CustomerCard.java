// CustomerCard.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="customer_cards")
public class CustomerCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_card_id")
    private long customerCardId;
    private long customerId;
    private Boolean preferred;
    private String cardNumber;
    private Date expires;
    private String ccv;

    public long getCustomerCardId() {

        return customerCardId;
    }

    public void setCustomerCardId(long customerCardId) {

        this.customerCardId = customerCardId;
    }

    public long getCustomerId() {

        return customerId;
    }

    public void setCustomerId(long customerId) {

        this.customerId = customerId;
    }

    public Boolean getPreferred() {

        return preferred;
    }

    public void setPreferred(Boolean preferred) {

        this.preferred = preferred;
    }

    public String getNumber() {

        return cardNumber;
    }

    public void setNumber(String cardNumber) {

        this.cardNumber = cardNumber;
    }

    public Date getExpires() {

        return expires;
    }

    public void setExpires(Date expires) {

        this.expires = expires;
    }

    public String getCcd() {

        return ccv;
    }

    public void setCcd(String ccv) {

        this.ccv = ccv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerCard that = (CustomerCard) o;
        return customerCardId == that.customerCardId &&
                customerId == that.customerId &&
                Objects.equals(preferred, that.preferred) &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(expires, that.expires) &&
                Objects.equals(ccv, that.ccv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerCardId, customerId, preferred, cardNumber, expires, ccv);
    }
}
