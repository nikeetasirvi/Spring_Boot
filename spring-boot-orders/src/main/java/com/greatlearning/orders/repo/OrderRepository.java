package com.greatlearning.orders.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.orders.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
