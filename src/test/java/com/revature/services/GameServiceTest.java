package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.GameGalaxyBackendApplication;
import com.revature.models.Game;

@SpringBootTest
@ContextConfiguration(classes = GameGalaxyBackendApplication.class)
public class GameServiceTest {

	@Autowired
    private GameService gameService;
	
	@Test
	public void testfindByName() {
		
		Optional<List<Game>> games = gameService.getByName("Syberia");
		int gamesNumber = games.get().size();
		assertEquals(1, gamesNumber);
	}

	@Test
	public void testgetAllGames() {
		
		List<Game> games = gameService.getAllGames();
		int gamesNumber = games.size();
		assertEquals(221, gamesNumber);
	}
	
	@Test
	public void testfindById() {
		
		Optional<Game> game = gameService.getById(2);
		assertEquals("Evochron Mercenary", game.get().getName());
	}
}
