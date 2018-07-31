/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import java.util.Date;
import models.CommentDocument;
import models.LikeDocument;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class CommentDocumentDAO {
     public String commentDocument(CommentDocument commentDocument) {
        Datastore ds = MongoContext.getDatastore();
        commentDocument.setCommentAt(new Date());
        return String.valueOf(ds.save(commentDocument));
    }
    
    public void deleteCommentDocument(ObjectId commentID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<CommentDocument> row = ds.createQuery(CommentDocument.class)
                                                .filter("_id", commentID);
        ds.delete(row);
    }
    
    public void deleteCommentByDocumentID(ObjectId documentID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<CommentDocument> row = ds.createQuery(CommentDocument.class)
                                                .filter("documentID", documentID);
        ds.delete(row);
    }
    
    public void changeCommentDocument(String commentDocumentID, String newContent){
        Datastore ds = MongoContext.getDatastore();
        Query query = ds.createQuery(CommentDocument.class)
                .field("_id").equal(new ObjectId(commentDocumentID));
        ds.update(query, ds.createUpdateOperations(CommentDocument.class).set("content", newContent));
    }
     
    public ObjectId convertStringToObjectId(String s){
        return new ObjectId(s);
    }
    public boolean checkCommentDocument(String userID, String commentDocumentID){
        Datastore ds = MongoContext.getDatastore();
        CommentDocument commentDocument = ds.find(CommentDocument.class).filter("userID", new ObjectId(userID)).filter("_id", new ObjectId(commentDocumentID)).get();
        
        if(commentDocument!=null)return true;
        return false;
    }
    
    public ArrayList<CommentDocument> showCommentDocument(String documentID){
        ArrayList arr = new ArrayList<CommentDocument>();

        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<CommentDocument>) ds.find(CommentDocument.class).filter("documentID",new ObjectId(documentID)).asList();

        return arr;
    }
    public void main(String[] args) {
        
        System.out.println(commentDocument(new CommentDocument(new ObjectId("5b495a3ad048571d58a1a43a"), new ObjectId("5b4fdfc6d048572b0066c9d2"), "abcd")));
    }
}
