<%-- Document : home Created on : Jan 15, 2024, 2:39:49 PM Author : Admin --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@taglib prefix="c"
                                                                 uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap"
            rel="stylesheet"
            />

        <title>Happy Programming</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

        <!--

TemplateMo 570 Chain App Dev

https://templatemo.com/tm-570-chain-app-dev

        -->

        <!-- Additional CSS Files -->
        <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
            integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css" />
        <link rel="stylesheet" href="assets/css/animated.css" />
        <link rel="stylesheet" href="assets/css/owl.css" />
        <script
            src="https://kit.fontawesome.com/4c292f6960.js"
            crossorigin="anonymous"
        ></script>
        <style>
            .tlist {
                background-color: rgb(190, 251, 244);
                border-radius: 10px;
                width: 20%;
                border: 1px solid #03bfcb;
                text-align: center;
                margin-bottom: 20px;
            }
            .card-container {
                margin-bottom: 20px;
                background-color: white;
                border-radius: 5px;
                box-shadow: 0px 10px 20px -10px rgba(0, 0, 0, 0.75);
                padding-top: 30px;
                position: relative;
                width: 350px;
                max-width: 100%;
                text-align: center;
            }

            .card-content p {
                font-family: Apercu;
                font-size: 17px;
                color: black;
            }
            .card-container h6 {
                font-family: Apercu;
                color: green;
            }
            .card-container p {
                font-family: Apercu;
                font-size: 17px;
                color: black;
            }
            .card-container .round {
                width: 80%;
                border: 1px solid #03bfcb;
                border-radius: 50%;
                padding: 7px;
                object-fit: cover;
            }
            .card-container .pro {
                color: #231e39;
                background-color: #febb0b;
                border-radius: 3px;
                font-size: 14px;
                font-weight: bold;
                padding: 3px 7px;
                position: absolute;
                top: 30px;
                left: 30px;
            }
            .card {
                display: flex;
                width: 95%;
                padding: 20px;
                margin-bottom: 20px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
                transition: 0.3s;
            }

            .card-content {
                flex: 1;
            }
        </style>
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-content">
                            <h1 style="color: red" ;>${err}</h1>
                        <h1 style="color: green" ;>${message}</h1>
                        <p>Description: ${des}</p>
                    </div>
                </div>
                <div class="tlist">
                    <h4>List Mentor</h4>
                </div>

                <div
                    class="row left-content show-up header-text wow fadeInLeft"
                    data-wow-duration="1s"
                    data-wow-delay="0.2s"
                    >
                    <c:forEach var="o" items="${listM}">
                        <div class="col-sm-4">
                            <div class="card-container">
                                <span class="pro">Mentor</span>
                                <img class="round" src="${o.getAvatar()}" alt="Card image
                                     cap";">
                                <div class="card-body">
                                    <h5 class="card-title">
                                        <a
                                            href="profilecv?action=view&idMentor=${o.getIdMentor()}"
                                            style="color: black"
                                            >${o.getFullname()}</a
                                        >
                                    </h5>
                                    <h6>
                                        Rate: ${o.getRate()}
                                        <i class="fa-solid fa-star" style="color: #ffd43b"></i>
                                    </h6>
                                    <p>Total Request: ${o.getTotalRequest()}</p>
                                    
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

        <!-- Scripts -->
    </body>
</html>
