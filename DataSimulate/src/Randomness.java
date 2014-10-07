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
		String fileName = "/Users/steventhanna/Desktop/Programming/sails/adswithfriends/Data-Simulate/firstNames.txt";
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
		String fileName = "/Users/steventhanna/Desktop/Programming/sails/adswithfriends/Data-Simulate/the-english.txt";
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
		String fileName = "/Users/steventhanna/Desktop/Programming/sails/adswithfriends/Data-Simulate/lastNames.txt";
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
		float newNumber = number * 100000000000000000000;
		System.out.println(newNumber);
		return newNumber;
	}
	
	
	
}
