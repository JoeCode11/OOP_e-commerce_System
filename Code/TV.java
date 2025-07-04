
public class TV extends Products implements ShippableProducts{

	private boolean expired;
	private float weight;
	
	
	public TV(String name, int quantity, float price, float weight) {
		super(name, price, quantity);
		this.weight= weight;
	}
	
	
	
	
	@Override
	public float returnWeight() {
		return this.weight;
	}

}
