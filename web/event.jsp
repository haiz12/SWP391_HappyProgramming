<%-- 
    Document   : event
    Created on : Feb 26, 2024, 10:18:12 AM
    Author     : trang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programing</title>

        <!-- mobile responsive meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- ** Plugins Needed for the Project ** -->
        <!-- Bootstrap -->
        <link rel="stylesheet" href="plugins/bootstrap/bootstrap.min.css">
        <!-- slick slider -->
        <link rel="stylesheet" href="plugins/slick/slick.css">
        <!-- themefy-icon -->
        <link rel="stylesheet" href="plugins/themify-icons/themify-icons.css">
        <!-- animation css -->
        <link rel="stylesheet" href="plugins/animate/animate.css">
        <!-- aos -->
        <link rel="stylesheet" href="plugins/aos/aos.css">
        <!-- venobox popup -->
        <link rel="stylesheet" href="plugins/venobox/venobox.css">

        <!-- Main Stylesheet -->
        <link href="css/styleevent.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styleevent.css"/>
        <!--Favicon-->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">

        <link href="vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

        <!--
        
        TemplateMo 570 Chain App Dev
        
        
        -->

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>

    </head>

    <jsp:include page="header.jsp"></jsp:include>

        <body>
            <!-- header -->




            <!-- page title -->
            <section class="page-title-section overlay" >
                <div class="container">
                    <div class="row">
                        <div class="col-md-8">
                            <ul class="list-inline custom-breadcrumb">
                                <li class="list-inline-item"><a class="h2 text-primary font-secondary" href="">Upcoming Events</a></li>
                                <li class="list-inline-item text-white h3 font-secondary"></li>
                            </ul>
                            <p class="text-lighten">Event news will be gathered at this news page. We invite everyone to watch and read the news</p>
                        </div>
                    </div>
                </div>
            </section>
            <!-- /page title -->

            <!-- courses -->
            <section class="section" id="event-section">
                <div class="container">
                    <div class="row">
                    <c:forEach var="e" items="${listN}" varStatus="loop">
                        <div class="col-lg-4 col-sm-6 mb-5 event-item ${loop.index > 5 ? 'hidden-event' : ''}">
                            <div class="card border-0 rounded-0 hover-shadow">
                                <div class="card-img position-relative">
                                    <img class="card-img-top rounded-0" style="width: 290px; height: 174px;" src="${e.getImageURL()}" alt="event thumb">
                                    <div class="card-date">
                                        <span>${e.getEventday()}</span><br>
                                        ${e.getMonthdate()} <br>
                                        ${e.getYeardate()}
                                    </div>
                                </div>
                                <div class="card-body">
                                    <a href="newsdetail?newsid=${e.getNewsID()}"><h4 class="card-title">${e.getTitle()}</h4></a>

                                </div>
                                <div  class="card-body" style="margin-top: 5px;">

                                    <p class="card-title">${e.getSummary()}</p>

                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
                <div class="text-center">
                    <button id="see-all-btn" class="btn btn-primary">SEE ALL</button>
                </div>
            </div>
        </section>
        <!-- /courses -->

        <!-- /footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- footer -->


        <!-- jQuery -->
        <script src="plugins/jQuery/jquery.min.js"></script>
        <!-- Bootstrap JS -->
        <script src="plugins/bootstrap/bootstrap.min.js"></script>
        <!-- slick slider -->
        <script src="plugins/slick/slick.min.js"></script>
        <!-- aos -->
        <script src="plugins/aos/aos.js"></script>
        <!-- venobox popup -->
        <script src="plugins/venobox/venobox.min.js"></script>
        <!-- mixitup filter -->
        <script src="plugins/mixitup/mixitup.min.js"></script>
        <!-- google map -->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcABaamniA6OL5YvYSpB3pFMNrXwXnLwU&libraries=places"></script>
        <script src="plugins/google-map/gmap.js"></script>

        <!-- Main Script -->
        <script src="js/scriptevent.js"></script>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var eventSection = document.getElementById('event-section');
                var allEvents = eventSection.querySelectorAll('.event-item');
                var seeAllBtn = document.getElementById('see-all-btn');

                // Ẩn các sự kiện nằm sau sự kiện thứ 6
                for (var i = 6; i < allEvents.length; i++) {
                    allEvents[i].style.display = 'none';
                }

                // Bắt sự kiện click vào nút "SEE ALL"
                seeAllBtn.addEventListener('click', function () {
                    // Hiển thị tất cả các sự kiện
                    allEvents.forEach(function (event) {
                        event.style.display = 'block';
                    });

                    // Ẩn nút "SEE ALL" sau khi đã hiển thị tất cả các sự kiện
                    this.style.display = 'none';
                });

                // Kiểm tra nếu có ít hơn 6 sự kiện, ẩn luôn nút "SEE ALL"
                if (allEvents.length <= 6) {
                    seeAllBtn.style.display = 'none';
                }
            });

        </script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/animation.js"></script>
        <script src="assets/js/imagesloaded.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> 
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
