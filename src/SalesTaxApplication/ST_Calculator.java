package SalesTaxApplication;

import java.text.*;
import java.util.*;

/*
 * Sales Tax Calculator is an implementation of Calculator
 */
public class ST_Calculator<T> implements Calculator {

	private double taxrate;
	
	private double importTaxrate;
	
	private double total;
	
	private double totalTax;
	
	private ArrayList<T> items;
	
	public ST_Calculator(double taxrate, double importTaxrate) {
		this.setTax(taxrate,importTaxrate);
	}

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
	
	
	public double getTotal() {
		return total;
	}
	
	public double getSalesTaxTotal() {
		return totalTax;
	}

	@Override
	public void printTotal() {
		NumberFormat df = new DecimalFormat("#0.00");
		System.out.println("Sales Tax: "
				+df.format(totalTax)+"\n"
				+"Total: "+df.format(total));

	}

}
