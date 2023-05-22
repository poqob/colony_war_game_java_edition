package strategy;

public class Strategy2 extends AStrategy {

	final int fightPower = 800;

	@Override
	public int fight() {
		return fightPower;
	}
}
