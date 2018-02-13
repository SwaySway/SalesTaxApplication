package SalesTaxApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class ST_Application<T> {
	
	//variables
	private Scanner kb;
	
	private double taxrate;
	
	private double import_taxrate;
	
	private Calculator salestaxCalc;
	
	private ArrayList<ST_Item> st_Items;
	
	private Filter pw;
	
	public ST_Application(double taxrate, double import_taxrate) {
		this.taxrate = taxrate;
		this.import_taxrate = import_taxrate;
	}

	public void intialprompt() {
		String prompt = "Welcome! Add items to the cart!"
				+ "\nEnter 'checkout' when done!"
				+ "\nType 'change' to change the tax rates";
		
		System.out.println(prompt);
		start();
	}
	
	public void start() {
				String input = null;
				kb = new Scanner(System.in);
				salestaxCalc = new ST_Calculator(taxrate, import_taxrate);
				st_Items = new ArrayList<>();
				pw = new Filter();
				input  = kb.nextLine();
				boolean flip = true;
				
				if(input.equalsIgnoreCase("checkout") && st_Items.size() < 1) {
					System.out.println("Please enter an item in the cart before checkout!");
					start();
				}
				else {
					while(flip){
						if(input.equalsIgnoreCase("checkout")){
							flip = false;
							break;
						}
						String currentItem = input;
						//checkKet uses the check method on current entered item
						if(pw.checkKeywords(currentItem)) {
							st_Items.add(new ST_Item(currentItem));
						}
						input = kb.nextLine();
					}
					
				}
				if(input.equalsIgnoreCase("change")) {
					changeTax();
				}
				
				if(!flip) {
					salestaxCalc.addItems(st_Items);
				}

	}

	private void changeTax() {
		kb = new Scanner(System.in);
		try {
			System.out.println("Enter sales tax rate below:\n");
			taxrate = kb.nextDouble();
			System.out.println("Enter import tax rate below:\n");
			import_taxrate = kb.nextDouble();
			start();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
