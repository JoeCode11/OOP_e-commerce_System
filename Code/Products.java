
public abstract class Products {

	private String name;
	private float price;
	private int quantity;
	
	public Products(String name, float price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addToCart(Cart cart, int quantity) {
		if(this.quantity>quantity) {
			cart.addToCart(this, quantity);
		}
	}
	
}

