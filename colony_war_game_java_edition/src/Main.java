
import java.util.ArrayList;

import game.Game;
import gameManager.GameManager;
import ui.Ui;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> populations = new ArrayList<Integer>();
		populations.add(50);
		populations.add(150);
		populations.add(200);

		GameManager gm = new GameManager(populations);
		Game game = new Game(gm);
		game.play();
		Ui.showLogs(gm.toursLogPack);

		System.out.print("EXIT SUCCESFULLY");

	}

}
