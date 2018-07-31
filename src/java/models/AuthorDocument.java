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
@Entity("authorDocument")
public class AuthorDocument {
    @Id
    private ObjectId authorDocumentID;
    private ObjectId fromUserID;
    private ObjectId documentID;

    public AuthorDocument() {
    }

    public AuthorDocument(ObjectId fromUserID, ObjectId documentID) {
        this.fromUserID = fromUserID;
        this.documentID = documentID;
    }

    public AuthorDocument(ObjectId authorDocumentID, ObjectId fromUserID, ObjectId documentID) {
        this.authorDocumentID = authorDocumentID;
        this.fromUserID = fromUserID;
        this.documentID = documentID;
    }

    public ObjectId getAuthorDocumentID() {
        return authorDocumentID;
    }

    public void setAuthorDocumentID(ObjectId authorDocumentID) {
        this.authorDocumentID = authorDocumentID;
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
