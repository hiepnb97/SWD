/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import models.AuthorDocument;
import models.CoauthorDocument;
import models.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class CoauthorDocumentDAO {
     public String createCoauthorDocument(CoauthorDocument coauthorDocument) {
        Datastore ds = MongoContext.getDatastore();
        return String.valueOf(ds.save(coauthorDocument));
    }
     
     public void deleteCoauthorByDocumentID(ObjectId documentID){
         Datastore ds = MongoContext.getDatastore();
         final Query<CoauthorDocument> row = ds.createQuery(CoauthorDocument.class)
                .filter("documentID", documentID);
         ds.delete(row);
     }

    public ArrayList<Document> findCoauthorDocumentByUserId(String fromUserID) {
        ArrayList<CoauthorDocument> arr = new ArrayList<CoauthorDocument>();
        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<CoauthorDocument>) ds.find(CoauthorDocument.class).filter("fromUserID", new ObjectId(fromUserID)).asList();

        ArrayList<Document> arrDocument = new ArrayList<Document>();
        for (CoauthorDocument ad : arr) {
            Document currentDocument = ds.find(Document.class).filter("_id", (ObjectId)ad.getDocumentID()).get();
            arrDocument.add(currentDocument);
        }
        return arrDocument;
    }
    
    public int countCoauthorDocumentByUserId(String fromUserID) {
        ArrayList<CoauthorDocument> arr = new ArrayList<CoauthorDocument>();
        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<CoauthorDocument>) ds.find(CoauthorDocument.class).filter("fromUserID", new ObjectId(fromUserID)).asList();
        return arr.size();
    }
    
    public void main(String[] args) {
        System.out.println(createCoauthorDocument(new CoauthorDocument(new ObjectId("5b4af861d0485707745a0576"), new ObjectId("5b506830d0485758b80059de"))));
    }
}
