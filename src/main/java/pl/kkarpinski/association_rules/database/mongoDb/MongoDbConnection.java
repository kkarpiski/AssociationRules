package pl.kkarpinski.association_rules.database.mongoDb;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.types.ObjectId;

import org.bson.Document;
import java.util.Arrays;

/**
 * Created by kkarp.
 */
public class MongoDbConnection {
    public static void main(String[] args) {
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "mongodb+srv://admin:admin@cluster0.8h7vv.mongodb.net";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Cluster0");
            MongoCollection<org.bson.Document> collection = database.getCollection("Collection");
            InsertOneResult result = collection.insertOne(new Document()
                    .append("_id", "1"));
            System.out.println("Success! Inserted document id: " + result.getInsertedId());
        }
    }
}
