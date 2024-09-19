package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity

public class Address {

    @Id
    private int aid;
    private String city;
    private String street;


    @ManyToOne
    private Customer customer;

    public Address() {
    }


    public Address(int aid, String city, String street, Customer customer) {
        this.aid = aid;
        this.city = city;
        this.street = street;
        this.customer = customer;
    }


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
