/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.UserDAO;
import java.util.ArrayList;
import java.util.Date;
import models.AuthorDocument;
import models.Document;
import models.LikeDocument;
import models.RequestFriend;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class DocumentDAO {
     public ObjectId createDocument(Document document) {
        Datastore ds = MongoContext.getDatastore();
        document.setPublishAt(new Date());
        return (ObjectId) ds.save(document).getId();
    }
     
     public void changeDocument(ObjectId documentID, String title, String content, String filePath){
        Datastore ds = MongoContext.getDatastore();
        Query query = ds.createQuery(Document.class)
                .field("_id").equal(documentID);
        ds.update(query, ds.createUpdateOperations(Document.class).set("title", title)
                .set("content", content)
                .set("filePath", filePath));
    }

    
    public void deleteDocument(ObjectId documentID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<Document> row = ds.createQuery(Document.class)
                                                .filter("_id", documentID);
        ds.delete(row);
    }
     
     
     
    public ArrayList<Document> findAllDocument(){
        ArrayList arr = new ArrayList<Document>();
        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<Document>)ds.find(Document.class).order("-publishAt").asList();
        return arr;
    }
    
    public ArrayList<Document> findDocumentByTitle(String titleContain){
        ArrayList<Document> arr = new ArrayList<Document>();
        Datastore ds = MongoContext.getDatastore();
        arr=(ArrayList) ds.createQuery(Document.class).field("title").contains(titleContain).order("-publishAt").asList();
        return arr;
    }
    
    public Document getDocumentById(String id){
        ArrayList arr = new ArrayList<Document>();
        Datastore ds = MongoContext.getDatastore();
        Document document = ds.find(Document.class).filter("_id", new ObjectId(id)).get();
        
        return document;
    }
    
}
