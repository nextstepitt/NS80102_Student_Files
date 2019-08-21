// CustomerCard.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.util.Objects;

public class CustomerCard {

    @Id
    private int customerCardId;
    private int customerId;
    private Boolean preferred;
    private String number;
    private Date expires;
    private String ccd;

    @ManyToOne(optional = false)
    @JoinColumn(name="CUSTOMER_ID",referencedColumnName="CUSTOMER_ID")
    private Customer customer;

    public int getCustomerCardId() {

        return customerCardId;
    }

    public void setCustomerCardId(int customerCardId) {

        this.customerCardId = customerCardId;
    }

    public int getCustomerId() {

        return customerId;
    }

    public void setCustomerId(int customerId) {

        this.customerId = customerId;
    }

    public Boolean getPreferred() {

        return preferred;
    }

    public void setPreferred(Boolean preferred) {

        this.preferred = preferred;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {

        this.number = number;
    }

    public Date getExpires() {

        return expires;
    }

    public void setExpires(Date expires) {

        this.expires = expires;
    }

    public String getCcd() {

        return ccd;
    }

    public void setCcd(String ccd) {

        this.ccd = ccd;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerCard that = (CustomerCard) o;
        return customerCardId == that.customerCardId &&
                customerId == that.customerId &&
                Objects.equals(preferred, that.preferred) &&
                Objects.equals(number, that.number) &&
                Objects.equals(expires, that.expires) &&
                Objects.equals(ccd, that.ccd) &&
                Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerCardId, customerId, preferred, number, expires, ccd, customer);
    }
}
