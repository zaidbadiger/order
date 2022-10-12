package com.clothingfly.order.Model;


import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

@Entity
public class Item {

    @Id
    private long id;
    private String name;
    private float price;
    private String imageUrl;
    private long quantity;
    private long inventory;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
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
}