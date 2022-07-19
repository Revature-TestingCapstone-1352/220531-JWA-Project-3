package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Cart;
import com.revature.models.Game;
import com.revature.models.User;
import com.revature.repositories.CartDAO;

@Service
public class CartService {

	private CartDAO cartDao;
	private GameService gameService;
	
	@Autowired
	public CartService(CartDAO cartDao, GameService gameService) {
		super();
		this.cartDao = cartDao;
		this.gameService = gameService;
	}
	
	public boolean addToCart(int gameId, User user) {	
		Cart cart = new Cart();
		Optional<Game> opt = gameService.getById(gameId);
		
		if(opt.isPresent()) {
			cart.setId(0);
			cart.setGame(opt.get());
			cart.setUser(user);
			
			cartDao.save(cart);
			
			return true;
		}
		
		return false;

	}

	public List<Game> getCartItems(User user) {
		
	//	return cartDao.findAllByUser(user);
		return null;
		
	}

	public void deleteCartItem(int gameId, User user) {
/*		
		Optional<Game> opt = gameService.getById(gameId);
		if(opt.isPresent()) {
			Game game = opt.get();
			System.out.println(game);
			System.out.println(user);
			Cart dbCart = cartDao.getByUserandGame();
			System.out.println(dbCart);
			cartDao.delete(dbCart);
		}*/
	}
	
	public void deleteCartItems(User user) {
		
	//	cartDao.deleteByUser(user);
		
	}
}
