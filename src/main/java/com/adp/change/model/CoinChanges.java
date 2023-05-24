package com.adp.change.model;

public class Changes {
	private Coin c25Cents;
	private Coin c10Cents;
	private Coin c05Cents;
	private Coin c01Cents;

	public Changes() {
		c25Cents = new Coin("c25", 0, 0.25d);
		c10Cents = new Coin("c10", 0, 0.10d);
		c05Cents = new Coin("c05", 0, 0.05d);
		c01Cents = new Coin("c01", 0, 0.01d);
	}

	public Coin getC25Cents() {
		return c25Cents;
	}

	public void setC25Cents(Coin c25Cents) {
		this.c25Cents = c25Cents;
	}

	public Coin getC10Cents() {
		return c10Cents;
	}

	public void setC10Cents(Coin c10Cents) {
		this.c10Cents = c10Cents;
	}

	public Coin getC05Cents() {
		return c05Cents;
	}

	public void setC05Cents(Coin c05Cents) {
		this.c05Cents = c05Cents;
	}

	public Coin getC01Cents() {
		return c01Cents;
	}

	public void setC01Cents(Coin c01Cents) {
		this.c01Cents = c01Cents;
	}

	@Override
	public String toString() {
		return "Changes [c25Cents=" + c25Cents + ", c10Cents=" + c10Cents + ", c05Cents=" + c05Cents + ", c01Cents="
				+ c01Cents + "]";
	}
	

	
	

	
	
}
