package colony;

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

	// methods

	void grow() {
	}

	void reportLifeStatus() {
	}

	public String toString() {
		return "Colony";
	}
}
