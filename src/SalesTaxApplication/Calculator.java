package SalesTaxApplication;

import java.util.*;

public interface Calculator {
	
	public <T> void addItems(ArrayList<T> items);
	
	public void clear();
	
	public void printTotal();

}
