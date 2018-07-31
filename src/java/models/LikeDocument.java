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

/**
 *
 * @author Hoang Hiep
 */

@Entity("likeDocument")
public class LikeDocument {
    @Id
    private ObjectId likeDocumentID;
    private ObjectId userID;
    private ObjectId documentID;

    public LikeDocument(ObjectId likeDocumentID, ObjectId userID, ObjectId documentID) {
        this.likeDocumentID = likeDocumentID;
        this.userID = userID;
        this.documentID = documentID;
    }

    public LikeDocument() {
    }

    public LikeDocument(ObjectId userID, ObjectId documentID) {
        this.userID = userID;
        this.documentID = documentID;
    }

    public ObjectId getLikeDocumentID() {
        return likeDocumentID;
    }

    public void setLikeDocumentID(ObjectId likeDocumentID) {
        this.likeDocumentID = likeDocumentID;
    }

    public ObjectId getUserID() {
        return userID;
    }

    public void setUserID(ObjectId userID) {
        this.userID = userID;
    }

    public ObjectId getDocumentID() {
        return documentID;
    }

    public void setDocumentID(ObjectId documentID) {
        this.documentID = documentID;
    }
    
    
}
