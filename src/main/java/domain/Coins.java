package domain;

import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;

public class Coins {

	private final Map<Coin, Integer> coins;

	public Coins() {
		this.coins = new TreeMap<>();
		initCoins();
	}

	public Coins(Map<Coin, Integer> coins) {
		this.coins = coins;
	}

	private void initCoins() {
		for (Coin coin : Coin.values()) {
			coins.put(coin, 0);
		}
	}

	public void generate(int amount) {
		while (amount != 0) {
			int random = Randoms.pickNumberInList(Coin.getCoins());
			if (validateRandom(random, amount)) {
				Coin coin = Coin.find(random);
				coins.put(coin, coins.get(coin) + 1);
				amount -= random;
			}
		}
	}

	private boolean validateRandom(int coin, int amount) {
		return amount - coin >= 0;
	}

	public Map<Coin, Integer> getCoins() {
		return new TreeMap<>(coins);
	}

	public void returnMoney(Coin coin, int count) {
		coins.put(coin, coins.get(coin) - count);
	}
}
