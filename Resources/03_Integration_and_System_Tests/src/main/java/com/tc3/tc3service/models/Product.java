// Product.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long productId;
    
    private long productTypeId;
    private String name;
    private BigDecimal price;

    @ManyToOne(optional = false)
    @JoinColumn(name="product_type_id",referencedColumnName="product_type_id")
    private ProductType productType;

    public long getProductId() {

        return productId;
    }

    public void setProductId(long productId) {

        this.productId = productId;
    }

    public long getProductTypeId() {

        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                productTypeId == product.productTypeId &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(productType, product.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productTypeId, name, price, productType);
    }
}
