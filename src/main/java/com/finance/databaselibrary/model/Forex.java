package com.finance.databaselibrary.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "forex")
public class Forex {

    @Id
    public ObjectId _id;

    private String fromCurrencySymbol;

    private String toCurrencySymbol;

    private String timestamp;

    private String fromCurrencyName;

    private String toCurrencyName;

    private float exchangeRate;

    private float bidPrice;

    private float askPrice;

    public Forex(ObjectId _id, String fromCurrencySymbol, String toCurrencySymbol, String timestamp, String fromCurrencyName, String toCurrencyName, float exchangeRate, float bidPrice, float askPrice) {
        this._id = _id;
        this.fromCurrencySymbol = fromCurrencySymbol;
        this.toCurrencySymbol = toCurrencySymbol;
        this.timestamp = timestamp;
        this.fromCurrencyName = fromCurrencyName;
        this.toCurrencyName = toCurrencyName;
        this.exchangeRate = exchangeRate;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
    }

    public ObjectId get_id() {
        return this._id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFromCurrencySymbol() {
        return this.fromCurrencySymbol;
    }

    public void setFromCurrencySymbol(String fromCurrencySymbol) {
        this.fromCurrencySymbol = fromCurrencySymbol;
    }

    public String getToCurrencySymbol() {
        return this.toCurrencySymbol;
    }

    public void setToCurrencySymbol(String toCurrencySymbol) {
        this.toCurrencySymbol = toCurrencySymbol;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFromCurrencyName() {
        return this.fromCurrencyName;
    }

    public void setFromCurrencyName(String fromCurrencyName) {
        this.fromCurrencyName = fromCurrencyName;
    }

    public String getToCurrencyName() {
        return this.toCurrencyName;
    }

    public void setToCurrencyName(String toCurrencyName) {
        this.toCurrencyName = toCurrencyName;
    }

    public float getExchangeRate() {
        return this.exchangeRate;
    }

    public void setExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public float getBidPrice() {
        return this.bidPrice;
    }

    public void setBidPrice(float bidPrice) {
        this.bidPrice = bidPrice;
    }

    public float getAskPrice() {
        return this.askPrice;
    }

    public void setAskPrice(float askPrice) {
        this.askPrice = askPrice;
    }
}
