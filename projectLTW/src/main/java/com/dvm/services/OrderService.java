package com.dvm.services;

import java.util.List;
import java.util.Optional;

import com.dvm.entity.Order;

public interface OrderService {

	void delete(Order entity);

	void deleteById(Integer id);

	long count();

	Optional<Order> findById(Integer id);

	List<Order> findAll();

	Order save(Order entity);

	List<Order> findAllByIdUsername(String username);

}
