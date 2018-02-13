package SalesTaxApplication;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ST_Item implements Item {
	
	private Filter itemFilter = new Filter();
	private int quantity;
	private String itemDescription;
	private double price = 0;
	private double totaltax = 0;
	private Exemption exempt = new Exemption();
	
	public ST_Item(String item) {
		parseItem(item);
		price = price * quantity;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getItem() {
		// TODO Auto-generated method stub
		return itemDescription;
	}

	@Override
	public void addTax(double taxRate) {
		totaltax += taxRate;
	}
	
	public void calcTax() {
		double totaltaxpercent = price * totaltax;
		totaltaxpercent = (double) Math.round(totaltaxpercent * 20) / 20.0;
		price = price + totaltaxpercent;
		totaltax = totaltaxpercent;
	}
	public boolean checkImport() {
		if(itemDescription.contains("import")) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		NumberFormat df = new DecimalFormat("#0.00");
		String result = quantity 
				+ " "+itemDescription
				+": "
				+df.format(price);
		return result;
	}
	
	/*
	 * parseItem serves as a setter
	 * for the quantity, item description,
	 * and price
	 */
	private void parseItem(String item) {
		ItemData result = itemFilter.parse(item);
		quantity = (Integer) result.getFirst();
		itemDescription = (String)result.getSecond();
		price = (double) result.getThird();
	}

	public boolean checkExempt() {
		return exempt.checkExempt(itemDescription);
	}

	public double getTax() {
		// TODO Auto-generated method stub
		totaltax = (double) Math.round(totaltax * 20) / 20.0;
		return totaltax;
	}

}
