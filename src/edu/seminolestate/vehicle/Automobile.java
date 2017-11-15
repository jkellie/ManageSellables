package edu.seminolestate.vehicle;

/*
Author: Jason Kellie
Date: 11/04/17
*/

import java.time.LocalDate;

public class Automobile extends Vehicle {
	private int numberOfSeats;
	private double saleAmount;

	public Automobile(String vin, double purchasePrice, String make, String model, int modelYear,
			int mileage, int numberOfSeats) throws IllegalVehicleArgumentException {
		super(vin, purchasePrice, make, model, modelYear, mileage);
		this.setNumberOfSeats(numberOfSeats);
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) throws IllegalVehicleArgumentException {
		if (numberOfSeats > 0)
			this.numberOfSeats = numberOfSeats;
		else
			throw new
			IllegalVehicleArgumentException("Number of seats must be greater than zero");
	}

	@Override
	public double getSaleAmount() {
		double purchasePrice = this.getPurchasePrice();
		int modelYear = this.getModelYear();
		int currentYear = LocalDate.now().getYear();
		int saleYear = currentYear - modelYear;
		double originalSalePrice = purchasePrice * .85;
		double newPrice = originalSalePrice;
		
		if (saleYear > 0) {
			for (int i = 1; i <= saleYear; i++) {
				newPrice = newPrice * .91;
			}
			saleAmount = newPrice;
		}
		else
			saleAmount = originalSalePrice;
		
		return saleAmount;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " +
				getClass() + " [numberOfSeats=" + numberOfSeats + "]";
	}
}
