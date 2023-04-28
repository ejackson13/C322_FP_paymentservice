package edu.iu.c322.finalproject.paymentservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customerShipping")
public class CustomerShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shippingGen")
    @SequenceGenerator(name = "shippingGen", sequenceName = "shippingSeq", allocationSize = 1)
    private int id;


    private String state;


    private String city;

    private int postalCode;

    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
