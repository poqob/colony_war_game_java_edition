package strategy;

public class Strategy0 extends AStrategy {
	final int fightPower = 400;

	@Override
	public int fight() {
		return fightPower;
	}

}
