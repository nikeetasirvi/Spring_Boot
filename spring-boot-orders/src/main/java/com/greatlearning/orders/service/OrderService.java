package com.greatlearning.orders.service;

import java.util.List;

import com.greatlearning.orders.model.Order;

public interface OrderService {
	
	Order saveOrder(Order order);

	List<Order> fetchAllOrders();

	Order findOrderById(long id);

	Order updateOrder(long id, Order order);

	void deleteOrder(long id);

}
