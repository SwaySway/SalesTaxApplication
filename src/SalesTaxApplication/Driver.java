package SalesTaxApplication;

public class Driver {

	/*
	 * Initial program starts the application
	 * 
	 */
	public static void main(String[] args) {
		//enter tax percentages in whole numbers
		ST_Application st_app = new ST_Application(0.10,0.5);
		st_app.intialprompt();
	}
}
