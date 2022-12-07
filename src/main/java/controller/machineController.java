package controller;

import domain.Coins;
import domain.Products;
import domain.VendingMachine;
import view.InputView;
import view.OutputView;

public class machineController {

	VendingMachine vendingMachine;

	private void run() {
		setting();
	}

	private void setting() {
		OutputView.printAmountMessage();
		Coins coins = new Coins();
		coins.generate(InputView.inputAmount());
		OutputView.printCoins(coins.getCoins());

		OutputView.printProductsMessage();
		Products products = new Products(InputView.inputProducts());
		vendingMachine = new VendingMachine(coins,products);
	}
}
