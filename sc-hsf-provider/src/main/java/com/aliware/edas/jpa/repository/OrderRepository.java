package com.aliware.edas.jpa.repository;

import com.aliware.edas.jpa.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
 
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}