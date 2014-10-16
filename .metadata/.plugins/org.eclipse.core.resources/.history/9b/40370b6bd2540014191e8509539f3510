/**
*	<code>Driver</code> will loop through and create several instances of users on the 
*		adswithfriends database
*	@author Preston Stosur-Bassett
*	@date October 15 2014
*/

import java.util.Random;

public class Driver {
	public static void main(String[] args) {
		//Create a boolean for either advertiser or influencer
		boolean advOrInf;

		//Loop 100 times creating new users
			//Should create about 50 influencers and about 50 advertisers
		for(int i = 0; i < 100; i++) {
			advOrInf = new Random().nextInt(2)==0;

			if(advOrInf == true) {
				//Create an advertiser account
				InsertData.createUser("Advertiser");
			}
			else {
				//Create an influencer account
				InsertData.createUser("Influencer");
			}
		}
	}
}