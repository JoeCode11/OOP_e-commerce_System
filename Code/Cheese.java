
public class Cheese extends Products implements ExpiryProducts, ShippableProducts {
	
	//these are the expiry dates 
		private int day;
		private int month;
		private int year;
		private boolean expired;
		private float weight;

		
	public Cheese(int day, int month, int year, String name, int quantity, float price, float weight) {
		super(name, price, quantity);
		this.day = day;
		this.month = month;
		this.year = year;
		this.weight= weight;
	}
	
	@Override
	public void checkExpired(int day, int month, int year) {
		if (this.year< year) {
			expired = true;
		}
		else if (this.month< month && this.year == year ) {
			expired = true;
		}
		else if (this.day<day && this.month==month && this.year == year) {
			expired = true;
		}
		else {
			expired = false;
		}
	}
	
	@Override
	public boolean getExpired() {
		return this.expired;
	}
	
	
	@Override
	public float returnWeight() {
		return this.weight;
	}
}
