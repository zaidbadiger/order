package com.clothingfly.order;

import java.util.ListIterator;
import org.springframework.web.client.RestTemplate;
import com.clothingfly.order.Model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clothingfly.order.Model.Order;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {


    @Autowired
    TempOrderRepository orderRepository;


    private void checkInventory(Order order) {
        RestTemplate restTemplate = new RestTemplate();
        ListIterator<Item> it = order.getItems().listIterator();
        String error = "";
        while (it.hasNext()) {
            Item orderItem = it.next();
            Item item = restTemplate.getForObject("http://localhost:8080/items/" + orderItem.getId(), Item.class);
            if (Long.compare(orderItem.getQuantity(), item.getInventory()) > 0) {
                error += "Error! Not Enough Inventory For " + item.getName() + "! ";
            }
        }
        order.setError(error);
    }

    @PostMapping("/order")
    public Order postOrder(@RequestBody Order order) {
      Order _order = orderRepository.save(new Order(order.getId(), order.getAddress(), order.getPayment(), order.getItems()));
      checkInventory(_order);
      return _order;
    }
}
