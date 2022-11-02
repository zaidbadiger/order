package com.clothingfly.order;

import java.util.ArrayList;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.clothingfly.order.Model.Order;



public interface TempOrderRepository extends JpaRepository<Order, Long>{

  // update("insert into order (id, address, payment, items) " + "values(?, ?, ?, ?)",
  // new Object[] {
  //     order.getId(), employee.getAddress(), employee.getPayment(), employee.getItems()
  // });


  // public List<Order> orders= new ArrayList<Order>();

  // public Order save(Order order){
  //   this.orders.add(order);
  //   return order;
  // }
}
