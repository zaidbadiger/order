package com.clothingfly.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.clothingfly.order.Model.Order;

@Repository
public class TempOrderRepository{
    public List<Order> orders= new ArrayList<Order>();
    public TempOrderRepository(){

       };


    public Order save(Order order){
        this.orders.add(order);
        return order;
    }

}
