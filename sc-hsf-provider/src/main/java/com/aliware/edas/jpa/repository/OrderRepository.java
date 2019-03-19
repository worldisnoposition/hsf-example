package com.aliware.edas.jpa.repository;

import com.aliware.edas.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    @Lock(LockModeType.READ)
    OrderEntity findByOrderId(Long orderId);
}