package edu.seminolestate.stock;

/*
Author: Jason Kellie
Date: 11/04/17
*/

import java.time.LocalDate;
import edu.seminolestate.sellable.Sellable;

public class Stock implements Sellable {
	
	private String certificateNumber;
	private double numberOfShares;
	private double pricePerShare;
	private LocalDate datePurchased;
	private LocalDate dateSold;
	
	public Stock(String certificateNumber, double pricePerShare, double numberOfShares,
			LocalDate datePurchased, LocalDate dateSold) throws IllegalStockArgumentException {
		this.setCertificateNumber(certificateNumber);
		this.setPricePerShare(pricePerShare);
		this.setNumberOfShares(numberOfShares);
		this.setDatePurchased(datePurchased);
		this.setDateSold(dateSold);
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}
	public void setCertificateNumber(String certificateNumber) throws IllegalStockArgumentException {
		if (certificateNumber != null || certificateNumber.length() > 0)
			this.certificateNumber = certificateNumber;
		else
			throw new
			IllegalStockArgumentException("You must enter a certificate number");
	}

	public double getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(double numberOfShares) throws IllegalStockArgumentException {
		if (numberOfShares > 0)
			this.numberOfShares = numberOfShares;
		else
			throw new
			IllegalStockArgumentException("You must enter at least one share");
	}

	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) throws IllegalStockArgumentException {
		if (pricePerShare > 0)
			this.pricePerShare = pricePerShare;
		else
			throw new
			IllegalStockArgumentException("The price per share must be greater than zero");
	}

	public LocalDate getDatePurchased() {
		return datePurchased;
	}
	public void setDatePurchased(LocalDate datePurchased) throws IllegalStockArgumentException {
		if (datePurchased != null)
			this.datePurchased = datePurchased;
		else
			throw new
			IllegalStockArgumentException("You must enter a purchase date.");
	}

	public LocalDate getDateSold() {
		return dateSold;
	}
	public void setDateSold(LocalDate dateSold) {
		this.dateSold = dateSold;
	}

	@Override
	public double getSaleAmount() {
		//check to make sure the () are needed on this
		return (numberOfShares * pricePerShare);
	}
	
	@Override
	public String toString() {
		return getClass() + " [certificateNumber=" + certificateNumber + ", "
				+ "numberOfShares=" + numberOfShares + ", "
				+ "pricePerShare=" + pricePerShare + ", "
				+ "datePurchased=" + datePurchased + ", "
				+ "dateSold=" + dateSold + "]";
	}

}
