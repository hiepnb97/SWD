/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.UserDAO;
import java.util.ArrayList;
import models.Colleague;
import models.RequestFriend;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author Hoang Hiep
 */
public class ColleagueDAO {

    public String requestColleague(Colleague colleague) {
        Datastore ds = MongoContext.getDatastore();
        return String.valueOf(ds.save(colleague));
    }

    public void cancelColleague(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        final Query<Colleague> row = ds.createQuery(Colleague.class)
                .filter("fromUserID", fromUserID)
                .filter("toUserID", toUserID);
        ds.delete(row);
    }

    public boolean checkColleague(ObjectId fromUserID, ObjectId toUserID) {
        Datastore ds = MongoContext.getDatastore();
        Colleague colleague = ds.find(Colleague.class).filter("fromUserID", fromUserID).filter("toUserID", toUserID).get();

        if (colleague != null) {
            return true;
        }
        return false;
    }

    public static int numColleague(String fromUserID) {
        UserDAO ud = new UserDAO();
        ArrayList<User> users = ud.showAllUser();

        int count = 0;
        for (User user : users) {
            ObjectId toUserID = user.getId();
            ColleagueDAO cd = new ColleagueDAO();
            if (cd.checkColleague(new ObjectId(fromUserID), toUserID)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
