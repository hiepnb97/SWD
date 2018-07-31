/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.UserDAO;
import java.util.ArrayList;
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
public class LikeDocumentDAO {
     public String likeDocument(LikeDocument likeDocument) {
        Datastore ds = MongoContext.getDatastore();
        return String.valueOf(ds.save(likeDocument));
    }
    
    public void cancelLikeDocument(ObjectId userID, ObjectId documentID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<LikeDocument> row = ds.createQuery(LikeDocument.class)
                                                .filter("userID", userID)
                                                .filter("documentID", documentID);
        ds.delete(row);
    }
     
    public ObjectId convertStringToObjectId(String s){
        return new ObjectId(s);
    }
    public boolean checkLikeDocument(ObjectId userID, ObjectId documentID){
        Datastore ds = MongoContext.getDatastore();
        LikeDocument requestFriend = ds.find(LikeDocument.class).filter("userID", userID).filter("documentID", documentID).get();
        
        if(requestFriend!=null)return true;
        return false;
    }
    
    public int countLikeDocument(ObjectId documentID){
        ArrayList arr = new ArrayList<LikeDocument>();

        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<LikeDocument>) ds.find(LikeDocument.class).filter("documentID", documentID).asList();

        return arr.size();
    }
    public void main(String[] args) {
       
    }
}
