package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Game;

public interface GameDAO extends JpaRepository<Game, Integer>{
	Optional<List<Game>> findByName(String name);
}

