package SalesTaxApplication;

public interface Item {

	public int getQuantity();
	
	public double getPrice();
	
	public String getItem();
	
	public void addTax(double tax);
}
