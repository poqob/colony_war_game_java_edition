
import game.Game;
import gameManager.GameManager;
import input.InputManager;
import ui.Ui;

public class Main {

	public static void main(String[] args) {
		InputManager manager = new InputManager();
		manager.startInput();
		GameManager gm = new GameManager(manager.getNumbers());
		Game game = new Game(gm);
		game.play();
		Ui.showLogs(gm.toursLogPack);
		game.showWinner();
	}

}
