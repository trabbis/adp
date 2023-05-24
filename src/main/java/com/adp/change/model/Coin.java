package com.adp.change.model;

public class Coin {
	private String name;
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
		this.name = n;
		this.count = b;
		this.coinValue = v;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Coins [name=" + name + ", count=" + count + ", coinValue=" + coinValue + "]";
	}
	
	

}
