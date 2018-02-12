package SalesTaxApplication;

//class can support 2-3 objects inside one
public class ItemData <T>{

	private T first;
	private T second;
	private T third;
	
	public ItemData(T first, T second) {
		this.setFirst(first);
		this.setSecond(second);
	}
	
	public ItemData(T first, T second, T third) {
		this(first, second);
		this.setThird(third);
		
	}

	public T getFirst() {
		return first;
	}

	private void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	private void setSecond(T second) {
		this.second = second;
	}
	
	public T getThird() {
		return third;
	}

	private void setThird(T third) {
		this.third = third;
		
	}
	
	
	
	

}
