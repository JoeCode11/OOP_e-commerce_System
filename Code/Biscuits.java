
public class Biscuits extends Products implements ExpiryProducts {
	
	//these are the expiry dates 
		private int day;
		private int month;
		private int year;
		private boolean expired;

		
	public Biscuits(int day, int month, int year, String name, int quantity, float price) {
		super(name, price, quantity);
		this.day = day;
		this.month = month;
		this.year = year;
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
	
	public float getWeight() {
		return 0.00f;
	}
	
}
