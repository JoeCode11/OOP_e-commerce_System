import java.util.ArrayList;
import java.util.List;

public class Customer {

	private double balance;
	
	public Customer(double balance) {
		this.balance = balance;
	}
	
	public void checkout(Cart cart, int currentDay, int currentMonth, int currentYr) {
		double subtotal = 0;
        double shipping = 0;
        
        List<Products> items = cart.getItems();
        List<Integer> quantities = cart.getQuantities();
        
        
        if (items.isEmpty()) {
            System.out.println("Cart is empty. No checkout.");
            return;
        }
        
        
        for (int i = 0; i < items.size(); i++) {
            Products p = items.get(i);
            int quantity = quantities.get(i);
            
            if (p instanceof ExpiryProducts) {
                ((ExpiryProducts) p).checkExpired(currentDay, currentMonth, currentYr);
                if (((ExpiryProducts) p).getExpired()) {
                    System.out.println("Product " + p.getName() + " is expired.");
                    return;
                }
            }
            
            
            double price = p.getPrice() * quantity;
            subtotal += price;

            if (p instanceof ShippableProducts) {
                float weight = ((ShippableProducts) p).returnWeight();
                shipping += weight * 0.45f; 
            }
        }
        
        double total = subtotal + shipping;
        
        if (total > balance) {
            System.out.println("Not enough balance. Your balance is: "+ this.balance+ ".");
        } else {
        	
        	for (int i = 0; i < items.size(); i++) {
                Products p = items.get(i);
                int quantity = quantities.get(i);
                p.setQuantity(p.getQuantity() - quantity);
            }
            balance -= total;
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Shipping Fees: " + shipping);
            System.out.println("Total Paid: " + total);
            System.out.println("Remaining Balance: " + this.balance);
        }
        
	}
}
