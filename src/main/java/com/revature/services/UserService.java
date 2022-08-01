package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class UserService {

	protected UserDAO userDAO;

	@Autowired
	public UserService(UserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}

	public boolean register(User user) {
		if(user!=null) {
			user.setId(0);
			userDAO.save(user);
			return true;
		} else {
      return false;
    }
	}

	public User login(User user) {
		User dbUser = userDAO.getUserByUsername(user.getUsername());
		if(dbUser != null) {
			return dbUser;
		} else {
      return null;
    }
	}

	public User update(User user) {
		User dbUser = userDAO.getUserByUsername(user.getUsername());
		if(dbUser != null) {
			User updatedUser = userDAO.getUserByUsername(dbUser.getUsername());
			updatedUser.seteMail(user.geteMail());
			updatedUser.setPassword(user.getPassword());
			userDAO.save(updatedUser);
			return user;
		}
		return null;
	}

	public User getUserByUsername(String username) {
    User user = userDAO.getUserByUsername(username);
    if(user != null){
      return user;
    } else {
      return null;
    }
	}

}
