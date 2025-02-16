import com.mongodb.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.io.*;

import org.bson.types.ObjectId;

public class Defaults {
	
	public static void createDefaultsDB() throws IOException {
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("DS-DB");

		// Test to make sure the database was created properly
		DBCollection collection = db.getCollection("test");
		
		BasicDBObject profile = new BasicDBObject("testHead", "testBody");
		collection.insert(profile);
		
	}
	
	// Create defaults on init
	public static void defaults() throws IOException {
		// Test to see if database exists
		// Actually, this will create a DB no matter what... 
		// Should test for contents in the collection
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("DS-DB");
		DBCollection userDefaults = db.getCollection("userDefaults");
//		String firstTime = userDefaults.findOne("firstTime").toString();
//		BasicDBObject time = new BasicDBObject("firstTime", true);
//		userDefaults.insert(time);
//		System.out.println(firstTime + " first time");
	}
	
	
	public static void main(String[] args) throws IOException {
		defaults();
		
	}

}
