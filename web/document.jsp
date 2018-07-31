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
            Author: <a href="UserInfo?userid=${user.id}">${user.userName}</a>
             | Co-author: 
            <jsp:useBean id="dao" class="db.UserDAO"/>
            <c:forEach items="${dao.getUsersCoauthorByDocumentId(param.documentid)}" var="i">
                <a href="UserInfo?userid=${i.id}">${i.userName}</a> 
            </c:forEach>
            
            <c:if test = "${sessionuser != null}">
            <jsp:useBean id="authorDocumentDAO" class="db.AuthorDocumentDAO"/>
            <c:if test="${authorDocumentDAO.checkDocumentByUserID(document.documentID, sessionmemberid)==true}">
            <a href="DeleteDocumentController?documentID=${document.documentID}" style="float: right"><span class="glyphicon glyphicon-trash"></span></a>
            <a href="changedocument.jsp?documentID=${document.documentID}" style="float: right"><span class="glyphicon glyphicon-edit">&ensp;</span></a>
            </c:if>
            </c:if>
        </div>
        <div class="panel-body">
            
           
                <div class="media">
                 <div class="media-body">
                    <span class='date'> ${document.publishAt}</span>
                    
                    
                    <h4 class="media-heading">${document.title}</h4>
                    <jsp:useBean id="likeDocumentDAO" class="db.LikeDocumentDAO"/>
                    <c:if test = "${sessionuser != null}">
                        <c:if test = "${likeDocumentDAO.checkLikeDocument(sessionmemberid, document.documentID)==false}">
                        <a class="like" href="LikeDocumentController?documentID=${document.documentID}">(${likeDocumentDAO.countLikeDocument(document.documentID)} Likes) <span class='glyphicon glyphicon-thumbs-up'></span></a>
                        </c:if>
                        <c:if test = "${likeDocumentDAO.checkLikeDocument(sessionmemberid, document.documentID)==true}">
                        <a  class="like" href="DislikeDocumentController?documentID=${document.documentID}">(${likeDocumentDAO.countLikeDocument(document.documentID)} Likes) <span class='glyphicon glyphicon-thumbs-down'></span></a>
                        </c:if>
                    </c:if>
                    <p>${document.content}</p>
                    <!-- Star -->
                    <span class="like">
                        <c:if test = "${sessionuser != null}">
                        <jsp:useBean id="starDocumentDAO" class="db.StarDocumentDAO"/>
                        (${starDocumentDAO.getAverageStarDocument(document.documentID)} Star)
                        
                        <a href="RateStarDocument?documentID=${document.documentID}&star=1"><span class='glyphicon <c:choose><c:when test="${starDocumentDAO.getStarDocument(sessionmemberid,document.documentID)>=1}">glyphicon-star</c:when><c:otherwise>glyphicon-star-empty</c:otherwise></c:choose>'></span></a>
                        <a href="RateStarDocument?documentID=${document.documentID}&star=2"><span class='glyphicon <c:choose><c:when test="${starDocumentDAO.getStarDocument(sessionmemberid,document.documentID)>=2}">glyphicon-star</c:when><c:otherwise>glyphicon-star-empty</c:otherwise></c:choose>'></span></a>
                        <a href="RateStarDocument?documentID=${document.documentID}&star=3"><span class='glyphicon <c:choose><c:when test="${starDocumentDAO.getStarDocument(sessionmemberid,document.documentID)>=3}">glyphicon-star</c:when><c:otherwise>glyphicon-star-empty</c:otherwise></c:choose>'></span></a>
                        <a href="RateStarDocument?documentID=${document.documentID}&star=4"><span class='glyphicon <c:choose><c:when test="${starDocumentDAO.getStarDocument(sessionmemberid,document.documentID)>=4}">glyphicon-star</c:when><c:otherwise>glyphicon-star-empty</c:otherwise></c:choose>'></span></a>
                        <a href="RateStarDocument?documentID=${document.documentID}&star=5"><span class='glyphicon <c:choose><c:when test="${starDocumentDAO.getStarDocument(sessionmemberid,document.documentID)>=5}">glyphicon-star</c:when><c:otherwise>glyphicon-star-empty</c:otherwise></c:choose>'></span></a>
                        </c:if>
                    </span>
                    <p>Attach File: <a href="doc/${user.id}/${document.filePath}">${document.filePath}</a></p>
                </div>
            </div>


        </div>
                <jsp:useBean id="commentDocumentDAO" class="db.CommentDocumentDAO"/>
                <h4 style="margin-left: 15px">${commentDocumentDAO.showCommentDocument(document.documentID).size()} comments:</h4>
<div style="margin: 15px">

<c:forEach items="${commentDocumentDAO.showCommentDocument(document.documentID)}" var="i">
    <p><a href="UserInfo?userid=${i.userID}">${dao.getUserName(i.userID)}</a> commented at ${i.commentAt}:
        
        <c:if test="${i.userID==sessionmemberid||authorDocumentDAO.checkDocumentByUserID(document.documentID, sessionmemberid)==true}">
           
        <a href="DeleteCommentDocumentController?commentDocumentID=${i.commentDocumentID}" style="float: right"><span class="glyphicon glyphicon-trash"></span></a>
        <a class="changecomment" style="float: right" commentDocumentID="${i.commentDocumentID}" oldCommentDocumentID="${i.content}"><span class="glyphicon glyphicon-edit">&ensp;</span></a>
        </c:if>
        
        <br> ${i.content}</p><hr>
</c:forEach>
</div>
<form action="CommentDocumentController" method="post" style="margin: 15px">
    <input size="50" type="text" name="content" value="">
    <input type="hidden" name="documentID" value="${document.documentID}">
    <input type="submit" value="Comment">
</form> 
    
    
<!-- Edit comment -->
<div id="popup">
  <span id="close" title="press Esc to close">&times;</span>
  <h3>Change comment</h3>
  <form action="ChangeCommentController" method="post" style="">
    <input type="hidden" id="commentDocumentID" name="commentDocumentID" value="">
    <input size="51" type="text" name="newcomment" value="" id="newcomment">
    <input type="submit" value="Change">
  </form>  
</div>
<script>

$(".changecomment").click(function(){
  $("body").addClass("show-popup");
  $("#commentDocumentID").val($(this).attr("commentDocumentID"));
  $("#newcomment").val($(this).attr("oldCommentDocumentID"));
});
function closePopup(){
  $("body").removeClass("show-popup");
}

$("#close").click(function(){
  closePopup();
});

$(document).keyup(function(e) {
  if (e.keyCode == 27) {  
    closePopup();     
  }   // esc
});
</script>
    </div>

<jsp:include page="footer.jsp"/>

