package com.revature.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingCart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Game game;
	@OneToOne
	private User user;
	
	
	public Cart() {
		super();
	}


	public Cart(int id, Game game, User user) {
		super();
		this.id = id;
		this.game = game;
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Cart [id=" + id + ", game=" + game + ", user=" + user + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(game, id, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cart other = (Cart) obj;
		return Objects.equals(game, other.game) && id == other.id && Objects.equals(user, other.user);
	}
	
	

}
