package manufacture;

/**
 * Class Manufacture2 is a concrete implementation of AManufacture. It produces
 * with a fixed produce power of 10.
 */
public class Manufacture2 extends AManufacture {

	/**
	 * Overrides the produce method from the superclass. Sets the produce power to
	 * 10 and returns it.
	 *
	 * @return The amount of production.
	 */
	@Override
	public int produce() {
		super.producePower = 10;
		return super.producePower;
	}

}
