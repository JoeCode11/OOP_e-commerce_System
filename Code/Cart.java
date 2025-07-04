import java.util.ArrayList;
import java.util.List;

public class Cart {

	
    private List<Products> items = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
	
	
	public boolean addToCart(Products p, int quantity) {
		if (quantity <= p.getQuantity()) {
			items.add(p);
			quantities.add(quantity);
			return true;
		}
		else {
			System.out.println("Not enough stock currently for product "+ p.getName()+".");
			return false;
		}

	}
	
	public List<Products> getItems() {
        return items;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }
	
	
}
