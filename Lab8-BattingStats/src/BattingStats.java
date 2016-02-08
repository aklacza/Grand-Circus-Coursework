import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

//Created by Andrew Klacza

// This program calculates batting averages for multiple batters, validates input,
// stores results in an array, and gives the option to print results for all batters
// at the end of the program.
// In addition, the program plays the first seven notes of "take me out to the ball game" 
// using an imported midi synthesizer library

public class BattingStats {

	public static void main(String[] args) {

		banner(); //prints ascii art banner

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Batting Average Calculator!");

		music(); //plays intro music

		String another = "y";
		ArrayList<ArrayList<Integer>> allResults = new ArrayList<ArrayList<Integer>>();

		while (!another.equalsIgnoreCase("n")) { //continues to ask for input until user inputs "n"
			ArrayList<Integer> currentResults = new ArrayList<Integer>(); //initiates new ArrayList for each batter

			int atBats = getIntegerInRange(scanner, "Enter number of times at bat, up to 10: ", 1, 10);

			System.out.println("Enter 0 - no runs, 1-single, 2-double, 3-triple, 4 grand slam.");

			for (int x = 0; x < atBats; x++) { //receives input for each at-bat
				// System.out.println("Result for at-bat " + (x + 1) + " : ");
				int result = getIntegerInRange(scanner, ("Result for at-bat " + (x + 1) + " : "), 0, 4);
				currentResults.add(result);
			}
			scanner.nextLine();

			results(currentResults); //prints results and averages for the batter

			allResults.add(currentResults); //adds batter results to an ArrayList to print all later

			System.out.println();  
			System.out.println("Enter another batter? n to exit");  //asks user to continue
			another = scanner.nextLine();

		}

		System.out.println("Print all stats? (y/n)");  //asks user to print all stats
		another = scanner.nextLine();
		if (another.equalsIgnoreCase("y")) {  //prints all results
			for (ArrayList<Integer> array : allResults) {
				results(array);
			}
		}

		System.out.println("Exiting.");

	}

	public static void results(ArrayList<Integer> currentResults) { //calculates batting avg and slugging pct
		int sum = 0;
		int notZero = 0;

		System.out.println("Results: ");

		for (int x : currentResults) {
			sum += x;
			if (x > 0) {
				notZero++;
			}
			System.out.print(x + ", ");
		}
		System.out.println();

		double battingAvg = ((double) notZero / (double) currentResults.size());
		double sluggingPct = ((double) sum / (double) currentResults.size());

		NumberFormat decimal = NumberFormat.getInstance();
		decimal.setMaximumFractionDigits(3);
		String batAvgForm = decimal.format(battingAvg);
		String slugAvgForm = decimal.format(sluggingPct);

		System.out.println("Batting Average: " + batAvgForm);
		System.out.println("Slugging Percentage: " + slugAvgForm);
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

	public static void music() {  //plays intro music
		int channel = 0; // 0 is a piano, 9 is percussion
		int volume = 100; // between 0 and 127
		int duration = 200; // in milliseconds

		try {
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			MidiChannel[] channels = synth.getChannels();

			channels[channel].noteOn(60, volume); // C note, half
			Thread.sleep((int) (duration * 2.2));
			channels[channel].noteOff(60);

			Thread.sleep((int) (duration / 2));  // pause between notes

			channels[channel].noteOn(74, volume); // C note - high
			Thread.sleep(duration);
			channels[channel].noteOff(74);

			Thread.sleep(duration / 2);

			channels[channel].noteOn(70, volume); // A note
			Thread.sleep(duration);
			channels[channel].noteOff(70);

			Thread.sleep(duration / 2);

			channels[channel].noteOn(68, volume); // G note
			Thread.sleep(duration);
			channels[channel].noteOff(68);

			Thread.sleep(duration / 2);

			channels[channel].noteOn(64, volume); // E note
			Thread.sleep(duration);
			channels[channel].noteOff(64);

			Thread.sleep(duration / 2);

			channels[channel].noteOn(66, volume); // F note, whole
			Thread.sleep((int) (duration * 4));
			channels[channel].noteOff(66);

			Thread.sleep(duration);

			channels[channel].noteOn(62, volume); // D note, whole

			Thread.sleep(duration * 7);
			channels[channel].noteOff(62);

			Thread.sleep(500);
			channels[channel].allNotesOff();
			Thread.sleep(500);
			synth.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void banner(){
	System.out.println("______         _    _    _                 _____  _          _         _  _");
	System.out.println("| ___ \\       | |  | |  (_)               /  ___|| |        | |       | || |");
	System.out.println("| |_/ /  __ _ | |_ | |_  _  _ __    __ _  \\ `--. | |_  __ _ | |_  ___ | || |");
	System.out.println("| ___ \\ / _` || __|| __|| || '_ \\  / _` |  `--. \\| __|/ _` || __|/ __|| || |");
	System.out.println("| |_/ /| (_| || |_ | |_ | || | | || (_| | /\\__/ /| |_| (_| || |_ \\__ \\|_||_|");
	System.out.println("\\____/  \\__,_| \\__| \\__||_||_| |_| \\__, | \\____/  \\__|\\__,_| \\__||___/(_)(_)");
	System.out.println("                                    __/ |");
	System.out.println("                                   |___/    ");
	}
}
