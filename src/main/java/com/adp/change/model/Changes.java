package com.adp.change.model;

public class Changes {
	private Coins c25Cents;
	private Coins c10Cents;
	private Coins c05Cents;
	private Coins c01Cents;

	public Changes() {
		c25Cents = new Coins("c25", 0, 0.25d);
		c10Cents = new Coins("c10", 0, 0.10d);
		c05Cents = new Coins("c05", 0, 0.05d);
		c01Cents = new Coins("c01", 0, 0.01d);
	}

	public Coins getC25Cents() {
		return c25Cents;
	}

	public void setC25Cents(Coins c25Cents) {
		this.c25Cents = c25Cents;
	}

	public Coins getC10Cents() {
		return c10Cents;
	}

	public void setC10Cents(Coins c10Cents) {
		this.c10Cents = c10Cents;
	}

	public Coins getC05Cents() {
		return c05Cents;
	}

	public void setC05Cents(Coins c05Cents) {
		this.c05Cents = c05Cents;
	}

	public Coins getC01Cents() {
		return c01Cents;
	}

	public void setC01Cents(Coins c01Cents) {
		this.c01Cents = c01Cents;
	}

	@Override
	public String toString() {
		return "Changes [c25Cents=" + c25Cents + ", c10Cents=" + c10Cents + ", c05Cents=" + c05Cents + ", c01Cents="
				+ c01Cents + "]";
	}
	

	
	

	
	
}
