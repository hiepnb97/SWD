<%-- 
    Document   : user
    Created on : Jul 14, 2018, 7:06:35 PM
    Author     : Hoang Hiep
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>


    <div class="panel panel-info">
        <div class="panel-heading">
         <jsp:useBean id="dao" class="db.DocumentDAO"/>
         ${dao.findDocumentByTitle(param.input).size()} document results:
     
        </div>
        <div class="panel-body">

            <c:forEach items="${dao.findDocumentByTitle(param.input)}" var="i">
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
         
         
         
          <div class="panel panel-info">
        <div class="panel-heading">
         <jsp:useBean id="UserDao" class="db.UserDAO"/>
         ${UserDao.findUserByUsername(param.input).size()} user results:
     
        </div>
        <div class="panel-body">

            <c:forEach items="${UserDao.findUserByUsername(param.input)}" var="i">
                <div class="media">
                <div class="media-body">
                    <h4 class="media-heading"><a href="UserInfo?userid=${i.id}">${i.userName}</a></h4> 
                </div>
            </div>
            </c:forEach>

        </div>


    </div>
    
  

<jsp:include page="footer.jsp"/>

