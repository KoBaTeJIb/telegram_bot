package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * DTO for Curriency
 * Created by Kovatelj on 11.10.2017.
 */
public class Currencies implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("Currency")
    private String Currency;

    @SerializedName("CurrencyLong")
    private String CurrencyLong;

    @SerializedName("MinConfirmation")
    private int MinConfirmation;

    @SerializedName("TxFee")
    private Double TxFee;

    @SerializedName("IsActive")
    private Boolean IsActive;

    @SerializedName("CoinType")
    private String CoinType;

    @SerializedName("BaseAddress")
    private String BaseAddress;

    @SerializedName("Notice")
    private String Notice;



    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        this.Currency = currency;
    }

    public String getCurrencyLong() {
        return CurrencyLong;
    }

    public void setCurrencyLong(String currencyLong) {
        this.CurrencyLong = currencyLong;
    }

    public int getMinConfirmation() {
        return MinConfirmation;
    }

    public void setMinConfirmation(int minConfirmation) {
        this.MinConfirmation = minConfirmation;
    }

    public Double getTxFee() {
        return TxFee;
    }

    public void setTxFee(Double txFee) {
        this.TxFee = txFee;
    }

    public Boolean getActive() {
        return IsActive;
    }

    public void setActive(Boolean active) {
        this.IsActive = active;
    }

    public String getCoinType() {
        return CoinType;
    }

    public void setCoinType(String coinType) {
        this.CoinType = coinType;
    }

    public String getBaseAddress() {
        return BaseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.BaseAddress = baseAddress;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        this.Notice = notice;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
