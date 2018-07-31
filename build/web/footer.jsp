<%-- 
    Document   : footer
    Created on : Jul 16, 2018, 4:33:05 PM
    Author     : Hoang Hiep
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</div>
<div class="col-sm-3">
    <div class="panel panel-default panel-custom">
        <div class="panel-heading">
            <h3 class="panel-title">
                People you may know:

                ${message}
                
                <c:if test = "${sessionuser != null}">
                    <div class="bigRight">
                        <br>
                        <jsp:include page="AllRequestFriendSent"/>

                    </div>
                </c:if>

            </h3>
        </div>
        <div class="panel-body">

            <!-- People  -->

        </div>

    </div>
    <div class="well well-sm">
        <ul class="list-inline">
            <li>© 2015 Twitter</li>
            <li><a href="#">About</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="#">Terms</a></li>
            <li><a href="#">Privacy</a></li>
            <li><a href="#">Cookies</a></li>
            <li><a href="#">Ads info</a></li>
            <li><a href="#">Brand</a></li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Status</a></li>
            <li><a href="#">Apps</a></li>
            <li><a href="#">Jobs</a></li>
            <li><a href="#">Advertise</a></li>
            <li><a href="#">Businesses</a></li>
            <li><a href="#">Media</a></li>
            <li><a href="#">Developers</a></li>
        </ul>
    </div>
</div>
</div>
</div>
<script src="js/main.js" type="text/javascript"></script>
</body>

</html>
