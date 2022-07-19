package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.models.WishList;
import com.revature.repositories.GameDAO;
import com.revature.repositories.WishListDAO;

@Service
public class WishListService {
	private WishListDAO wishListDao;
	private GameDAO gameDao;
	private GameService gameService;
	
	public WishListService(WishListDAO wishListDao, GameDAO gameDao, GameService gameService) {
		super();
		this.wishListDao = wishListDao;
		this.gameDao = gameDao;
		this.gameService =gameService;
	}
	
		
	public void addFavouriteGame(Game game,User user) {
		
		WishList wishlist = new WishList();
		
		wishlist.setUserId(user.getId());
		wishlist.setGameID(game.getGameID());
		wishListDao.save(wishlist);
	}
	
	public List<Game> getFavGames(User user) {
		List<WishList> allWish = wishListDao.findByUserId(user.getId());
		
		List<Game> favList = new ArrayList<>();
		for(WishList wish : allWish) {
			if(wish.getGameID()!=0) {
				favList.add(gameService.getById(wish.getGameID()).get());
			} 
		}
		return favList;
	}
	
	public void deleteFavGame(User user, int gameID) {
		List<WishList> wishlist = wishListDao.findByUserId(user.getId());
		for(WishList wish : wishlist) {
			if(wish.getGameID()!=0 && wish.getGameID()==(gameID)) {
				wishListDao.delete(wish);
			} 
		}
	}
	
	

}
