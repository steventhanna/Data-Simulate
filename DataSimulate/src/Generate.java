import com.mongodb.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.io.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Generate extends Randomness {
	
	
	public static void generateInfluencer() throws IOException{
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		DBCollection coll = db.getCollection("user");
		
		// Add data
		// Vars
		String firstName = randomFirstName();
		String type = ("influencer");
		String lastName = randomLastName();
		String dateOfBirth = randomDate();
		String fullName = (firstName + " " + lastName);
		String email = (firstName + lastName + "@example.com");
		String password = ("password");
		String export = (firstName + " " + lastName + " , " + "DOB:" + dateOfBirth + " , "  + email + " , " + password + " , " + type);
		System.out.println(export);
		exportCredentials(export);
	}
	
	public static void generateAdvertiser() throws IOException {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		DBCollection coll = db.getCollection("user");
		
		// Add data
		// Vars
		String firstName = randomFirstName();
		String type = ("advertiser");
		String lastName = randomLastName();
		String dateOfBirth = randomDate();
		String fullName = (firstName + " " + lastName);
		String email = (firstName + lastName + "@example.com");
		String password = ("password");
		String export = (firstName + " " + lastName + " , " + "DOB:" + dateOfBirth + " , "  + email + " , " + password + " , " + type);
		System.out.println(export);
		exportCredentials(export);
	}
	
	public static void exportCredentials(String export) throws IOException {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/steventhanna/Desktop/Programming/java/data-simulate/credentials.txt", true)))) {
		    out.println(export);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
			System.out.println("HELP!");
		}
		
	}
}
