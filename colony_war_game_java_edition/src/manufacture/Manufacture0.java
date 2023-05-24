package manufacture;

/**
 * Class Manufacture0 is a concrete implementation of AManufacture. It produces
 * with a fixed produce power of 6.
 */
public class Manufacture0 extends AManufacture {

	/**
	 * Overrides the produce method from the superclass. Sets the produce power to 6
	 * and returns it.
	 *
	 * @return The amount of production.
	 */
	@Override
	public int produce() {
		super.producePower = 6;
		return super.producePower;
	}

}
