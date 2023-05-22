package strategy;

public class Strategy2 extends AStrategy {

	final int fightPower = 800;

	@Override
	int fight() {
		return fightPower;
	}
}
