// CountryCode.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountryCode {

    @Id
    private String countryCodeId;

    private String name;

    @ManyToOne
    @JoinColumn(name="PRODUCT_TYPE_ID",referencedColumnName="PRODUCT_TYPE_ID")
    private List<Customer> customers;

    public CountryCode() {

        customers = new ArrayList<Customer>();
    }

    public String getCountryCodeId() {

        return countryCodeId;
    }

    public void setCountryCodeId(String countryCodeId) {

        this.countryCodeId = countryCodeId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Customer> getCustomers() {

        return customers;
    }

    public void setCustomers(List<Customer> customers) {

        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCode that = (CountryCode) o;
        return Objects.equals(countryCodeId, that.countryCodeId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCodeId, name, customers);
    }
}
