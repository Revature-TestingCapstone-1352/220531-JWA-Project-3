package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Cart;
import com.revature.models.Game;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.services.CartService;
import com.revature.services.GameService;
import com.revature.services.OrderService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CartController {
	private CartService cartService;
	private OrderService orderService;
	
	
	@Autowired
	public CartController(CartService cartService,OrderService orderService) {
		super();
		this.cartService = cartService;
		this.orderService = orderService;
	}
/*

	@GetMapping
	public ResponseEntity<List<Game>> getCartItems(HttpSession session){
		
		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			User user = (User)session.getAttribute("user");
			List<Game> games = cartService.getCartItems(user);
			return ResponseEntity.status(HttpStatus.OK).body(games);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}

	@PostMapping
	public ResponseEntity<Game> addToCart(@RequestBody int gameId, HttpSession session) {
		
		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			User user = (User)session.getAttribute("user");
			if (cartService.addToCart(gameId,user)) {
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
	@DeleteMapping
	public ResponseEntity<Game> removeFromCart(@RequestBody int gameId, HttpSession session) {
		
		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			User user = (User)session.getAttribute("user");
			cartService.deleteCartItem(gameId,user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
			//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	*/
	
	@GetMapping()
	public ResponseEntity<List<Order>> getOrderHistory(HttpSession session){
		
		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			User user = (User)session.getAttribute("user");
			List<Order> orders = orderService.getOrdersByUser(user);
			if (orders != null) 
				return ResponseEntity.status(HttpStatus.OK).body(orders);
			else 
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		
	}
	

	@PostMapping
	public ResponseEntity<Order> addToOrderHistory(@RequestBody Order order, HttpSession session) {
		
		//System.out.println("order order");
		if(session.getAttribute("logged in")!=null&&(Boolean)session.getAttribute("logged in")) {
			User user = (User)session.getAttribute("user");
			if (orderService.addOrder(order,user) != null) {
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}
	
}
