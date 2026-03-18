package com.example.project_01_E_commerce_order_service.repository;

import com.example.project_01_E_commerce_order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
