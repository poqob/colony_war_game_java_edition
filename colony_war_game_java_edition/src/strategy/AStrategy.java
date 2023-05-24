package strategy;

/**
 * AStrategy is an abstract class representing a strategy for fighting.
 */
public abstract class AStrategy {
	public int fightPower;

	/**
	 * Abstract method for performing the fight action.
	 *
	 * @return The fight power value.
	 */
	public abstract int fight();
}
