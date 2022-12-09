package view;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import domain.Product;
import validator.Validator;

public class InputView {

	public static int inputChange() {
		while (true) {
			try {
				return Integer.parseInt(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static Map<Product, Integer> inputProducts() {
		while (true) {
			try {
				return Validator.validateInputtingProducts(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static int inputAmount() {
		while (true) {
			try {
				return Integer.parseInt(Console.readLine());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static String inputProductName() {
		while (true) {
			try {
				return Console.readLine();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
