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
@Entity("document")
public class Document {
    @Id
    private ObjectId documentID;
    private String title;
    private String content;
    private String filePath;
    private Date publishAt;

    public Document() {
    }

    public Document(ObjectId documentID, String title, String content, String filePath, Date publishAt) {
        this.documentID = documentID;
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.publishAt = publishAt;
    }

    public Document(String title, String content, String filePath) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
    }



    public Document(String title, String content, String filePath, Date publishAt) {
        this.title = title;
        this.content = content;
        this.filePath = filePath;
        this.publishAt = publishAt;
    }

    public ObjectId getDocumentID() {
        return documentID;
    }

    public void setDocumentID(ObjectId documentID) {
        this.documentID = documentID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Date publishAt) {
        this.publishAt = publishAt;
    }
    
    
}
