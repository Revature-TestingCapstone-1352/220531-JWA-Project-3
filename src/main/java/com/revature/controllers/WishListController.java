package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.models.Game;

import com.revature.models.User;
import com.revature.services.GameService;
import com.revature.services.WishListService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class WishListController {
    private WishListService wishListService;
    private GameService gameService;

    public WishListController(WishListService wishListService, GameService gameService) {
            super();
            this.wishListService = wishListService;
            this.gameService = gameService;
        }

    @PostMapping("/{id}")
    public ResponseEntity<Game> addFavouriteGame(@PathVariable("id") int id, HttpSession session){
        System.out.println("user: "+(User)session.getAttribute("user"));
        System.out.println("loggedin: "+session.getAttribute("logged in"));
        if(session.getAttribute("logged in")!=null && (Boolean)session.getAttribute("logged in")) {
            User user = (User)session.getAttribute("user");
            Game game = gameService.getById(id).get();
            wishListService.addFavouriteGame(game,user);
            System.out.println("Wishlist added!");
            return ResponseEntity.status(201).build();
        }
        return ResponseEntity.status(403).build();
    }
    
    @GetMapping
    public ResponseEntity<List<Game>> getFavGames(HttpSession session){
        if(session.getAttribute("logged in")!=null && (Boolean)session.getAttribute("logged in")) {
        	System.out.println("smth");
            User user = (User)session.getAttribute("user");
            List<Game> list = wishListService.getFavGames(user);
            return ResponseEntity.status(200).body(list); 
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Game> deleteFavCharacter(@PathVariable("id") int id, HttpSession session){
        if(session.getAttribute("logged in")!=null && (Boolean)session.getAttribute("logged in")) {
            User user = (User)session.getAttribute("user");
            wishListService.deleteFavGame(user, id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(403).build();
    }

}