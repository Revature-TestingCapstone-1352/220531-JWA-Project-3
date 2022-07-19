package com.revature.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Game;
import com.revature.repositories.GameDAO;

@Service
public class GameService {
	private GameDAO gameDao;
	
	@Autowired
	public GameService(GameDAO gameDao) {
		super();
		this.gameDao = gameDao;
	}
	
	
	public Optional<List<Game>> getByName(String name){
		return gameDao.findByName(name);
	}
	
	/*
	public Game addGame(Game game) {
	     game.setGameID(0);
	     Game dbGame= gameDao.save(game);
	     return dbGame;
	     }
	
	public Game addOrUpdateGame(Game game) {
		Game dbGame = gameDao.save(game);
		return dbGame;
	}
	*/
	
	public List<Game> getAllGames(){
		return gameDao.findAll();
	}	 
	
	public Optional<Game> getById(int gameId) {
		return gameDao.findById(gameId);
	}
	

}