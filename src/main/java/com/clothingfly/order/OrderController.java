package com.clothingfly.order;

import java.util.ListIterator;
import org.springframework.web.client.RestTemplate;
import com.clothingfly.order.Model.Item;

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

    private void checkInventory(Order order) {
        RestTemplate restTemplate = new RestTemplate();
        ListIterator<Item> it = order.getItems().listIterator();
        String error = "";
        while (it.hasNext()) {
            Item orderItem = it.next();
            Item item = restTemplate.getForObject("http://localhost:8080/items/" + orderItem.getId(), Item.class);
            if (orderItem.getQuantity() > item.getInventory()) {
                error += "Error! Not Enough Inventory For " + item.getName() + "! ";
            }
        }
        order.setError(error);
    }

    @PostMapping("/order")
    public Order postOrder(@RequestBody Order order) {
        checkInventory(order);
        return orderService.postOrder(order);
    }



}
