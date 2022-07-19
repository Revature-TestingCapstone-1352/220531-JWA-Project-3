package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Cart;
import com.revature.models.Game;
import com.revature.models.User;

public interface CartDAO extends JpaRepository<Cart,Integer>{

	//List<Game> findAllByUser(User user);

	//void deleteByUser(User user);

	//Cart getByUserandGame();

}
