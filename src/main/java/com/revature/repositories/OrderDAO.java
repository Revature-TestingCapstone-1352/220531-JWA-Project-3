package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Order;
import com.revature.models.User;

public interface OrderDAO extends JpaRepository<Order, Integer>{

	List<Order> findByUser(User user);


}
