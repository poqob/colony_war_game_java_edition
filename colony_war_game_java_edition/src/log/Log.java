package log;

import colony.Colony;
import constants.Constants;

public class Log {
	// fields
	int foodStock;
	int population;
	boolean amIALive;
	char symbol;
	int victory;
	int loose;

	Log(Colony colony) {
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
		res += " ".repeat(Constants.SPACING - 4);
		if (amIALive == true) {
			res += population;
			res += " ".repeat(Constants.SPACING - 2 + 2);
			res += foodStock;
			res += " ".repeat(Constants.SPACING - 2);
			res += victory;
			res += " ".repeat(8 - 2);
			res += loose;
		} else {
			res += "--";
			res += " ".repeat(Constants.SPACING - 2 + 2);
			res += "--";
			res += " ".repeat(Constants.SPACING - 2);
			res += "--";
			res += " ".repeat(8 - 2);
			res += "--";
		}

		return res;

	}
}
