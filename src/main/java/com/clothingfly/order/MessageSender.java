package com.clothingfly.order;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import javax.jms.ConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.clothingfly.order.Model.Order;


// This class contains the details needed to send an aynchronous message using
// Java Messaging Service (JMS).
@Service
// @RequestScope
// @Resource(name = "jms/shipmentQCF", lookup = "jms/shipmentQCF", type = ConnectionFactory.class)
@EnableJms
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

    public static ConfigurableApplicationContext context;

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    public void initiateShipping() {

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        String message = "Shipment Initiation Request from entity: ClothingFly";
        System.out.println("Sending message: \t" + message);
        jmsTemplate.convertAndSend("OrderTransactionQueue", message);
        System.out.println("Message Sent");
    }

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
