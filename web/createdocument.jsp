<%-- 
    Document   : createdocument
    Created on : Jul 16, 2018, 9:12:32 PM
    Author     : Hoang Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<form action="CreateDocumentController" method="post" enctype="multipart/form-data">
    Title:<br>
    <input size="50" type="text" name="title" value="">
    <br>
    Content:<br>
    <textarea width="50" type="text" name="content" value=""></textarea>
    <br>
    <br>
    Co-author (Split by ","):<br>
    <input size="50" type="text" name="coauthor" value="" id="coauthor">
    <br>
    

    Suggest:<br>
    <jsp:useBean id="dao" class="db.UserDAO"/>
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