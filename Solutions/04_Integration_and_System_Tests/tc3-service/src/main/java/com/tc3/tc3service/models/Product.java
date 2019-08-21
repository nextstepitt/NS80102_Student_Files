// Product.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

    @Id
    private int productId;
    
    private int productTypeId;
    private String name;
    private BigDecimal price;
    private ProductType productType;

    @OneToMany
    @JoinColumn(name="PRODUCT_ID",referencedColumnName="PRODUCT_ID")
    private List<SalesOrderItem> salesOrderItems;

    public Product() {

        salesOrderItems = new ArrayList<SalesOrderItem>();
    }

    public int getProductId() {

        return productId;
    }

    public void setProductId(int productId) {

        this.productId = productId;
    }

    public int getProductTypeId() {

        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {

        this.productTypeId = productTypeId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public BigDecimal getPrice() {

        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public ProductType getProductType() {

        return productType;
    }

    public void setProductType(ProductType productType) {

        this.productType = productType;
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
        Product product = (Product) o;
        return productId == product.productId &&
                productTypeId == product.productTypeId &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(productType, product.productType) &&
                Objects.equals(salesOrderItems, product.salesOrderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productTypeId, name, price, productType, salesOrderItems);
    }
}
