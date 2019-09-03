// PaymentType.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="payment_types")
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_type_id")
    private long paymentTypeId;
    private String name;

    public long getPaymentTypeId() {

        return paymentTypeId;
    }

    public void setPaymentTypeId(long paymentTypeId) {

        this.paymentTypeId = paymentTypeId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentType that = (PaymentType) o;
        return paymentTypeId == that.paymentTypeId &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentTypeId, name);
    }
}
