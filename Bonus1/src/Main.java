import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Letter Grade Converter!!");

		String check = "y";
		
		while(check.equalsIgnoreCase("y")){
			System.out.println("Enter numerical grade:");

			int grade = scanner.nextInt();
			String gradeString;

			if (grade > 87) {
				gradeString = "A";
			} else if (grade > 79) {
				gradeString = "B";
			} else if (grade > 66) {
				gradeString = "C";
			} else if (grade > 60) {
				gradeString = "D";
			} else {
				gradeString = "F";
			}

			System.out.println("Letter grade: " + gradeString);
			
			System.out.println("Continue? (y/n)");
			check = scanner.nextLine();
			check = scanner.nextLine();
		}
		
		scanner.close();
		

	}

}
