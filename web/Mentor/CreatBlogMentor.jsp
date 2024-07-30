<%-- 
    Document   : CreatBlog
    Created on : Mar 6, 2024, 11:53:42 PM
    Author     : ADMIN
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title> Happy Programming </title>
        <link rel="stylesheet" href="style.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cublog.css" />
        
    </head>
    <body>
      
        <div class="container">
            <div class="title">Create Blog</div>
            <div class="content">
                <form action="createblogMentor" method="POST" enctype="multipart/form-data">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Title</span>
                            <input type="text" name="title" placeholder="Enter title" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Brief-Info</span>
                            <input type="text" name="brief" placeholder="Enter brief-info" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Detail Info</span>
                            <input type="text" name="detail" placeholder="Enter detail-info" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Date</span>
                            <input type="date" name="date"placeholder="Enter date required>
                        </div>
                        <div class="input-box">
                            <span class="details">Upload Thumbnail</span>
                            <input type="file" name="image" required>
                        </div>
                        
                    </div>
                    
                    <div class="button">
                        <input type="submit" value="CREATE">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
