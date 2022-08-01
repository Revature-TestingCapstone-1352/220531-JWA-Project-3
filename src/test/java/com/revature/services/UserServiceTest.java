package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.revature.repositories.UserDAO;
import org.junit.jupiter.api.Test;


import com.revature.GameGalaxyBackendApplication;
import com.revature.models.User;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@InjectMocks
	private UserService mockUserService;

  @Mock
  private UserDAO mockUserDao;

	//Get User by Username - happy path
  @Test
	public void testgetUserByUsername() {
    //given
    User mockUser = new User(1, "username", "password", "testEmail@email.com");
		//when
    when(mockUserDao.getUserByUsername("username")).thenReturn(mockUser);
    //then
		assertEquals(mockUser, mockUserService.getUserByUsername("username"));
	}
  //Get User by Username - sad path
  @Test
  public void testNotGetUserByUsername(){
    //given
    User mockUser = new User(1, "username", "password", "testEmail@email.com");
    //when
    when(mockUserDao.getUserByUsername("nameuser")).thenReturn(null);
    //then
    assertNull(mockUserService.getUserByUsername("nameuser"));
  }

  //Login - happy path
	@Test
	public void testlogin() {
    //given
    User mockUser = new User(1, "username", "password", "testEmail@email.com");
    //when
    when(mockUserDao.getUserByUsername("username")).thenReturn(mockUser);
    //then
    assertEquals(mockUser, mockUserService.login(mockUser));
  }
  //Login - sad path
  @Test
  public void testNotLogin(){
    //given
    User mockUser = new User();
    mockUser.setUsername("user1");
    //when
    when(mockUserDao.getUserByUsername(mockUser.getUsername())).thenReturn(null);
    //then
    assertEquals(null, mockUserService.login(mockUser));
  }


  //Update User - happy path
	@Test
	public void testupdate() {
		//given
    User mockUser = new User();
    mockUser.setUsername("username");
    mockUser.setPassword("newPass");
    mockUser.seteMail("testEmail@email.org");
    //when
    when(mockUserDao.getUserByUsername("username")).thenReturn(mockUser);
    //then
    assertEquals(mockUser, mockUserService.update(mockUser));
	}
	
	//Negative tests?
	
	//test register - TR
	
  //Update User - sad path
  @Test
  public void testFailedUpdate(){
    //given
    User mockUser = new User();
    mockUser.setUsername("username");
    //when
    when(mockUserDao.getUserByUsername(mockUser.getUsername())).thenReturn(null);
    //then
    assertEquals(null, mockUserService.update(mockUser));
  }

  //Register User - happy path
  @Test
  public void testRegisterUser(){
    //given
    User mockUser = new User(1, "username", "password", "mockEmail@email.com");
    //when
    when(mockUserDao.save(mockUser)).thenReturn(mockUser);
    //then
    assertEquals(true, mockUserService.register(mockUser));
  }

  //Register User - sad path
  @Test
  public void testNotRegisterUser(){
    //given
    User mockUser = null;
    //then
    assertEquals(false, mockUserService.register(mockUser));
  }
}


