package manufacture;

import java.util.Random;

public class ManufactureManager {
	static Random random;

	public static AManufacture pickManufacture() {
		random = new Random();
		int index = random.nextInt(Manufactures.values().length);
		switch (Manufactures.values()[index]) {
		case manufacture0:
			return new Manufacture0();
		case manufacture1:
			return new Manufacture1();
		case manufacture2:
			return new Manufacture2();
		default:
			return new Manufacture0();
		}
	}
}
