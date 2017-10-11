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

	@SerializedName("success")
	private Boolean success;
	@SerializedName("message")
	private String message;
	@SerializedName("result")
	private List<Summaries> summaries = new ArrayList<Summaries>();

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

	public List<Summaries> getSummaries() {
		return summaries;
	}

	public void setSummaries(List<Summaries> summaries) {
		this.summaries = summaries;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
