package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Game;
import com.revature.models.User;
import com.revature.services.GameService;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class GameController {
	
	private GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}
	
	@GetMapping
	public ResponseEntity<List<Game>> getAllGames(){
		List<Game> list = gameService.getAllGames();
		return ResponseEntity.status(200).body(list);
	}
	
	/*
	@PostMapping
	public ResponseEntity<Game> addGame(@RequestBody Game game){
		if(game!=null) {
			gameService.addOrUpdateGame(game);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(403).build();
	}
	*/

}
