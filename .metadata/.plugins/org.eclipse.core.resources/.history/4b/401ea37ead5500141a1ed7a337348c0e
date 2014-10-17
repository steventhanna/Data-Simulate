import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.Collections;

public class Randomness {

	public static float randomFloat() {
		float randy = new Random().nextFloat();
		return randy;
	}

	public static String[] randomSphere() {
		//Generate a random number between 0 and 10
		//new Random().nextInt((max - min) + 1) + min;
		int lengthOfSphere = new Random().nextInt((10 - 0) + 1) + 0;

		String[] spheres = new String[lengthOfSphere];

		if(lengthOfSphere == 0) {
			//Add nothing, this person has no interests... how boring.
		}
		if(lengthOfSphere >= 1) {
			spheres[0] = "Conversation Starters";
		}
		if(lengthOfSphere >= 2) {
			spheres[1] = "Politics";
		}
		if(lengthOfSphere >= 3) {
			spheres[2]  = "Sports";
		}
		if(lengthOfSphere >= 4) {
			spheres[3] = "TV";
		}
		if(lengthOfSphere >= 5) {
			spheres[4] = "Movies";
		}
		if(lengthOfSphere >= 6) {
			spheres[5] = "Music";
		}
		if(lengthOfSphere >= 7) {
			spheres[6] = "Food";
		}
		if(lengthOfSphere >= 8) {
			spheres[7] = "Tech";
		}
		if(lengthOfSphere >= 9) {
			spheres[8] = "Countries";
		}

		return spheres;
	}

	public static Location randomLocation() {
		boolean cityOrState = new Random().nextInt(2)==0;
		Location location;

		if(cityOrState == true) {
			//Return a random location with just state and country
			location = new Location("Illinois", "USA");
		}
		else {
			//Return a random location with city, state, and country
			location = new Location("Chicago", "IL", "USA");
		}

		return location;
	}
	
	public static String randomDate() {
		Random random = new Random();
		// Pick Month
		int month = random.nextInt(13);
		// Pick Date
		int date = random.nextInt(32);
		// Pick Year
		int year = random.nextInt(2016);
		String finalDate = (month + "/" + date + "/" + year);
		// Output
		System.out.println(month + "/" + date + "/" + year);
		return finalDate;
		
	}
	
	public static String randomFirstName() throws IOException {
		String fileName = "../../firstNames.txt";
		ArrayList<String> allNames = new ArrayList<String>();
		Random random = new Random();

		BufferedReader in = new BufferedReader(new FileReader(fileName)); 
		while (in.ready()) { 
		     allNames.add( in.readLine() );
		}
		in.close();

		String randomName = allNames.get(random.nextInt(allNames.size()));
		System.out.println(randomName);
		return randomName;
	}
	
	public static String randomWord() throws IOException {
		String fileName = "../../the-english.txt";
		ArrayList<String> allNames = new ArrayList<String>();
		Random random = new Random();

		BufferedReader in = new BufferedReader(new FileReader(fileName)); 
		while (in.ready()) { 
		     allNames.add( in.readLine() );
		}
		in.close();

		String randomName = allNames.get(random.nextInt(allNames.size()));
		System.out.println(randomName);
		return randomName;
	}
	
	public static String randomLastName() throws IOException {
		String fileName = "../../lastNames.txt";
		ArrayList<String> allNames = new ArrayList<String>();
		Random random = new Random();

		BufferedReader in = new BufferedReader(new FileReader(fileName)); 
		while (in.ready()) { 
		     allNames.add( in.readLine() );
		}
		in.close();

		String randomName = allNames.get(random.nextInt(allNames.size()));
		System.out.println(randomName);
		return randomName;
	}
	
	public static boolean randomBoolean() {
		Random random = new Random();
		Boolean bool = random.nextBoolean();
		System.out.println(bool);
		return bool;
	}
	
	public static int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(100001);
		return number;
	}
	
	public static float randomID() {
		Random random = new Random();
		float number = random.nextFloat();
		//float newNumber = number * 100000000000000000000;
		//System.out.println(number);
		return number;
	}
	
	
	
}
