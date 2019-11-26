package com.finance.databaselibrary.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stockDetails")
public class StockDetails {

    @Id
    private ObjectId _id;

    private String symbol;

    private String chiefExecutiveOfficer;

    private String numberOfEmployees;

    private String headquarters;

    private String dateFounded;

    private String marketCap;

    private String priceEarningsRatio;

    private String dividendYield;

    private String averageVolume;

    private String todayHigh;

    private String todayLow;

    private String openPrice;

    private String volume;

    private String yearHigh;

    private String yearLow;

    public StockDetails(ObjectId _id, String symbol, String chiefExecutiveOfficer, String numberOfEmployees,
                        String headquarters, String dateFounded, String marketCap, String priceEarningsRatio,
                        String dividendYield, String averageVolume, String todayHigh, String todayLow,
                        String openPrice, String volume, String yearHigh, String yearLow) {
        this._id = _id;
        this.symbol = symbol;
        this.chiefExecutiveOfficer = chiefExecutiveOfficer;
        this.numberOfEmployees = numberOfEmployees;
        this.headquarters = headquarters;
        this.dateFounded = dateFounded;
        this.marketCap = marketCap;
        this.priceEarningsRatio = priceEarningsRatio;
        this.dividendYield = dividendYield;
        this.averageVolume = averageVolume;
        this.todayHigh = todayHigh;
        this.todayLow = todayLow;
        this.openPrice = openPrice;
        this.volume = volume;
        this.yearHigh = yearHigh;
        this.yearLow = yearLow;
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

    public String getChiefExecutiveOfficer() {
        return this.chiefExecutiveOfficer;
    }

    public void setChiefExecutiveOfficer(String chiefExecutiveOfficer) {
        this.chiefExecutiveOfficer = chiefExecutiveOfficer;
    }

    public String getNumberOfEmployees() {
        return this.numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getHeadquarters() {
        return this.headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getDateFounded() {
        return this.dateFounded;
    }

    public void setDateFounded(String dateFounded) {
        this.dateFounded = dateFounded;
    }

    public String getMarketCap() {
        return this.marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
    }

    public String getPriceEarningsRatio() {
        return this.priceEarningsRatio;
    }

    public void setPriceEarningsRatio(String priceEarningsRatio) {
        this.priceEarningsRatio = priceEarningsRatio;
    }

    public String getDividendYield() {
        return this.dividendYield;
    }

    public void setDividendYield(String dividendYield) {
        this.dividendYield = dividendYield;
    }

    public String getAverageVolume() {
        return this.averageVolume;
    }

    public void setAverageVolume(String averageVolume) {
        this.averageVolume = averageVolume;
    }

    public String getTodayHigh() {
        return this.todayHigh;
    }

    public void setTodayHigh(String todayHigh) {
        this.todayHigh = todayHigh;
    }

    public String getTodayLow() {
        return this.todayLow;
    }

    public void setTodayLow(String todayLow) {
        this.todayLow = todayLow;
    }

    public String getOpenPrice() {
        return this.openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getYearHigh() {
        return this.yearHigh;
    }

    public void setYearHigh(String yearHigh) {
        this.yearHigh = yearHigh;
    }

    public String getYearLow() {
        return this.yearLow;
    }

    public void setYearLow(String yearLow) {
        this.yearLow = yearLow;
    }
}