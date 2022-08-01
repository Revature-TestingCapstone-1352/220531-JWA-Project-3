package com.revature.controllerAndServiceTests;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Tag;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.CartController;
import com.revature.models.Order;
import com.revature.models.User;
import com.revature.services.CartService;
import com.revature.services.OrderService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = CartController.class)
public class CartControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private CartService mockCs;
	
	@MockBean
	private OrderService mockOs;
	
	@Test
	@Tag("Controller Test")
	public void should_getOrderHistory() {
		//G
		User mockUser = new User();
		Random rand = new Random();
		int upper = 100000;
		int random = rand.nextInt(upper);
		
		String testchars = String.valueOf(random);
		
		mockUser.setUsername(testchars);
		mockUser.setPassword("password");
		mockUser.seteMail("email@email.org");
		List<Order> orderlist = new ArrayList<>();
		orderlist.add(new Order());
		orderlist.add(new Order());
		orderlist.add(new Order());
		//W
		when(mockOs.getOrdersByUser(mockUser)).thenReturn(orderlist);
		
		//T
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String mockRegisterJson = mapper.writeValueAsString(mockUser);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart")
					.accept(MediaType.APPLICATION_JSON).content(mockRegisterJson)
					.contentType(MediaType.APPLICATION_JSON)
					.sessionAttr("logged in", true)
					.sessionAttr("user", mockUser);
			
			MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse mockResponse = result.getResponse();
			assertEquals(HttpStatus.OK.value(), mockResponse.getStatus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void should_returnNoContentOrderEmptyGet() {
		//G
		User mockUser = new User();
		Random rand = new Random();
		int upper = 100000;
		int random = rand.nextInt(upper);
		
		String testchars = String.valueOf(random);
		
		mockUser.setUsername(testchars);
		mockUser.setPassword("password");
		mockUser.seteMail("email@email.org");
		List<Order> orderlist = new ArrayList<>();
		//W
		when(mockOs.getOrdersByUser(mockUser)).thenReturn(null);
		
		//T
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String mockRegisterJson = mapper.writeValueAsString(mockUser);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart")
					.accept(MediaType.APPLICATION_JSON)
					.sessionAttr("user", mockUser)
					.sessionAttr("logged in", true);
			
			MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse mockResponse = result.getResponse();
			assertEquals(HttpStatus.NO_CONTENT.value(), mockResponse.getStatus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void should_returnNullWhenNotLoggedInGet() {
		//G
		User mockUser = new User();
		Random rand = new Random();
		int upper = 100000;
		int random = rand.nextInt(upper);
		
		String testchars = String.valueOf(random);
		
		mockUser.setUsername(testchars);
		mockUser.setPassword("password");
		mockUser.seteMail("email@email.org");
		List<Order> orderlist = new ArrayList<>();
		orderlist.add(new Order());
		orderlist.add(new Order());
		orderlist.add(new Order());
		//W
		when(mockOs.getOrdersByUser(mockUser)).thenReturn(orderlist);
		
		//T
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String mockRegisterJson = mapper.writeValueAsString(mockUser);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart")
					.accept(MediaType.APPLICATION_JSON).content(mockRegisterJson)
					.contentType(MediaType.APPLICATION_JSON)
					.sessionAttr("logged in", false);
			
			MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse mockResponse = result.getResponse();
			assertEquals(HttpStatus.UNAUTHORIZED.value(), mockResponse.getStatus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void should_postOrderHistory() {
		//G
		User mockUser = new User();
		Random rand = new Random();
		int upper = 100000;
		int random = rand.nextInt(upper);
		
		String testchars = String.valueOf(random);
		
		mockUser.setUsername(testchars);
		mockUser.setPassword("password");
		mockUser.seteMail("email@email.org");
		
		Order mockOrder = new Order();
		
		//W
		when(mockOs.addOrder(mockOrder, mockUser)).thenReturn(mockOrder);
		
		//T
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String mockOrderJson = mapper.writeValueAsString(mockOrder);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cart")
					.accept(MediaType.APPLICATION_JSON)
					.content(mockOrderJson).contentType(MediaType.APPLICATION_JSON)
					.sessionAttr("logged in", true)
					.sessionAttr("user", mockUser);
			
			MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse mockResponse = result.getResponse();
			assertEquals(HttpStatus.CREATED.value(), mockResponse.getStatus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void should_internalServerErrorInvalidOrder() {
		//G
		User mockUser = new User();
		Random rand = new Random();
		int upper = 100000;
		int random = rand.nextInt(upper);
		
		String testchars = String.valueOf(random);
		
		mockUser.setUsername(testchars);
		mockUser.setPassword("password");
		mockUser.seteMail("email@email.org");
		
		Order mockOrder = new Order();
		
		//W
		when(mockOs.addOrder(mockOrder, mockUser)).thenReturn(null);
		
		//T
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String mockOrderJson = mapper.writeValueAsString(mockOrder);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cart")
					.accept(MediaType.APPLICATION_JSON)
					.content(mockOrderJson).contentType(MediaType.APPLICATION_JSON)
					.sessionAttr("logged in", true)
					.sessionAttr("user", mockUser);
			
			MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse mockResponse = result.getResponse();
			assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), mockResponse.getStatus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void should_badRequestWhenNotLoggedIn() {
		//G
		User mockUser = new User();
		Random rand = new Random();
		int upper = 100000;
		int random = rand.nextInt(upper);
		
		String testchars = String.valueOf(random);
		
		mockUser.setUsername(testchars);
		mockUser.setPassword("password");
		mockUser.seteMail("email@email.org");
		
		Order mockOrder = new Order();
		
		//W
		when(mockOs.addOrder(mockOrder, mockUser)).thenReturn(null);
		
		//T
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String mockOrderJson = mapper.writeValueAsString(mockOrder);
			
			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/cart")
					.accept(MediaType.APPLICATION_JSON)
					.content(mockOrderJson).contentType(MediaType.APPLICATION_JSON)
					.sessionAttr("logged in", false)
					.sessionAttr("user", mockUser);
			
			MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse mockResponse = result.getResponse();
			assertEquals(HttpStatus.BAD_REQUEST.value(), mockResponse.getStatus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
