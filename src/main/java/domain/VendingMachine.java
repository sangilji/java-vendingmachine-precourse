package domain;

import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {

	private final Coins coins;
	private final Products products;
	private int inputAmount;

	public VendingMachine(Coins coins, Products products, int inputAmount) {
		this.coins = coins;
		this.products = products;
		this.inputAmount = inputAmount;
	}

	public boolean isSell() {
		return products.getProducts()
			.entrySet()
			.stream()
			.anyMatch(product -> inputAmount >= product.getKey().getPrice() && product.getValue() > 0);

	}

	public int getAmount() {
		return inputAmount;
	}

	public void sell(Product product) {
		inputAmount -= product.getPrice();
		products.sell(product);
	}

	public void validateSellingProduct(Product product) {
		if (inputAmount < product.getPrice()) {
			throw new IllegalArgumentException("금액이 부족합니다.");
		}
	}

	public Product findProduct(String productName) {
		return products.find(productName);
	}

	public Coins giveBack() {
		Map<Coin, Integer> changeCoin = new TreeMap<>();
		Map<Coin, Integer> machineCoins = coins.getCoins();
		for (Coin coin : machineCoins.keySet()) {
			if (inputAmount == 0) {
				return new Coins(changeCoin);
			}
			int count = getCoinCount(machineCoins, coin);

			inputAmount -= count * coin.getAmount();
			coins.returnMoney(coin, count);
			changeCoin.put(coin, count);
		}
		return new Coins(changeCoin);
	}

	private int getCoinCount(Map<Coin, Integer> machineCoins, Coin coin) {
		int count = coin.getAmount() / inputAmount;

		if (count > machineCoins.get(coin)) {
			count = machineCoins.get(coin);
		}
		return count;
	}
}
