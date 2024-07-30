<%-- 
    Document   : MyCourse
    Created on : Mar 9, 2024, 10:11:20 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

        <title>Happy Programming</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!--
        
        TemplateMo 570 Chain App Dev
        
        https://templatemo.com/tm-570-chain-app-dev
        
        -->

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>

    <body>

        <jsp:include page="../header.jsp"></jsp:include>

            <div class="main-banner wow fadeIn" id="top" data-wow-duration="1s" data-wow-delay="0.5s">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-lg-12 align-self-center">
                                    <div class="left-content show-up header-text wow fadeInLeft" data-wow-duration="1s" data-wow-delay="1s">
                                        <form action="searchMentor" method="post">
                                            <div class="input-group mb-3">
                                                <input name="searchBySkill" type="text" class="form-control" placeholder="Search skill">
                                                <button class="btn btn-success" type="submit">Go</button>
                                            </div>
                                        </form>
                                        <div class="table-responsive">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Course</th>
                                                        <th>Mentor</th>
                                                        <th>Title</th>
                                                        <th>SkillName</th>
                                                        <th></th>
                                                        <th></th>
                                                        
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${lfav}" var="l">
                                                    <tr>
                                                        <td><img src="${l.image}" alt="alt" style="width: 8rem"></td>
                                                        <td><a href="profilecv?action=view&idMentor=${l.idMentor}" style="color: black">${l.nameMentor}</a></td>
                                                        <td>${l.title}</td>
                                                        <td>${l.skillName}</td>
                                                        <td><button><a href="Request?action=create&idMentor=${l.idMentor}&idSkill=${l.idSkill}">Invite</a></button></td>
<!--                                                        <td><button><a href="fav?idSkill=${o.getIdSkill()}">Favourite</a></button></td>-->
                                                        <td><button><a href="deletecourse?idSkill=${l.idSkill}"> Delete</a> </button></td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>


            <jsp:include page="../footer.jsp"></jsp:include>


        <!-- Scripts -->
        
    </body>
</html>
