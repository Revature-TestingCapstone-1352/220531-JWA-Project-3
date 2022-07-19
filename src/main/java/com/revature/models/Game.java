package com.revature.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "videoGames")
public class Game {

	@Id
	private int gameID;
	@Column(nullable = false)
	private double storeID;
	private String name;
	private double steamAppID;
	private double salePrice;
	private double retailPrice;
	private String steamRatingText;
	private double steamRatingPercent;
	private double steamRatingCount;
	private double metacriticScore;
	private String metacriticLink;
	private Date releaseDate;
	private String publisher;
	private String thumb;

	public Game() {
		super();

	}

	public Game(int gameID, double storeID, String name, double steamAppID, double salePrice, double retailPrice,
			String steamRatingText, double steamRatingPercent, double steamRatingCount, double metacriticScore,
			String metacriticLink, Date releaseDate, String publisher, String thumb) {
		super();
		this.gameID = gameID;
		this.storeID = storeID;
		this.name = name;
		this.steamAppID = steamAppID;
		this.salePrice = salePrice;
		this.retailPrice = retailPrice;
		this.steamRatingText = steamRatingText;
		this.steamRatingPercent = steamRatingPercent;
		this.steamRatingCount = steamRatingCount;
		this.metacriticScore = metacriticScore;
		this.metacriticLink = metacriticLink;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
		this.thumb = thumb;
	}



	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public double getSteamRatingPercent() {
		return steamRatingPercent;
	}

	public void setSteamRatingPercent(double steamRatingPercent) {
		this.steamRatingPercent = steamRatingPercent;
	}

	public double getMetacriticScore() {
		return metacriticScore;
	}

	public void setMetacriticScore(double metacriticScore) {
		this.metacriticScore = metacriticScore;
	}
	
	public String getMetacriticLink() {
		return metacriticLink;
	}

	public void setMetacriticLink(String metacriticLink) {
		this.metacriticLink = metacriticLink;
	}

	public double getStoreID() {
		return storeID;
	}

	public void setStoreID(double storeID) {
		this.storeID = storeID;
	}

	public double getSteamAppID() {
		return steamAppID;
	}

	public void setSteamAppID(double steamAppID) {
		this.steamAppID = steamAppID;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getSteamRatingText() {
		return steamRatingText;
	}

	public void setSteamRatingText(String steamRatingText) {
		this.steamRatingText = steamRatingText;
	}

	public double getSteamRatingCount() {
		return steamRatingCount;
	}

	public void setSteamRatingCount(double steamRatingCount) {
		this.steamRatingCount = steamRatingCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gameID, metacriticLink, metacriticScore, name, publisher, releaseDate, retailPrice,
				salePrice, steamAppID, steamRatingCount, steamRatingPercent, steamRatingText, storeID, thumb);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return gameID == other.gameID && Objects.equals(metacriticLink, other.metacriticLink)
				&& Double.doubleToLongBits(metacriticScore) == Double.doubleToLongBits(other.metacriticScore)
				&& Objects.equals(name, other.name) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(releaseDate, other.releaseDate)
				&& Double.doubleToLongBits(retailPrice) == Double.doubleToLongBits(other.retailPrice)
				&& Double.doubleToLongBits(salePrice) == Double.doubleToLongBits(other.salePrice)
				&& Double.doubleToLongBits(steamAppID) == Double.doubleToLongBits(other.steamAppID)
				&& Double.doubleToLongBits(steamRatingCount) == Double.doubleToLongBits(other.steamRatingCount)
				&& Double.doubleToLongBits(steamRatingPercent) == Double.doubleToLongBits(other.steamRatingPercent)
				&& Objects.equals(steamRatingText, other.steamRatingText)
				&& Double.doubleToLongBits(storeID) == Double.doubleToLongBits(other.storeID)
				&& Objects.equals(thumb, other.thumb);
	}

	@Override
	public String toString() {
		return "Game [gameID=" + gameID + ", storeID=" + storeID + ", name=" + name + ", steamAppID=" + steamAppID
				+ ", salePrice=" + salePrice + ", retailPrice=" + retailPrice + ", steamRatingText=" + steamRatingText
				+ ", steamRatingPercent=" + steamRatingPercent + ", steamRatingCount=" + steamRatingCount
				+ ", metacriticScore=" + metacriticScore + ", metacriticLink=" + metacriticLink + ", releaseDate="
				+ releaseDate + ", publisher=" + publisher + ", thumb=" + thumb + "]";
	}

	

}
