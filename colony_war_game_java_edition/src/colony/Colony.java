package colony;

import constants.Constants;
import manufacture.AManufacture;
import strategy.AStrategy;

public class Colony {
	// fields
	int foodStock;
	int population;
	boolean amIALive;
	char symbol;
	int victory;
	int loose;
	AManufacture manufacture;
	AStrategy strategy;

	Colony(int population, char symbol, AStrategy strategy, AManufacture manufacture) {
		this.amIALive = population == 0 ? false : true;
		this.symbol = symbol;
		this.foodStock = population * population;
		this.victory = 0;
		this.loose = 0;
		this.strategy = strategy;
		this.manufacture = manufacture;
	}

	// methods

	void grow() {
		// controlling population, if the population is under 0 set colony is dead.
		if (population <= 0) {
			this.amIALive = false;
			return;
		}

		// new population per round.
		population = population * Constants.POPULATION_SCALE_AS_PERCENTAGE / 100;

		// minus food stock
		foodStock -= population * 2;

		// produce according to updated population.
		foodStock += manufacture.produce();

		// controlling if food stock is under level zero.
		if (population <= 0) {
			this.amIALive = false;
			return;
		}
	}

	// controlls the colony's life status, GameManager calls it after every single
	// combat.
	void reportLifeStatus() {
		// controlling if food stock is under level zero.
		if (foodStock <= 0 || population <= 0) {
			amIALive = false;
		}
	}

	public String toString() {
		String output;
		output = "\n***************************\n";

		return "Colony";
	}
}
