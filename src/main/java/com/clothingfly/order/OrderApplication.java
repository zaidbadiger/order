package com.clothingfly.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		MessageSender.context = SpringApplication.run(OrderApplication.class, args);
	}
}
