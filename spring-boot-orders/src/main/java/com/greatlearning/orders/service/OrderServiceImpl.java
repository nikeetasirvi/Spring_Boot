package com.greatlearning.orders.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.orders.model.Order;
import com.greatlearning.orders.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		Order savedOrder = this.orderRepository.save(order);
		return savedOrder;
	}

	@Override
	public List<Order> fetchAllOrders() {
		return this.orderRepository.findAll();
		//return Set.copyOf(this.orderRepository.findAll());
	}

	@Override
	public Order updateOrder(long id, Order order) {
		Order orderById = (this.orderRepository.findById(id)).get();
		if(orderById != null) {
			orderById.setName(order.getName());
			orderById.setPrice(order.getPrice());
			return this.orderRepository.save(orderById);
		}
		throw new IllegalArgumentException("Invalid order id passed");
	}

	@Override
	public void deleteOrder(long id) {
		Order orderById = (this.orderRepository.findById(id)).get();
		if(orderById != null) {
			this.orderRepository.delete(orderById);
		}
	}

	@Override
	public Order findOrderById(long id) {
		Optional<Order> optionalOrder = this.orderRepository.findById(id);
		if(optionalOrder.isPresent()) {
			return optionalOrder.get();
		}
		throw new IllegalArgumentException("invalid order id passed");
	}
}