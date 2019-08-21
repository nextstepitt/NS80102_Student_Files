// SalesOrder.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SalesOrder {

    @Id
    private int salesOrderId;
    private Date orderDate;
    private int customerId;
    private BigDecimal total;
    private int paymentTypeId;
    private String cardNumber;
    private Date cardExpires;
    private Date filled;
    private Customer customer;

    @ManyToOne(optional=false)
    @JoinColumn(name="PAYMENT_TYPE_ID",referencedColumnName="PAYMENT_TYPE_ID")
    private PaymentType paymentType;

    @OneToMany
    @JoinColumn(name="SALES_ORDER_ID",referencedColumnName="SALES_ORDER_ID")
    private List<SalesOrderItem> salesOrderItems;

    public SalesOrder() {

        salesOrderItems = new ArrayList<SalesOrderItem>();
    }

    public int getSalesOrderId() {

        return salesOrderId;
    }

    public void setSalesOrderId(int id) {

        this.salesOrderId = id;
    }

    public Date getOrderDate() {

        return orderDate;
    }

    public void setOrderDate(Date orderDate) {

        this.orderDate = orderDate;
    }

    public int getCustomerId() {

        return customerId;
    }

    public void setCustomerId(int customerId) {

        this.customerId = customerId;
    }

    public BigDecimal getTotal() {

        return total;
    }

    public void setTotal(BigDecimal total) {

        this.total = total;
    }

    public int getPaymentTypeId() {

        return paymentTypeId;
    }

    public void setPaymentTypeId(int paymentTypeId) {

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
