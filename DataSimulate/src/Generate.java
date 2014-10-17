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
		DBCollection securityCollection = db.getCollection("security");
		DBCollection influencers = db.getCollection("influencer");
		
		//Generate random user information
		String firstName = randomFirstName();
		String lastName = randomLastName();
		//For testing purposes, we will set these to true, 
		Boolean completed = true; //randomBoolean();
		Boolean confirmed = true; //randomBoolean();
		Boolean isActive = randomBoolean();
		int uid = randomNumber();
		String fullName = firstName + " " + lastName;
		Boolean linkToTwitter = randomBoolean();
		String dateOfBirth = randomDate();
		Location location = randomLocation();
		String fullLocation = location.getLocation();
		String city = null;
		String state = location.getState();
		String country = location.getCountry();
		String password = randomWord();
		String email = (firstName+"."+lastName+"@adswithfriends.com");

		if(location.hasCity()) {
			city = location.getCity();
		}

		//Create a security profile for the user
		//Generate the random information
		boolean resetPassword = false;
		String questionOne = randomWord();
		String questionTwo = randomWord();
		String answerOne = randomWord();
		String answerTwo = randomWord();
		int resetToken = randomNumber();

		//create the security object
		BasicDBObject profile = new BasicDBObject("resetPassword", resetPassword)
		.append("questionOne", questionOne)
		.append("questionTwo", questionTwo)
		.append("answerOne", answerOne)
		.append("answerTwo", answerTwo)
		.append("resetToken", resetToken);

		ObjectId securityId = (ObjectId)profile.get("_id");

		//insert the security object into the security collection
		securityCollection.insert(profile);

		//Create an influencer account for the user
		//Generate the random data
		//boolean isActive = true;
		String[] sphere = randomSphere();
		boolean allowExplicit = randomBoolean();
		Location fullTwitterLocation = randomLocation();
		String twitterLocation = fullTwitterLocation.getLocation();
		int followerCount = randomNumber();
		String dateCreated = randomDate();
		int statusCount = randomNumber();
		boolean defaultProfile = randomBoolean();
		boolean suspendStatus = randomBoolean();
		float totalValue = randomFloat();
		int totalTweets = randomNumber();
		float payoutOption = randomFloat();

		//Create the influencer object
		BasicDBObject influencerAccount = new BasicDBObject("isActive", isActive)
		.append("sphere", sphere)
		.append("allowExplicit", allowExplicit)
		.append("location", twitterLocation)
		.append("followerCount", followerCount)
		.append("dateCreated", dateCreated)
		.append("statusCount", statusCount)
		.append("defaultProfile", defaultProfile)
		.append("suspendStatus", suspendStatus)
		.append("totalValue", totalValue)
		.append("totalTweets", totalTweets)
		.append("payoutOption", payoutOption);

		ObjectId influencerId = (ObjectId)influencerAccount.get("_id");

		//Insert the influencer into the collection
		influencers.insert(influencerAccount);

		//Create a user account for this user
		BasicDBObject userAccount = new BasicDBObject("primaryAccount", "Influencer")
		.append("firstName", firstName)
		.append("lastName", lastName)
		.append("completed", completed)
		.append("confirmed", confirmed)
		.append("isActive", isActive)
		.append("uid", uid)
		.append("fullName", fullName)
		.append("linkToTwitter", linkToTwitter)
		.append("birthdate", dateOfBirth)
		.append("location", fullLocation)
		.append("city", city)
		.append("state", state)
		.append("country", country)
		.append("email", email)
		.append("password", password)
		.append("influencerAccount", influencerId)
		.append("securityProfile", securityId);
	}
	
	public static void generateAdvertiser() throws IOException {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		DBCollection coll = db.getCollection("user");
		
		// Add data
		// Vars
		String firstName = randomFirstName();
		String type = ("advertiserAccount");
		String primaryAccount = ("Advertiser");
		Boolean completed = randomBoolean();
		String lastName = randomLastName();
		String dateOfBirth = randomDate();
		String securityQuestion1 = randomWord();
		String securityQuestion2 = randomWord();
		String fullName = (firstName + " " + lastName);
		String email = (firstName + lastName + "@example.com");
		String password = ("password");
		String export = (firstName + " " + lastName + " , " + "DOB:" + dateOfBirth + " , "  + email + " , " + password + " , " + " Security Question 1: " + securityQuestion1 + " , " + "Security Question 2: " + securityQuestion2 + " , " + type);
		exportCredentials(export);
		
		//Where is this being added to an advertiser object? where is this added to a user account?
	}
	
	public static void exportCredentials(String export) throws IOException {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/steventhanna/Desktop/Programming/sails/adswithfriends/data-simulate/datasimulate/credentials.txt", true)))) {
		    out.println(export);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
			System.out.println("HELP!");
		}
		
	}
}
