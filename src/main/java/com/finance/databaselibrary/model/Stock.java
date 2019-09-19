package com.finance.databaselibrary.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stocks")
public class Stock {

    @Id
    public ObjectId _id;

    private String symbol;

    private String timestamp;

    private float open;

    private float high;

    private float low;

    private float close;

    private int volume;

    public Stock(ObjectId _id, String symbol, String timestamp, float open, float high, float low, float close, int volume) {
        this._id = _id;
        this.symbol = symbol;
        this.timestamp = timestamp;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    public String get_id() {
        return this._id.toHexString();
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

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public float getOpen() {
        return this.open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getHigh() {
        return this.high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return this.low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getClose() {
        return this.close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
