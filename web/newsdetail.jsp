<%-- 
    Document   : event-single
    Created on : Feb 29, 2024, 10:16:30 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programing</title>
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

        <!--Favicon-->
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>

    </head>
    <jsp:include page="header.jsp"></jsp:include>
        <body>





            <!-- page title -->
            <section class="page-title-section overlay" data-background="images/backgrounds/page-title.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8">
                            <ul class="list-inline custom-breadcrumb">
                                <li class="list-inline-item"><a class="h2 text-primary font-secondary" href="news">Upcoming Events</a></li>
                                <li class="list-inline-item text-white h3 font-secondary nasted">Event Details</li>
                            </ul>
                            <p class="text-lighten"></p>
                        </div>
                    </div>
                </div>
            </section>
            <!-- /page title -->

            <!-- event single -->
            <section class="section-sm">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <h2 class="section-title">${requestScope.news.getTitle()}</h2>
                    </div>
                    <!-- event image -->
                    <div class="col-12 mb-4">
                        <img src="${requestScope.news.getImageURL()}" alt="event thumb" class="img-fluid w-100">
                    </div>
                </div>
                <!-- event info -->
                <div class="row align-items-center mb-5">
                    <div class="col-lg-9">
                        <ul class="list-inline">

                            <li class="list-inline-item mr-xl-5 mr-4 mb-3 mb-lg-0">
                                <div class="d-flex align-items-center">
                                    <i class="ti-calendar text-primary icon-md mr-2"></i>
                                    <div class="text-left">
                                        <h6 class="mb-0">DATE</h6>
                                        <p class="mb-0">${requestScope.news.getEventday()}-${requestScope.news.getMonthdate()}-${requestScope.news.getYeardate()}</p>  
                                    </div>
                                </div>
                            </li>

                        </ul>
                    </div>

                    <!-- border -->
                    <div class="col-12 mt-4 order-4">
                        <div class="border-bottom border-primary"></div>
                    </div>
                </div>
                <!-- event details -->
                <div class="row">
                    <div class="col-12 mb-50">
                        <h3>About Event</h3>
                        <p>
                            ${requestScope.news.getContent()}
                        </p>
                    </div>
                </div>
        </section>
        <!-- /event single -->

        <!-- more event -->

        <!-- /more event -->

        <!-- footer -->

        <jsp:include page="footer.jsp"></jsp:include>
        <!-- /footer -->
        <!-- /footer -->

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
        <script src="js/script.js"></script>
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
