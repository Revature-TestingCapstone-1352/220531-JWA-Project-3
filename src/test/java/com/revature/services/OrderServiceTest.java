package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.GameGalaxyBackendApplication;
import com.revature.models.Game;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.repositories.OrderDAO;

@SpringBootTest
@ContextConfiguration(classes = GameGalaxyBackendApplication.class)
public class OrderServiceTest {

	@InjectMocks
	private OrderService orderService;
	
	//private UserService userService;
	
	@Mock
	private static OrderDAO MockOrderDao;
	
	@Mock
	private static UserService MockUserService;
	
	
	
	@Test
	public void testgetAllOrders() {
		
		
		
		//List<Order> expectedOrders = new ArrayList<Order>() {
	//		add(0, 05/28/12, );
	//		add(1, );
	//	};
		
	//	when(MockOrderDao.save(null)).thenReturn(orders);
		
		List<Order> actualOrders = orderService.getAllOrders();
	//	Order order = orders.get(2);
	//	assertEquals(order.getUser().getUsername(), "andres");
	}
	
	@Test
	public void testgetOrderById() { //get order with valid id
		java.sql.Date d1 = (java.sql.Date) new Date();
		java.sql.Date d2 = (java.sql.Date) new Date();
		List<Game> g1 = new ArrayList<Game>();
			g1.add(new Game(0, 0, "test", 0, 0.00, 0.00, null, 0.00, 0, 0, "test", d2, "testindo", "test"));
		User u1 = new User(0, "test", "tst", "twr@sdad.com");
		
		Order expectedOrder = new Order(0, d1, g1, u1);
		when(MockOrderDao.save(expectedOrder)).thenReturn(expectedOrder);
		Order ActualOrder = orderService.getByOrderId(0);
		assertEquals(expectedOrder, ActualOrder);
	}
	
	@Test
	public void testgetOrderById2() { //get null with invalid id
		int invalidId = -1;
		Order actualOrder = orderService.getByOrderId(invalidId);
		assertEquals(actualOrder, null);
	}
	
	@Test
	public void testgetOrderByUser() { //get all orders of a user
		java.sql.Date d1 = (java.sql.Date) new Date();
		java.sql.Date d2 = (java.sql.Date) new Date();
		User user = new User(0, "test", "tst", "twr@sdad.com");
		List<Game> g1 = new ArrayList<Game>();
		g1.add(new Game(0, 0, "test", 0, 0.00, 0.00, null, 0.00, 0, 0, "test", d2, "testindo", "test"));
		
		List<Game> g2 = new ArrayList<Game>();
		g1.add(new Game(0, 0, "test", 0, 0.00, 0.00, null, 0.00, 0, 0, "test", d2, "testindo", "test"));
		
		List<Order> expectedOrders = new ArrayList<Order>();
		expectedOrders.add(new Order(0, d1, g1, user));
		expectedOrders.add(new Order(1, d2, g2, user));
		
		when(MockOrderDao.saveAll(expectedOrders)).thenReturn(expectedOrders);
		List<Order> ActualOrders = orderService.getOrdersByUser(user);
		
		assertEquals(ActualOrders, expectedOrders);
	}
	
	@Test
	public void testgetOrderByUser2() { //get all orders of a user with no orders
		User user = new User(0, "test", "tst", "twr@sdad.com");
		List<Order> orders = orderService.getOrdersByUser(user);
		assertEquals(orders, null);
	}
	@Test
	public void testgetOrderByUser3() { //get all orders but the user doesn't exist
		User user = MockUserService.getUserByUsername("LoginUserTest");
		List<Order> orders = orderService.getOrdersByUser(user);
		assertEquals(orders, null);
	}
	
	@Test
	public void testupdateOrder() {
		java.sql.Date d1 = (java.sql.Date) new Date();
		User user = new User(0, "test", "tst", "twr@sdad.com");
		List<Game> g1 = new ArrayList<Game>();
		g1.add(new Game(0, 0, "test", 0, 0.00, 0.00, null, 0.00, 0, 0, "test", d1, "testindo", "test"));
		Order order = new Order(0, d1, g1, user);
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		order.setOrderDate(sqlDate);
		orderService.updateOrder(order);
		assertEquals(order.getOrderDate(), utilDate);
	}
	@Test
	public void testupdateOrder2() { //update but with null input
		Order order = orderService.getByOrderId(9);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		order.setOrderDate(sqlDate);
		orderService.updateOrder(order);
		assertEquals(order.getOrderDate(), utilDate);
	}
	@Test
	public void testupdateOrder3() { //update with bad input
		Order order = orderService.getByOrderId(9);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		order.setOrderDate(sqlDate);
		orderService.updateOrder(order);
		assertEquals(order.getOrderDate(), utilDate);
	}
	
	@Test
	public void deleteOrder() {
		
	}
	@Test
	public void deleteOrder2() {
		
	}

		
	@Test
	public void addOrder() {
		
	}
	@Test
	public void addOrder2() {
		
	}
	@Test
	public void addOrder3() {
		
	}

	
	//add and delete order tests
	
}
