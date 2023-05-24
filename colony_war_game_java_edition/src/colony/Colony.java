package colony;

import constants.Constants;
import manufacture.AManufacture;
import strategy.AStrategy;

public class Colony {
	// fields
	public int foodStock;
	public int population;
	public boolean amIALive;
	public String symbol;
	public int victory;
	public int loose;
	AManufacture manufacture;
	AStrategy strategy;

	// Constructor
	public Colony(String symbol, int population, AStrategy strategy, AManufacture manufacture) {
		this.population = population;
		this.amIALive = population == 0 ? false : true;
		this.symbol = symbol;
		this.foodStock = population * population;
		this.victory = 0;
		this.loose = 0;
		this.strategy = strategy;
		this.manufacture = manufacture;
	}

	// methods
	public void grow() {
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

		reportLifeStatus();
	}

	public int fight() {
		return strategy.fight();
	}

	public int produce() {
		return manufacture.produce();
	}

	// controlls the colony's life status, GameManager calls it after every single
	// combat.
	public void reportLifeStatus() {
		// controlling if food stock is under level zero.
		if (foodStock <= 0 || population <= 0) {
			amIALive = false;
		}
	}

	public String toString() {
		return "Colony";
	}
}
