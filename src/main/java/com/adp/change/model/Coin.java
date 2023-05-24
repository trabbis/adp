package com.adp.change.model;

public class Coin {
	private String code;
	private Integer count;
	private Double coinValue;
	
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getCoinValue() {
		return coinValue;
	}

	public void setCoinValue(Double coinValue) {
		this.coinValue = coinValue;
	}

	public Double getTotalValue() {
		return getCount() * getCoinValue();
	}

	public Coin(String n, Integer b, Double v) {
		this.code = n;
		this.count = b;
		this.coinValue = v;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String name) {
		this.code = name;
	}

	@Override
	public String toString() {
		return "Coins [name=" + code + ", count=" + count + ", coinValue=" + coinValue + "]";
	}
	
	

}
