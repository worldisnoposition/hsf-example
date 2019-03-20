package com.aliware.edas.jpa.repository;

import com.aliware.edas.jpa.entity.OrderEntity;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    @Lock(LockModeType.READ)
    OrderEntity findByOrderId(Long orderId);

    OrderEntity findByUserId(Long userId);

    OrderEntity findByUserIdAndOrderId(Long userId, Long orderId);

//    @Query("select orderentit0_.order_id as order_id1_1_, orderentit0_.user_id from t_order orderentit0_ where orderentit0_.user_id=? and orderentit0_.order_id=?")
//    OrderEntity myOwnHql(Long userId, Long orderId);

//    @Query(value = "select order_id as orderId,user_id as userId from t_order_0 where order_id = ?1", nativeQuery = true)
//    OrderEntity myOwnSql(Long orderId);

    OrderEntity findByUserIdAndOrderByOrderIdDesc(Long userId,Long orderId);

//    OrderEntity findByUserIdAndOrderIdOrderByDesc(Long userId, Long OrderId);
}