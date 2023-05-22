package strategy;

public class Strategy1 extends AStrategy {
	@Override
	public int fight() {
		super.fightPower = 600;
		return super.fightPower;
	}

}
