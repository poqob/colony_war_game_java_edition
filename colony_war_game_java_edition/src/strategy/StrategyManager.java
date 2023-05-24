package strategy;

import java.util.Random;

/**
 * StrategyManager is responsible for picking a strategy randomly from the
 * available strategies.
 */
public class StrategyManager {
	static Random random;

	/**
	 * Picks a strategy randomly from the available strategies.
	 *
	 * @return AStrategy - the picked strategy
	 */
	public static AStrategy pickStrategy() {
		random = new Random();
		int index = random.nextInt(Strategies.values().length);
		switch (Strategies.values()[index]) {
		case STRATEGY0:
			return new Strategy0();
		case STRATEGY1:
			return new Strategy1();
		case STRATEGY2:
			return new Strategy2();
		default:
			return new Strategy0();
		}
	}
}
