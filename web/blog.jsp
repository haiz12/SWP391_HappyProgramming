<%-- 
    Document   : blog
    Created on : Feb 27, 2024, 10:22:03 PM
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
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/blog.css" />
        <style>
            .gg{
                display: contents;
            }
            .pagination-link {

            }

            .search-input {
                padding: 0.8rem 0;
                border: 1px solid black;
                border-radius: inherit;
                padding-left: 5px;
            }
            .banner form{

                width: 200%;


            }
            .banner{
                justify-content: space-around;
                margin-left: 20px;
            }
            .header-area.header-sticky {
                min-height: 80px;
                background: white;
            }
        </style>

    </head>
    <body>



        <!-- header -->
        <header class="gg">
            <jsp:include page="header.jsp"></jsp:include>
                <div class = "banner">
                    <div>                                 
                        <form action="searchblog">
                            <input name="txt" type = "text" class = "search-input" placeholder="Find blog . . .">
                            <button type = "submit" class = "search-btn">
                                <i class = "fas fa-search"></i>
                            </button>
                        </form>

                    </div>
                </div>
            </header>

            <section class = "blog" id = "blog">

                <div class = "container">
                    <div class = "title">
                        <h2>Latest Blog</h2>
                        <p>recent blogs about Happy Programming</p>
                    </div>

                    <div class = "blog-content">
                        <!-- item -->
                    <c:forEach items="${bloglist}" var="bl">
                        <div class = "blog-item">
                            <div class = "blog-img">
                                <img src = "${bl.thumbnail}"  alt = "">
                                <span><i class = "far fa-heart"></i></span>
                            </div>

                            <div class = "blog-text">
                                <span>${bl.updatedate}   ${bl.nameMentor}</span>

                                <h2>${bl.title}</h2>
                                <p>${bl.briefinfo}</p>
                                <a href = "blogdetail?bid=${bl.idblog}">Read More</a>
                            </div>
                        </div>
                    </c:forEach>  

                </div>

            </div>

        </section>


        <c:forEach begin="1" end="${endP}" var="i">
            <a><a class="pagination-link" href="blog?index=${i}">${i}</a>
            </c:forEach>
            <!-- footer -->



    </body>
</html>

