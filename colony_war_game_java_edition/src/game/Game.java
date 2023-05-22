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
	public void play() {

		while (gm.goodToGo() == true) {

			gm.totalWarCount += gm.calculatePossibleWarCountPerRound();
			gm.tour++;// increase tour count
			gm.logger();
			gm.battle();
			gm.growOrganizer();

		}
		gm.logger();
	}

	public String inspect() {
		return "Game";
	}
}
