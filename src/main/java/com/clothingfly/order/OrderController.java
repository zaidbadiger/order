package com.clothingfly.order;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clothingfly.order.Model.Order;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private final OrderServiceImpl orderService;
    public OrderController(OrderServiceImpl orderService){
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public Order postOrder(@RequestBody Order order) {
        return orderService.postOrder(order);
    }



}
