<%-- 
    Document   : login
    Created on : Jan 8, 2024, 9:26:26 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style_1.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <style>
            .alert {
                margin-top: 20px;
                padding: 10px 15px;
                border-radius: 5px;
            }
            .alert-success {
                background-color: #d4edda;
                border-color: #c3e6cb;
                color: #155724;
            }

            .alert-danger {
                background-color: #f8d7da;
                border-color: #f5c6cb;
                color: #721c24;
            }
        </style>
    </head>
    <body>
        <div class="wapper">
            <div style="display: flex;justify-content: space-between">
                <span class="back"><a href="signin"><i class="fa-solid fa-arrow-left"></i></i></a></span>
                <span class="back"><a href="home"><i class="fa fa-home" style="font-size: 24px;color: black;"></i></a></span>
            </div>
            <form action="reset-password" method="post">
                <h1>Reset Password</h1>
                <p style="text-align: center;">If you've forgotten your password, enter your account and email</p>
                <div class="input-box">
                    <input type="text" id="aname" name="accountname" placeholder="Account name" required>   
                </div>    
                <div class="input-box">
                    <input type="email" id="email" name="emailaddress" placeholder="Email address" required>   
                </div> 
                <c:if test="${message eq 'ok'}">
                    <div class="alert alert-success" role="alert">
                        We have send new password to your email, please check it.
                    </div>
                </c:if>
                <c:if test="${message eq 'not found'}">
                    <div class="alert alert-danger" role="alert">
                        Incorrect username or email. Please enter again.
                    </div>
                </c:if>
                <button class="button" type="submit" name="signup">
                    Enter
                </button>

            </form>

        </div>
    </body>
</html>