package edu.seminolestate.stock;

/*
Author: Jason Kellie
Date: 11/04/17
*/

public class IllegalStockArgumentException extends Exception {
	
	public IllegalStockArgumentException() {
		super("Invalid values sent to method");
	}
	
	public IllegalStockArgumentException(String message) {
		super(message);
	}

}
