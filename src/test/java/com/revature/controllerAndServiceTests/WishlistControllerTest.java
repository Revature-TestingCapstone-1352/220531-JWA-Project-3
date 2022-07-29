package com.revature.controllerAndServiceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import com.revature.controllers.WishListController;
import com.revature.models.Game;
import com.revature.models.User;
import com.revature.models.WishList;
import com.revature.services.GameService;
import com.revature.services.WishListService;

@ExtendWith(MockitoExtension.class)
public class WishlistControllerTest {
	
	//Place to inject mocks
	@InjectMocks
	private static WishListController wlc;
	
	@Mock
	private static WishListService wls;
	
	@Mock
	private static GameService gs;
	
	//Tests for Add Favorite Game
	@Test
	public void afg_notLoggedIn()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		assertEquals(wlc.addFavouriteGame(0, hS).getStatusCodeValue(),403);
	}
	
	@Test 
	public void afg_badGameID()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		User u = new User();
		hS.setAttribute("logged in", true);
		hS.setAttribute("user", u);
		Mockito.when(gs.getById(-1)).thenReturn(Optional.of(new Game()));
		assertEquals(wlc.addFavouriteGame(-1, hS).getStatusCodeValue(),201);
	}
	
	@Test 
	public void afg_goodGameID()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		User u = new User();
		Optional<Game> oGame = Optional.of(new Game());
		hS.setAttribute("logged in", true);
		hS.setAttribute("user", u);
		Mockito.when(gs.getById(-1)).thenReturn(oGame);
		assertEquals(wlc.addFavouriteGame(-1, hS).getStatusCodeValue(),201);
	}
	
	//Tests for getFavGames
	@Test
	public void gfg_badLogin()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		assertEquals(wlc.getFavGames(hS),null);
	}
	
	@Test 
	public void gfg_emptyList()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		User u = new User();
		hS.setAttribute("logged in", true);
		hS.setAttribute("user", u);
		List<Game> mockGames = new ArrayList<>();
		Mockito.when(wls.getFavGames(u)).thenReturn(mockGames);
		ResponseEntity<List<Game>> re = wlc.getFavGames(hS);
		assertEquals(re.getStatusCodeValue(),200);
		assertEquals(re.getBody(),mockGames);
	}
	
	@Test 
	public void gfg_goodList()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		User u = new User();
		hS.setAttribute("logged in", true);
		hS.setAttribute("user", u);
		List<Game> mockGames = new ArrayList<>();
		for (int i=0;i<4;i++) {mockGames.add(new Game());}
		Mockito.when(wls.getFavGames(u)).thenReturn(mockGames);
		ResponseEntity<List<Game>> re = wlc.getFavGames(hS);
		assertEquals(re.getStatusCodeValue(),200);
		assertEquals(re.getBody(),mockGames);
	}
	
	//Tests for deleteFavCharacter
	@Test
	public void dfg_badLogin()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		assertEquals(wlc.deleteFavCharacter(0, hS).getStatusCodeValue(),403);
	}
	
	@Test
	public void dfg_badGameID()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		User u = new User();
		hS.setAttribute("logged in", true);
		hS.setAttribute("user", u);
		assertEquals(wlc.deleteFavCharacter(-1, hS).getStatusCodeValue(),200);
	}
	
	@Test 
	public void dfg_irrelevantGameID()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		User u = new User();
		hS.setAttribute("logged in", true);
		hS.setAttribute("user", u);
		List<WishList> mockList = new ArrayList<>();
		for (int i=0;i<4;i++) {mockList.add(new WishList(i,u.getId(),i));}
		assertEquals(wlc.deleteFavCharacter(15, hS).getStatusCodeValue(),200);
	}
	
	@Test
	public void dfg_relevantGameID()
	{
		MockHttpServletRequest hSR = new MockHttpServletRequest();
		HttpSession hS = hSR.getSession();
		User u = new User();
		hS.setAttribute("logged in", true);
		hS.setAttribute("user", u); 
		List<WishList> mockList = new ArrayList<>();
		for (int i=0;i<4;i++) {mockList.add(new WishList(i,u.getId(),i));}
		assertEquals(wlc.deleteFavCharacter(4, hS).getStatusCodeValue(),200);
	}
}