package com.clothingfly.order.Model;


import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Order {
    @Id
    private long id;
    private Address address;
    private PaymentInfo payment;
    private List<Item> items;
    private String error;

    public Order(long id, Address address, PaymentInfo payment, List<Item> items){
        this.id = id;
        this.address = address;
        this.payment = payment;
        this.items = items;
        this.error = "";
    }

    public long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }


    public PaymentInfo getPayment() {
        return payment;
    }


    public List<Item> getItems() {
        return items;
    }

    public String getError() {
        return error;
    }
    
    public void setError(String error) {
        this.error = error;
    }

}