package SalesTaxApplication;

import java.text.*;
import java.util.*;

/*
 * Sales Tax Calculator is an implementation of Calculator
 */
public class ST_Calculator<T> implements Calculator {

	//variables
	private double taxrate;
	
	private double importTaxrate;
	
	private double total;
	
	private double totalTax;
	
	//constructor for the class
	public ST_Calculator(double taxrate, double importTaxrate) {
		this.setTax(taxrate,importTaxrate);
	}

	//setter for the class
	private void setTax(double taxrate, double importTaxrate) {
		this.taxrate = taxrate;
		this.importTaxrate = importTaxrate;
	}

	//adds a generic list of items
	@Override
	public <T> void addItems(ArrayList<T> items) {
		
		ST_Item currentItem = null;
		for(T item : items) {
			currentItem = (ST_Item) item;
			if(currentItem.checkImport()) {
				currentItem.addTax(importTaxrate);
			}
			if(!currentItem.checkExempt()) {
				currentItem.addTax(taxrate);
			}
			currentItem.calcTax();
			System.out.println(currentItem);
			totalTax += currentItem.getTax();
			total += currentItem.getPrice();
		}
		printTotal();
	}
	
	//returns total
	public String getTotal() {
		NumberFormat df = new DecimalFormat("#0.00");
		return df.format(total);
	}
	
	//returns total sales tax
	public String getSalesTaxTotal() {
		NumberFormat df = new DecimalFormat("#0.00");
		return df.format(totalTax);
	}

	//prints total at the end
	@Override
	public void printTotal() {
		NumberFormat df = new DecimalFormat("#0.00");
		System.out.println("Sales Tax: "
				+df.format(totalTax)+"\n"
				+"Total: "+df.format(total));

	}

	//Clears the variables in calculator
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		taxrate = 0;
		importTaxrate = 0;
		total = 0;
		totalTax = 0;
		
	}

}
