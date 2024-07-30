<%-- 
    Document   : UpdateBlog
    Created on : Mar 7, 2024, 12:04:31 PM
    Author     : ADMIN
--%>

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
            <div class="title">Update Blog</div>
            <div class="content">
                <form action="updateblog" method="POST" enctype="multipart/form-data">
                    <input type="text" value="${b.idblog}" name="idblog" style="display: none">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Title</span>
                            <input type="text" name="title" placeholder="Enter title" value="${b.title}" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Brief-Info</span>
                            <input type="text" name="brief" placeholder="Enter brief-info" value="${b.briefinfo}" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Detail Info</span>
                            <input type="text" name="detail" placeholder="Enter detail-info" value="${b.detailinfo}" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Date</span>
                            <input type="date" name="date"placeholder="Enter date required" value="${b.updatedate}">
                        </div>
                        <div class="input-box">
                            <span class="details">Upload Thumbnail</span>
                            <input type="file" name="image" value="${b.thumbnail}" required >
                        </div>
                        
                    </div>
                    
                    <div class="button">
                        <input type="submit" value="Update">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
