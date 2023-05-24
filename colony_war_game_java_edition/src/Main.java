
import game.Game;
import gameManager.GameManager;
import input.InputManager;
import ui.Ui;

public class Main {

	public static void main(String[] args) {
		// manage console inputs
		InputManager manager = new InputManager();
		manager.startInput();
		// create game manager to manage game data
		GameManager gm = new GameManager(manager.getNumbers());
		// create game
		Game game = new Game(gm);
		game.play();
		// console output
		Ui.showLogs(gm.toursLogPack);
		game.showWinner();
	}
}
