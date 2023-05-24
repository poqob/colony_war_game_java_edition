package manufacture;

/**
 * Abstract class AManufacture represents a generic producing process with a
 * produce power.
 */
public abstract class AManufacture {
	public int producePower;

	/**
	 * Abstract method produce() defines the production behavior for subclasses to
	 * implement.
	 *
	 * @return The power of production.
	 */
	public abstract int produce();
}
