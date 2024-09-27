package domain;

import java.util.Map;

public class Products {
	private final Map<Product, Integer> products;

	public Products(Map<Product, Integer> products) {
		this.products = products;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public Product find(String productName) {
		return products.keySet()
			.stream()
			.filter(product -> product.sameName(productName))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public void sell(Product product) {
		products.put(product,products.get(product)-1);
	}
}
