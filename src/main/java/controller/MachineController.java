package controller;

import domain.Coins;
import domain.Product;
import domain.Products;
import domain.VendingMachine;
import view.InputView;
import view.OutputView;

public class MachineController {

	VendingMachine vendingMachine;

	public void run() {
		setting();
		progress();
		giveBackMoney();
	}

	private void setting() {
		OutputView.printAmountMessage();
		Coins coins = new Coins();
		coins.generate(InputView.inputChange());
		OutputView.printCoins(coins.getCoins());

		OutputView.printProductsMessage();
		Products products = new Products(InputView.inputProducts());
		OutputView.printInputtingMoneyMessage();
		int inputAmount = InputView.inputAmount();
		vendingMachine = new VendingMachine(coins, products, inputAmount);
	}

	private void progress() {

		while (vendingMachine.isSell()) {
			OutputView.printBuyingMessage(vendingMachine.getAmount());
			String productName = InputView.inputProductName();
			try {
				Product product = vendingMachine.findProduct(productName);
				vendingMachine.validateSellingProduct(product);
				vendingMachine.sell(product);
			} catch (IllegalArgumentException e) {
				OutputView.printErrorMessage(e.getMessage());
			}

		}
	}

	private void giveBackMoney() {
		OutputView.printChangeMessage(vendingMachine.getAmount(),vendingMachine.giveBack());
	}
}
