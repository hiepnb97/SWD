package db;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MongoContext {

    public static Datastore getDatastore() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        final Morphia morphia = new Morphia();
        final Datastore datastore = morphia.createDatastore(mongoClient, "assignment");
        datastore.ensureIndexes();
        return datastore;
    }
}
