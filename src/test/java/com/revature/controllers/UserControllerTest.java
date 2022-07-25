package com.revature.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class)
public class UserControllerTest {
  @Autowired
  private MockMvc mockmvc;

  @MockBean
  private UserService mockUs;

  @Test
  public void should_registerUser(){
    //given
    User mockUser = new User();
    Random rand = new Random();
    int upperbound = 100000;
    int random = rand.nextInt(upperbound);
    String testchars = String.valueOf(random);
    mockUser.setUsername(testchars);
    mockUser.setPassword("password");
    mockUser.seteMail("email@email.org");
    //when
    when(mockUs.register(mockUser)).thenReturn(true);
    //then
    try {
      //send json object
      ObjectMapper mapper = new ObjectMapper();
      String mockRegisterJson = mapper.writeValueAsString(mockUser);
      RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/users/register")
        .accept(MediaType.APPLICATION_JSON).content(mockRegisterJson)
        .contentType(MediaType.APPLICATION_JSON);
      //get result
      MvcResult result = mockmvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse mockResponse = result.getResponse();
      //check result
      assertEquals(HttpStatus.CREATED.value(), mockResponse.getStatus());
    } catch(Exception e){
      e.printStackTrace();
    }

  }

  @Test
  public void should_notRegisterUser(){
    //given
    User mockUser = new User();
    mockUser.setUsername("unTest");
    //when
    when(mockUs.register(mockUser)).thenReturn(false);
    //then
    try {
      //send json object
      ObjectMapper mapper = new ObjectMapper();
      String mockRegisterJson = mapper.writeValueAsString(mockUser);
      RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/users/register")
        .accept(MediaType.APPLICATION_JSON).content(mockRegisterJson)
        .contentType(MediaType.APPLICATION_JSON);
      //get result
      MvcResult result = mockmvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse mockResponse = result.getResponse();
      //check result
      assertEquals(HttpStatus.BAD_REQUEST.value(), mockResponse.getStatus());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void should_loginUser(){
    //given
    User mockUser = new User(1, "username", "password", "email@email.org");
    //when
    when(mockUs.login(mockUser)).thenReturn(mockUser);
    //then
    try{
      //send json object
      ObjectMapper mapper = new ObjectMapper();
      String mockUserJson = mapper.writeValueAsString(mockUser);
      RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/users")
        .accept(MediaType.APPLICATION_JSON).content(mockUserJson)
        .contentType(MediaType.APPLICATION_JSON);
      //get result
      MvcResult result = mockmvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse mockResponse = result.getResponse();
      //check result
      assertEquals(HttpStatus.OK.value(), mockResponse.getStatus());
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  @Test
  public void should_notLoginUser(){
    //given
    User mockUser = new User();
    mockUser.setUsername("gary");
    //when
    when(mockUs.login(mockUser)).thenReturn(null);
    //then
    try{
      //send json object
      ObjectMapper mapper = new ObjectMapper();
      String mockUserJson = mapper.writeValueAsString(mockUser);
      RequestBuilder requestBuilder = MockMvcRequestBuilders
        .post("/users")
        .accept(MediaType.APPLICATION_JSON).content(mockUserJson)
        .contentType(MediaType.APPLICATION_JSON);
      //get result
      MvcResult result = mockmvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse mockResponse = result.getResponse();
      //check result
      assertEquals(HttpStatus.UNAUTHORIZED.value(), mockResponse.getStatus());
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  @Test
  public void should_updateUser(){
    //given
    User mockUser = new User();
    mockUser.setUsername("username");
    mockUser.setPassword("password");
    mockUser.seteMail("newEmail@email.org");
    //when
    when(mockUs.update(mockUser)).thenReturn(mockUser);
    //then
    try{
      //send json object
      ObjectMapper mapper = new ObjectMapper();
      String mockUserJson = mapper.writeValueAsString(mockUser);
      RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/users")
        .accept(MediaType.APPLICATION_JSON).content(mockUserJson)
        .contentType(MediaType.APPLICATION_JSON);
      //get result
      MvcResult result = mockmvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse mockResponse = result.getResponse();
      //check result
      assertEquals(HttpStatus.OK.value(), mockResponse.getStatus());
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  @Test
  public void should_notUpdateUser(){
    //given
    User mockUser = new User();
    mockUser.setUsername("username");
    mockUser.seteMail("newEmail@email.org");
    //when
    when(mockUs.update(mockUser)).thenReturn(mockUser);
    //then
    try{
      //send json object
      ObjectMapper mapper = new ObjectMapper();
      String mockUserJson = mapper.writeValueAsString(mockUser);
      RequestBuilder requestBuilder = MockMvcRequestBuilders
        .put("/users")
        .accept(MediaType.APPLICATION_JSON).content(mockUserJson)
        .contentType(MediaType.APPLICATION_JSON);
      //get result
      MvcResult result = mockmvc.perform(requestBuilder).andReturn();
      MockHttpServletResponse mockResponse = result.getResponse();
      //check result
      assertEquals(HttpStatus.BAD_REQUEST.value(), mockResponse.getStatus());
    } catch(Exception e){
      e.printStackTrace();
    }
  }
}
