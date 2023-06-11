package com.dvm.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvm.entity.Order;
import com.dvm.repositories.OrderRepository;
import com.dvm.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order save(Order entity) {
		return orderRepository.save(entity);
	}

	@Override
	public List<Order> findAllByIdUsername(String username) {
		int tmp=0;
		List<Order> listOrder= new ArrayList<>();
			for(Order od : findAll()) {
				if(od.getUser().getUsername().equals(username)) {
					listOrder.add(od);
					tmp=1;
				}
			}
		if(tmp==0) return null;
		return listOrder;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return orderRepository.findById(id);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}
	
	
}
