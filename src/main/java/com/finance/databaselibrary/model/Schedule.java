package com.finance.databaselibrary.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "schedule")
public class Schedule {

    @Id
    public ObjectId _id;

    private String symbol;

    private String function;

    private String interval;

    private String fromCurrency;

    private String toCurrency;

    private String market;

    public Schedule(ObjectId _id, String symbol, String function, String interval, String fromCurrency, String toCurrency, String market) {
        this._id = _id;
        this.symbol = symbol;
        this.function = function;
        this.interval = interval;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.market = market;
    }

    public ObjectId get_id() {
        return this._id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getInterval() {
        return this.interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getFromCurrency() {
        return this.fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return this.toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getMarket() {
        return this.market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
