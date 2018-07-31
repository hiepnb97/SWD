/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.UserDAO;
import java.util.ArrayList;
import java.util.Date;
import models.RequestFriend;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class RequestFriendDAO {
    public String requestFriend(RequestFriend requestFriend) {
        Datastore ds = MongoContext.getDatastore();
        return String.valueOf(ds.save(requestFriend));
    }
    
    public void cancelRequestFriend(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<RequestFriend> row = ds.createQuery(RequestFriend.class)
                                                .filter("fromUserID", fromUserID)
                                                .filter("toUserID", toUserID);
        ds.delete(row);
    }
     
    public boolean checkRequestSent(ObjectId fromUserID, ObjectId toUserID){
        Datastore ds = MongoContext.getDatastore();
        RequestFriend requestFriend = ds.find(RequestFriend.class).filter("fromUserID", fromUserID).filter("toUserID", toUserID).get();
        
        if(requestFriend!=null)return true;
        return false;
    }
    
    public String getNumRequestFriend(ObjectId toUserID){
        ArrayList<RequestFriend> arr = new ArrayList<RequestFriend>();

        Datastore ds = MongoContext.getDatastore();
        arr = (ArrayList<RequestFriend>) ds.find(RequestFriend.class).filter("toUserID", toUserID).asList();
        if(arr.size()==0)return "";
        return "<a href=\"listrequestfriend.jsp\"><span class=\"glyphicon glyphicon-user\">+("+arr.size()+")</span></a>";
    }
    
    
}
