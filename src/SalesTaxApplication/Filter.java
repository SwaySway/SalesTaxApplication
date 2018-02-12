package SalesTaxApplication;

public class Filter {
	
	public String item;
	
	public Filter() {
		//nothing to intialize 
	}
	
	@SuppressWarnings("unused")
	public boolean checkKeywords(String item) {
		String[] arr = item.split(" ");
		try {
			/*
			 * If the integer type cannot be created
			 * for quantity and price then an exception
			 * will be thrown
			 */
			int qty = Integer.valueOf(arr[0]);
			double price = Double.parseDouble(arr[arr.length-1].trim());
			if(!item.contains(" at ")) {
				throw new KeywordMissingException("Please enter the correct format!");
			}
			
			return true;
			
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ItemData parse(String item) {
	try {
		/*
		 * First the method splits the quantity from the rest
		 */
		String temp  = item;
		int quantity = Integer.valueOf(temp.substring(0, temp.indexOf(' ')));
		String remainingItem = temp.substring(temp.indexOf(' ')+1);
		item = remainingItem.trim();
		/*
		 * Afterwards the remaining description
		 * is split into a regular expression between the keyword 'at'
		 */
		String[] arr = item.split(" at ");
		
		String itemDescription = arr[0].trim();
		
		double price = Double.parseDouble(arr[1].trim());
		
		return new ItemData(quantity, itemDescription, price);
	}catch(Exception e) {
		System.out.println("Error parsing: "+e);
		return null;
	}
		
	}
}
