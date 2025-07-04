public class Main {

    public static void main(String[] args) {
        System.out.println("*** CASE 1: Successful checkout ***");
        caseSuccessfulCheckout();

        System.out.println("\n*** CASE 2: Product is expired ***");
        caseProductExpired();

        System.out.println("\n*** CASE 3: Not enough balance ***");
        caseNotEnoughBalance();

        System.out.println("\n*** CASE 4: Empty cart ***");
        caseEmptyCart();

        System.out.println("\n*** CASE 5: Add quantity more than available ***");
        caseExceedStock();
        
        System.out.println("\n****** DONE ******");

    }

    static void caseSuccessfulCheckout() {
        Cart cart = new Cart();
        Customer customer = new Customer(6000.0); //the balance

        Cheese cheese = new Cheese(10, 8, 2025, "Cheddar", 5, 100.0f, 2.0f); 
        Biscuits biscuits = new Biscuits(15, 9, 2025, "biscuit", 3, 20.0f);
        TV tv = new TV("Television", 2, 3000.0f, 8.0f); 
        Mobile mobile = new Mobile("iphone", 10, 500.0f); 

        cart.addToCart(cheese, 2);     
        cart.addToCart(biscuits, 2);  
        cart.addToCart(tv, 1);        
        cart.addToCart(mobile, 1);    

        customer.checkout(cart, 1, 7, 2025);  
    }

    static void caseProductExpired() {
        Cart cart = new Cart();
        Customer customer = new Customer(5000.0);

        Cheese expiredCheese = new Cheese(1, 1, 2020, "expired Cheese", 5, 50.0f, 1.0f); //yr 2020
        cart.addToCart(expiredCheese, 1);

        customer.checkout(cart, 1, 7, 2025);  //yr 2025
    }

    static void caseNotEnoughBalance() {
        Cart cart = new Cart();
        Customer customer = new Customer(100.0); 

        TV tv = new TV("Expensive TV", 1, 1500.0f, 10.0f); 
        cart.addToCart(tv, 1);

        customer.checkout(cart, 1, 7, 2025);
    }

    static void caseEmptyCart() {
        Cart cart = new Cart();
        Customer customer = new Customer(1000.0);

        customer.checkout(cart, 1, 7, 2025); 
    }

    static void caseExceedStock() {
        Cart cart = new Cart();
        Biscuits Biscuits = new Biscuits(1, 1, 2026, "biscuits", 1, 10.0f);

        
        cart.addToCart(Biscuits, 5);  

        Customer customer = new Customer(100.0);
        customer.checkout(cart, 1, 1, 2026);
    }
}
