// PaymentType.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaymentType {

    @Id
    private int paymentTypeId;
    private String name;

    @OneToMany
    @JoinColumn(name="PAYMENT_TYPE_ID",referencedColumnName="PAYMENT_TYPE_ID")
    private List<SalesOrder> salesOrders;

    public PaymentType() {

        salesOrders = new ArrayList<SalesOrder>();
    }

    public int getPaymentTypeId() {

        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {

        this.paymentTypeId = paymentTypeId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<SalesOrder> getSalesOrders() {

        return salesOrders;
    }

    public void setSalesOrders(List<SalesOrder> salesOrders) {

        this.salesOrders = salesOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentType that = (PaymentType) o;
        return paymentTypeId == that.paymentTypeId &&
                name.equals(that.name) &&
                salesOrders.equals(that.salesOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentTypeId, name, salesOrders);
    }
}
