<%-- 
    Document   : newjsp
    Created on : Mar 2, 2024, 7:49:32 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programing</title>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">


        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <style>
            body{
                margin-top:20px;
                color: #1a202c;
                text-align: left;
                background-color: #fff;
            }
            .main-body {
                padding: 15px;
            }
            .card {
                box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #e2e8f0;
                background-clip: border-box;
                border: 0 solid rgba(0,0,0,.125);
                border-radius: .25rem;
                height: 575px;
            }

            .card-body {
                flex: 1 1 auto;
                min-height: 1px;
                padding: 1rem;
            }

            .gutters-sm {
                margin-right: -8px;
                margin-left: -8px;
            }

            .gutters-sm>.col, .gutters-sm>[class*=col-] {
                padding-right: 8px;
                padding-left: 8px;
            }
            .mb-3, .my-3 {
                margin-bottom: 1rem!important;
            }

            .bg-gray-300 {
                background-color: #e2e8f0;
            }
            .h-100 {
                height: 100%!important;
            }
            .shadow-none {
                box-shadow: none!important;
            }
            .rounded-circle {
                border-radius: 50%;
                width: 150px;
                height: 150px; 
            }
        </style>
    </head>

    <div style="margin-bottom: 10px;">
        <jsp:include page="header.jsp"></jsp:include>

        </div>

        <body>
            <h1 style="text-align: center; color: white;">View </h1>




            <div style="margin: 100px">

                <div class="container">
                    <div class="main-body">


                        <!-- info left  -->
                        <div class="row gutters-sm">
                            <div class="col-md-4 mb-3">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="d-flex flex-column align-items-center text-center">
                                            <img src="${requestScope.cvdetail.getAvatar()}" alt="Admin" class="rounded-circle" >
                                        <div class="mt-3">

                                            <h4 class="text-muted font-weight-bold"> Full Name: ${requestScope.cvdetail.getFullname()}</h4>
                                            <p class="text-muted font-size-sm">Date of birth:  ${requestScope.cvdetail.getDob()} </p>
                                            <p class="text-muted font-size-sm">Phone: ${requestScope.cvdetail.getPhone()} </p>
                                            <p class="text-muted font-size-sm">Sex: ${requestScope.cvdetail.getSex()} </p>
                                            <p class="text-muted font-size-sm">Address: ${requestScope.cvdetail.getAddress()} </p>


                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <button class="btn btn-info" onclick="goBack()" style="margin-bottom: 10px;
                                                float: right;
                                                margin-right: 10px;">Return</button>
                                    </div>
                                </div>
                            </div>
                            <!-- info left  -->

                        </div>
                        <div class="col-md-8">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Full Name: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getFullname()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">STK: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getStk()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Profession: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getProfession()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Framework: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getFramework()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Experience: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getExperience()}
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">My Service: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getMyservice()} 
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Archivement Descrition: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getArchivement_descition()} 
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Pro introduction: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getPro_introduc()} 
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Cost: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getCost()} 
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <h6 class="mb-0">Skills: </h6>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            ${requestScope.cvdetail.getSkill()} 
                                        </div>
                                    </div>
                                    <hr>

                                </div>
                            </div>




                        </div>
                    </div>

                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
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
        <script>
                                            function goBack() {
                                                window.history.back();
                                            }
        </script>
    </body>
</html>
