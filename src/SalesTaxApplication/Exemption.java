package SalesTaxApplication;

import java.io.*;
import java.util.*;

public class Exemption {
	
	//loads exemptions from file
	public boolean checkExempt(String itemDescription) {
		File exemptFile = new File("exempt.txt");
		try {
			Scanner filescanner = new Scanner(exemptFile);
			while(filescanner.hasNextLine()) {
				String line = filescanner.nextLine();
				if(itemDescription.toLowerCase().contains(line.toLowerCase())) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	

}
