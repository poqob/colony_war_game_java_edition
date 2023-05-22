package strategy;

public class Strategy2 extends AStrategy {
	@Override
	public int fight() {
		super.fightPower = 800;
		return super.fightPower;
	}
}
