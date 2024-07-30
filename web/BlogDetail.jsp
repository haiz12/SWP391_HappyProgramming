<%-- 
    Document   : BlogDetail
    Created on : Mar 6, 2024, 8:20:02 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Happy Programming</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Font awesome icon -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/blogdetail.css" />
    </head>
    <body>

        
        
            <nav class = "navbar">
                <div class = "container">
                    <a href = "home" class = "navbar-brand">Happy Programming</a>
                    <div class = "navbar-nav">
                        <a href = "home">home</a>
                        <a href = "">design</a>
                        <a href = "blog">blog</a>
                        <a href = "">about</a>
                    </div>
                </div>
            </nav>
        
        <section class="blog-detail">
            <div class="container">
                <c:forEach items="${blogbid}" var="bid">
                <div class="blog-detail-img">
                    <img src="${bid.thumbnail}" alt="Blog Image">
                </div>
                
                <div class="blog-detail-content">
                    <h2 class="blog-title">${bid.title}</h2>
                    <p class="blog-meta"><em>Published on: ${bid.updatedate} by ${bid.nameMentor}</em></p>
                    <p class="blog-post"> ${bid.briefinfo}</p>
                    <p class="blog-post"> ${bid.detailinfo}</p>
                </div>
                </c:forEach>
                
            </div>
        </section>
        <footer>
            <div class = "social-links">
                <a href = "#"><i class = "fab fa-facebook-f"></i></a>
                <a href = "#"><i class = "fab fa-twitter"></i></a>
                <a href = "#"><i class = "fab fa-instagram"></i></a>
                <a href = "#"><i class = "fab fa-pinterest"></i></a>
            </div>
            <span>Happy Programming</span>
        </footer>
    </body>

</html>