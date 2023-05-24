package strategy;

/**
 * Strategy1 is a concrete implementation of AStrategy representing a specific
 * strategy.
 */
public class Strategy1 extends AStrategy {
	@Override
	public int fight() {
		super.fightPower = 600;
		return super.fightPower;
	}

}
