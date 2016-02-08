import java.util.Scanner;

//Created by Andrew Klacza
//This program takes an integer as input and outputs the square and cube roots
//of all integers until that number.

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String another = "y";

		do {
			System.out.println("Learn your squares and cubes!");
			System.out.println("Enter an integer.");
			
			while (!scanner.hasNextInt()) {
				System.out.println("That's not a valid input. Please enter a positive integer.");
				scanner.next();
			}
			
			int x = scanner.nextInt();
			
			scanner.nextLine();

			System.out.println("Number \t Squared \t Cubed");
			System.out.println("====== \t ======= \t =====");

			for (int y = 1; y <= x; y++) {
				System.out.println(y + 
						"\t " + Math.pow(y, 2) + 
						"\t\t " + Math.pow(y, 3) + "\t");
			}

			System.out.println("Continue? (y/n)");
			another = scanner.nextLine();

		} while (another.equals("y"));
		System.out.println("Good bye.");
	}
}
