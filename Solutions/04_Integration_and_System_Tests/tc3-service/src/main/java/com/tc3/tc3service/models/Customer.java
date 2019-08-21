// Customer.java
// Copyright © 2019 NextStep IT Training. All rights reserved.
//

package com.tc3.tc3service.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Customer {

    @Id
    private int customerId;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String countryCodeId;
    private Date birthdate;
    private String confirmation;

    @ManyToOne(optional = false)
    @JoinColumn(name="COUNTRY_CODE_ID",referencedColumnName="COUNTRY_CODE_ID")
    private CountryCode countryCode;

    @OneToMany
    @JoinColumn(name="CUSTOMER_ID",referencedColumnName="CUSTOMER_ID")
    private Collection<CustomerCard> customerCards;

    @OneToMany
    @JoinColumn(name="CUSTOMER_ID",referencedColumnName="CUSTOMER_ID")
    private Collection<SalesOrder> salesOrders;

    public Customer()
    {

        customerCards = new ArrayList<CustomerCard>();
        salesOrders = new ArrayList<SalesOrder>();
    }

    public int getCustomerId() {

        return customerId;
    }

    public void setCustomerId(int customerId) {

        this.customerId = customerId;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getStateProvince() {

        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {

        this.stateProvince = stateProvince;
    }

    public String getPostalCode() {

        return postalCode;
    }

    public void setPostalCode(String postalCode) {

        this.postalCode = postalCode;
    }

    public String getCountryCodeId() {

        return countryCodeId;
    }

    public void setCountryCodeId(String countryCodeId) {

        this.countryCodeId = countryCodeId;
    }

    public Date getBirthdate() {

        return birthdate;
    }

    public void setBirthdate(Date birthdate) {

        this.birthdate = birthdate;
    }

    public String getConfirmation() {

        return confirmation;
    }

    public void setConfirmation(String confirmation) {

        this.confirmation = confirmation;
    }

    public CountryCode getCountryCode() {

        return countryCode;
    }

    public void setCountryCode(CountryCode countryCode) {

        this.countryCode = countryCode;
    }

    public Collection<CustomerCard> getCustomerCards() {

        return customerCards;
    }

    public void setCustomerCards(Collection<CustomerCard> customerCards) {

        this.customerCards = customerCards;
    }

    public Collection<SalesOrder> getSalesOrders() {

        return salesOrders;
    }

    public void setSalesOrders(Collection<SalesOrder> salesOrders) {

        this.salesOrders = salesOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                Objects.equals(email, customer.email) &&
                Objects.equals(password, customer.password) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(street, customer.street) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(stateProvince, customer.stateProvince) &&
                Objects.equals(postalCode, customer.postalCode) &&
                Objects.equals(countryCodeId, customer.countryCodeId) &&
                Objects.equals(birthdate, customer.birthdate) &&
                Objects.equals(confirmation, customer.confirmation) &&
                Objects.equals(countryCode, customer.countryCode) &&
                customerCards.equals(customer.customerCards) &&
                salesOrders.equals(customer.salesOrders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerId, email, password, firstName, lastName, street, city, stateProvince, postalCode, countryCodeId, birthdate, confirmation, countryCode, customerCards, salesOrders);
    }
}
