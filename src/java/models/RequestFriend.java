/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import com.mongodb.DBObject;
import java.util.Date;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author Hoang Hiep
 */
@Entity("requestFriend")
public class RequestFriend {
    @Id
    private ObjectId requestFriendID;
    private ObjectId fromUserID;
    private ObjectId toUserID;

    public RequestFriend() {
    }
    
    public RequestFriend(DBObject next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public RequestFriend(ObjectId fromUserID, ObjectId toUserID) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
    }

    public ObjectId getRequestFriendID() {
        return requestFriendID;
    }

    public void setRequestFriendID(ObjectId requestFriendID) {
        this.requestFriendID = requestFriendID;
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
