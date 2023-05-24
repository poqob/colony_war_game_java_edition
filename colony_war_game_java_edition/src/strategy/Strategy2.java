package strategy;

/**
 * Strategy2 is a concrete implementation of AStrategy representing a specific
 * strategy.
 */
public class Strategy2 extends AStrategy {
	@Override
	public int fight() {
		super.fightPower = 800;
		return super.fightPower;
	}
}
