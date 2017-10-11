package ru.kobatejib.telegram.bot.bittrex.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;


/**
 * DTO обертка для ответа от bittrex
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("success")
	private Boolean success;
	@SerializedName("message")
	private String message;
	@SerializedName("result")
	private T result;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
