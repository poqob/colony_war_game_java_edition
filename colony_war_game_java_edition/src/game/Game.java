package game;

import gameManager.GameManager;

public class Game {
	// field GameManager
	private GameManager gm;

	// constructor
	public Game(GameManager gm) {
		this.gm = gm;
	}

	// methods

	/**
	 * Executes the game by running the main game loop until the game is over. In
	 * each iteration of the loop, it performs the necessary game actions, such as
	 * calculating the possible war count, increasing the tour count, logging the
	 * game information, conducting battles, and growing the colonies.
	 */
	public void play() {

		while (gm.goodToGo()) {

			gm.totalWarCount += gm.calculatePossibleWarCountPerRound();
			gm.tour++;// increase tour count
			gm.logger();
			gm.battle();
			gm.growOrganizer();

		}
		gm.logger();
	}

	// prints winner to console
	public void showWinner() {
		System.out.println("Winner is: " + gm.getWinner().symbol);
	}

	public String inspect() {
		return "Game";
	}
}
