package com.aliware.edas.jpa.testrest;

import com.aliware.edas.jpa.entity.OrderEntity;
import com.aliware.edas.jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.TableGenerator;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping("/withTransactional")
    @Transactional
    public Object doneTransactional(){
        List<OrderEntity> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            OrderEntity order = new OrderEntity();
            order.setOrderId((long) i);
            order.setUserId((long) i);
            list.add(order);
            //会发现日志中的sql不是select/delete交替，而是全部都是select然后是delete
            orderRepository.delete(order.getOrderId());
        }
        return "success";
    }
    @RequestMapping("/create")
    public Object add() {
        OrderEntity orderEntityByUserId = orderRepository.findByUserId(1L);
        OrderEntity orderEntityByUserIdAndOrderId = orderRepository.findByUserIdAndOrderId(1L,1L);
//        OrderEntity o3 = orderRepository.findByUserIdOrOrderIdAndOrderByOrderIdDesc(1L,1L);
//        OrderEntity o4 = orderRepository.myOwnHql(1L,1L);
        OrderEntity o5 = orderRepository.myOwnSql(1L);

        List<OrderEntity> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            OrderEntity order = new OrderEntity();
            order.setUserId((long) i);
            order.setOrderId((long) i);
            list.add(order);
//            orderRepository.delete(order.getOrderId());
//            orderRepository.save(order);
        }
        orderRepository.save(list);
        for (int i = 10; i < 20; i++) {
            OrderEntity order = new OrderEntity();
            order.setUserId((long) i + 1);
            order.setOrderId((long) i);
            orderRepository.save(order);
        }

        OrderEntity o = orderRepository.findByOrderId(1L);
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