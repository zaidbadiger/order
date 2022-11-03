package com.clothingfly.order.Model;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ADDRESS_INFO_ID_FK")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="PAYMENT_INFO_ID_FK")
    private PaymentInfo payment;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="CUSTOMER_ORDER_ID_FK")
    private List<Item> items;

    @Column(name = "Error")
    private String error;

    public Order() {

    }

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
