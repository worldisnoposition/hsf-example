package com.aliware.edas.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
@Data
public class OrderEntity {
    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;
}