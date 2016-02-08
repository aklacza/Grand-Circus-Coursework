import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[][] students = new String[][] { { "John Yossarian", "Pianosa", "Chocolate-covered cotton" },
				{ "Harry P.", "Little Whinging", "earwax-flavored jelly beans" },
				{ "Billy Pilgrim", "Dresden", "pregnant women's nutritional supplement" },
				{ "Alex DeLarge", "London", "milk and ultraviolence" },
				{ "Winston Smith", "Airstrip One", "synthetic foodstuffs and oily gin" } };

		String input = "y", name;

		System.out.println("Welcome to the student database! Options:");

		loop: while (!input.equalsIgnoreCase("n")) {
			System.out.println("List: list of students");
			System.out.println("Name: Enter a student name for more information");
			System.out.println("Foods: List students and their favorite food");
			System.out.println("Hometown: Lists students and their hometowns");
			System.out.println("Listall: Lists students, their hometowns and favorite foods");

			input = scanner.nextLine();
			input.toLowerCase();

			switch (input) {
			case ("list"): {
				studentList(students);
				break;
			}
			case "name": {
				System.out.println("Please enter student name:");
				input = scanner.nextLine();
				moreInfo(students, input);
				break;
			}
			case "foods": {
				foods(students);
				break;
			}
			case "hometown": {
				hometown(students);
				break;
			}
			case "listall": {
				listAll(students);
				break;
			}
			default:
				System.out.println("Invalid input");
				System.out.println("Please enter one of the following options:");
				System.out.println("(list/name/foods/hometown/listall)");
				System.out.println("N to exit");
				
				continue loop;
			}
			System.out.println("Continue? (n to exit)");
			input = scanner.nextLine();
		}
		System.out.println("Goodbye.");
		scanner.close();
	}

	public static void foods(String[][] students) {
		for (int i = 0; i < (students.length - 1); i++) {
			System.out.println("Name: " + students[i][0] + ", favorite food:" + students[i][2]);
		}
	}

	public static void hometown(String[][] students) {
		for (int i = 0; i < (students.length - 1); i++) {
			System.out.println("Name: " + students[i][0] + ", hometown:" + students[i][1]);
		}
	}

	public static void studentList(String[][] students) {
		for (int i = 0; i < (students.length); i++) {
			System.out.println(students[i][0]);
		}
	}
	
	public static void listAll(String[][] students) {
		for (int i = 0; i < (students.length); i++) {
			System.out.println("Name: " + students[i][0] + 
					", hometown: " + students[i][1] + 
					", favorite food: " + students[i][2]);
		}
	}

	public static void moreInfo(String[][] students, String name) {
		for (int i = 0; i < (students.length); i++) {
			if (students[i][0].equalsIgnoreCase(name)) {
				System.out.println("Name: " + students[i][0]);
				System.out.println("Hometown: " + students[i][1]);
				System.out.println("Favorite food: " + students[i][2]);
			}
		}
	}
}
