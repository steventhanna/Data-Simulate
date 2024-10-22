import com.mongodb.*;

import java.io.*;
import java.net.UnknownHostException;
import java.util.*;

import org.bson.types.ObjectId;

import static java.util.concurrent.TimeUnit.SECONDS;

public class AddToMongo extends Generate {

	public static void addInfluencer() throws IOException {
		// Initialize mongo client
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		
		// Declare collections
		DBCollection influencer = db.getCollection("influencer");
		DBCollection security = db.getCollection("security");
		DBCollection user = db.getCollection("user");
		
		// Add user information
		// User
		String firstName = randomFirstName();
		String type = ("influencerAccount");
		String primaryAccount = ("Influencer");
		Boolean completed = randomBoolean();
		Boolean confirmed = randomBoolean();
		Boolean isActive = randomBoolean();
		Boolean securityProfile = randomBoolean();
		Boolean linkToTwitter = randomBoolean();
		String securityQuestion1 = randomWord();
		String securityQuestion2 = randomWord();
		String lastName = randomLastName();
		String dateOfBirth = randomDate();
		int totalValue = randomNumber();
		int totalTweets = randomNumber();
		String fullName = (firstName + " " + lastName);
		String email = (firstName + lastName + "@example.com");
		String password = ("password");
		Boolean allowExplicit = randomBoolean();
		Boolean resetPassword = randomBoolean();
		Double uid = null;
		
		
		// Add information to collection USER
		
		
		// Lets try something... lets update the collection with the new _ID
		BasicDBObject userObject = new BasicDBObject("email", email)
		.append("password", password)
		// .append("uid", uid)
		.append("firstName", firstName)
		.append("lastName", lastName)
		.append("fullName", fullName)
		.append("influencerAccount", null)
		.append("securityProfile", securityProfile )
		.append("confirmed", confirmed)
		.append("completeProfile", completed)
		.append("linkToTwitter", linkToTwitter)
		.append("location", "Chicago, IL");
		
		// Add collection information to collection USER
		user.insert(userObject);
		// Get the userId _ID 
		ObjectId id = (ObjectId)userObject.get( "_id" );
		ObjectId influencerAccount = id;
		
		// Reassign id to influencerAccount
		
		userObject.append("$set", new BasicDBObject().append("influencerAccount", id));
		
		// Add information to collection INFLUENCER
		BasicDBObject influencerObject = new BasicDBObject("_id", id)
		.append("isActive",isActive )
		.append("sphere", " ")
		.append("allowExplicit", allowExplicit)
		.append("totalValue", totalValue)
		.append("totalTweets", totalTweets)
		.append("payoutOption", 50);
		
		// Add collection information to collection INFLUENCER
		influencer.insert(influencerObject);
		
		// Add information to collection SECURITY
		BasicDBObject securityObject = new BasicDBObject("_id",id )
		.append("resetPassword", resetPassword);
		
		// Add collection information to collection SECURITY
		security.insert(securityObject);
		
		// Prepare information for export
		String export = ("_id: " + id + " " + "uid: " + uid +  firstName + " " + lastName + " , " + "DOB:" + dateOfBirth + " , "  + email + " , " + password + " , " + " Security Question 1: " + securityQuestion1 + " , " + "Security Question 2: " + securityQuestion2 + " , " + type + "totalTweets: " + totalTweets + " isActive: " + isActive + " allowExplicit: " + allowExplicit + " influencerAccount " + influencerAccount);
		// Export
		exportCredentials(export);
		
	}
	
	public static void addAdvertiser() throws UnknownHostException {
		// Initialize mongo client
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("awf_db");
		// Declare collections
		DBCollection advertiser = db.getCollection("advertiser");
		DBCollection security = db.getCollection("security");
		DBCollection user = db.getCollection("user");
		
	}
	
	
}