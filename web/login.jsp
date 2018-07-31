<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="assets/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Please Login or Sign up </h1>
        <div class="main">
            <div class="login-top left">
                <div class="social_icons">
                    <!-- Facebook -->
                    <div class="slide-social w3l">
                        <a href="#">
                            <div class="button">Facebook</div>
                            <div class="facebook icon"> <i class="facebook"></i> </div>
                            <div class="facebook slide">
                                <p>Facebook</p>
                            </div>
                            <div class="clear"></div>
                        </a>
                    </div>
                    <!-- Twitter -->
                    <div class="slide-social w3l">
                        <a href="#">
                            <div class="button">Twitter</div>

                            <div class="twitter icon"> <i class="twitter"></i></div>
                            <div class="twitter slide">
                                <p>Twitter</p>
                            </div>
                            <div class="clear"></div>
                        </a> 
                    </div>

                </div>
                <form action="SignupController" method="post">
                    <input type="text" name="name" class="name" placeholder="Your Name" required="">
                    <input type="text" name="email" class="email" placeholder="Your Email" required="">	
                    <input type="password" name="password" class="password" placeholder="Password" required="">
                    <input type="password" name="password" class="password" placeholder="Confirm Password" required="">											
                    <input type="submit" value="SIGN UP">
                </form>
            </div>	

            <!--****   LOGIN *****-->
            <div class="login-top right">
                <h3>Login</h3>
                <form action="LoginController" method="post">
                    <input type="text" class="email1 " name="name" placeholder="username" required="">
                    <input type="password" class="password1" name="password"  placeholder="Password" required="">	
                    <input type="checkbox" id="brand" value="">
                    <label for="brand"><span></span> Remember me</label>
                    <div class="login-bottom">
                        <ul>
                            <li>
                                <a href="#">Forgot password?</a>
                            </li>
                            <li>

                                <input type="submit" value="LOGIN">

                            </li>
                            <div class="clear"></div>
                        </ul>
                    </div>	
                </form>
                <p style="color: red">${err}</p>
            </div>
            <div class="clear"></div>
        </div>
        <div class="copy-right w3l-agile">
            <p></p>
        </div>
    </body>
</html>
