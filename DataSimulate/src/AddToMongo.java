import com.mongodb.*;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AddToMongo extends Generate {

	public static void addInfluencer() throws IOException {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		// Define collections
		DBCollection influencer = db.getCollection("influencer");
		DBCollection advertiser = db.getCollection("advertiser");
		DBCollection security = db.getCollection("security");
		DBCollection user = db.getCollection("user");
		
		// Add user information
		// User
		String firstName = randomFirstName();
		String type = ("influencerAccount");
		String primaryAccount = ("Influencer");
		Boolean completed = randomBoolean();
		Boolean confirmed = randomBoolean();
		Boolean securityProfile = randomBoolean();
		Boolean linkToTwitter = randomBoolean();
		String securityQuestion1 = randomWord();
		String securityQuestion2 = randomWord();
		String lastName = randomLastName();
		String dateOfBirth = randomDate();
		String fullName = (firstName + " " + lastName);
		String email = (firstName + lastName + "@example.com");
		String password = ("password");
		String export = (firstName + " " + lastName + " , " + "DOB:" + dateOfBirth + " , "  + email + " , " + password + " , " + " Security Question 1: " + securityQuestion1 + " , " + "Security Question 2: " + securityQuestion2 + " , " + type);
		exportCredentials(export);
		BasicDBObject userObject = new BasicDBObject("email", firstName)
		.append("password", password)
		.append("firstName", firstName)
		.append("lastName", lastName)
		.append("fullName", fullName)
		.append("primaryAccount", primaryAccount)
		.append("securityProfile", securityProfile )
		.append("confirmed", confirmed)
		.append("completeProfile", completed)
		.append("linkToTwitter", linkToTwitter)
		.append("location", null);
		
		// Add to db
		user.insert(userObject);
		
		
	}
}
