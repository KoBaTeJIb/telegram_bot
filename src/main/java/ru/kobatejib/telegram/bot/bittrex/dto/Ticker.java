package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Ticker implements Serializable{

	private static final long serialVersionUID = 1L;

	private String bid;
	private String ask;
	private String last;
	
	@SerializedName("Bid")
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	@SerializedName("Ask")
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	
	@SerializedName("Last")
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	
	
}