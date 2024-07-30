<%-- 
    Document   : statisticreq
    Created on : Feb 5, 2024, 11:12:34 PM
    Author     : ADMIN
--%>

<%-- 
    Document   : listallreq
    Created on : Jan 18, 2024, 11:43:47 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
        <title>Statistic of Requests</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
              crossorigin="anonymous" />
        <link href="vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;

            }

            header {

                color: #fff;
                padding: 10px;
                text-align: center;
            }

            section {
                margin: 20px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;

            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #48CEFA;
                color: #fff;
            }

            .btn-container {
                margin-top: 10px;
            }

            .update-btn, .delete-btn {
                padding: 8px 16px;
                margin-right: 10px;
                cursor: pointer;
            }

            .update-btn {
                background-color: #4caf50;
                color: #fff;
                border: none;
            }

            .delete-btn {
                background-color: #f44336;
                color: #fff;
                border: none;
            }
        </style>
     
    </head>
    <body>
        <jsp:include page="../header.jsp"></jsp:include>
            <header >

                <h1 style="margin-left: auto; padding-bottom: 20px;color: #000;">Statistic of Requests</h1>
            </header>

            <section>
                <table  border="1" style="margin:auto">
                    <thead style="border: 1px solid black; background:#48CEFA;">
                        <tr>
                            <th  style="width: 10%;text-align: center;">Title</th>
                            <th  style="width: 10%;text-align: center;">Skills</th>
                            <th  style="width: 10%;text-align: center;">Description</th>
                            <th  style="width: 10%;text-align: center;">Start learn</th>
                            <th  style="width: 10%;text-align: center;">Day complete</th>
                            <th  style="width: 10%;text-align: center;">Total learn hour</th>
                            <th  style="width: 10%;text-align: center;">Status</th>

                        </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="request" items="${listReq}">
                        <tr>
                            <td  style="width: 10%;text-align: center;padding: 15px;">${request.title}</td>
                            <td  style="width: 10%;text-align: center;padding: 15px;">${request.skill}</td>
                            <td  style="width: 10%;text-align: center;padding: 15px;">${request.content}</td>
                            <td  style="width: 10%;text-align: center;padding: 15px;">${request.startDate}</td>
                            <td  style="width: 10%;text-align: center;padding: 15px;">${request.endDate}</td>
                            <td  style="width: 10%;text-align: center;padding: 15px;">${request.hour}</td>
                            <td  style="width: 10%;text-align: center;padding: 15px;">${request.status}</td>

                        </tr>

                    </c:forEach>


                    <tr>
                        <td style="width: 10%;text-align: center;padding: 15px;">Total Request: </td>
                        <td style="width: 10%;text-align: center;">${totalRequests}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <!-- First empty column -->

                            <!-- Second empty column -->

                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%;text-align: center;padding: 15px;">Total Hour: </td>
                        <td style="width: 10%;text-align: center;padding: 15px;">${totalHours}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>

                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%;text-align: center;padding: 15px;">Mentor Name: </td>
                        <c:forEach var="entry" items="${mentorNames}">
                            <td style="width: 10%;text-align: center;padding: 15px;">${entry.value}</td>
                        </c:forEach>
                        <td></td>
                        <td></td>


                    </tr>
                    <tr>
                        <td style="width: 10%;text-align: center;padding: 15px;">Total Request send to Mentor: </td>
                        <c:forEach var="entry" items="${mentorCounts}">
                            <td style="width: 10%;text-align: center;padding: 15px;">${entry.value}</td>
                        </c:forEach>
                        <td></td>
                        <td></td>

                    </tr>
                    <!-- Add more rows as needed -->
                </tbody>
            </table>
        </section>
        <jsp:include page="../footer.jsp"></jsp:include>
       
    </body>
</html>

