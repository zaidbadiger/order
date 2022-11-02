package com.clothingfly.order;



import org.springframework.stereotype.Service;

import com.clothingfly.order.Model.Order;

@Service
public class OrderServiceImpl implements OrderService {

    private final TempOrderRepository orderRepository;

    public OrderServiceImpl(TempOrderRepository itemRepository) {
        this.orderRepository=itemRepository;
    }


    @Override
    public Order postOrder(Order order) {
        return orderRepository.save(order);
    }

}
