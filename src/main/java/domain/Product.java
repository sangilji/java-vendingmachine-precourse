package domain;

public class Product {

	private final String name;
	private final int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public boolean sameName(String name) {
		return this.name.equals(name);
	}
}
