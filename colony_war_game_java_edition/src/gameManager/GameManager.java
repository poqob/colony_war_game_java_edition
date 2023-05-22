package gameManager;

import java.util.ArrayList;
import java.util.Random;

import Symbols.Symbols;
import colony.Colony;
import constants.Constants;
import log.Log;
import manufacture.ManufactureManager;
import strategy.StrategyManager;
import utils.Todo;

@Todo("divide into parts, CombatManager, Logger")
public class GameManager {
	// fields
	ArrayList<Colony> players;
	public ArrayList<ArrayList<Log>> toursLogPack;
	public int totalWarCount;
	public int tour;

	// constructor
	public GameManager(ArrayList<Integer> populations) {
		totalWarCount = 0;
		tour = 0;
		players = createPlayers(populations);
		toursLogPack = new ArrayList<ArrayList<Log>>();
	}

	// methods
	private ArrayList<Colony> createPlayers(ArrayList<Integer> populations) {
		// popoulations array list stores intager values
		ArrayList<Colony> playerss = new ArrayList<Colony>();
		Colony colony;
		for (int i = 0; i < populations.size(); i++) {
			// create colony
			colony = new Colony(Symbols.pickASymbol(), populations.get(i), StrategyManager.pickStrategy(),
					ManufactureManager.pickManufacture());
			// add colony to local players list
			playerss.add(colony);
		}
		return playerss;
	}

	// creates logs for each tour
	public void logger() {
		ArrayList<Log> logs = new ArrayList<Log>();
		Log log;
		for (int i = 0; i < players.size(); i++) {
			log = new Log(players.get(i));
			logs.add(log);
		}
		toursLogPack.add(logs);
	}

	int PWC = 0;

	public Integer calculatePossibleWarCountPerRound() {
		int tmp;
		players.forEach(p -> {
			if (p.amIALive == true)
				PWC++;
		});
		tmp = PWC;
		PWC = 0;

		if (tmp % 2 == 0)
			return (((tmp) / 2) - 1) * tmp + (tmp / 2);
		else
			return (tmp / 2) * tmp;
	}

	public Boolean goodToGo() {
		return (calculatePossibleWarCountPerRound() != 0) ? true : false;
	}

	// colonies grow method
	public void growOrganizer() {
		for (int i = 0; i < players.size(); i++) {
			players.get(i).grow();
		}
	}

	// colonies battle method
	public void battle() {
		Colony c0;
		Colony c1;
		// combat alghorithm
		for (int i = 0; i < players.size() - 1; i++) {

			c0 = players.get(i);

			// controll c0 is alive
			if (c0.amIALive != true)
				continue;

			for (int j = i + 1; j < players.size(); j++) {
				c1 = players.get(j);

				// controll c1 is alive
				if (c1.amIALive != true)
					continue;

				// The situation where 'c0' did not survive the combat with the previous
				// colonies.
				if (c0.amIALive != true)
					break;

				versus(c0, c1); // FIGHTTTTTT
			}

		}
	}

	@Todo("NOT pass by refferance, change alghorithm c0 and c1 is not one that in players list!!!")
	// combat-fight function
	private void versus(Colony c0, Colony c1) {
		float ratio;

		// c0 winner situation
		if (c0.fight() > c1.fight()) {
			ratio = (float) (c0.fight() - c1.fight()) / Constants.INDEX;
			c1.population -= c1.population * ratio;// reduce c1's(looser) population.

			// transfer c1's(looser) food stock to c0(winner)
			c0.foodStock += c1.foodStock * ratio;
			c1.foodStock -= c1.foodStock * ratio;

			// victory-loose
			c0.victory++;
			c1.loose++;
		} else if (c0.fight() < c1.fight()) {
			ratio = (float) (c1.fight() - c0.fight()) / Constants.INDEX;
			c0.population -= c0.population * ratio;// reduce c0's(looser) population.

			// transfer c0's(looser) food stock to c1(winner)
			c1.foodStock += c0.foodStock * ratio;
			c0.foodStock -= c0.foodStock * ratio;

			// victory-loose
			c1.victory++;
			c0.loose++;
		} else // c0:fp == c1:fp situation
		{
			// compare population scales.
			if (c0.population > c1.population) {
				ratio = (float) (c0.produce() - c1.produce()) / Constants.INDEX;
				c1.population -= c1.population * ratio;// reduce c1's(looser) population.

				// transfer c1's(looser) food stock to c0(winner)
				c0.foodStock += c1.foodStock * ratio;
				c1.foodStock -= c1.foodStock * ratio;

				// victory-loose
				c0.victory++;
				c1.loose++;
			} else if (c0.population < c1.population) {
				ratio = (float) (c1.produce() - c0.produce()) / Constants.INDEX;
				c0.population -= c0.population * ratio; // reduce c0's(looser) population.

				// transfer c0's(looser) food stock to c1(winner)
				c1.foodStock += c0.foodStock * ratio;
				c0.foodStock -= c0.foodStock * ratio;

				c1.victory++;
				c0.loose++;

			} else// c0:population equals c1:population situation
			{
				// ratio is a constant value
				ratio = 10 / Constants.INDEX;

				Random random = new Random();
				if (random.nextInt(2) % 2 == 0) {
					// randomly colony0 is winner

					c1.population -= c1.population * ratio;// reduce c1's(looser) population.
					// transfer c1's(looser) food stock to c0(winner)
					c0.foodStock += c1.foodStock * ratio;
					c1.foodStock -= c1.foodStock * ratio;
					// victory-loose
					c0.victory++;
					c1.loose++;
				} else {
					// randomly colony1 is winner
					c0.population -= c0.population * ratio; // reduce c0's(looser) population.
					// transfer c0's(looser) food stock to c1(winner)
					c1.foodStock += c0.foodStock * ratio;
					c0.foodStock -= c0.foodStock * ratio;

					c1.victory++;
					c0.loose++;
				}
			}
		}
		// System.out.println(c1.fightPower() - c0.fightPower());
		c0.reportLifeStatus();
		c1.reportLifeStatus();
		// above results: populations affected, foodstocks transfared, amIAlive updated
	}

}
