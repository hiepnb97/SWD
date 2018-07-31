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
@Entity("commentDocument")
public class CommentDocument {
    @Id
    private ObjectId commentDocumentID;
    private ObjectId userID;
    private ObjectId documentID;
    private String content;
    private Date commentAt; 

    public CommentDocument(ObjectId commentDocumentID, ObjectId userID, ObjectId documentID, String content, Date commentAt) {
        this.commentDocumentID = commentDocumentID;
        this.userID = userID;
        this.documentID = documentID;
        this.content = content;
        this.commentAt = commentAt;
    }

    public CommentDocument() {
    }

    public CommentDocument(ObjectId userID, ObjectId documentID, String content) {
        this.userID = userID;
        this.documentID = documentID;
        this.content = content;
    }

    public ObjectId getCommentDocumentID() {
        return commentDocumentID;
    }

    public void setCommentDocumentID(ObjectId commentDocumentID) {
        this.commentDocumentID = commentDocumentID;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentAt() {
        return commentAt;
    }

    public void setCommentAt(Date commentAt) {
        this.commentAt = commentAt;
    }
    
}
