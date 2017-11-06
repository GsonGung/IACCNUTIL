package com.demo.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Corp {
    private Integer corpId;

    private String name;

    private String code;

    private String market;

    private BigDecimal currCapital;

    private String listingDate;

    private BigDecimal profitFour;

    private BigDecimal totalCapital;

    private String mgjzc;

    private String pinyin;

    private String stockType;

    private Byte status;

    private Byte state;

    public Integer getCorpId() {
        return corpId;
    }

    public void setCorpId(Integer corpId) {
        this.corpId = corpId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public BigDecimal getCurrCapital() {
        return currCapital;
    }

    public void setCurrCapital(BigDecimal currCapital) {
        this.currCapital = currCapital;
    }

    public String getListingDate() {
        return listingDate;
    }

    public void setListingDate(String listingDate) {
        this.listingDate = listingDate;
    }

    public BigDecimal getProfitFour() {
        return profitFour;
    }

    public void setProfitFour(BigDecimal profitFour) {
        this.profitFour = profitFour;
    }

    public BigDecimal getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(BigDecimal totalCapital) {
        this.totalCapital = totalCapital;
    }

    public String getMgjzc() {
        return mgjzc;
    }

    public void setMgjzc(String mgjzc) {
        this.mgjzc = mgjzc;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}