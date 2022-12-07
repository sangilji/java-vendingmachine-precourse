package domain;

public class VendingMachine {

	private Coins coins;
	private Products products;

	public VendingMachine(Coins coins, Products products) {
		this.coins = coins;
		this.products = products;
	}
}
