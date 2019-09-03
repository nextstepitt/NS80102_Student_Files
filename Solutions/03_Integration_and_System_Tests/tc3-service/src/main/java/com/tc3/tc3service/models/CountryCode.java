// CountryCode.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="country_codes")
public class CountryCode {

    @Id
    @Column(name="country_code_id")
    private String countryCodeId;

    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryCode that = (CountryCode) o;
        return Objects.equals(countryCodeId, that.countryCodeId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCodeId, name);
    }
}
