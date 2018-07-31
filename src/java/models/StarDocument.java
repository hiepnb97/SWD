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

@Entity("starDocument")
public class StarDocument {
    @Id
    private ObjectId starDocumentID;
    private ObjectId userID;
    private ObjectId documentID;
    private int star;

    public StarDocument() {
    }

    public ObjectId getStarDocumentID() {
        return starDocumentID;
    }

    public void setStarDocumentID(ObjectId starDocumentID) {
        this.starDocumentID = starDocumentID;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public StarDocument(ObjectId userID, ObjectId documentID, int star) {
        this.userID = userID;
        this.documentID = documentID;
        this.star = star;
    }

    public StarDocument(ObjectId starDocumentID, ObjectId userID, ObjectId documentID, int star) {
        this.starDocumentID = starDocumentID;
        this.userID = userID;
        this.documentID = documentID;
        this.star = star;
    }
    
}
