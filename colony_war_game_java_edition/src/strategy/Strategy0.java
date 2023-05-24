package strategy;

/**
 * Strategy0 is a concrete implementation of AStrategy representing a specific
 * strategy.
 */
public class Strategy0 extends AStrategy {
	@Override
	public int fight() {
		super.fightPower = 400;
		return super.fightPower;
	}

}
