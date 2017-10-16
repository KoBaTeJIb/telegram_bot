package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Kovatelj
 * 
 * DTO класс заявок на bittrex
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Ticker implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("Bid")
	private Float bid;
	@SerializedName("Ask")
	private Float ask;
	@SerializedName("Last")
	private Float last;

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

	public Float getLast() {
		return last;
	}

	public void setLast(Float last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bid.hashCode();
		result = prime * result + ask.hashCode();
		result = prime * result + last.hashCode();
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
		Ticker other = (Ticker) obj;
		if (!bid.equals(other.bid))
			return false;
		if (!ask.equals(other.ask))
			return false;
		if (!last.equals(other.last))
			return false;
		return true;
	}

}