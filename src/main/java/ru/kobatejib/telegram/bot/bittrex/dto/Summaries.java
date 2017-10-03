package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Summaries implements Serializable{
	private String MarketName;
	private String High;
	private String Low;
	private String Volume;
	private String Last;
	private String BaseVolume;
	private String TimeStamp;
	private String Bid;
	private String Ask;
	private String OpenBuyOrders;
	private String OpenSellOrders;
	private String PrevDay;
	private String Created;
	private String DisplayMarketName;
	
	@SerializedName("MarketName")
	public String getMarketName() {
		return MarketName;
	}
	public void setMarketName(String marketName) {
		this.MarketName = marketName;
	}
	
	@SerializedName("High")
	public String getHigh() {
		return High;
	}
	public void setHigh(String high) {
		this.High = high;
	}
	
	@SerializedName("Low")
	public String getLow() {
		return Low;
	}
	public void setLow(String low) {
		this.Low = low;
	}
	
	@SerializedName("Volume")
	public String getVolume() {
		return Volume;
	}
	public void setVolume(String volume) {
		this.Volume = volume;
	}
	
	@SerializedName("Last")
	public String getLast() {
		return Last;
	}
	public void setLast(String last) {
		this.Last = last;
	}
	
	@SerializedName("BaseVolume")
	public String getBaseVolume() {
		return BaseVolume;
	}
	public void setBaseVolume(String baseVolume) {
		this.BaseVolume = baseVolume;
	}
	
	@SerializedName("TimeStamp")
	public String getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.TimeStamp = timeStamp;
	}
	
	@SerializedName("Bid")
	public String getBid() {
		return Bid;
	}
	public void setBid(String bid) {
		this.Bid = bid;
	}
	
	@SerializedName("Ask")
	public String getAsk() {
		return Ask;
	}
	public void setAsk(String ask) {
		this.Ask = ask;
	}
	
	@SerializedName("OpenBuyOrders")
	public String getOpenBuyOrders() {
		return OpenBuyOrders;
	}
	public void setOpenBuyOrders(String openBuyOrders) {
		this.OpenBuyOrders = openBuyOrders;
	}
	
	@SerializedName("OpenSellOrders")
	public String getOpenSellOrders() {
		return OpenSellOrders;
	}
	public void setOpenSellOrders(String openSellOrders) {
		this.OpenSellOrders = openSellOrders;
	}
	
	@SerializedName("PrevDay")
	public String getPrevDay() {
		return PrevDay;
	}
	public void setPrevDay(String prevDay) {
		this.PrevDay = prevDay;
	}
	
	@SerializedName("Created")
	public String getCreated() {
		return Created;
	}
	public void setCreated(String created) {
		this.Created = created;
	}
	
	@SerializedName("DisplayMarketName")
	public String getDisplayMarketName() {
		return DisplayMarketName;
	}
	public void setDisplayMarketName(String displayMarketName) {
		this.DisplayMarketName = displayMarketName;
	}
	
	

}
