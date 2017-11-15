package edu.seminolestate.vehicle;

/*
Author: Jason Kellie
Date: 11/04/17
*/

import edu.seminolestate.sellable.Sellable;

public abstract class Vehicle implements Sellable {
	
	private String vin;
	private double purchasePrice;
	private String make;
	private String model;
	private int modelYear;
	private int mileage;
	
	public Vehicle(String vin, double purchasePrice, String make, String model, int modelYear,
			int mileage) throws IllegalVehicleArgumentException {
		this.setVin(vin);
		this.setPurchasePrice(purchasePrice);
		this.setMake(make);
		this.setModel(model);
		this.setModelYear(modelYear);
		this.setMileage(mileage);
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) throws IllegalVehicleArgumentException {
		if (vin != null || vin.length() > 0)
			this.vin = vin;
		else
			throw new
			IllegalVehicleArgumentException("You must enter a VIN number");
	}
	
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) throws IllegalVehicleArgumentException {
		if (purchasePrice > 0)
			this.purchasePrice = purchasePrice;
		else
			throw new
			IllegalVehicleArgumentException("The purchase price must be greater than zero");
	}
	
	public String getMake() { 
		return make;
	}
	public void setMake(String make) throws IllegalVehicleArgumentException {
		if (make != null || make.length() > 0)
			this.make = make;
		else
			throw new
			IllegalVehicleArgumentException("You must enter the vehical make");
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) throws IllegalVehicleArgumentException {
		if (model != null || model.length() > 0)
			this.model = model;
		else
			throw new
			IllegalVehicleArgumentException("You must enter the model of the vehical");
	}
	
	public int getModelYear() {
		return modelYear;
	}
	public void setModelYear(int modelYear) throws IllegalVehicleArgumentException {
		if (modelYear > 0)
			this.modelYear = modelYear;
		else
			throw new
			IllegalVehicleArgumentException("The year must be greater than zero");
	}
	
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) throws IllegalVehicleArgumentException {
		if (mileage > 0)
			this.mileage = mileage;
		else
			throw new
			IllegalVehicleArgumentException("The mileage must be greater than zero");
	}
	
	@Override
	public String toString() {
		return getClass() + " [vin=" + vin + ", "
				+ "purchasePrice=" + purchasePrice + ", "
				+ "make=" + make + ", "
				+ "model=" + model + ", "
				+ "modelYear=" + modelYear + ", "
				+ "mileage=" + mileage + "]";
	}

}
