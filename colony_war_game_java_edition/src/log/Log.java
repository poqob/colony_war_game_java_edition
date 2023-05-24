package log;

import colony.Colony;
import constants.Constants;

public class Log {
	// fields
	int foodStock;
	int population;
	boolean amIALive;
	String symbol;
	int victory;
	int loose;

	public Log(Colony colony) {
		foodStock = colony.foodStock;
		population = colony.population;
		amIALive = colony.amIALive;
		symbol = colony.symbol;
		victory = colony.victory;
		loose = colony.loose;
	}

	public String toString() {
		String res = "";

		res += symbol;
		res += " ".repeat(Constants.SPACING - symbol.length());
		if (amIALive == true) {
			res += population;
			res += " ".repeat(Constants.SPACING - Integer.toString(population).length() + 2);
			res += foodStock;
			res += " ".repeat(Constants.SPACING - Integer.toString(foodStock).length());
			res += victory;
			res += " ".repeat(8 - Integer.toString(victory).length() - 2);
			res += loose;
		} else {
			res += "--";
			res += " ".repeat(Constants.SPACING);
			res += "--";
			res += " ".repeat(Constants.SPACING - 2);
			res += "--";
			res += " ".repeat(8 - 4);
			res += "--";
		}

		return res;

	}
}
