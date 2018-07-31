/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.UserDAO;
import java.util.ArrayList;
import java.util.Date;
import models.Friend;
import models.RequestFriend;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class FriendDAO {

    public String acceptFriend(Friend friend) {
        Datastore ds = MongoContext.getDatastore();
        friend.setAcceptedAt(new Date());
        return String.valueOf(ds.save(friend));
    }

    public void cancelFriend(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<Friend> row = ds.createQuery(Friend.class)
                .filter("fromUserID", fromUserID)
                .filter("toUserID", toUserID);
        ds.delete(row);
    }

    public boolean checkIsFriend(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        Friend friend = ds.find(Friend.class)
                .filter("fromUserID", fromUserID).filter("toUserID", toUserID).get();

        if (friend != null) {
            return true;
        }
        return false;
    }

    public int numFriend(String fromUserID) {
        UserDAO ud = new UserDAO();
        ArrayList<User> users = ud.showAllUser();
        int count = 0;
        for (User user : users) {
            ObjectId toUserID = user.getId();
            FriendDAO fd = new FriendDAO();
            if (fd.checkIsFriend(new ObjectId(fromUserID), toUserID) || fd.checkIsFriend(toUserID, new ObjectId(fromUserID))) {
                count++;
            }
        }
        return count;
    }

    public void main(String[] args) {
        UserDAO ud = new UserDAO();
        ArrayList<User> arr = ud.showAllUser();

        String s = acceptFriend(new Friend(arr.get(0).getId(), arr.get(1).getId()));
        //System.out.println(checkIsFriend(arr.get(0).getId(),arr.get(2).getId()));

        /*String id = requestFriend(new RequestFriend("123456", "789456"));
        System.out.println(id);*/
 /*ArrayList<User> arr = showAllUser();
        User user = arr.get(0);
        //requestFriend(new RequestFriend(arr.get(0).getId(), arr.get(1).getId()));
        cancelRequestFriend(arr.get(0).getId(), arr.get(1).getId());
         
        System.out.println(checkRequestSent(arr.get(6).getId(), arr.get(5).getId()));*/
    }
}
