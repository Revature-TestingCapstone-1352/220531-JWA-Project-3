package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.GameGalaxyBackendApplication;
import com.revature.models.Cart;
import com.revature.models.Game;
import com.revature.models.User;

@SpringBootTest
@ContextConfiguration(classes = GameGalaxyBackendApplication.class)
public class CartServiceTest {
	
	@Autowired
    private CartService cartService;
	
	@Autowired
    private GameService gameService;
	
	@Test
	public void testaddToCart() {
		
		 Cart cart = new Cart();
		 if (cartService.addToCart(33, null)) {
			 cart.setId(0);
			 Optional<Game> game = gameService.getById(33);
			 if (game.isPresent()) {
				 cart.setGame(game.get());
			 }
			 cart.setUser(null);
		 };
		assertEquals("From Dust", cart.getGame().getName());
	}
}
