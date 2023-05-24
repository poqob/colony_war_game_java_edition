package input;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
	private ArrayList<Integer> numbers;

	public InputManager() {
		numbers = new ArrayList<>();
	}

	public void startInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter numeric inputs with one character spacing (e.g., 1 2 3), enter 'q' to quit:");

		while (scanner.hasNext()) {
			String input = scanner.next();

			if (input.equalsIgnoreCase("q")) {
				break;
			}

			try {
				int number = Integer.parseInt(input);
				numbers.add(number);
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid integer or 'q' to quit.");
			}
		}

		scanner.close();
	}

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}
}
