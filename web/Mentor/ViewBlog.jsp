<%-- 
    Document   : ViewBlog
    Created on : Mar 7, 2024, 12:08:45 PM
    Author     : ADMIN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://cdn.tiny.cloud/1/v2saiqx68nn924zq9xagmn8galaqifhtnlhjbr6jeofrd8n1/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
        <title>List of Requests</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
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
                background-color: whitesmoke;
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
            footer{
                background: #87cefa;
                color: #fff;
                text-align: center;
                padding: 2rem 0;
            }
        </style>
    </head>
    <body>

        <!--        <header>
                                <h1>List of Requests</h1>
                    <a href="home" style="text-decoration: none; color: white; display: flex; align-items: center;">
                        <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
                        Home
                    </a>
                    <h1 style="margin-left: auto;">BLOG LIST</h1>
                </header>-->

        <jsp:include page="../header.jsp"></jsp:include>
        <table class="container">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Date</th>
                        <th>Thumbnail</th>
                        <th>Title</th>
                        <th>Brief Info</th>
                        <th>Detail Info</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach items="${bloglist55}" var="bl">
                    <tr>
                        <td>${bl.idblog}</td>
                        <td>${bl.updatedate}</td>
                        <td><img src="${bl.thumbnail}" width="100rem"  alt="alt"/></td>
                        <td>${bl.title}</td>
                        <td>${bl.briefinfo}</td>
                        <td>${bl.detailinfo}</td>
                        <td><a href="updateblog?blogID=${bl.idblog}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="deleteblog?blogID=${bl.idblog}" onclick="return confirmDelete()"><i class="fa-solid fa-trash"></i></a></td>
                    </tr>
                </c:forEach>

                <!-- Add more rows as needed -->
            </tbody>
        </table>

        <jsp:include page="../footer.jsp"></jsp:include>
        <script>
            function confirmDelete() {
                var result = confirm("Do you want to delete this blog");
                if (result) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </body>
</html>
