package manufacture;

/**
 * Class Manufacture1 is a concrete implementation of AManufacture. It produces
 * with a fixed produce power of 8.
 */
public class Manufacture1 extends AManufacture {

	/**
	 * Overrides the produce method from the superclass. Sets the produce power to 8
	 * and returns it.
	 *
	 * @return The amount of production.
	 */
	@Override
	public int produce() {
		super.producePower = 8;
		return super.producePower;
	}

}
