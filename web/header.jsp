<%-- 
    Document   : header
    Created on : Jul 16, 2018, 4:32:41 PM
    Author     : Hoang Hiep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Web-based system Test</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>

      <link rel="stylesheet" href="css/style.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
      
</head>
<body>
  
<div class="navbar navbar-default navbar-static-top">
	<div class="container">
		<div class="navbar-collapse navbar-collapse-1 collapse" aria-expanded="true">
			<ul class="nav navbar-nav">
				<li>
					<a href="./"><span class="glyphicon glyphicon-home"></span> 
                                            
                                        Home
                        
                                        </a>
				</li>
                                <li class="dropdown">
					<a href="./myfriend.jsp"><span class="glyphicon glyphicon-globe"></span> 
                                        Friend
                                        </a>
                                        <div class="dropdown-content">
                                            <a href="./myfriend.jsp">Your Friend</a>
                                          <a href="./requestfriendsent.jsp">Request Sent</a>
                                          <a href="./listrequestfriend.jsp">Request Received</a>
                                        </div>
				</li>
				
				<li>
					<a href="mycolleague.jsp"><span class="glyphicon glyphicon-education"></span> Colleague</a>
				</li>
			</ul>
			<div class="navbar-form navbar-right">
				<div class="form-group has-feedback">
					<input type="text" class="form-control-nav" placeholder=" Search" id="search" aria-describedby="search1">
					<span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true"></span>
				</div>
                            <script>
                                document.getElementById("search")
                                    .addEventListener("keyup", function(event) {
                                    event.preventDefault();
                                    if (event.keyCode === 13) {
                                        window.location.href = '/SWDAss2/searchresult.jsp?input='+document.getElementById("search").value;
                                    }
                                });
                            </script>
                            <c:if test = "${sessionuser != null}">
                                <jsp:useBean id="rqDao" class="db.RequestFriendDAO"/>
                                ${rqDao.getNumRequestFriend(sessionmemberid)}
                            </c:if>

				<div class="dropdown btn btn-primary" type="submit" aria-label="Left Align">
					<span class="glyphicon glyphicon-user" aria-hidden="true"> </span> 
                                
                                        <c:if test = "${sessionuser != null}">
                                            <a class="a-white" href="UserInfo?userid=${sessionmemberid}">Wellcome ${sessionuser}</a> 
                                            <div class="dropdown-content user">
                                                <a href="./changepassword.jsp">Change password</a>
                                                <a href="./LogoutController">Logout</a>
                                              </div>
                                        </c:if>
                                       <c:if test = "${sessionuser == null}">
                                            <a  class="a-white" href="LoginController">Login or Sign up</a>
                                       </c:if>
          
                                
                                </div>
			</div>
		</div>
	</div>
</div>

<div class="container">
	<div class="row">
		<div class="col-sm-3">
			<div class="panel panel-default">
				<div class="panel-body">
                                     <c:if test = "${sessionuser != null}">
					<a href="createdocument.jsp"><img class="img-responsive" alt="" src="img/post.jpg"></a>
                                        
					<div class="row">
                                           
						<div class="col-xs-4">
							<h5>
								<small>DOCUMENTS</small>
                                                                <jsp:useBean id="dao" class="db.AuthorDocumentDAO"/>
								<a href="UserInfo?userid=${sessionmemberid}">${dao.countDocumentByUserId(sessionmemberid)}</a>
							</h5>
						</div>
						<div class="col-xs-3">
							<h5>
								<small>FRIENDS</small>
                                                                <jsp:useBean id="friendDAO" class="db.FriendDAO"/>
								<a href="./myfriend.jsp">${friendDAO.numFriend(sessionmemberid)}</a>
							</h5>
						</div>
						<div class="col-xs-5">
							<h5>
                                                            <small>COLLEAGUE</small><br>
                                                                <jsp:useBean id="colleagueDAO" class="db.ColleagueDAO"/>
								<a href="./mycolleague.jsp">${colleagueDAO.numColleague(sessionmemberid)}</a>
							</h5>
						</div>
                                            
					</div>
                                     </c:if>
				</div>
			</div>
                        <!--
			<div class="panel panel-default panel-custom">
				<div class="panel-heading">
					<h3 class="panel-title">
						Other
						<small><a href="#"></a></small>
					</h3>
				</div>

				<div class="panel-body">
					<ul class="list-unstyled">
						<li>aaa</li>
                                                <li>aaa</li>
                                                <li>aaa</li>
					</ul>
				</div>
			</div>
                        -->
		</div>
            <div class="col-sm-6">