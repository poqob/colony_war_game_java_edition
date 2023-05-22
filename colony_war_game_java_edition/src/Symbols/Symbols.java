package Symbols;

import java.util.LinkedList;
import java.util.Random;

public class Symbols {

	private static LinkedList<String> allSymbols;

	private static void createSymbols() {
		int num = 0x2600; // Unicode code point for the first symbol
		String temp;

		if (allSymbols == null)
			allSymbols = new LinkedList<String>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				temp = new String(Character.toChars(num));
				allSymbols.add(temp);
				num += 10;
			}
			num = 0x2600 + i + 1;
		}
	}

	public static String pickASymbol() {
		if (allSymbols == null || allSymbols.isEmpty())
			createSymbols();
		Random random = new Random();
		int index = random.nextInt(allSymbols.size());
		String symbol = allSymbols.get(index);
		allSymbols.remove(index);
		return symbol;
	}
}
