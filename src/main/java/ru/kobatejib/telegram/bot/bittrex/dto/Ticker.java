package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ticker implements Serializable{
	private String Bid;
	private String Ask;
	private String Last;
	
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
	
	@SerializedName("Last")
	public String getLast() {
		return Last;
	}
	public void setLast(String last) {
		this.Last = last;
	}
	
	
}