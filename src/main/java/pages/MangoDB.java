package pages;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MangoDB {
	
	public static void mongoClient() {
		MongoClient mc = new MongoClient("localhost", 27017);
		System.out.println("Created Mongo DB Connection successfully");
		
		MongoDatabase db = mc.getDatabase("Jacky");
		System.out.println("Get database is successfull");
		
		MongoCollection<Document> collection = db.getCollection("Testing");
		Document doc = new Document("name", "DemoQA");
		collection.insertOne(doc);
		
		MongoCursor<String> dbsCursor =  mc.listDatabaseNames().iterator();
		while(dbsCursor.hasNext()) {
			System.out.println(dbsCursor.next());
		}
		
		mc.close();
	}
}
