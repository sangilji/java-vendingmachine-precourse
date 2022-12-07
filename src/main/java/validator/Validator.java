package validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import domain.Product;

public class Validator {
	public static Map<Product, Integer> validateInputtingProducts(String input) {
		Map<Product, Integer> products = new HashMap<>();
		Arrays.stream(input.split(";"))
			.map(item -> item.substring(1, item.length() - 1).split(","))
			.forEach(productInfo -> products.put(new Product(productInfo[0], Integer.parseInt(productInfo[1])),
				Integer.parseInt(productInfo[2])));

		return products;
	}
}
