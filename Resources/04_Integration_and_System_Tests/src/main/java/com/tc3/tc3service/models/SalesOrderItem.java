// SalesOrderItem.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesOrderItem {

    @Id
    private int salesOrderItemId;
    private int salesOrderId;
    private int productId;
    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="PRODUCT_ID",referencedColumnName="PRODUCT_ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name="SALES_ORDER_ID",referencedColumnName="SALES_ORDER_ID")
    private SalesOrder salesOrder;

    public int getSalesOrderItemId() {

        return salesOrderItemId;
    }

    public void setSalesOrderItemId(int salesOrderItemId) {

        this.salesOrderItemId = salesOrderItemId;
    }

    public int getSalesOrderId() {

        return salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {

        this.salesOrderId = salesOrderId;
    }

    public int getProductId() {

        return productId;
    }

    public void setProductId(int productId) {

        this.productId = productId;
    }

    public Integer getQuantity() {

        return quantity;
    }

    public void setQuantity(Integer quantity) {

        this.quantity = quantity;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {

        this.product = product;
    }

    public SalesOrder getSalesOrder() {

        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {

        this.salesOrder = salesOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrderItem that = (SalesOrderItem) o;
        return salesOrderItemId == that.salesOrderItemId &&
                salesOrderId == that.salesOrderId &&
                productId == that.productId &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price) &&
                Objects.equals(product, that.product) &&
                Objects.equals(salesOrder, that.salesOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesOrderItemId, salesOrderId, productId, quantity, price, product, salesOrder);
    }
}
