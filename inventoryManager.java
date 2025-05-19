package MyStore;

import java.util.ArrayList;
import java.util.List;

public class inventoryManager {

	private List<SalableProduct> products;
	
	public inventoryManager() {
		this.products = new ArrayList<>();
	}

	public void addProduct(SalableProduct product) {
		products.add(product);
		
	}

	// Method to get a product from the inventory by its name
    public SalableProduct getProduct(String name) {
        for (SalableProduct product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null; // Return null if the product with the given name is not found
    }

	public void updateProduct(SalableProduct updateProduct) {
		// TODO Auto-generated method stub
		for(int i = 0; i <products.size(); i++) {
			if(products.get(i).getId() == updateProduct.getId()) {
				products.set(i,  updateProduct); //update with new product
				return;
			}
		}
		
	}

}
