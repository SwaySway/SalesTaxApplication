package SalesTaxApplication;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class salesTaxTest {

	@Test
	void test() {
		
		//Checking output 1
		ST_Calculator testSTC = new ST_Calculator(0.10, 0.05);
		ArrayList<ST_Item> st_Items = new ArrayList<>();
		st_Items.add(new ST_Item("1 book at 12.49"));
		st_Items.add(new ST_Item("1 music CD at 14.99"));
		st_Items.add(new ST_Item("1 chocolate bar at 0.85"));
		testSTC.addItems(st_Items);
		String salesTax = testSTC.getSalesTaxTotal();
		String totalAmount = testSTC.getTotal();
		String answerTax = "1.50";
		String answerTotal = "29.83";
		assertEquals(answerTax, salesTax);
		assertEquals(answerTotal, totalAmount);
		
		//Checking output 2
		testSTC = new ST_Calculator(0.10,0.05);
		st_Items = new ArrayList<>();
		st_Items.add(new ST_Item("1 imported box of chocolates at 10.00"));
		st_Items.add(new ST_Item("1 imported bottle of perfume at 47.50"));
		//make sure to clear calculator before adding new array of items
		testSTC.addItems(st_Items);
		salesTax = testSTC.getSalesTaxTotal();
		totalAmount = testSTC.getTotal();
		answerTax = "7.65";
		answerTotal = "65.15";
		assertEquals(answerTax, salesTax);
		assertEquals(answerTotal, totalAmount);
	}
	

}
