package com.clothingfly.order;

import java.util.ListIterator;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import com.clothingfly.order.Model.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clothingfly.order.Model.Order;
import com.clothingfly.order.Model.PaymentChase;
import com.clothingfly.order.Model.PaymentInfo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {


    @Autowired
    TempOrderRepository orderRepository;

    @Autowired
    MessageSender messageSender;

    static final String SHIPMENT_PROCESSING_URL = "http://localhost:8081/";


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

    private String checkPayment(PaymentInfo payment){
        RestTemplate restTemplate = new RestTemplate();
        PaymentChase chasePayment = new PaymentChase();
        chasePayment.setAccountNum("2345334564");
        chasePayment.setBusiness("ClothingFly");
        chasePayment.setCardHolder(payment.getCardHolder());
        chasePayment.setCardNumber(payment.getCardNumber());
        chasePayment.setCvv(payment.getCvv());
        chasePayment.setExpirationDate(payment.getExpirationDate());
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:9080/payment", chasePayment, String.class);
        return result.getBody();
    }

    @PostMapping("/order")
    public Order postOrder(@RequestBody Order order) {
    
      
      String confNumber = checkPayment(order.getPayment());
      Order _order = orderRepository.save(new Order(order.getId(), order.getAddress(), order.getPayment(), order.getItems(), confNumber));
      checkInventory(_order);

      // Call messaging microservice after the successful persistence of the customer order.
      messageSender.initiateShipping(); // TODO: Uncomment once messaging service is done or ready to be tested

      return _order;
    }
}
