import com.mongodb.*;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

import org.bson.types.ObjectId;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AddToMongo extends Randomness {
	
	// Create the object method
	public static Object createUser(String primaryAccount) throws IOException {
		// Init mongo
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		// Define collections
		// DBCollection influencers = db.getCollection("influencer");
		// DBCollection advertiser = db.getCollection("advertiser");
		// DBCollection securityCollection = db.getCollection("security");
		DBCollection users = db.getCollection("user");
		
		// Generate random user information
		// Names
		String firstName = randomFirstName();
		String lastName = randomLastName();
		String fullName = firstName + " " + lastName;
		String email = firstName +"." + lastName + "@adswithfriends.com";
		// For testing purposes, we will set these to true
		Boolean completed = true;
		Boolean confirmed = true;
		Boolean isActive = randomBoolean();
		// Random uid
		int uid = randomNumber();
		Boolean linkToTwitter = randomBoolean();
		String dateOfBirth = randomDate();
		// Init location
		Location location = randomLocation();
		String fullLocation = location.getLocation();
		String city = null;
		String state = location.getState();
		String country = location.getCountry();
		String password = randomWord();
		
		// City check
		if(location.hasCity()) {
			city = location.getCity();
		}
		
		// Create a security profile for a user
		ObjectId securityProfile = createSecurityProfile();
		
		// Create the user object
		BasicDBObject userAccount = new BasicDBObject("primaryAccount", primaryAccount)
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
		.append("securityProfile", securityProfile);
		
		//Create advertiser account or influencer account
		if(primaryAccount.equals("Influencer")) {
			ObjectId influencerProfile = createInfluencer();
			userAccount.append("influencerAccount", influencerProfile);
			userAccount.append("primaryAccount", primaryAccount);
		}
		else if(primaryAccount.equals("Advertiser")) {
			ObjectId advertiserProfile = createAdvertiser();
			userAccount.append("advertiserAccount", advertiserProfile);
			userAccount.append("primaryAccount", primaryAccount);
		}
		else {
			System.out.println("ERROR!! Error Code 01 = Incorrect Account Type.");
		}
		
		// Get the userId again? 
		Object userId = userAccount.get("_id");
		
		// Insert the user information
		users.insert(userAccount);
		
		//export the users credentials
		String creds = "Username: "+email + ";  Password: "+password+";  ";
		exportCredentials(creds);

		return userId;
		
		
	}

	public static ObjectId createSecurityProfile() throws IOException {
		// Init
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		DBCollection securityCollection = db.getCollection("security");
		
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
		
		
		ObjectId thisID = (ObjectId)profile.get("_id");
		
		//insert the security object into the security collection
		securityCollection.insert(profile);

		return thisID;
		
	}
	
	public static ObjectId createInfluencer() throws IOException {
		// init
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		DBCollection influencers = db.getCollection("influencer");
		
		//Generate the random data
		boolean isActive = true;
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

		ObjectId influencerID = (ObjectId)influencerAccount.get("_id");

		//Insert the influencer into the collection
		influencers.insert(influencerAccount);

		return influencerID;
		
	}

	public static ObjectId createAdvertiser() throws IOException {
		// init
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		DBCollection advertisers = db.getCollection("advertiser");
		
		//Generate random data
		boolean isActive = true;
		String[] sphere = randomSphere();
		boolean explicit = randomBoolean();
		int totalTweets = randomNumber();
		float currentValue = randomFloat();
		boolean advertiserReady = true;
		float lastUploadValue = randomFloat();
		String organizationName = randomWord();
	
		//Create the advertiser object
		BasicDBObject advertiserAccount = new BasicDBObject("isActive", isActive)
		.append("sphere", sphere)
		.append("explicit", explicit)
		.append("totalTweets", totalTweets)
		.append("currentValue", currentValue)
		.append("advertiserReady", advertiserReady)
		.append("lastUploadValue", lastUploadValue)
		.append("organizationName", organizationName);
	
		ObjectId advertiserID = (ObjectId)advertiserAccount.get("_id");
	
		//Insert the advertiser into the collection
		advertisers.insert(advertiserAccount);
	
		return advertiserID;
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