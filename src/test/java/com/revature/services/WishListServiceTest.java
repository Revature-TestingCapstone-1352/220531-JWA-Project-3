package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.GameGalaxyBackendApplication;
import com.revature.models.Game;
import com.revature.models.User;

@SpringBootTest
@ContextConfiguration(classes = GameGalaxyBackendApplication.class)
public class WishListServiceTest {
	
	@Autowired
	private WishListService wishListService;
	
	@Autowired
	private UserService userService;

	@Test
	public void testgetFavGames() {
		
		User user = userService.getUserByUsername("user1");
		List<Game> allWish = wishListService.getFavGames(user);
		Game game = allWish.get(0);
		assertEquals(game.getName(), "Demigod");
	}
}
