<%-- 
    Document   : header
    Created on : Mar 10, 2024, 2:53:01 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">-->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">


        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

        <!--
        
        TemplateMo 570 Chain App Dev
        
        
        -->

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="container navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid row" >
                <a href="home" class="logo col-2">
                    <img src="img/logo.png" alt="Chain App Dev" style="height: 30px">
                </a>
                <div class="col-5"></div>
                <ul class="nav col-4">
                    <li class="scroll-to-section"><a  class="nav-link js-scroll-trigger" href="home" >Home</a></li>
                    <li class="scroll-to-section"><a  class="nav-link js-scroll-trigger" href="home">About</a></li>
                    <li class="scroll-to-section"><a  class="nav-link js-scroll-trigger" href="news" >News</a></li>
                    <li class="scroll-to-section"><a  class="nav-link js-scroll-trigger" href="home">Feedback</a></li>
                    <li class="scroll-to-section"><a  class="nav-link js-scroll-trigger" href="blog">Blog</a></li>
                    <li></li>
                </ul>     
                <div class="collapse navbar-collapse col-1" id="navbarSupportedContent">
                    
                    <c:if test="${account ne null}">
                        <ul class="nav navbar-nav ">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${account.getUser()} <span class="caret"></span></a>
                                <ul class="dropdown-menu">

                                    <!--nếu là Mentee-->
                                    <c:if test="${account.getRole() eq 'Mentee'}">
                                        <li class="scroll-to-section"><a  class="dropdown-item" href="profileMentee" >ProfileMentee</a></li>
                                        <li class="scroll-to-section"><a class="dropdown-item"  href="listrequest" >List Request</a></li>
                                        <li class="scroll-to-section"><a  class="dropdown-item" href="statisticreq">Statistic Request</a></li>
                                        <li class="scroll-to-section"><a class="dropdown-item"  href="mycourse" >MY COURSE</a></li>
                                        </c:if>
                                    <!------------------------------- -->    

                                    <!--nếu là Mentor-->
                                    <c:if test="${account.getRole() eq 'Mentor'}">
                                        <li class="scroll-to-section"><a  class="dropdown-item" href="profilecv?idMentor=${account.getId()}" >Profile</a></li>

                                        <li class="scroll-to-section"><a class="dropdown-item"  href="#" data-toggle="modal" data-target="#statisticsModal">View Statistic</a></li>
                                        <li class="scroll-to-section"><a  class="dropdown-item" href="reqmentor" >View Request</a></li>
                                        <li class="scroll-to-section"><a class="dropdown-item"  href="createblog" >CREATE BLOG</a></li>
                                        <li class="scroll-to-section"><a class="dropdown-item"  href="bloglist" >VIEW BLOG</a></li>
                                        </c:if>
                                    <!------------------------------- -->    

                                    <!--<li class="scroll-to-section"><a  class="dropdown-item" href="Request?action=create" >Create Request</a></li>-->

                                    <li class="scroll-to-section"><a href="changePass">changePass</a></li>
                                    <li class="dropdown-divider"></li> <!-- Đường nằm ngang -->
                                    <li><a href="logoutUser">Log out <i class="fa-solid fa-right-from-bracket"></i></a></li>
                                </ul>
                            </li>
                        </ul>
                        <input type="text" value="${account.user}" name="user" style="display: none">

                    </c:if>
                </div>
            </div>
        </nav>   
        <!--        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/animation.js"></script>
        <script src="assets/js/imagesloaded.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> 
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
