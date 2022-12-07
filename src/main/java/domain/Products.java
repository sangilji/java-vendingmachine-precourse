package domain;

import java.util.Map;

public class Products {
	private Map<Product, Integer> products;

	public Products(Map<Product, Integer> products) {
		this.products = products;
	}

	public void add(Product product, int quantity) {
		products.put(product, quantity);
	}
}
