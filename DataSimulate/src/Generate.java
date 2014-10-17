import com.mongodb.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;
import java.io.*;

import org.bson.types.ObjectId;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Generate extends Randomness {
	
	public static void exportCredentials(String export) throws IOException {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/Users/steventhanna/Desktop/Programming/sails/adswithfriends/data-simulate/datasimulate/credentials.txt", true)))) {
		    out.println(export);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
			System.out.println("HELP!");
		}
		
	}
}