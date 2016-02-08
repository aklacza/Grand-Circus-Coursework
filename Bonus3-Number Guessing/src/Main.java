import java.util.Scanner;

//Created by Andrew Klacza
//This program asks the user to guess a random number between 1 and 100
//and validates input

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the number guessing game!");

		play(scanner);
	}

	public static void play(Scanner scanner) {

		int random = (int) ((Math.random() * 99) + 1);
		int guess, numberOfGuesses = 0;
		String another = "y";

		//System.out.println("random number: " + random);

		while (another.equalsIgnoreCase("y")) {

			System.out.println("Guess a number from 1 to 100 (inclusive).");

			guess = getIntWithinRange(scanner);

			numberOfGuesses++;

			if (guess == random) {
				congrats(numberOfGuesses);
				playAgain(scanner);
				break;
			} else if (guess > (random + 11)) {
				System.out.println("Way too high!");
			} else if (guess > (random)) {
				System.out.println("Too high.");
			} else if (guess < (random - 11)) {
				System.out.println("Way too low!");
			} else if (guess < (random)) {
				System.out.println("Too low.");
			}
		}
	}

	public static int getIntWithinRange(Scanner scanner) {
		int min = 1, max = 100, number;

		while (!scanner.hasNextInt()) {
			System.out.println("That's not a valid input. Please enter a positive integer.");
			scanner.next(); // this is important!
		}
		number = scanner.nextInt();

		while (number < min || number > max) {
			System.out.println("Please enter a number between 1 and 100");
			number = scanner.nextInt();
		}
		return number;
	}

	public static void playAgain(Scanner scanner) {

		String another = "y";
		System.out.println("Do you want to play again? (y/n)");
		scanner.nextLine();
		another = scanner.nextLine();

		boolean isValidChoice = another.matches("^[ynYN]$");
		while (!isValidChoice) {
			System.out.println("That is not a valid option.");
			System.out.print("Would you like to continue? (y/n): ");
			another = scanner.nextLine();
			isValidChoice = another.matches("^[ynYN]$");
		}

		if (another.equalsIgnoreCase("y")) {
			play(scanner);
		} else
			System.out.println("Thanks for playing!");
	}

	public static void congrats(int guesses) {
		System.out.println("Congratulations, you guessed it!");
		System.out.println("It took you " + guesses + " guesses");
		if (guesses < 5) {
			System.out.println("You're a great guesser!");
		} else if (guesses < 20) {
			System.out.println("Your guessing skills are good");
		} else {
			System.out.println("It's about time!");
		}
	}
}
