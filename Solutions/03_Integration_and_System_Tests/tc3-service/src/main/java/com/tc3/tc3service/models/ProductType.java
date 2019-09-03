// ProductType.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="product_types")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_type_id")
    private long productTypeId;
    private String name;

    public long getProductTypeId() {

        return productTypeId;
    }

    public void setProductTypeId(long id) {

        this.productTypeId = id;
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
        ProductType that = (ProductType) o;
        return productTypeId == that.productTypeId &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeId, name);
    }
}
