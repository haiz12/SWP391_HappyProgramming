

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" uri="/WEB-INF/url-encoder.tld" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

        <title>Chain App Dev - App Landing Page HTML5 Template</title>

        <!-- Bootstrap core CSS -->
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

    <body>



        <jsp:include page="header.jsp"></jsp:include>

            <div class="main-banner-container">
                <div class="main-banner" id="slide-1">
                    <div class="container">
                        <div class="row">
                        <c:forEach var="n" items="${listnews}">
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-lg-6 align-self-center">
                                        <div class="left-content show-up header-text wow fadeInLeft" data-wow-duration="1s" data-wow-delay="1s">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <h2>${n.getTitle()}</h2>
                                                    <h5>${n.getSummary()}</h5>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="right-image wow fadeInRight" data-wow-duration="1s" data-wow-delay="0.5s">
                                            <img style="width: 446px; height:268px; "  src="${n.getImageURL()}" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>>
                    </div>
                </div>
            </div>
            <div class="main-banner" id="slide-2" style="display: none;">
                <div class="container">
                    <div class="row">
                        <c:forEach var="n" items="${listsecond}">
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-lg-6 align-self-center">
                                        <div class="left-content show-up header-text wow fadeInLeft" data-wow-duration="1s" data-wow-delay="1s">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <h2>${n.getTitle()}</h2>
                                                    <h5>${n.getSummary()}</h5>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="right-image wow fadeInRight" data-wow-duration="1s" data-wow-delay="0.5s">
                                            <img style="width: 446px; height:268px;" src="${n.getImageURL()}" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>>
                    </div>
                </div>
            </div>
            <div class="main-banner" id="slide-3" style="display: none;">
                <div class="container">
                    <div class="row">
                        <c:forEach var="n" items="${listlast}">
                            <div class="col-lg-12">
                                <div class="row">
                                    <div class="col-lg-6 align-self-center">
                                        <div class="left-content show-up header-text wow fadeInLeft" data-wow-duration="1s" data-wow-delay="1s">
                                            <div class="row">
                                                <div class="col-lg-12">
                                                    <h2>${n.getTitle()}</h2>
                                                    <h5>${n.getSummary()}</h5>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="right-image wow fadeInRight" data-wow-duration="1s" data-wow-delay="0.5s">
                                            <img style="width: 446px; height:268px;" src="${n.getImageURL()}" alt="">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>>
                    </div>
                </div>
            </div>

        </div>

        <%-- search mentor by skill name ------------------------------------------------------------------------- --%>
        <!--        <div class="container">    
                    <form action="searchMentor" method="post">
                        <div class="input-group mb-3">
                            <input name="searchBySkill" type="text" class="form-control" placeholder="Search skill">
                            <button class="btn btn-success" type="submit">Go</button>
                        </div>
                    </form>
                </div>-->
        <%-- ---------------------------------------------------------------------------------------------------- --%>

        <div id="services" class="services section" style="padding-top: 0">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2">
                        <div class="section-heading  wow fadeInDown" data-wow-duration="1s" data-wow-delay="0.5s" style="margin-bottom: 20px">
                            <h4>The <em>Skill</em> we are teaching</h4>
                            <img src="assets/images/heading-line-dec.png" alt="">
                        </div>
                    </div>
                </div>
                <form action="searchMentor" method="get">
                    <div class="input-group mb-3">
                        <input name="searchBySkill" type="text" class="form-control" placeholder="Search skill">
                        <button class="btn btn-success" type="submit">Go</button>
                    </div>
                </form>
            </div>

            <div class="container">  
                <div class="row">
                    <c:forEach   items="${listSkill}" var = "item">
                        <div class="col-lg-4" style="margin-bottom: 10px">
                            <div class="service-item first-service">
                                <div  >
                                    <img src="${item.image}" height="237" width="246" alt="alt"/>
                                </div>                          
                                <h4> ${item.title} ${item.skillName}</h4>
                                <p> Học ${item.skillName} cùng mentor</p>
                                <div class="text-button">
                                    <a href="searchMentor?searchBySkill=<custom:encodeUrl value="${item.getSkillName()}"/>">Read More <i class="fa fa-arrow-right"></i></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div id="about" class="about-us section">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 align-self-center">
                            <div class="section-heading">
                                <h4>About <em>What We Do</em> &amp; Who We Are</h4>
                                <img src="assets/images/heading-line-dec.png" alt="">
                                <p>You are looking for a mentor but finding the right one is too difficult. 
                                    Here we have reputable instructors who vouch for their knowledge and teaching style</p>
                            </div>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="box-item">
                                        <h4><a href="#">Professional</a></h4>
                                        <p>Mentors with many experiences</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="box-item">
                                        <h4><a href="#">24/7 Support &amp; Help</a></h4>
                                        <p>Hotline: 0923457189</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="box-item">
                                        <h4><a href="#">Quality</a></h4>
                                        <p>Many mentee work in big company</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="box-item">
                                        <h4><a href="#">Co. Development</a></h4>
                                        <p>developed by FPT student</p>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="right-image">
                                <img src="assets/images/about-right-dec.png" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div id="rate" class="the-clients">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 offset-lg-2">
                            <div class="section-heading">
                                <h4>Check What <em>The Mentees Say</em> About Our App Dev</h4>
                                <img src="assets/images/heading-line-dec.png" alt="">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="naccs">
                                <div class="grid">
                                    <div class="row">
                                        <div class="col-lg-7 align-self-center">
                                            <div class="menu">
                                                <div class="first-thumb active">
                                                    <div class="thumb">
                                                        <div class="row">
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <h4>David Martino Co</h4>
                                                                <span class="date">30 November 2021</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 d-none d-sm-block">
                                                                <span class="category">Software Engineering</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <span class="rating">4</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="thumb">
                                                        <div class="row">
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <h4>Jake Harris Nyo</h4>
                                                                <span class="date">29 November 2021</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 d-none d-sm-block">
                                                                <span class="category">Data Analyst</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <span class="rating">4.5</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="thumb">
                                                        <div class="row">
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <h4>ดีมาก</h4>
                                                                <span class="date">27 November 2021</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 d-none d-sm-block">
                                                                <span class="category">Software Engineering</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <span class="rating">4.7</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div>
                                                    <div class="thumb">
                                                        <div class="row">
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <h4>とても良い</h4>
                                                                <span class="date">24 November 2021</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 d-none d-sm-block">
                                                                <span class="category">Tester</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <span class="rating">3.9</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="last-thumb">
                                                    <div class="thumb">
                                                        <div class="row">
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <h4>बहुत अच्छा</h4>
                                                                <span class="date">21 November 2021</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 d-none d-sm-block">
                                                                <span class="category">Web Development</span>
                                                            </div>
                                                            <div class="col-lg-4 col-sm-4 col-12">
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <i class="fa fa-star"></i>
                                                                <span class="rating">4.3</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="col-lg-5">
                                            <ul class="nacc">
                                                <li class="active">
                                                    <div>
                                                        <div class="thumb">
                                                            <div class="row">
                                                                <div class="col-lg-12">
                                                                    <div class="client-content">
                                                                        <img src="assets/images/quote.png" alt="">
                                                                        <p>“Lorem ipsum dolor sit amet, consectetur adpiscing elit, sed do eismod tempor idunte ut labore et dolore magna aliqua darwin kengan
                                                                            lorem ipsum dolor sit amet, consectetur picing elit massive big blasta.”</p>
                                                                    </div>
                                                                    <div class="down-content">
                                                                        <img src="assets/images/client-image.jpg" alt="">
                                                                        <div class="right-content">
                                                                            <h4>David Martino</h4>
                                                                            <span>CEO of David Company</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div>
                                                        <div class="thumb">
                                                            <div class="row">
                                                                <div class="col-lg-12">
                                                                    <div class="client-content">
                                                                        <img src="assets/images/quote.png" alt="">
                                                                        <p>“CTO, Lorem ipsum dolor sit amet, consectetur adpiscing elit, sed do eismod tempor idunte ut labore et dolore magna aliqua darwin kengan
                                                                            lorem ipsum dolor sit amet, consectetur picing elit massive big blasta.”</p>
                                                                    </div>
                                                                    <div class="down-content">
                                                                        <img src="assets/images/client-image.jpg" alt="">
                                                                        <div class="right-content">
                                                                            <h4>Jake H. Nyo</h4>
                                                                            <span>CTO of Digital Company</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div>
                                                        <div class="thumb">
                                                            <div class="row">
                                                                <div class="col-lg-12">
                                                                    <div class="client-content">
                                                                        <img src="assets/images/quote.png" alt="">
                                                                        <p>“May, Lorem ipsum dolor sit amet, consectetur adpiscing elit, sed do eismod tempor idunte ut labore et dolore magna aliqua darwin kengan
                                                                            lorem ipsum dolor sit amet, consectetur picing elit massive big blasta.”</p>
                                                                    </div>
                                                                    <div class="down-content">
                                                                        <img src="assets/images/client-image.jpg" alt="">
                                                                        <div class="right-content">
                                                                            <h4>May C.</h4>
                                                                            <span>Founder of Catherina Co.</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div>
                                                        <div class="thumb">
                                                            <div class="row">
                                                                <div class="col-lg-12">
                                                                    <div class="client-content">
                                                                        <img src="assets/images/quote.png" alt="">
                                                                        <p>“Lorem ipsum dolor sit amet, consectetur adpiscing elit, sed do eismod tempor idunte ut labore et dolore magna aliqua darwin kengan
                                                                            lorem ipsum dolor sit amet, consectetur picing elit massive big blasta.”</p>
                                                                    </div>
                                                                    <div class="down-content">
                                                                        <img src="assets/images/client-image.jpg" alt="">
                                                                        <div class="right-content">
                                                                            <h4>Random Staff</h4>
                                                                            <span>Manager, Digital Company</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li>
                                                    <div>
                                                        <div class="thumb">
                                                            <div class="row">
                                                                <div class="col-lg-12">
                                                                    <div class="client-content">
                                                                        <img src="assets/images/quote.png" alt="">
                                                                        <p>“Mark, Lorem ipsum dolor sit amet, consectetur adpiscing elit, sed do eismod tempor idunte ut labore et dolore magna aliqua darwin kengan
                                                                            lorem ipsum dolor sit amet, consectetur picing elit massive big blasta.”</p>
                                                                    </div>
                                                                    <div class="down-content">
                                                                        <img src="assets/images/client-image.jpg" alt="">
                                                                        <div class="right-content">
                                                                            <h4>Mark Am</h4>
                                                                            <span>CTO, Amber Do Company</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>          
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <jsp:include page="footer.jsp"></jsp:include>

                <div class="modal fade" id="statisticsModal" tabindex="-1" role="dialog" aria-labelledby="statisticsModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document"> <!-- Added modal-lg class -->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="statisticsModalLabel">Statistic Request Form</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <table id="statisticsTable" class="table">
                                    <p style="text-align: center; color: red;"> ${errorMess}</p> 
                                <tbody>
                                    <c:set var="mentorStats" value="${mentorStats}" />
                                    <tr>
                                        <td>Processing Request Count:</td>
                                        <td>${mentorStats.processingRequestCount}</td>
                                    </tr>
                                    <tr>
                                        <td>Open Request Count:</td>
                                        <td>${mentorStats.openRequestCount}</td>
                                    </tr>
                                    <tr>
                                        <td>Cancel Request Count:</td>
                                        <td>${mentorStats.cancelRequestCount}</td>
                                    </tr>
                                    <tr>
                                        <td>Cancel Ratio:</td>
                                        <td>${mentorStats.cancelRatio}%</td>
                                    </tr>
                                    <tr>
                                        <td>Closed Ratio:</td>
                                        <td>${mentorStats.closedRatio}%</td>
                                    </tr>
                                    <tr>
                                        <td>Rating star:</td>
                                        <td>${mentorStats.averageRating}</td>
                                    </tr>
                                </tbody>

                            </table>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>




            <script>
                document.addEventListener("DOMContentLoaded", function () {
                    var slideIndex = 1;
                    showSlide(slideIndex);

                    function showSlide(n) {
                        var i;
                        var slides = document.getElementsByClassName("main-banner");
                        if (n > slides.length) {
                            slideIndex = 1
                        }
                        if (n < 1) {
                            slideIndex = slides.length
                        }
                        for (i = 0; i < slides.length; i++) {
                            slides[i].style.display = "none";
                        }
                        slides[slideIndex - 1].style.display = "block";
                    }

                    function nextSlide() {
                        showSlide(slideIndex += 1);
                    }

                    setInterval(nextSlide, 5000); // Chuyển slide sau mỗi 5 giây (5000 milliseconds)
                });

            </script>
            <!-- Scripts -->
            <!--            <script src="vendor/jquery/jquery.min.js"></script>
                        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
                        <script src="assets/js/owl-carousel.js"></script>
                        <script src="assets/js/animation.js"></script>
                        <script src="assets/js/imagesloaded.js"></script>
                        <script src="assets/js/popup.js"></script>
                        <script src="assets/js/custom.js"></script>
                        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> 
                        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>-->
    </body>
</html>
