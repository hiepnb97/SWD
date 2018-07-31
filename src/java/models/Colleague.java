/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author Hoang Hiep
 */
@Entity("colleague")
public class Colleague {
    @Id
    private ObjectId ColleagueID;
    private ObjectId fromUserID;
    private ObjectId toUserID;

    public Colleague(ObjectId ColleagueID, ObjectId fromUserID, ObjectId toUserID) {
        this.ColleagueID = ColleagueID;
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

    public Colleague(ObjectId fromUserID, ObjectId toUserID) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

    
    public Colleague() {
    }

    public ObjectId getColleagueID() {
        return ColleagueID;
    }

    public void setColleagueID(ObjectId ColleagueID) {
        this.ColleagueID = ColleagueID;
    }

    public ObjectId getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(ObjectId fromUserID) {
        this.fromUserID = fromUserID;
    }

    public ObjectId getToUserID() {
        return toUserID;
    }

    public void setToUserID(ObjectId toUserID) {
        this.toUserID = toUserID;
    }
    
    

}
