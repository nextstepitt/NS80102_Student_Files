// SalesOrderItem.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="sales_order_items")
public class SalesOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sales_order_item_id")
    private long salesOrderItemId;
    private long salesOrderId;
    private long productId;
    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="product_id",referencedColumnName="product_id")
    private Product product;

    public long getSalesOrderItemId() {

        return salesOrderItemId;
    }

    public void setSalesOrderItemId(long salesOrderItemId) {

        this.salesOrderItemId = salesOrderItemId;
    }

    public long getSalesOrderId() {

        return salesOrderId;
    }

    public void setSalesOrderId(long salesOrderId) {

        this.salesOrderId = salesOrderId;
    }

    public long getProductId() {

        return productId;
    }

    public void setProductId(long productId) {

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
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesOrderItemId, salesOrderId, productId, quantity, price, product);
    }
}
