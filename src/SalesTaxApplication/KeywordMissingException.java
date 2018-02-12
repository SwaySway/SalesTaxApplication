package SalesTaxApplication;

public class KeywordMissingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//custom exception because it is missing the 'at' keyword
	public KeywordMissingException(String message) {
		super(message);
	}

}
