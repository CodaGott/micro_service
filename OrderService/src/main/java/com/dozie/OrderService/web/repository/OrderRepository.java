package com.dozie.OrderService.web.repository;

import com.dozie.OrderService.web.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface OrderRepository extends JpaRepository<Order,String> {
}
