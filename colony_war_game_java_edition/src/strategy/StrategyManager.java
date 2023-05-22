package strategy;

import java.util.Random;

public class StrategyManager {
	static Random random;

	public static AStrategy pickStrategy() {
		random = new Random();
		int index = random.nextInt(Strategies.values().length);
		switch (Strategies.values()[index]) {
		case strategy0:
			return new Strategy0();
		case strategy1:
			return new Strategy1();
		case strategy2:
			return new Strategy2();
		default:
			return new Strategy0();
		}
	}
}
