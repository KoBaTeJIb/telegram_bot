package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * DTO for MarketHistory
 * Created by Kovatelj on 11.10.2017.
 */
public class MarketHistory implements Serializable{
    private static final long serialVersionUID = 1L;

    @SerializedName("Id")
    private Integer Id;

    @SerializedName("TimeStamp")
    private String TimeStamp;

    @SerializedName("Quantity")
    private Float Quantity;

    @SerializedName("Price")
    private Float Price;

    @SerializedName("Total")
    private Float Total;

    @SerializedName("FillType")
    private String FillType;

    @SerializedName("OrderType")
    private String OrderType;



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.TimeStamp = timeStamp;
    }

    public Float getQuantity() {
        return Quantity;
    }

    public void setQuantity(Float quantity) {
        this.Quantity = quantity;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        this.Price = price;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float total) {
        this.Total = total;
    }

    public String getFillType() {
        return FillType;
    }

    public void setFillType(String fillType) {
        this.FillType = fillType;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        this.OrderType = orderType;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
