package com.aliware.edas.jpa.testrest;

import com.aliware.edas.jpa.entity.OrderEntity;
import com.aliware.edas.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
 
    @RequestMapping("/create")
    public Object add() {
        for (int i = 0; i < 10; i++) {
            OrderEntity order = new OrderEntity();
            order.setUserId((long) i);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
        for (int i = 10; i < 20; i++) {
            OrderEntity order = new OrderEntity();
            order.setUserId((long) i + 1);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }
 
//        for (int i = 0; i < 30; i++) {
//            Order order = new Order();
//            order.setOrderId(keyGenerator.generateKey().longValue());
//            order.setUserId(keyGenerator.generateKey().longValue());
//            orderRepository.save(order);
//        }
 
        return "success";
    }
 
    @RequestMapping("query")
    private Object queryAll() {
        return orderRepository.findAll();
    }
}