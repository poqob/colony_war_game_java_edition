package ui;

import java.util.ArrayList;

import log.Log;

public class Ui {
	private static String divider = "\n-------------------------------------------------------";

	/**
	 * Displays the logs in a formatted manner.
	 * 
	 * @param listOfLogsList The list of logs(list of log per tour) to be displayed.
	 */
	public static void showLogs(ArrayList<ArrayList<Log>> listOfLogsList) {
		String res = "";
		ArrayList<Log> logs;
		Log log;

		for (int i = 0; i < listOfLogsList.size(); i++) {
			logs = listOfLogsList.get(i);
			res += divider;
			res += "\nTour: " + (i + 1);
			res += "\nColony    Population      Food Stock      Victory Loose";

			for (int j = 0; j < logs.size(); j++) {
				log = logs.get(j);
				res += "\n " + log.toString();
			}
		}
		res += divider + "\n";
		System.out.print(res);
	}
}
