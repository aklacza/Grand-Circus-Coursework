import java.util.Scanner;

// This program simulates rolling two dice, of user specified sides each
// and validates user input
public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Grand Circus casino!");
		
		System.out.println("How many sides per die?");
		int sides = scanner.nextInt(); //get user input for sides of dice
		scanner.nextLine();
		
		System.out.println("Roll the dice? (y/n)");
		String roll = scanner.nextLine();
		
		int numberOfRolls = 0;
		
		while (!roll.equalsIgnoreCase("n")){
			
			System.out.println("Roll " + ++numberOfRolls); //print number of rolls and adds 1 to number
			rollDice(sides);
			roll = another(scanner, sides);
		}
		System.out.println("Thanks for playing!");
	}
	
	public static void rollDice(int sides){
		for(int x = 1; x <= 2 ; x++){  //finds two random numbers between 1 and number of sides
			System.out.println((int)(Math.random()*(sides) +1));
		}
	}
	
	public static String another(Scanner scanner, int sides){
		System.out.println("Any key to continue. (n to exit)"); //asks user to continue
		String play = scanner.nextLine();
		return play;
	}

}
