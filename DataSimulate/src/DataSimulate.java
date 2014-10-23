/*
 * Copyright (c) 2008-2014 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.mongodb.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * The tutorial from http://docs.mongodb.org/ecosystem/tutorial/getting-started-with-java-driver/
 */
public class DataSimulate extends AddToMongo {
    // CHECKSTYLE:OFF
    /**
     * Run this main method to see the output of this quick example.
     *
     * @param args takes no args
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException {
        // connect to the local database server
        MongoClient mongoClient = new MongoClient();

        /*
        // Authenticate - optional
        MongoCredential credential = MongoCredential.createMongoCRCredential(userName, database, password);
        MongoClient mongoClient = new MongoClient(new ServerAddress(), Arrays.asList(credential));
        */

        // get handle to "mydb"
        DB db = mongoClient.getDB("awf_db");

        // get a list of the collections in this database and print them out
        /*Set<String> collectionNames = db.getCollectionNames();
        for (final String s : collectionNames) {
            System.out.println(s);
        }*/
        
        //Create a boolean for either advertiser or influencer
		boolean advOrInf;
	
		//Loop 100 times creating new users
			//Should create about 50 influencers and about 50 advertisers
		for(int i = 0; i < 100; i++) {
			advOrInf = new Random().nextInt(2)==0;
	
			if(advOrInf == true) {
				//Create an advertiser account
				createUser("Advertiser");
			}
			else {
				//Create an influencer account
				createUser("Influencer");
			}
		}
        
        mongoClient.close();
    }
    // CHECKSTYLE:ON
}
