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
public class Summaries implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("MarketName")
	private String marketName;
	@SerializedName("High")
	private Float high;
	@SerializedName("Low")
	private Float low;
	@SerializedName("Volume")
	private Float volume;
	@SerializedName("Last")
	private Float last;
	@SerializedName("BaseVolume")
	private Float baseVolume;
	@SerializedName("TimeStamp")
	private String timeStamp;
	@SerializedName("Bid")
	private Float bid;
	@SerializedName("Ask")
	private Float ask;
	@SerializedName("OpenBuyOrders")
	private Integer openBuyOrders;
	@SerializedName("OpenSellOrders")
	private Integer openSellOrders;
	@SerializedName("PrevDay")
	private Float prevDay;
	@SerializedName("Created")
	private String created;


	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public Float getHigh() {
		return high;
	}

	public void setHigh(Float high) {
		this.high = high;
	}


	public Float getLow() {
		return low;
	}

	public void setLow(Float low) {
		this.low = low;
	}


	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}


	public Float getLast() {
		return last;
	}

	public void setLast(Float last) {
		this.last = last;
	}


	public Float getBaseVolume() {
		return baseVolume;
	}

	public void setBaseVolume(Float baseVolume) {
		this.baseVolume = baseVolume;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}


	public Float getBid() {
		return bid;
	}

	public void setBid(Float bid) {
		this.bid = bid;
	}


	public Float getAsk() {
		return ask;
	}

	public void setAsk(Float ask) {
		this.ask = ask;
	}


	public Integer getOpenBuyOrders() {
		return openBuyOrders;
	}

	public void setOpenBuyOrders(Integer openBuyOrders) {
		this.openBuyOrders = openBuyOrders;
	}

	public Integer getOpenSellOrders() {
		return openSellOrders;
	}

	public void setOpenSellOrders(Integer openSellOrders) {
		this.openSellOrders = openSellOrders;
	}

	public Float getPrevDay() {
		return prevDay;
	}

	public void setPrevDay(Float prevDay) {
		this.prevDay = prevDay;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
