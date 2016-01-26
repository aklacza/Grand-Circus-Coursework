import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*Created by Andrew Klacza
 * 	This program takes user input for length, width and height and calculates
 *  the perimeter, area and volume of a room.
 *  In addition, the program rounds the outputs to two decimal places and 
 *  checks for invalid input.  
 */

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String choice = "y";

		System.out.println("Welcome to Grand Circus' Room Detail Generator!");

		while (choice.equalsIgnoreCase("y")) {

			double length = enter("length");
			double width = enter("width");
			double height = enter("height");

			double perimeter = (2 * length) + (2 * width);
			double area = length * width;
			double volume = length * width * height;

			perimeter = round(perimeter);
			area = round(area);
			volume = round(volume);

			System.out.println("Perimeter: " + perimeter + " meters");
			System.out.println("Area:      " + area + " m^2");
			System.out.println("Volume:    " + volume + " m^3");
			System.out.println();

			System.out.println("Continue? (y/n)");
			choice = scanner.nextLine();
			System.out.println("you selected: " + choice);
		}
		System.out.println("goodbye");
		scanner.close();
	}

	public static double round(double number) {
		double numberRounded = new BigDecimal(number).setScale(2, RoundingMode.HALF_UP).doubleValue();
		return numberRounded;
	}

	static public double enter(String type) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter " + type + " in meters: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("That's not a valid input. Please enter a number for the " + type);
			scanner.next(); // this is important!
		}
		double input = scanner.nextDouble();
		return input;
	}

}
