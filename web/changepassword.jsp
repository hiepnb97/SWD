<%-- 
    Document   : createdocument
    Created on : Jul 16, 2018, 9:12:32 PM
    Author     : Hoang Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<b>${message}</b><br><br>
<form action="ChangePasswordController" method="post">
    Old password:<br>
    <input size="50" type="password" name="oldpassword" value="">
    <br>
     New password:<br>
    <input size="50" type="password" name="newpassword" value="">
    <br>
     Repeat new password:<br>
    <input size="50" type="password" name="repeatnewpassword" value="">
    <br><br>
    <input type="submit" value="Change password">
</form> 

<jsp:include page="footer.jsp"/>