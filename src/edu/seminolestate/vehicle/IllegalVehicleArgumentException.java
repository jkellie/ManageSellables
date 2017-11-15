package edu.seminolestate.vehicle;

/*
Author: Jason Kellie
Date: 11/04/17
*/

public class IllegalVehicleArgumentException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IllegalVehicleArgumentException() {
		super("Invalid values sent to method");
	}
	
	public IllegalVehicleArgumentException(String message) {
		super(message);
	}

}
