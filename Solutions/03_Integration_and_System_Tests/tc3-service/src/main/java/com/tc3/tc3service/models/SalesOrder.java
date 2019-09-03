// SalesOrder.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="sales_orders")
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sales_order_id")
    private long salesOrderId;
    private Date orderDate;
    private long customerId;
    private BigDecimal total;
    private long paymentTypeId;
    private String cardNumber;
    private Date cardExpires;
    private Date filled;
    private Customer customer;

    @ManyToOne(optional=false)
    @JoinColumn(name="payment_type_idD",referencedColumnName="payment_type_id")
    private PaymentType paymentType;

    @OneToMany
    @JoinColumn(name="sales_order_id",referencedColumnName="sales_order_id")
    private List<SalesOrderItem> salesOrderItems;

    public SalesOrder() {

        salesOrderItems = new ArrayList<SalesOrderItem>();
    }

    public long getSalesOrderId() {

        return salesOrderId;
    }

    public void setSalesOrderId(long id) {

        this.salesOrderId = id;
    }

    public Date getOrderDate() {

        return orderDate;
    }

    public void setOrderDate(Date orderDate) {

        this.orderDate = orderDate;
    }

    public long getCustomerId() {

        return customerId;
    }

    public void setCustomerId(long customerId) {

        this.customerId = customerId;
    }

    public BigDecimal getTotal() {

        return total;
    }

    public void setTotal(BigDecimal total) {

        this.total = total;
    }

    public long getPaymentTypeId() {

        return paymentTypeId;
    }

    public void setPaymentTypeId(long paymentTypeId) {

        this.paymentTypeId = paymentTypeId;
    }

    public String getCardNumber() {

        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {

        this.cardNumber = cardNumber;
    }

    public Date getCardExpires() {

        return cardExpires;
    }

    public void setCardExpires(Date cardExpires) {

        this.cardExpires = cardExpires;
    }

    public Date getFilled() {

        return filled;
    }

    public void setFilled(Date filled) {

        this.filled = filled;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

    public PaymentType getPaymentType() {

        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {

        this.paymentType = paymentType;
    }

    public List<SalesOrderItem> getSalesOrderItems() {

        return salesOrderItems;
    }

    public void setSalesOrderItems(List<SalesOrderItem> salesOrderItems) {
        
        this.salesOrderItems = salesOrderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrder that = (SalesOrder) o;
        return salesOrderId == that.salesOrderId &&
                customerId == that.customerId &&
                paymentTypeId == that.paymentTypeId &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(total, that.total) &&
                Objects.equals(cardNumber, that.cardNumber) &&
                Objects.equals(cardExpires, that.cardExpires) &&
                Objects.equals(filled, that.filled) &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(paymentType, that.paymentType) &&
                Objects.equals(salesOrderItems, that.salesOrderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesOrderId, orderDate, customerId, total, paymentTypeId, cardNumber, cardExpires, filled, customer, paymentType, salesOrderItems);
    }
}
