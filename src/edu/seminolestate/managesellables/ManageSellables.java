package edu.seminolestate.managesellables;

/*
Author: Jason Kellie
Date: 11/04/17
*/

import edu.seminolestate.vehicle.*;
import edu.seminolestate.stock.*;
import edu.seminolestate.sellable.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageSellables {
	private static ArrayList<Sellable> sellables = new ArrayList<>();
	
	private static Scanner keyboard = new Scanner(System.in);
	private static final int ADD_STOCK = 1;
	private static final int ADD_TRUCK = 2;
	private static final int ADD_AUTOMOBILE = 3;
	private static final int DISPLAY_SALES = 4;
	private static final int EXIT = 5;

	public static void main(String[] args) {
		int choice = 0;
		do {
			choice = menu();
			switch (choice) {
			case ADD_STOCK:
				add_stock();
				break;
			case ADD_TRUCK:
				add_truck();
				break;
			case ADD_AUTOMOBILE:
				add_auto();
				break;
			case DISPLAY_SALES:
				display_sales();
				break;
			case EXIT:
				System.out.println("Thanks for using Sellables!");
			}
		} while (choice != EXIT);
		
	}

	public static int menu(){
		int menuChoice = 0;
		String input;
		do {
			System.out.println("Enter your choice: ");
			System.out.println(ADD_STOCK + ". Add a stock");
			System.out.println(ADD_TRUCK + ". Add a truck");
			System.out.println(ADD_AUTOMOBILE + ". Add an automobile");
			System.out.println(DISPLAY_SALES + ". List sales");
			System.out.println(EXIT + ". Exit");
			input = keyboard.nextLine();
			try{
				menuChoice = Integer.parseInt(input);
			}
			catch (NumberFormatException e) {
				System.out.println("Enter numeric values for menu choice");
				menuChoice = -1;
			}
			
			if (menuChoice < ADD_STOCK || menuChoice > EXIT){
				System.out.println("Invalid value. Enter a value between" + ADD_STOCK
						+ " and " + EXIT);
			}
		} while (menuChoice < ADD_STOCK || menuChoice > EXIT);
		return menuChoice;
	}
	
	private static void add_stock() {
		String certificateNumber = getString("Enter a certificate number: ");
		double numberOfShares = getDouble("Enter the number of shares: ");
		double pricePerShare = getDouble("Enter the price per share: ");
		LocalDate datePurchased = getDate("Enter the date purchased (like 8/9/1989): ");
		LocalDate dateSold = getDate("Enter the date sold (like 8/9/1989): ");
		Stock stock = null;
		try {
			stock = new Stock(certificateNumber, numberOfShares, pricePerShare, datePurchased, dateSold);
			sellables.add(stock);
		}
		catch (IllegalStockArgumentException e) {
			System.out.println("Couldn't create the Stock object but application will continue.");
			e.printStackTrace();
		}
	}
	
	private static void add_truck()	{
		String vin = getString("Enter the VIN: ");
		double purchasePrice = getDouble("Enter the purchase price: ");
		String make = getString("Enter the make of the truck: ");
		String model = getString("Enter the model of the truck: ");
		int modelYear = getInteger("Enter the model year of the truck: ");
		int mileage = getInteger("Enter the mileage of the truck: ");
		double cargoCapacity = getDouble("Enter the cargo capacity of the truck: ");
		double horsePower = getDouble("Enter the horse power of the truck: ");
		int numberOfAxles = getInteger("Enter the number of axles on the truck: ");
		Truck truck = null;
		try {
			truck = new Truck(vin, purchasePrice, make, model, modelYear, mileage, cargoCapacity, horsePower, numberOfAxles);
			sellables.add(truck);
		}
		catch (IllegalVehicleArgumentException e) {
			System.out.println("Couldn't create the Truck object but application will continue.");
			e.printStackTrace();
		}
	}
	
	private static void add_auto() {
		String vin = getString("Enter the VIN: ");
		double purchasePrice = getDouble("Enter the purchase price: ");
		String make = getString("Enter the make of the automobile: ");
		String model = getString("Enter the model of the automobile: ");
		int modelYear = getInteger("Enter the model year of the automobile: ");
		int mileage = getInteger("Enter the mileage of the automobile: ");
		int numberOfSeats = getInteger("Enter the number of seats in the automobile: ");
		Automobile auto = null;
		try {
			auto = new Automobile(vin, purchasePrice, make, model, modelYear, mileage, numberOfSeats);
			sellables.add(auto);
		}
		catch (IllegalVehicleArgumentException e) {
			System.out.println("Couldn't create the Automobile object but application will continue.");
			e.printStackTrace();
		}
	}
	
	private static void display_sales() {
		if (sellables.isEmpty()){
			System.out.println("There are no sellables.");
		} else {
			for (int i = 0; i < sellables.size(); i++){
				System.out.println((sellables.get(i)).toString());
				//if (sellables.get(i).getClass() == edu.seminolestate.stock.Stock.class) {
					System.out.printf("Sale Amount: $%6.2f", (sellables.get(i)).getSaleAmount());
					System.out.print("\n");
				//}
			}
		}	
	}
	
	public static  String getString(String prompt) {
		String userValue = null;
		do {
			System.out.println(prompt);
			userValue = keyboard.nextLine();
			if (userValue == null || userValue.length() < 1) {
				System.out.println("You must enter a value.");
			}
		} while (userValue == null || userValue.length() < 1); 
		
		return userValue;
	}
	
	public static double getDouble(String prompt) {
		String userValue = null;
		double validDouble = 0;
		boolean isValidDouble = false;
		do {
			System.out.println(prompt);
			try {
				userValue = keyboard.nextLine();
				validDouble = Double.parseDouble(userValue);
				if (validDouble > 0) {
					isValidDouble = true;
				}
				else {
					System.out.println("Enter a value > 0.");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Enter only decimal numbers.");
			}
		} while (! isValidDouble);
		
		return validDouble;
	}
	
	public static LocalDate getDate(String prompt) {		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		LocalDate validDate = null;
		boolean isValidDate = false;
		System.out.println(prompt);
		do {
			try {
				String userInput = keyboard.nextLine();
				validDate = LocalDate.parse(userInput, formatter);
				isValidDate = true;
			} catch (DateTimeParseException e) {
				System.out.println("You have entered an invalid date.");
				System.out.println("Enter a date (like 8/9/1989)");
			}
		} while (! isValidDate);
		return validDate;
	}
	
	public static int getInteger(String prompt) {
		String userValue = null;
		int validInteger = 0;
		boolean isValidInteger = false;
		do {
			System.out.println(prompt);
			try {
				userValue = keyboard.nextLine();
				validInteger = Integer.parseInt(userValue);
				if (validInteger > 0) {
					isValidInteger = true;
				}
				else {
					System.out.println("Enter a value > 0.");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Only enter numbers.");
			}
		} while (! isValidInteger);
		
		return validInteger;
	}

}
