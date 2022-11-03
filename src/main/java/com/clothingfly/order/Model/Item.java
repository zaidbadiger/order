package com.clothingfly.order.Model;

import javax.persistence.*;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "items")
public class Item {

    
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue
    @Column(name = "uniqueID")
    private long uniqueID;

    @Column(name = "price")
    private float price;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "inventory")
    private long inventory;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getItemNumber() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getInventory() {
        return inventory;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Item(long id, String name, float price, long quantity, long inventory, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.inventory = inventory;
        this.imageUrl = imageUrl;
    }

    public Item() {

  }
}
