package MyStore;

//StoreFront class represents the front-end of the store, managing inventory and purchases.
public class storeFront {
 private inventoryManager inventoryManager; // Private attribute to manage inventory

 // Constructor initializes the InventoryManager
 public storeFront() {
    inventoryManager = new inventoryManager();
 }

 // Method to initialize the store with sample products
 public void initializeStore() {
   
     
     inventoryManager.addProduct(new SalableProduct(1, "Furniture", "Dining Table", 1500.99, 10));
     inventoryManager.addProduct(new SalableProduct(2, "Furniture", "Bedroom Mattress", 1299.99, 5));
 }

 // Method to purchase a product from the inventory
 public boolean purchaseProduct(String productName) {
     // Implement purchase logic here
	 SalableProduct product = inventoryManager.getProduct(productName);
     // Checks if the product exists in inventory and has available quantity
     if (product != null && product.getQuantity() > 0) {
         product.setQuantity(product.getQuantity() - 1); // Decrease quantity after purchase
         inventoryManager.updateProduct(product);
         return true; // Return true indicating successful purchase
     }
     return false; // Return false indicating failed purchase
 }

 // Method to cancel a purchase and return the product to inventory
 public boolean cancelPurchase(String productName) {
     // Implement cancel purchase
	 SalableProduct product = inventoryManager.getProduct(productName);
     // Checks if the product exists in inventory
	 if (product != null) {
		product.setQuantity(product.getQuantity() +1 );
		inventoryManager.updateProduct(product);// update quantity after cancellation
	 
         return true; // Return true for successful cancellation
     }
     return false; // Return false for failed cancellation
 }
 
 public static void main(String[] args) {
     // Create an instance of InventoryManager
	 storeFront store = new storeFront();
	 store.initializeStore();
	 
	 //Create shopping cart
	 shoppingCart shoppingCart = new shoppingCart();

     // Retrieve products from inventory
     SalableProduct product1 = store.inventoryManager.getProduct("Dining Table");
     SalableProduct product2 = store.inventoryManager.getProduct("Bedroom Mattress");

     if (product1 != null) shoppingCart.addItem(product1, 3);
     if (product2 != null) shoppingCart.addItem(product2, 2);
     
     
    

     // Display the total price in the shopping cart
     System.out.println("Total Price in Cart: $" + shoppingCart.getTotalPrice());

     // Perform checkout
     shoppingCart.checkout();
 }
}
