import java.util.Scanner;

//Created by Andrew Klacza
//This program calculates the factorial of a user-entered number
//and validates input

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Factorial Calculator");
		System.out.println();

		program(scanner);
	}
	
	public static void program(Scanner scanner){
		int x = getIntWithinRange(scanner);  //gets valid integer
		long y = compute(x);
		System.out.println("The factorial of " + x + " is " + y);
		again(scanner);
	}
	
	public static int getInput(Scanner scanner){
		System.out.println("Enter an integer between 1 and 19: ");
		int x = scanner.nextInt();
		return x;
	}
	
	public static int getIntWithinRange(Scanner scanner) {
		int min = 1, max = 19, number;

		System.out.println("Enter an integer between 1 and 19: ");
		
		while (!scanner.hasNextInt()) {
			System.out.println("That's not a valid input. Please enter a positive integer 1-19.");
			scanner.next(); // this is important!
		}
		number = scanner.nextInt();

		while (number < min || number > max) {
			System.out.println("Please enter a number between 1 and 19");
			number = scanner.nextInt();
		}
		return number;
	}
	
	public static int compute(int n){ //uses recursion
		if (n == 0)
			{return 1;}
		else{
			return n * compute(n-1);
		}
	}
	
//	public static void compute(int x) {  //uses iteration
//		long answer = 1;
//
//		for (int y = 2; y <= x; y++) {
//			answer *= y;
//		}
//		System.out.println("The factorial of " + x + " is " + answer);
//	}

	public static void again(Scanner scanner) {
		System.out.println("continue? (y/n)");
		scanner.nextLine();
		String another = scanner.nextLine();

		boolean isValidChoice = another.matches("^[ynYN]$");
		while (!isValidChoice) {
			System.out.println("That is not a valid option.");
			System.out.print("Would you like to continue? (y/n): ");
			another = scanner.nextLine();
			isValidChoice = another.matches("^[ynYN]$");
		}
		if (another.equalsIgnoreCase("y")) {
			program(scanner);
		}else {
			System.out.println("Program ending.");
		}
	}
}
