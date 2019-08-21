// ProductType.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProductType {

    @Id
    private int productTypeId;
    private String name;

    @OneToMany
    @JoinColumn(name="PRODUCT_TYPE_ID",referencedColumnName="PRODUCT_TYPE_ID")
    private List<Product> products;

    public ProductType() {

        products = new ArrayList<Product>();
    }

    public int getProductTypeId() {

        return productTypeId;
    }

    public void setProductTypeId(int id) {

        this.productTypeId = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Product> getProducts() {

        return products;
    }

    public void setProducts(List<Product> products) {

        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return productTypeId == that.productTypeId &&
                name.equals(that.name) &&
                products.equals(that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeId, name, products);
    }
}
