package edu.seminolestate.vehicle;

/*
Author: Jason Kellie
Date: 11/04/17
*/

import java.time.LocalDate;

public class Truck extends Vehicle {
	
	private double cargoCapacity;
	private double horsePower;
	private int numberOfAxles;
	private double saleAmount;
	
	public Truck(String vin, double purchasePrice, String make, String model, int modelYear, int mileage,
			double cargoCapacity, double horsePower, int numberOfAxles)
					throws IllegalVehicleArgumentException {
		super(vin, purchasePrice, make, model, modelYear, mileage);
		this.setCargoCapacity(cargoCapacity);
		this.setHorsePower(horsePower);
		this.setNumberOfAxles(numberOfAxles);
	}
	
	public double getCargoCapacity() {
		return cargoCapacity;
	}
	public void setCargoCapacity(double cargoCapacity) throws IllegalVehicleArgumentException {
		if (cargoCapacity > 0 )
			this.cargoCapacity = cargoCapacity;
		else
			throw new
			IllegalVehicleArgumentException("Cargo capacity must be greater than zero");
	}
	
	public double getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(double horsePower) throws IllegalVehicleArgumentException {
		if (horsePower > 0)
			this.horsePower = horsePower;
		else
			throw new
			IllegalVehicleArgumentException("Horse power must be greater than zero");
	}
	
	public int getNumberOfAxles() {
		return numberOfAxles;
	}
	public void setNumberOfAxles(int numberOfAxles) throws IllegalVehicleArgumentException {
		if (numberOfAxles > 0)
			this.numberOfAxles = numberOfAxles;
		else
			throw new
			IllegalVehicleArgumentException("The number of axles must be greater than zero");
	}

	@Override
	public double getSaleAmount() {
		double purchasePrice = this.getPurchasePrice();
		int modelYear = this.getModelYear();
		int currentYear = LocalDate.now().getYear();
		int saleYear = currentYear - modelYear;
		double originalSalePrice = purchasePrice * .9;
		double newPrice = originalSalePrice;
		
		if (saleYear > 0) {
			for (int i = 1; i <= saleYear; i++) {
				newPrice = newPrice * .96;
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
				getClass() + " [cargoCapacity=" + cargoCapacity + ", "
				+ "horsePower=" + horsePower + ", "
				+ "numberOfAxles=" + numberOfAxles + ", "
				+ "saleAmount=" + saleAmount + "]";
	}

}
