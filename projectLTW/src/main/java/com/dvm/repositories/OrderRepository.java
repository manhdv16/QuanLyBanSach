package com.dvm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvm.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
