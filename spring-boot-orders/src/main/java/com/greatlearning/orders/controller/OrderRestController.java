package com.greatlearning.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.orders.model.Order;
import com.greatlearning.orders.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {

	@Autowired
	public OrderService orderService;
	
	@GetMapping
	public List<Order> fetchAllOrders(){
		return this.orderService.fetchAllOrders();
	}
	
	@GetMapping("/{id}")
	public Order fetchOrderById(@PathVariable("id") long id) {
		return this.orderService.findOrderById(id);
	}
	
	@PostMapping
	public Order saveUser(@RequestBody Order order) {
		return this.orderService.saveOrder(order);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable("id") long id) {
		this.orderService.deleteOrder(id);
	}

}
