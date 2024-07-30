<%-- 
    Document   : admin2
    Created on : Mar 9, 2024, 2:48:34 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>ADMIN-Happy Programming</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <!--        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
                <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
                <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- Custom styles for this template -->
        <!--        <link href="../css/resume.min.css"  type="text/css" rel="stylesheet">-->
        <link href="../css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/resume.min.css"/>
        <style>
            .search {
                width: 400px;
                height: 40px;
                margin: 5px auto;
                background: #fff;
                background: transparent;
                border-radius:  5px;
                border: 1px solid #06357a;
                margin-right: 15px;
                padding-right: 0px;

                input {
                    width: 200px;
                    padding: 5px 5px;
                    float: left;
                    color: #444;
                    border: 0;
                    background: transparent;
                    border-radius: 3px 3px 3px 3px;
                    &:focus {
                        outline: 0;
                        background:transparent;
                    }
                }

                button {
                    font-size: medium;
                    position: relative;
                    float: right;
                    border: 0;
                    padding: 0;
                    cursor: pointer;
                    height: 40px;
                    width: 120px;
                    color: #444;
                    background: transparent;
                    border-left: 1px solid #212529;
                    border-radius: 3px 3px 3px 3px;
                    &:hover {
                        background: rgba(0,0,0,.2);
                        color:#444;
                    }
                    &:active {
                        box-shadow: 0px 0px 12px 0px rgba(225, 225, 225, 1);
                    }
                    &:focus {
                        outline: 0;
                    }
                }
            }
            .pagination{
                display: inline-block;
            }
            .pagination a{
                color:black;
                font-size: 22px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }
            .pagination a.active{
                background-color: #4CAF50;
                color: white;
            }

            .pagination a:hover:not(.active){
                background-color: chocolate;
            }
            td, th {
                border: 1px solid black;
                padding: 8px;
            }
        </style>
    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">Start Bootstrap</span>
                <span class="d-none d-lg-block">
                    <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/profile.jpg" alt="">
                </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#mentor">Mentor</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#mentee">Mentee</a>
                    </li>
                </ul>
            </div>
        </nav>
        <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="mentor">
            <div class="my-auto">
                <h2 class="mb-5">Mentor</h2>
            </div>
            <div class="container">
                <section  class="row" style="margin: 30px; text-align: end; font-size: 18px;">
                    <form class="search" action="admin2" method="get">
                        <input name="search" type="search" value ="${param.search}" placeholder="Search here..."   >
                        <button type="submit">Search</button>
                    </form>   
                </section>


                <section class="row " style="background: white">

                    <div>                              
                        <div class="table-responsive">
                            <c:set var="page1" value="${requestScope.page1}"/>
                            <div class="pagination">
                                <c:forEach begin="1" end="${requestScope.num}" var="i">
                                    <a class="${i==page1 ? 'active' : ''}" href="admin2?page1=${i}">${i}</a>
                                </c:forEach>
                            </div>

                            <table class="table table-bordered">
                                <thead>
                                    <tr style="background: whitesmoke;">
                                        <th>STT</th>
                                        <th>ID</th>
                                        <th>FullName</th>
                                        <th>Account</th>
                                        <th>Profession</th>
                                        <th>Accepted request</th>
                                        <th>Percentage completed</th>
                                        <th>Rate</th>
                                        <th>Active</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="a" items="${lis}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${a.getID()}</td>
                                            <td>${a.getFullName()}</td>                                           
                                            <td>${a.getAccountname()}</td>
                                            <td>${a.getProfession()}</td>
                                            <td>${a.getAcceptrequest()}</td>
                                            <td>${a.getPercentcompleted()}%</td>
                                            <td>${a.getRate()}<i class="fa-solid fa-star" style="color: #FFD43B;"></i></td>

                                            <c:if test="${a.getActive() eq 1}">
                                                <td style="color: #01df1f">
                                                    <p style="font-size: large">Active</p>
                                                    <a class="btn btn-danger" href="activementor?id=${a.getID()}#mentor"  style="width: 70%">Inactive</a>
                                                </td>
                                            </c:if>
                                            <c:if test="${a.getActive() eq 0}">
                                                <td style="color: #ff1921">
                                                    <p style="font-size: large">Inactive</p>
                                                    <a class="btn" style="background-color: #4acd3d; color: white; width: 70%;" href="activementor?id=${a.getID()}#mentor" >Active</a>
                                                </td>
                                            </c:if>


                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </section>
        </section>
        <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="mentee">
            <div class="my-auto">
                <h2 class="mb-5">Mentee</h2>
                <div class="header">             
                    <h5>Total of Mentee: ${result}</h5>            
                </div>
                <c:set var="page2" value="${requestScope.page2}"/>
                <div class="pagination">
                    <c:forEach begin="1" end="${requestScope.num2}" var="i">
                        <a class="${i==page2 ? 'active' : ''}" href="admin2?page2=${i}#mentee">${i}</a>
                    </c:forEach>
                </div>
                <table border="1px" class="container">
                    <tr style="background: whitesmoke;" >
                        <td >Full Name</td>
                        <td >Username</td>
                        <td >NumRequests</td>
                        <td >TotalHours</td>
                        <td >TotalSkills</td>
                    </tr>
                    <c:forEach items="${list2}"  var="e">
                        <tr>
                            <td>${e.getFullName()}</td>
                            <td>${e.getUserName()}</td>
                            <td>${e.getNumRequests()}</td>
                            <td>${e.getTotalHours()}</td>
                            <td>${e.getTotalSkills()}</td>               
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </section>
                <script>
                    function submitCombinedForm() {
                        document.getElementById('combinedFilterForm').submit();
                    }
                    function changeStatus(selectElement) {
                        var requestId = selectElement.id.split('-')[1]; // Extracting the request ID
                        var selectedValue = selectElement.value; // Getting the selected value

                        // Call the controller using AJAX
                        // Example using jQuery AJAX
                        $.get("changestatus", {requestId: requestId, status: selectedValue}, function (response) {
                            // Handle response if needed
                        });
                    }
                </script>
                </body>

            </section>


        </div>

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Plugin JavaScript -->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for this template -->
        <script src="js/resume.min.js"></script>

    </body>

</html>
