package ru.kobatejib.telegram.bot.bittrex.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.gson.annotations.SerializedName;

/**
 * Base class Response. First use for Summaries
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean success;
	private String message;
	private List<Summary> summaries = new ArrayList<Summary>();;

	@SerializedName("success")
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@SerializedName("message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@SerializedName("result")
	public List<Summary> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
