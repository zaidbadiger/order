package com.clothingfly.order;

import javax.annotation.Resource;
// import javax.jms.ConnectionFactory;
// import javax.jms.JMSConnectionFactory;
// import javax.jms.JMSContext;
// import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.jms.annotation.EnableJms;
// import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.clothingfly.order.Model.Order;


// This class contains the details needed to send an aynchronous message using
// Java Messaging Service (JMS).
//@RequestScope
// @Resource(name = "jms/shipmentQCF", lookup = "jms/shipmentQCF", type = ConnectionFactory.class)
public class MessageSender {

    // @Autowired
    // @JMSConnectionFactory("java:comp/env/jms/shipmentQCF")
    // private JMSContext jmsContext;

    // @Resource(lookup = "jms/shipmentQ")
    // private Queue queue;

    // public void initiateShipping() {
    //     String message = "Shipment Initiation Request from entity: ClothingFly";
    //     System.out.println("Sending message: \t" + message);
    //     jmsContext.createProducer().send(queue, message);
    //     System.out.println("Message Sent");
    // }
}

// @RestController
// @RequestMapping("/shipment-processing")
// public class MessageSender {

//   @Autowired private JmsTemplate jmsTemplate;
//   private Queue queue;

//     @PostMapping("/initiate")
//     public void initiateShipping(@RequestBody Order order) {
//         String message = "Shipment Initiation Request from entity: ClothingFly";
//         System.out.println("Sending message: \t" + message);
//         // Post message to the message queue named "OrderTransactionQueue"
//         jmsTemplate.convertAndSend("OrderTransactionQueue", order);
//         System.out.println("Message Sent");
//     }
// }
