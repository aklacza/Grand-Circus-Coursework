import java.util.Scanner;

//Created by Andrew Klacza
//This program takes the radius of a circle, inputted by the user, and calculates
//the area and circumference of a circle 

public class CircleApp {

	public static void main(String[] args) {

		banner();

		Scanner scan = new Scanner(System.in);
		String another = "y";
		int circles = 0;

		while (!another.equalsIgnoreCase("n")) {

			circles++;
			Circle circle = new Circle(getIntegerInRange(scan, "Please enter the radius of a circle: ", 0, 1000000));
			scan.nextLine();
			System.out.println(circle);

			System.out.println("Continue? (n to exit)");
			another = scan.nextLine();
		}
		System.out.println("Goodbye. You created " + circles + " circle(s).");
		scan.close();
	}

	public static int getIntegerInRange(Scanner sc, String prompt, int min, int max) {
		// receives and validates user input
		// within minimum and maximum values
		int input;
		System.out.println(prompt);
		for (;;) {
			if (!sc.hasNextInt()) {
				System.out.println("Please enter an integer between " + min + " and " + max + ".");
				sc.next(); // discard
				continue;
			}
			input = sc.nextInt();
			if (input >= min && input <= max) {
				return input;
			} else {
				System.out.println("Please enter an integer between " + min + " and " + max + ".");
				continue;
			}
		}
	}

	public static void banner() {
		System.out.println("		 _____ _          _       ___");
		System.out.println("		/  __ (_)        | |     /  _\\");
		System.out.println("		| /  \\/_ _ __ ___| | ___/ /_\\ \\_ __  _ __  ");
		System.out.println("		| |   | | '__/ __| |/ _ \\  _  | '_ \\| '_ \\");
		System.out.println("		| \\__/\\ | | | (__| |  __/ | | | |_) | |_) |");
		System.out.println("		 \\____/_|_|  \\___|_|\\___\\_| |_/ .__/| .__/ ");
		System.out.println("	                  	              | |   | |");
		System.out.println("		    	                      |_|   |_|    ");
		System.out.println("");
	}
}
