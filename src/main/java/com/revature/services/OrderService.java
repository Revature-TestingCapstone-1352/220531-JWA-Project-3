package com.revature.services;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Order;
import com.revature.models.User;
import com.revature.repositories.OrderDAO;

@Service
public class OrderService {
	
	private OrderDAO orderDao;
	
	@Autowired
	public OrderService(OrderDAO orderDao) {
		super();
		this.orderDao = orderDao;
	}
	
	public List<Order> getAllOrders() {
		
		return orderDao.findAll();
	}
	
	public Order getByOrderId(int orderId) {
		Optional<Order> opt = orderDao.findById(orderId);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	public List<Order> getOrdersByUser(User user) {
		
		List<Order> orders = orderDao.findByUser(user);
		if (!orders.isEmpty()) {
			return orders;
		}
		return null;
	}
	
	
	public Order addOrder(Order newOrder, User user) {
		
		newOrder.setUser(user);
		return orderDao.save(newOrder);
	}
	
	public Order updateOrder(Order order) {
		
		return  orderDao.save(order);
	}
	
	public void deleteOrder(Order order) {
		
		orderDao.delete(order);
	}

}
