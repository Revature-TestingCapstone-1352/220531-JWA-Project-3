package com.revature.repositories;
import com.revature.models.WishList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListDAO extends JpaRepository<WishList, Integer>{
	List<WishList> findByUserId(int userId);
}
