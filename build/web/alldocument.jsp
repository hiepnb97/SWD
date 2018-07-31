<%-- 
    Document   : document
    Created on : Jul 16, 2018, 9:26:23 PM
    Author     : Hoang Hiep
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


    <jsp:useBean id="dao" class="db.DocumentDAO"/>
    <jsp:useBean id="likeDocumentDAO" class="db.LikeDocumentDAO"/>
    
    <div class="panel panel-info">
        <div class="panel-heading">
            Recent Document
        </div>
        <div class="panel-body">
            
            
            <c:forEach items="${dao.findAllDocument()}" var="i">
                <div class="media">
                 <div class="media-body">
                    <span class='date'> ${i.publishAt}</span>
                    <h4 class="media-heading"><a href="DocumentController?documentid=${i.documentID}">${i.title}</a></h4>
                    <c:if test = "${sessionuser != null}">
                        <c:if test = "${likeDocumentDAO.checkLikeDocument(sessionmemberid, i.documentID)==false}">
                        <a class="like" href="LikeDocumentController?documentID=${i.documentID}">(${likeDocumentDAO.countLikeDocument(i.documentID)} Likes) <span class='glyphicon glyphicon-thumbs-up'></span></a>
                        </c:if>
                        <c:if test = "${likeDocumentDAO.checkLikeDocument(sessionmemberid, i.documentID)==true}">
                        <a  class="like" href="DislikeDocumentController?documentID=${i.documentID}">(${likeDocumentDAO.countLikeDocument(i.documentID)} Likes) <span class='glyphicon glyphicon-thumbs-down'></span></a>
                        </c:if>
                    </c:if>
                    <p>${i.content}</p>
                    
                </div>
            </div>
            </c:forEach>

        </div>


    </div>

    <br>
    <br>
    <br>
