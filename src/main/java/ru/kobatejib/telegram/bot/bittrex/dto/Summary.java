package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO for Summary
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Summary implements Serializable {

	private static final long serialVersionUID = 1L;

	private String marketName;
	private String high;
	private String low;
	private String volume;
	private String last;
	private String baseVolume;
	private String timeStamp;
	private String bid;
	private String ask;
	private String openBuyOrders;
	private String openSellOrders;
	private String prevDay;
	private String created;
	private String displayMarketName;

	@SerializedName("MarketName")
	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	@SerializedName("High")
	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	@SerializedName("Low")
	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	@SerializedName("Volume")
	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	@SerializedName("Last")
	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	@SerializedName("BaseVolume")
	public String getBaseVolume() {
		return baseVolume;
	}

	public void setBaseVolume(String baseVolume) {
		this.baseVolume = baseVolume;
	}

	@SerializedName("TimeStamp")
	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

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

	@SerializedName("OpenBuyOrders")
	public String getOpenBuyOrders() {
		return openBuyOrders;
	}

	public void setOpenBuyOrders(String openBuyOrders) {
		this.openBuyOrders = openBuyOrders;
	}

	@SerializedName("OpenSellOrders")
	public String getOpenSellOrders() {
		return openSellOrders;
	}

	public void setOpenSellOrders(String openSellOrders) {
		this.openSellOrders = openSellOrders;
	}

	@SerializedName("PrevDay")
	public String getPrevDay() {
		return prevDay;
	}

	public void setPrevDay(String prevDay) {
		this.prevDay = prevDay;
	}

	@SerializedName("Created")
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	@SerializedName("DisplayMarketName")
	public String getDisplayMarketName() {
		return displayMarketName;
	}

	public void setDisplayMarketName(String displayMarketName) {
		this.displayMarketName = displayMarketName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
