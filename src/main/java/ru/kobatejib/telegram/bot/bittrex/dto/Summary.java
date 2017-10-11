package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO класс отчет от bittrex
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Summary implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("MarketName")
	private String marketName;
	@SerializedName("High")
	private String high;
	@SerializedName("Low")
	private String low;
	@SerializedName("Volume")
	private String volume;
	@SerializedName("Last")
	private String last;
	@SerializedName("BaseVolume")
	private String baseVolume;
	@SerializedName("TimeStamp")
	private String timeStamp;
	@SerializedName("Bid")
	private String bid;
	@SerializedName("Ask")
	private String ask;
	@SerializedName("OpenBuyOrders")
	private String openBuyOrders;
	@SerializedName("OpenSellOrders")
	private String openSellOrders;
	@SerializedName("PrevDay")
	private String prevDay;
	@SerializedName("Created")
	private String created;
	@SerializedName("DisplayMarketName")
	private String displayMarketName;

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getBaseVolume() {
		return baseVolume;
	}

	public void setBaseVolume(String baseVolume) {
		this.baseVolume = baseVolume;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}

	public String getOpenBuyOrders() {
		return openBuyOrders;
	}

	public void setOpenBuyOrders(String openBuyOrders) {
		this.openBuyOrders = openBuyOrders;
	}

	public String getOpenSellOrders() {
		return openSellOrders;
	}

	public void setOpenSellOrders(String openSellOrders) {
		this.openSellOrders = openSellOrders;
	}

	public String getPrevDay() {
		return prevDay;
	}

	public void setPrevDay(String prevDay) {
		this.prevDay = prevDay;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDisplayMarketName() {
		return displayMarketName;
	}

	public void setDisplayMarketName(String displayMarketName) {
		this.displayMarketName = displayMarketName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marketName.hashCode();
		result = prime * result + high.hashCode();
		result = prime * result + low.hashCode();
		result = prime * result + volume.hashCode();
		result = prime * result + last.hashCode();
		result = prime * result + baseVolume.hashCode();
		result = prime * result + timeStamp.hashCode();
		result = prime * result + bid.hashCode();
		result = prime * result + ask.hashCode();
		result = prime * result + openBuyOrders.hashCode();
		result = prime * result + openSellOrders.hashCode();
		result = prime * result + prevDay.hashCode();
		result = prime * result + created.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Summary other = (Summary) obj;
		if (!marketName.equals(other.marketName))
			return false;
		if (!high.equals(other.high))
			return false;
		if (!low.equals(other.low))
			return false;
		if (!volume.equals(other.volume))
			return false;
		if (!last.equals(other.last))
			return false;
		if (!baseVolume.equals(other.baseVolume))
			return false;
		if (!timeStamp.equals(other.timeStamp))
			return false;
		if (!bid.equals(other.bid))
			return false;
		if (!ask.equals(other.ask))
			return false;
		if (!openBuyOrders.equals(other.openBuyOrders))
			return false;
		if (!openSellOrders.equals(other.openSellOrders))
			return false;
		if (!prevDay.equals(other.prevDay))
			return false;
		if (!created.equals(other.created))
			return false;
		return true;
	}
}
