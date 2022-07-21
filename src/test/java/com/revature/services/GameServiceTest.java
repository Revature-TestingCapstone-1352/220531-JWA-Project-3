package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.revature.models.Game;
import com.revature.repositories.GameDAO;

@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

	@InjectMocks
	private GameService gameService;

	@Mock
	private GameDAO mockGameDao;

	@Test
	public void testSearchGamesByValidName() {
		String testName = "Test Game Name";
		Optional<List<Game>> mockGameList = Optional.of(new ArrayList<Game>());
		Game mockGame = new Game();
		mockGame.setName(testName);
		mockGameList.get().add(mockGame);

		when(mockGameDao.findByName(testName)).thenReturn(mockGameList);

		assertEquals(mockGameList, gameService.getByName(testName));
	}

	@Test
	public void testSearchGamesByInvalidName() {

		String testName = "Test Game Name";
		List<Game> testList = new ArrayList<Game>();
		Optional<List<Game>> mockGameList = Optional.of(testList);
		Game mockGame = new Game();
		mockGame.setName(testName);

		when(mockGameDao.findByName("Junk")).thenReturn(mockGameList);

		assertTrue(gameService.getByName("Junk").get().isEmpty());
	}

	@Test
	public void testFindAllGames() {
		List<Game> mockGameList = new ArrayList<Game>();
		Game game1 = new Game();
		game1.setGameID(1);
		mockGameList.add(game1);
		Game game2 = new Game();
		game2.setGameID(2);
		mockGameList.add(game2);
		Game game3 = new Game();
		game3.setGameID(3);
		mockGameList.add(game3);

		when(mockGameDao.findAll()).thenReturn(mockGameList);

		assertEquals(mockGameList.size(), gameService.getAllGames().size());
	}

	@Test
	public void testSearchGamesByValidId() {
		int mockId = 1;
		Optional<List<Game>> mockGameList = Optional.of(new ArrayList<Game>());
		Optional<Game> mockGame = Optional.of(new Game());
		mockGame.get().setGameID(mockId);
		mockGameList.get().add(mockGame.get());

		when(mockGameDao.findById(mockId)).thenReturn(mockGame);

		assertEquals(mockGame, gameService.getById(mockId));
	}

	@Test
	public void testSearchGamesByInvalidId() {
		Optional<List<Game>> mockGameList = Optional.of(new ArrayList<Game>());
		Optional<Game> mockGame = Optional.of(new Game());
		mockGame.get().setGameID(1);
		mockGameList.get().add(mockGame.get());

		when(mockGameDao.findById(anyInt())).thenReturn(mockGame);

		assertNotEquals(-1, gameService.getById(anyInt()).get().getGameID());
	}
}
