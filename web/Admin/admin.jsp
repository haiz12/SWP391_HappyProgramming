<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <script src="https://cdn.tiny.cloud/1/v2saiqx68nn924zq9xagmn8galaqifhtnlhjbr6jeofrd8n1/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <style>

            td{
                text-align: center;
            }
            th{
                padding: 10px;
            }
            .refresh{
                padding-left: 20px;
                padding-bottom: 10px;
            }
            .refresh input{
                background: #0354D5;
                color: white;
                border: none;
                padding: 5px 10px;
            }
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background: #fff;

                background-size: cover;
            }

            header {

                color: #000;
                padding: 10px;
                text-align: center;
            }
            th{
                text-align: center
            }
            .logout-container {
                text-align: center;
                margin-top: 100px;
            }
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
    <body >
        <header>
            <div class="row">
                <div class="col-sm-2">
                    <!--                    <img src="img/logo.png" width="100%" " alt="alt"/> -->
                </div>
                <div class="col-sm-10">
                    <h1>Admin Page</h1>
                </div>
            </div>
        </header>

        <div class="container">
            <section class=" row">
                <!-- Admin content goes here -->
                <h2 class="col-sm-11">Welcome, ${account.user}!</h2>
                <div class="col-sm-1">
                    <a class="btn btn-danger" href="logoutAdmin" style="width: 100%">Log out</a>
                </div>
            </section>



            <br><br>
            <form  class="refresh" action="displayRegister" method="post">
                <button type="submit" value="Refresh" class="btn btn-primary">
                    <i class="fa-solid fa-rotate-right"></i> Refresh
                </button>
            </form>
            <div class = "container">
                <h1 class="header">Statistic of all Mentee </h1>
                <div class="header">             
                    <h5>Total of Mentee: ${result}</h5>            
                </div>
            </div>
            <div class = "container">
                <table border="1px" class="container">
                    <tr style="background: whitesmoke;" >
                        <td >Full Name</td>
                        <td >Username</td>
                        <td >NumRequests</td>
                        <td >TotalHours</td>
                        <td >TotalSkills</td>
                    </tr>
                    <c:forEach items="${list}"  var="e">
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
            <br/><br/>


            <h3 style="text-align: center;">View List All Mentor</h3>
            <div class="container">
                <section  class="row" style="margin: 30px; text-align: end; font-size: 18px;">
                    <form class="search" action="admin" method="get">
                        <input name="search" type="search" value ="${param.search}" placeholder="Search here..."   >
                        <button type="submit">Search</button>
                    </form>   
                </section>


                <section class="row " style="background: white">

                    <div>                              
                        <div class="table-responsive">
                            <c:set var="page" value="${requestScope.page}"/>
                            <div class="pagination">
                                <c:forEach begin="1" end="${requestScope.num}" var="i">
                                    <a class="${i==page ? 'active' : ''}" href="admin?page=${i}">${i}</a>
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
                                                    <a class="btn btn-danger" href="activementor?id=${a.getID()}"  style="width: 70%">Inactive</a>
                                                </td>
                                            </c:if>
                                            <c:if test="${a.getActive() eq 0}">
                                                <td style="color: #ff1921">
                                                    <p style="font-size: large">Inactive</p>
                                                    <a class="btn" style="background-color: #4acd3d; color: white; width: 70%;" href="activementor?id=${a.getID()}" >Active</a>
                                                </td>
                                            </c:if>


                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>


                </section>


            </div>



            <h3>Mentor<a href="addInfo"><i class="fa-solid fa-plus"></i></a></h3><br>


            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <br><br><br>
            <h3>Statistic of Mentee<a href="statistic"><i class="fa-solid fa-plus"></i></a></h3><br>


            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <br><br><br>

            <h3>Mentee <a href="addInfo"><i class="fa-solid fa-plus"></i></a></h3><br>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>


                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
            <br><br><br>

            <h3>Request <a href="addOldStudent"><i class="fa-solid fa-plus"></i></a></h3><br>
            <h3 style="text-decoration: none;"><a href="viewall">ViewRequest</a></h3>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${listO}" >
                            <tr>
                                <td>${o.name}</td>
                                <td><a href="updateOldStudent?id_old=${o.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                                <td><a href="deleteOldStudent?id_old=${o.id}" onclick="return confirmAccess('${link.url}')"><i class="fa-solid fa-trash"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <br><br><br>

            <h3>Skills <a href="addSkill"><i class="fa-solid fa-plus"></i></a></h3><br>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${listSkill}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${s.getId()}</td>
                                <td>${s.getTiltle()}</td>
                                <td><img src="${s.getImage()}" width="100rem"  alt="alt"/></td>
                                <td>${s.getSkillName()}</td>
                                <td>${s.getSkill_description()}</td>
                                <c:if test="${s.getStatus() eq 'enable'}" >
                                    <td style="color: #01df1f">
                                        <p style="font-size: large">${s.getStatus()}</p>
                                        <a class="btn btn-danger" href="activeSkill?idSkill=${s.getId()}" style="width: 70%">Disable</a>
                                    </td>
                                </c:if>
                                <c:if test="${s.getStatus() ne 'enable'}" >
                                    <td style="color: #ff1921">
                                        <p style="font-size: large">${s.getStatus()}</p>
                                        <a class="btn" style="background-color: #4acd3d; color: white;" href="activeSkill?idSkill=${s.getId()}" style="width: 70%">Enable</a>
                                    </td>
                                </c:if>
                                <td><a href="updateSkill?idSkill=${s.getId()}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="message"></div>
            <h3>News <a href="addnews"><i class="fa-solid fa-plus"></i></a></h3><br> 
            <p style="color: green;">${message}</p> 
            <p style="color: red;">${eror}</p>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Postdate</th>
                            <th>Event Dates</th>
                            <th>Content</th>
                            <th>Summary</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${news}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${s.getNewsID()}</td>
                                <td>${s.getTitle()}</td>
                                <td><img src="${s.getImageURL()}" width="100rem"  alt="alt"/></td>
                                <td>${s.getPostDate()}</td>
                                <td>${s.getEventday()}-${s.getMonthdate()}-${s.getYeardate()}</td>

                                <td>${s.getContent()}</td>
                                <td>${s.getSummary()}</td>
                                <td><a href="updatenews?newsID=${s.getNewsID()}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                                <td><a href="deletenews?newsID=${s.getNewsID()}" onclick="return confirmDelete()"><i class="fa-solid fa-trash-alt"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <br><br>

        <footer >
            @Admin
            <p>&copy; 2023 Your Company. All rights reserved. | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>

        </footer>
        <script>
            function confirmAccess(url) {
                var confirmation = confirm("Do you want to delete ?");
                if (confirmation) {
                    // User confirmed, access the link
                    window.location.href = url;
                } else {
                    // User canceled, do nothing
                    return false;
                }
            }

            function confirmDelete() {
                var result = confirm("Do you want to delete this news?");
                if (result) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>

    </body>
</html>
