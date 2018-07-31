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
@Entity("coauthorDocument")
public class CoauthorDocument {
    @Id
    private ObjectId coauthorDocumentID;
    private ObjectId fromUserID;
    private ObjectId documentID;

    public CoauthorDocument() {
    }

    public CoauthorDocument(ObjectId fromUserID) {
        this.fromUserID = fromUserID;
    }

    public CoauthorDocument(ObjectId fromUserID, ObjectId documentID) {
        this.fromUserID = fromUserID;
        this.documentID = documentID;
    }

    public ObjectId getCoauthorDocumentID() {
        return coauthorDocumentID;
    }

    public void setCoauthorDocumentID(ObjectId coauthorDocumentID) {
        this.coauthorDocumentID = coauthorDocumentID;
    }

    public ObjectId getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(ObjectId fromUserID) {
        this.fromUserID = fromUserID;
    }

    public ObjectId getDocumentID() {
        return documentID;
    }

    public void setDocumentID(ObjectId documentID) {
        this.documentID = documentID;
    }
    
    
}
