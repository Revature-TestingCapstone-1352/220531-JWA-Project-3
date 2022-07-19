package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.revature.GameGalaxyBackendApplication;
import com.revature.models.User;

@SpringBootTest
@ContextConfiguration(classes = GameGalaxyBackendApplication.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testgetUserByUsername() {
		User user = userService.getUserByUsername("paul");
		assertEquals("paulkita@gmail.com", user.geteMail());
	}
	
	@Test
	public void testlogin() {
        User user = userService.getUserByUsername("Puru1");
        User loggedUser = userService.login(user);
        assertEquals(loggedUser, user);
    }
	
	@Test
	public void testupdate() {
		User user = new User ("user", "password", "email@email.com");
		User userToUpdate = userService.update(user);
		assertEquals("email@email.com", userToUpdate.geteMail());
	}
	
}


