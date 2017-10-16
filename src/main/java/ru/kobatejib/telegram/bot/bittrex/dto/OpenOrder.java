package ru.kobatejib.telegram.bot.bittrex.dto;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO for openOrders
 * Created by Kovatelj on 16.10.2017.
 */
public class OpenOrder {

    @SerializedName("Uuid")
    private String Uuid;

    @SerializedName("OrderUuid")
    private String OrderUuid;

    @SerializedName("Exchange")
    private String Exchange;

    @SerializedName("OrderType")
    private String OrderType;

    @SerializedName("Quantity")
    private Float Quantity;

    @SerializedName("QuantityRemaining")
    private Float QuantityRemaining;

    @SerializedName("Limit")
    private Float Limit;

    @SerializedName("CommissionPaid")
    private Float CommissionPaid;

    @SerializedName("Price")
    private Float Price;

    @SerializedName("PricePerUnit")
    private Float PricePerUnit;

    @SerializedName("Opened")
    private String Opened;

    @SerializedName("Closed")
    private String Closed;

    @SerializedName("CancelInitiated")
    private Boolean CancelInitiated;

    @SerializedName("ImmediateOrCancel")
    private Boolean ImmediateOrCancel;

    @SerializedName("IsConditional")
    private Boolean IsConditional;

    @SerializedName("Condition")
    private String Condition;

    @SerializedName("ConditionTarget")
    private String ConditionTarget;


    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        this.Uuid = uuid;
    }

    public String getOrderUuid() {
        return OrderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.OrderUuid = orderUuid;
    }

    public String getExchange() {
        return Exchange;
    }

    public void setExchange(String exchange) {
        this.Exchange = exchange;
    }

    public String getOrderType() {
        return OrderType;
    }

    public void setOrderType(String orderType) {
        this.OrderType = orderType;
    }

    public Float getQuantity() {
        return Quantity;
    }

    public void setQuantity(Float quantity) {
        this.Quantity = quantity;
    }

    public Float getQuantityRemaining() {
        return QuantityRemaining;
    }

    public void setQuantityRemaining(Float quantityRemaining) {
        this.QuantityRemaining = quantityRemaining;
    }

    public Float getLimit() {
        return Limit;
    }

    public void setLimit(Float limit) {
        this.Limit = limit;
    }

    public Float getCommissionPaid() {
        return CommissionPaid;
    }

    public void setCommissionPaid(Float commissionPaid) {
        this.CommissionPaid = commissionPaid;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        this.Price = price;
    }

    public Float getPricePerUnit() {
        return PricePerUnit;
    }

    public void setPricePerUnit(Float pricePerUnit) {
        this.PricePerUnit = pricePerUnit;
    }

    public String getOpened() {
        return Opened;
    }

    public void setOpened(String opened) {
        this.Opened = opened;
    }

    public String getClosed() {
        return Closed;
    }

    public void setClosed(String closed) {
        this.Closed = closed;
    }

    public Boolean getCancelInitiated() {
        return CancelInitiated;
    }

    public void setCancelInitiated(Boolean cancelInitiated) {
        this.CancelInitiated = cancelInitiated;
    }

    public Boolean getImmediateOrCancel() {
        return ImmediateOrCancel;
    }

    public void setImmediateOrCancel(Boolean immediateOrCancel) {
        this.ImmediateOrCancel = immediateOrCancel;
    }

    public Boolean getConditional() {
        return IsConditional;
    }

    public void setConditional(Boolean conditional) {
        this.IsConditional = conditional;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String condition) {
        this.Condition = condition;
    }

    public String getConditionTarget() {
        return ConditionTarget;
    }

    public void setConditionTarget(String conditionTarget) {
        this.ConditionTarget = conditionTarget;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
