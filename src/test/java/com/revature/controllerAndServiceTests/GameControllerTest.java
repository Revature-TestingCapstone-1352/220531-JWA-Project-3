package com.revature.controllerAndServiceTests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.revature.controllers.GameController;
import com.revature.models.Game;
import com.revature.services.GameService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = GameController.class)
public class GameControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GameService gameService;

	@Test
	public void testGetAllGames() {
		List<Game> mockGameList = new ArrayList<Game>();
		mockGameList.add(new Game());
		String expected = "[{\"gameID\":0,\"storeID\":0.0,\"name\":null,\"steamAppID\":0.0,\"salePrice\":0.0,\"retailPrice\":0.0,\"steamRatingText\":null,\"steamRatingPercent\":0.0,\"steamRatingCount\":0.0,\"metacriticScore\":0.0,\"metacriticLink\":null,\"releaseDate\":null,\"publisher\":null,\"thumb\":null}]";

		Mockito.when(gameService.getAllGames()).thenReturn(mockGameList);
		RequestBuilder rb = MockMvcRequestBuilders.get("/game").accept(MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform(rb).andReturn();
			JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

}
