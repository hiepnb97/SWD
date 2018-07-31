/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;
import models.LikeDocument;
import models.StarDocument;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class StarDocumentDAO {
    public String starDocument(StarDocument starDocument) {
        Datastore ds = MongoContext.getDatastore();
        return String.valueOf(ds.save(starDocument));
    }
    
    public void deleteStarDocument(ObjectId userID, ObjectId documentID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<StarDocument> row = ds.createQuery(StarDocument.class)
                                                .filter("userID", userID)
                                                .filter("documentID", documentID);
        ds.delete(row);
    }
    
    public void deleteAllStarDocument(ObjectId documentID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<StarDocument> row = ds.createQuery(StarDocument.class)
                                                .filter("documentID", documentID);
        ds.delete(row);
    }
     
    public int getStarDocument(ObjectId userID, ObjectId documentID){
        Datastore ds = MongoContext.getDatastore();
        StarDocument starDocument = ds.find(StarDocument.class).filter("userID", userID).filter("documentID", documentID).get();
        
        if(starDocument!=null)return starDocument.getStar();
        return -1;
    }
    
    
     public String getAverageStarDocument(ObjectId documentID){
        ArrayList<StarDocument> arr = new ArrayList<StarDocument>();

        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<StarDocument>) ds.find(StarDocument.class).filter("documentID", documentID).asList();
        if(arr.size()==0)return "No";
        int sum=0;
        for(StarDocument sD : arr){
            sum+=sD.getStar();
        }
        
        
        return String.format("%.1f" , 1.0*sum/arr.size());
    }
    
    
    public void main(String[] args) {
       // System.out.println(starDocument(new StarDocument(new ObjectId("5b506ce6d0485758b8baacf4"), new ObjectId("5b548051f6f11647bccd4fe6"), 3)));
       //deleteStarDocument(new ObjectId("5b506ce6d0485758b8baacf4"), new ObjectId("5b548051f6f11647bccd4fe6"));
        //System.out.println(""+getStarDocument(new ObjectId("5b506ce6d0485758b8baacf4"), new ObjectId("5b548051f6f11647bccd4fe6")));
        System.out.println(starDocument(new StarDocument(new ObjectId("5b506ce6d0485758b8baacf4"), new ObjectId("5b548051f6f11647bccd4fe6"), 2)));
        System.out.println(getAverageStarDocument(new ObjectId("5b548051f6f11647bccd4fe6")));
    }
}
