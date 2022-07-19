package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.GameGalaxyBackendApplication;
import com.revature.models.Order;
import com.revature.models.User;

@SpringBootTest
@ContextConfiguration(classes = GameGalaxyBackendApplication.class)
public class OrderServiceTest {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testgetAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		Order order = orders.get(2);
		assertEquals(order.getUser().getUsername(), "andres");
	}
	
	@Test
	public void testgetOrderById() {
		Order order = orderService.getByOrderId(9);
		assertEquals(order.getUser().geteMail(), "Paul@abc.pl");
	}
	
	@Test
	public void testgetOrderById2() {
		Order order = orderService.getByOrderId(10000);
		assertEquals(order, null);
	}
	
	@Test
	public void testgetOrderByUser() {
		User user = userService.getUserByUsername("andres");
		List<Order> orders = orderService.getOrdersByUser(user);
		assertEquals(orders.size(), 3);
	}
	
	@Test
	public void testgetOrderByUser2() {
		User user = userService.getUserByUsername("LoginUserTest");
		List<Order> orders = orderService.getOrdersByUser(user);
		assertEquals(orders, null);
	}
	
	@Test
	public void testupdateOrder() {
		Order order = orderService.getByOrderId(9);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		order.setOrderDate(sqlDate);
		orderService.updateOrder(order);
		assertEquals(order.getOrderDate(), utilDate);
	}
	
}
