package com.revature.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "userId", "gameID" }) })
public class WishList implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int userId;
	private int gameID;
	
	
	public WishList(int id, int userId, int gameID) {
		super();
		this.id = id;
		this.userId = userId;
		this.gameID = gameID;
	}


	public WishList() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getGameID() {
		return gameID;
	}


	public void setGameID(int gameID) {
		this.gameID = gameID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(gameID, id, userId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishList other = (WishList) obj;
		return gameID == other.gameID && id == other.id && userId == other.userId;
	}


	@Override
	public String toString() {
		return "WishList [id=" + id + ", userId=" + userId + ", gameID=" + gameID + "]";
	}

	
	

}
