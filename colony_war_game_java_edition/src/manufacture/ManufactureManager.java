package manufacture;

import java.util.Random;

/**
 * ManufactureManager is responsible for picking a random manufacture option
 * from the available options.
 */
public class ManufactureManager {
	static Random random;

	/**
	 * Picks a random manufacture option.
	 *
	 * @return An instance of AManufacture representing the chosen manufacture
	 *         option.
	 */
	public static AManufacture pickManufacture() {
		random = new Random();
		int index = random.nextInt(Manufactures.values().length);
		switch (Manufactures.values()[index]) {
		case MANUFACTURE0:
			return new Manufacture0();
		case MANUFACTURE1:
			return new Manufacture1();
		case MANUFACTURE2:
			return new Manufacture2();
		default:
			return new Manufacture0();
		}
	}
}
