package view;

import java.util.Map;

import domain.Coin;
import domain.Coins;

public class OutputView {
	private static final String AMOUNT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String COIN_MESSAGE = "자판기가 보유한 동전";
	private static final String COINS = "%d원 - %d개\n";
	private static final String INPUTTING_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String INPUTTING_MONEY_MESSAGE = "투입 금액을 입력해 주세요";

	public static void printAmountMessage() {
		System.out.println(AMOUNT_MESSAGE);
	}

	public static void printCoins(Map<Coin, Integer> coins) {
		System.out.println(COIN_MESSAGE);
		for (Coin coin : coins.keySet()) {
			System.out.printf(COINS, coin.getAmount(), coins.get(coin));
		}
	}

	public static void printProductsMessage() {
		System.out.println(INPUTTING_PRODUCT_MESSAGE);
	}

	public static void printInputtingMoneyMessage() {
		System.out.println(INPUTTING_MONEY_MESSAGE);
	}

	public static void printBuyingMessage(int amount) {
		System.out.printf("투입 금액: %d원\n구매할 상품명을 입력해 주세요.\n", amount);
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printChangeMessage(int amount, Coins coins) {
		System.out.printf("투입 금액: %d원\n잔돈\n", amount);
		Map<Coin, Integer> changeCoins = coins.getCoins();
		for (Coin coin : changeCoins.keySet()) {
			if (changeCoins.get(coin) == 0) {
				continue;
			}
			System.out.printf("%d원 - %d개\n", coin.getAmount(), changeCoins.get(coin));
		}
	}
}
