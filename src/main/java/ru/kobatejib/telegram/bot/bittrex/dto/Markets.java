package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * DTO for Markets
 * Created by Kovatelj on 11.10.2017.
 */
public class Markets implements Serializable{

    private static final long serialVersionUID = 1L;

    @SerializedName("MarketCurrency")
    private String MarketCurrency;

    @SerializedName("BaseCurrency")
    private String BaseCurrency;

    @SerializedName("MarketCurrencyLong")
    private String MarketCurrencyLong;

    @SerializedName("BaseCurrencyLong")
    private String BaseCurrencyLong;

    @SerializedName("MinTradeSize")
    private Double MinTradeSize;

    @SerializedName("MarketName")
    private String MarketName;

    @SerializedName("IsActive")
    private Boolean IsActive;

    @SerializedName("Created")
    private String Created;

    @SerializedName("Notice")
    private String Notice;

    @SerializedName("IsSponsored")
    private String IsSponsored;

    @SerializedName("LogoUrl")
    private String LogoUrl;


    public String getMarketCurrency() {
        return MarketCurrency;
    }

    public void setMarketCurrency(String marketCurrency) {
        this.MarketCurrency = marketCurrency;
    }

    public String getBaseCurrency() {
        return BaseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.BaseCurrency = baseCurrency;
    }

    public String getMarketCurrencyLong() {
        return MarketCurrencyLong;
    }

    public void setMarketCurrencyLong(String marketCurrencyLong) {
        this.MarketCurrencyLong = marketCurrencyLong;
    }

    public String getBaseCurrencyLong() {
        return BaseCurrencyLong;
    }

    public void setBaseCurrencyLong(String baseCurrencyLong) {
        this.BaseCurrencyLong = baseCurrencyLong;
    }

    public Double getMinTradeSize() {
        return MinTradeSize;
    }

    public void setMinTradeSize(Double minTradeSize) {
        this.MinTradeSize = minTradeSize;
    }

    public String getMarketName() {
        return MarketName;
    }

    public void setMarketName(String marketName) {
        this.MarketName = marketName;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        this.IsActive = active;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        this.Created = created;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        this.Notice = notice;
    }

    public String getIsSponsored() {
        return IsSponsored;
    }

    public void setIsSponsored(String isSponsored) {
        this.IsSponsored = isSponsored;
    }

    public String getLogoUrl() {
        return LogoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.LogoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
