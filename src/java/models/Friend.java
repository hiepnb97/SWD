/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author Hoang Hiep
 */
@Entity("friend")
public class Friend {
    @Id
    private ObjectId friendID;
    private ObjectId fromUserID;
    private ObjectId toUserID;
    private Date acceptedAt;

    public Friend() {
    }

    public Friend(ObjectId fromUserID, ObjectId toUserID, Date acceptedAt) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.acceptedAt = acceptedAt;
    }

    public Friend(ObjectId fromUserID, ObjectId toUserID) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

  

    public ObjectId getFriendID() {
        return friendID;
    }

    public void setFriendID(ObjectId friendID) {
        this.friendID = friendID;
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
    

    public Date getAcceptedAt() {
        return acceptedAt;
    }

    public void setAcceptedAt(Date acceptedAt) {
        this.acceptedAt = acceptedAt;
    }
    
}
