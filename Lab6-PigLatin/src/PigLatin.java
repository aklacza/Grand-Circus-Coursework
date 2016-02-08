import java.util.Scanner;

//Created by Andrew Klacza
//This program takes user input and translates it into pig latin

public class PigLatin {

	public static void main(String[] args) {
		System.out.println("Elcomway otay ethay Igpay Atinlay Anslatortray!");
		System.out.println("Enter text to translate:");

		Scanner scanner = new Scanner (System.in);
		int vowelLocation = 0;
		String input;
		//String input = "This is a simple, sentence.!?,";
		input = scanner.nextLine();

		while(input.equals("")){//checks to make sure input is not blank
			System.out.println("please enter a string:");
			input = scanner.nextLine();  //take user input
		}
		input = input.toLowerCase();  //convert to lower case
		
		String[] words = input.split("\\s+");  //splits sentence into words in an array

		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u' }; //character array of vowels
		char[] numbers = new char[] {'1', '2', '3','4','5','6','7','8','9','0','@','#','$','&','*'};

		for (String word : words) {  //iterates through each word of the String array
			vowelLocation = getVowelLocation(vowels, word); //finds location of first vowel

			String[] disallowedChars = new String[] { ".", ",", "!", "?" }; 
			for (String a : disallowedChars) {//removes these characters from the string
				word = word.replace(a, "");
			}
			
			StringBuilder tempWord = new StringBuilder(word);
			
			boolean hasNumbers = checkForNumbers(numbers, word);
			if(hasNumbers){
				continue;
			}
			
			
			
			addSuffix(vowelLocation, tempWord); //adds suffix and prints word
		}
		scanner.close();
	}

	private static void addSuffix(int vowelLocation, StringBuilder tempWord) {
		if (vowelLocation == 0) { //if word starts with vowel, end word with "way"
			tempWord = tempWord.insert((tempWord.length()), "way");
		} else { //if word starts with consonants, place starting consonants at end of word and add "ay" suffix
			addAy(vowelLocation, tempWord);
		}
		System.out.print(tempWord + " "); //prints out word with a space
	}

	private static void addAy(int vowelLocation, StringBuilder tempWord) {
		for (int y = 0; y < vowelLocation; y++) {
			char a = tempWord.charAt(0);
			tempWord.delete(0, 1); //deletes first character
			tempWord.insert((tempWord.length()), (a)); //adds first character to end
		}
		tempWord.insert((tempWord.length()), ("ay")); //adds suffix "ay"
	}

	private static int getVowelLocation(char[] vowels, String word) {
		for (int x = 0; x < word.length(); x++) {  //iterates through each letter of the string
			char c = word.charAt(x);

			for (char ch : vowels) { //iterates through each letter for vowels
				if (c == ch) {
					return x;  //returns location of first vowel found
				}
			}
		}
		return -1;
	}
	
	public static boolean checkForNumbers(char[] numbers, String word){
		for (int x = 0; x < word.length(); x++) {  //iterates through each letter of the string
			char c = word.charAt(x);

			for (char ch : numbers) { //iterates through each letter for numbers
				if (c == ch) {
					System.out.print(word + " "); //prints out word with a space
					return true;  //returns true if number found
				}
			}
		}
		return false;
	}
}
