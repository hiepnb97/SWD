<%-- 
    Document   : createdocument
    Created on : Jul 16, 2018, 9:12:32 PM
    Author     : Hoang Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<h3>Change Document:</h3>
<jsp:useBean id="dao" class="db.UserDAO"/>
<jsp:useBean id="documentDAO" class="db.DocumentDAO"/>

<c:set var="document" value="${documentDAO.getDocumentById(param.documentID)}"/>
<form action="ChangeDocumentController" method="post" enctype="multipart/form-data">
    <input type="hidden"  name="documentID" value="${param.documentID}">
    Title:<br>
    <input size="50" type="text" name="title" value="${document.title}">
    <br>
    Content:<br>
    <textarea width="50" type="text" name="content" value="">${document.content}</textarea>
    <br>
    <br>
    Co-author (Split by ","):<br>
    
    <c:set var="coauthor" value=""/>
    <c:forEach items="${dao.getUsersCoauthorByDocumentId(param.documentID)}" var="i">
       <c:set var="coauthor" value="${coauthor}${i.userName},"/>
    </c:forEach>
    
    <input size="50" type="text" name="coauthor" value="${coauthor}" id="coauthor">
    <br>
    

    Suggest:<br>
    
    <c:forEach items="${dao.friendOfUser(sessionmemberid)}" var="i">
        <a style="cursor: pointer" onclick="addUserId('${i.userName}')">${i.userName}</a> 
    </c:forEach>

    <br>
    <br>
    Attach File:<br>
    <input type="file" name="file">
    <br><br>
    <input type="submit" value="Send">
</form> 
    <script>
        function addUserId(userName){
            console.log("a");
            document.getElementById("coauthor").value+=userName+",";
        }
    </script>
    

<jsp:include page="footer.jsp"/>