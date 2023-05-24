package com.adp.change.exceptions;

public class CoinNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8737854847508358767L;
	
	public CoinNotExistException(String msg) {
		super(msg);
	}

}
