package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.models.Cart;
import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repositories.CartDAO;


@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
	
	@InjectMocks
	private static CartService cartService;
	
	@Mock
    private static GameService gameService;
	
	@Mock
	private static CartDAO cartDao;
	
	// CS-GP-00 Tests adding a game to cart with valid id and user
	@Test
	public void testAddItemToCartValidId() {
		 //Input Data
		 User inputUser = new User();
         inputUser.setId(1); // Assuming id of 1 exists
         inputUser.setUsername("George");
		 Date d1 = new Date(2323223232L);
		 Cart cart = new Cart();
		 Optional<Game> opt = Optional.of(new Game(33, 1, "From Dust", 12, 14.99, 19.99, "Positive", 0.75, 199, 90, "Somewebpage",d1, "Eonix","thumb"));
		 
		 // Mocking game service
		 when(gameService.getById(33)).thenReturn(opt);
		 
		 // Running test
		 if (cartService.addToCart(33, inputUser)) {
			 cart.setId(0);
			 cart.setUser(inputUser);
			
			 if (opt.isPresent()) {
				 cart.setGame(opt.get());
			 }
			 cart.setUser(inputUser);
		 };
		// Assertions
		assertEquals("From Dust", cart.getGame().getName());
		assertEquals("George", inputUser.getUsername());
	}
	
	// CS-GP-01 Tests adding a valid game to cart with no user
	@Test
	public void testAddToCartNoUser() {
		 //Input Data
		 Date d1 = new Date(2323223232L);
		 Cart cart = new Cart();
		 Optional<Game> opt = Optional.of(new Game(33, 1, "From Dust", 12, 14.99, 19.99, "Positive", 0.75, 199, 90, "Somewebpage",d1, "Eonix","thumb"));
		 
		 // Mocking game service
		 when(gameService.getById(33)).thenReturn(opt);
		 
		 // Running test
		 if (cartService.addToCart(33, null)) {
			 cart.setId(0);
			
			 if (opt.isPresent()) {
				 cart.setGame(opt.get());
			 }
			 cart.setUser(null);
		 };
		// Assertions
		assertEquals("From Dust", cart.getGame().getName());
	}
	
	// CS-GP-02 Tests trying to get an invalid game id with no user
	@Test
	public void testAddItemToCartInvalidId() {
		//Input Data
		 Cart cart = new Cart();
		 Optional<Game> opt = Optional.empty();
		
		 // Mocking game service
		 when(gameService.getById(-1)).thenReturn(opt);

		 
		// Running test
		 if (!cartService.addToCart(-1, null)) {
			 cart.setId(0);
			 if (opt.isEmpty()) {
				 cart.setGame(null);
			 }

			 cart.setUser(null);
		 };
		// Assertions
		assertEquals(null, cart.getGame());
	}
	
<<<<<<< HEAD

=======
>>>>>>> 1048adafa9aa92eff23dce79e61660542873e4d7
}
