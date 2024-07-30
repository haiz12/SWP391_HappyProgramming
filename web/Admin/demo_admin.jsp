<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>ADMIN-Happy Programming</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:100,200,300,400,500,600,700,800,900" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
        <!--        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
                <link href="vendor/devicons/css/devicons.min.css" rel="stylesheet">
                <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet">-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- Custom styles for this template -->
        <!--        <link href="../css/resume.min.css"  type="text/css" rel="stylesheet">-->
        <link href="../css/bootstrap.min.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/resume.min.css"/>
        <style>
            .search {
                width: 400px;
                height: 40px;
                margin: 5px auto;
                background: transparent;
                border-radius: 5px;
                border: 1px solid #06357a;
                margin-right: 15px;
                padding-right: 0px;
            }

            .search input {
                width: 200px;
                padding: 5px 5px;
                float: left;
                color: #444;
                border: 0;
                background: transparent;
                border-radius: 3px;
            }

            .search input:focus {
                outline: 0;
                background: transparent;
            }

            .search button {
                font-size: medium;
                position: relative;
                float: right;
                border: 0;
                padding: 0;
                cursor: pointer;
                height: 40px;
                width: 120px;
                color: #444;
                background: transparent;
                border-left: 1px solid #212529;
                border-radius: 3px;
            }

            .search button:hover {
                background: rgba(0, 0, 0, .2);
                color: #444;
            }

            .search button:active {
                box-shadow: 0px 0px 12px 0px rgba(225, 225, 225, 1);
            }

            .search button:focus {
                outline: 0;
            }

            .pagination {
                display: inline-block;
            }

            .pagination a {
                color: black;
                font-size: 22px;
                float: left;
                padding: 8px 16px;
                text-decoration: none;
            }

            .pagination a.active {
                background-color: #4CAF50;
                color: white;
            }

            .pagination a:hover:not(.active) {
                background-color: chocolate;
            }

            td, th {
                border: 1px solid black;
                padding: 8px;
            }

            .accept-btn {
                background-color: #1BA345;
                border-radius: 5px;
                height: 30px;
                width: 70px;
                display: inline-block;
                text-align: center;
                line-height: 30px;
                color: white;
                text-decoration: none;
                cursor: pointer;
                margin-right: 5px;
            }

            .delete-btn {
                background-color: #DE3E44;
                border-radius: 5px;
                height: 30px;
                width: 70px;
                display: inline-block;
                text-align: center;
                line-height: 30px;
                color: white;
                text-decoration: none;
                cursor: pointer;
                margin-top: 5px;
            }

            .table-responsive {
                display: block;
                width: 100%;
                overflow-x: auto;
                -webkit-overflow-scrolling: touch;
            }

            .table th {
                white-space: nowrap;
            }

            .schedule-container table {
                width: 100%;
                border-collapse: collapse;
            }

            .schedule-container th,
            .schedule-container td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            .schedule-container th {
                background-color: #f2f2f2;
            }

            .schedule-container input[type="checkbox"] {
                transform: scale(1.5);
            }

            .popup {
                position: relative;
                display: inline-block;
                cursor: pointer;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            .popup .popuptext {
                visibility: hidden;
                width: 160px;
                background-color: #555;
                color: #fff;
                text-align: center;
                border-radius: 6px;
                padding: 8px 0;
                position: absolute;
                z-index: 1;
                left: 100%;
                transform: translate(0, -50%);
                text-decoration: none;
            }

            .popup .popuptext::after {
                content: "";
                position: absolute;
                top: 50%;
                left: -5px;
                margin-top: -5px;
                border-width: 5px;
                border-style: solid;
                border-color: transparent #555 transparent transparent;
            }

            .popup .show {
                visibility: visible;
                -webkit-animation: fadeIn 1s;
                animation: fadeIn 1s;
            }

            @-webkit-keyframes fadeIn {
                from {
                    opacity: 0;
                }
                to {
                    opacity: 1;
                }
            }

            @keyframes fadeIn {
                from {
                    opacity: 0;
                }
                to {
                    opacity: 1;
                }
            }

            .schedule-container {
                display: flex;
                gap: 20px;
            }

            .schedule-details {
                width: 100%;
                max-width: 1200px;
                background-color: #f1f1f1;
                border: 1px solid #ccc;
                padding: 20px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
            }

            .schedule-details h3 {
                margin-bottom: 20px;
                font-size: 1.5em;
                color: #333;
                border-bottom: 2px solid #ccc;
                padding-bottom: 10px;
            }

            .table {
                width: 100%;
                border-collapse: collapse;
                background-color: #fff;
            }

            .table th, .table td {
                border: 1px solid #ccc;
                padding: 12px;
                text-align: center;
                font-size: 1em;
            }

            .table th {
                background-color: #f7f7f7;
                font-weight: bold;
                color: #555;
            }

            .table tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            .table tr:hover {
                background-color: #f1f1f1;
            }

            .table input[type="checkbox"] {
                transform: scale(1.2);
                margin: 0;
            }

            button {
                display: inline-block;
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 1em;
            }

            button:hover {
                background-color: #0056b3;
            }

            .hidden {
                display: none;
            }
        </style>
    </head>

    <body id="page-top">

        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">Start Bootstrap</span>
                <span class="d-none d-lg-block"><img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/profile.jpg" alt="">
                </span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <!--                    <li class="nav-item">
                                            <a class="nav-link js-scroll-trigger" href="#withdrawal">Wallet</a>
                                        </li>-->
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#cvmentor">CV Mentor</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#schedule">Schedule</a>
                    </li>
<!--                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#mentor">Mentor</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#mentee">Mentee</a>
                    </li>-->
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#skills">Skills</a>

                    </li>
<!--                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#report">Report</a>

                    </li>-->
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#request">Requests</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#blog">Wallet</a>
                    </li> 
                </ul>
            </div>
            <div>
                <a class="nav-link js-scroll-trigger" href="logoutAdmin">Log out</a>
            </div>
        </nav>
        <section class="resume-section p-3 p-lg-5 d-flex d-column" id="cvmentor">
            <div class="my-auto">
                <h1 class="mb-0">
                    <span class="text-primary">CV Mentor</span>
                </h1>
                <div class="table-responsive">                       
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>ID</th>
                                <th>Image</th>
                                <th>Full Name</th>
                                <th>Phone</th>
                                <th>DOB</th>
                                <!-- <th>Sex</th> --><!-- <th>Address</th>             -->
                                <th>Profession</th>
                                <!-- <th>Profession Introduction</th> -->
                                <th>Achievement Description</th>
                                <th>Framework</th>
                                <th>Experience</th>
                                <th>Education</th>
                                <th>My Service</th>
                                <th>STK</th>
                                <th>Pay/hour</th>
                                <th>Skill</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="s" items="${cvList}" varStatus="loop">
                                <tr>
                                    <td>${loop.index + 1}</td>
                                    <td>${s.getIdMentor()}</td>
                                    <td><img src="${s.getAvatar()}" width="100rem"  alt="alt"/></td>
                                    <td><a style="text-decoration: none;" href="cvdetail?id=${s.getIdMentor()}">${s.getFullname()}</a></td>
                                    <td>${s.getPhone()}</td>
                                    <td>${s.getDob()}</td>
                                    <!-- <td>${s.getSex()}</td> -->
                                    <!-- <td>${s.getAddress()}</td> -->
                                    <td>${s.getProfession()}</td>
<!--                                    <td>${s.getPro_introduc()}</td>-->
                                    <td>${s.getArchivement_descition()}</td>
                                    <td>${s.getFramework()}</td>
                                    <td>${s.getExperience()}</td>
                                    <td>${s.getEducation()}</td>
                                    <td>${s.getMyservice()}</td>
                                    <td>${s.getStk()}</td>
                                    <td>${s.getCost()}</td>
                                    <td>${s.getSkill()}</td>

                                    <td class="btn-container">
                                        <a href="upcvmentor?idmentor=${s.getIdMentor()}" class="accept-btn">
                                            Accept
                                        </a>
                                        <a href="deletecv?idmentor=${s.getIdMentor()}" class="delete-btn">
                                            Reject
                                        </a> 
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>


        <!--        <div class="container-fluid p-0">/-strong/-heart:>:o:-((:-h<section class="resume-section p-3 p-lg-5 d-flex d-column row" id="withdrawal">
                        <div class="my-auto col-7">
                            <h1 class="mb-0">
                                <span class="text-primary">Wallet</span>
                            </h1>
        
                            <div class="table-responsive">
                                <table class="table table-bordered" style="text-align: center">
                                    <thead>
                                        <tr>
                                            <th>Fullname</th>
                                            <th>Username</th>
                                            <th>Money</th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
        <c:forEach var="h" items="${listTakeMoney}" >
            <tr>
                <td>${h.getFullname()}</td>
                <td>${h.getUsername()}</td>
                <td>${h.getMoney()} VNÐ</td>
                <td><a href="walletAdmin?action=accept&id=${h.getId()}" class="btn btn-success">Accept</a></td>
                <td><a href="walletAdmin?action=reject&id=${h.getId()}" class="btn btn-danger">Reject</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</div>
<div class="col-5" style="margin-top: 87px">
<div style="border: solid;box-sizing: border-box;padding-left: 30px">
<h3>Total income</h3>
<h3>${totalIncome} VNÐ</h3>
</div>
<div style="border: solid;box-sizing: border-box;padding-left: 30px; margin-top: 30px">
<h3>Wallet System</h3>
<h3>${walletSystem} VNÐ</h3>
</div>
<br>
<div>History Payment</div>
<table class="table table-bordered" style="text-align: center;border: solid">
<thead>
    <tr>
        <th>Content</th>
        <th>Money</th>
        <th>Date</th>
    </tr>
</thead>
<tbody>
        <c:forEach items="${listHistory}" var="l">
            <tr>
                <td>${l.getContent()}</td>
            <c:if test="${l.getStype() eq 'Deposit'}">
                <td style="color: green">+ ${l.getAmount()}</td>
            </c:if>
            <c:if test="${l.getStype() eq 'Payment'}">
                <td style="color: red">- ${l.getAmount()}</td>
            </c:if>
            <td>${l.getDatePay()}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>
</section>-->
        <section class="resume-section p-3 p-lg-5 d-flex d-column" id="schedule">
            <div class="my-auto">
                <h2 class="mb-5">Schedule</h2>
                <div class="schedule-container">
                    <table class="table table-bordered" id="schedule-table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>FullName</th>
                                <th>Schedule</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Example rows -->
                            <c:forEach var="entry" items="${mentorSchedules}" varStatus="loop">
                                <c:set var="mentor" value="${entry.key}" />
                                <c:set var="scheduleList" value="${entry.value}" />
                                <c:if test="${not empty scheduleList}">
                                    <tr id="mentor-${mentor.getMentorId()}">
                                        <td>${mentor.getMentorId()}</td>
                                        <td>${mentor.getFullname()}</td>
                                        <td>
                                            <!-- Button to show schedule -->
                                            <div class="popup" onclick="toggleSchedule('${mentor.getMentorId()}')">Show</div>
                                            <!-- Popup Container for schedule details -->
                                            <div id="scheduleDetails-${mentor.getMentorId()}" class="details" style="display:none;">
                                                <h3>Schedule Details</h3>
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Slot</th>
                                                            <th>MON</th>
                                                            <th>TUE</th>
                                                            <th>WED</th>
                                                            <th>THU</th>
                                                            <th>FRI</th>
                                                            <th>SAT</th>
                                                            <th>SUN</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="timeSlot" items="${timeSlot}">
                                                            <tr>
                                                                <td><label class="form-check-label" for="timeSlotId">${timeSlot.time}</label></td>

                                                                <c:set var="isCheckedMon" value="false" />
                                                                <c:set var="isCheckedTue" value="false" />
                                                                <c:set var="isCheckedWed" value="false" />
                                                                <c:set var="isCheckedThu" value="false" />
                                                                <c:set var="isCheckedFri" value="false" />
                                                                <c:set var="isCheckedSat" value="false" />
                                                                <c:set var="isCheckedSun" value="false" />

                                                                <c:forEach var="list" items="${scheduleList}" varStatus="loop">
                                                                    <c:choose>
                                                                        <c:when test="${list.time == timeSlot.time}">
                                                                            <c:choose>
                                                                                <c:when test="${list.day == 'mon'}">
                                                                                    <c:set var="isCheckedMon" value="true" />
                                                                                </c:when>
                                                                                <c:when test="${list.day == 'tue'}">
                                                                                    <c:set var="isCheckedTue" value="true" />
                                                                                </c:when>
                                                                                <c:when test="${list.day == 'wed'}">
                                                                                    <c:set var="isCheckedWed" value="true" />
                                                                                </c:when>
                                                                                <c:when test="${list.day == 'thu'}">
                                                                                    <c:set var="isCheckedThu" value="true" />
                                                                                </c:when>
                                                                                <c:when test="${list.day == 'fri'}">
                                                                                    <c:set var="isCheckedFri" value="true" />
                                                                                </c:when>
                                                                                <c:when test="${list.day == 'sat'}">
                                                                                    <c:set var="isCheckedSat" value="true" />
                                                                                </c:when>
                                                                                <c:when test="${list.day == 'sun'}">
                                                                                    <c:set var="isCheckedSun" value="true" />
                                                                                </c:when>
                                                                            </c:choose>
                                                                        </c:when>
                                                                    </c:choose>
                                                                </c:forEach>

                                                                <td><input type="checkbox" disabled readonly name="schedule" value="mon-${timeSlot.time_slot_id}" data-day="mon" data-slot="${timeSlot.time}" <c:if test="${isCheckedMon}">checked</c:if>></td>
                                                                <td><input type="checkbox" disabled readonly name="schedule" value="tue-${timeSlot.time_slot_id}" data-day="tue" data-slot="${timeSlot.time}" <c:if test="${isCheckedTue}">checked</c:if>></td>
                                                                <td><input type="checkbox" disabled readonly name="schedule" value="wed-${timeSlot.time_slot_id}" data-day="wed" data-slot="${timeSlot.time}" <c:if test="${isCheckedWed}">checked</c:if>></td>
                                                                <td><input type="checkbox" disabled readonly name="schedule" value="thu-${timeSlot.time_slot_id}" data-day="thu" data-slot="${timeSlot.time}" <c:if test="${isCheckedThu}">checked</c:if>></td>
                                                                <td><input type="checkbox" disabled readonly name="schedule" value="fri-${timeSlot.time_slot_id}" data-day="fri" data-slot="${timeSlot.time}" <c:if test="${isCheckedFri}">checked</c:if>></td>
                                                                <td><input type="checkbox" disabled readonly name="schedule" value="sat-${timeSlot.time_slot_id}" data-day="sat" data-slot="${timeSlot.time}" <c:if test="${isCheckedSat}">checked</c:if>></td>
                                                                <td><input type="checkbox" disabled readonly name="schedule" value="sun-${timeSlot.time_slot_id}" data-day="sun" data-slot="${timeSlot.time}" <c:if test="${isCheckedSun}">checked</c:if>></td>
                                                                </tr>
                                                        </c:forEach>

                                                    </tbody>
                                                </table>
                                                <button onclick="closeSchedule()">Close</button>
                                            </div>
                                        </td>
                                        <!-- Bat dau sua o day -->
                                        <td>
                                            <c:set var="mentorId" value="${mentor.getMentorId()}"/>
                                            <c:set var="foundMatch" value="false"/>

                                            <c:forEach var="lu" items="${listUSR}">
                                                <c:if test="${mentorId == lu.mentor_id}">
                                                    <c:set var="foundMatch" value="true"/>
                                                </c:if>
                                            </c:forEach>

                                            <c:choose>
                                                <c:when test="${foundMatch == 'true'}">
                                                    Update Request
                                                </c:when>
                                                <c:otherwise>
                                                    Processing
                                                </c:otherwise>
                                            </c:choose>
                                        </td>


                                        <c:set var="mentorId" value="${mentor.getMentorId()}"/>
                                        <c:set var="foundMatch" value="false"/>

                                        <c:forEach var="lu" items="${listUSR}">
                                            <c:if test="${mentorId == lu.mentor_id}">
                                                <c:set var="foundMatch" value="true"/>
                                            </c:if>
                                        </c:forEach>

                                        <c:choose>
                                            <c:when test="${foundMatch == 'true'}">
                                                <td class="btn-container">
                                                    <form action="adminManagerScheduleRequest" method="post">
                                                        <input type="hidden" name="mentorId" value="${mentor.getMentorId()}">
                                                        <input type="hidden" name="statusId" value="8">
                                                        <button type="submit" style="background-color: #1BA345">Accept</button>
                                                    </form>
                                                    <a href="#schedule" class="delete-btn" onclick="showRejectForm1(this)">Reject</a>

                                                    <div id="rejectForm1" class="hidden">
                                                        <form id="confirmRejectForm1" action="adminManagerScheduleRequest" method="post" onsubmit="return confirmReject1()">
                                                            <input type="hidden" name="mentorId" value="${mentor.getMentorId()}">
                                                            <label for="reasonReject">Reason for Reject:</label>
                                                            <input type="text" id="reasonReject1" name="reasonReject" required>
                                                            <input type="hidden" name="statusId" value="9">
                                                            <button type="submit" style="background-color: #DE3E44">Reject</button>
                                                        </form>
                                                    </div>

                                                    <script>
                                                        function showRejectForm1(button) {
                                                            document.getElementById('rejectForm1').classList.remove('hidden');
                                                            button.classList.add('hidden');
                                                        }

                                                        function confirmReject1() {
                                                            const reason = document.getElementById('reasonReject1').value;
                                                            return confirm(`Are you sure you want to reject with the following reason?\n\nReason: ${reason}`);
                                                        }
                                                    </script>
                                                </td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class="btn-container">
                                                    <a href="acceptschedule?idmentor=${mentor.getMentorId()}" class="accept-btn">Accept</a>
                                                    <a href="rejectschedule?idmentor=${mentor.getMentorId()}" class="delete-btn" onclick="return confirmReject()">Reject</a> 
                                                </td>

                                            </c:otherwise>
                                        </c:choose>


                                        <!-- Bat dau sua o day -->
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>



<!--        <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="mentor">
            <div class="my-auto">
                <h2 class="mb-5">Mentor</h2>
            </div>
            <div class="container">
                <section  class="row" style="margin: 30px; text-align: end; font-size: 18px;">
                    <form class="search" action="admin" method="get">
                        <input name="search" type="search" value ="${param.search}" placeholder="Search here..."   >
                        <button type="submit">Search</button>
                    </form>   
                </section>


                <section class="row " style="background: white">

                    <div>                              
                        <div class="table-responsive">
                            <c:set var="page1" value="${requestScope.page1}"/>
                            <div class="pagination">
                                <c:forEach begin="1" end="${requestScope.num}" var="i"><a class="${i==page1 ? 'active' : ''}" href="admin?page1=${i}#mentor">${i}</a>
                                </c:forEach>
                            </div>

                            <table class="table table-bordered">
                                <thead>
                                    <tr style="background: whitesmoke;">
                                        <th>STT</th>
                                        <th>ID</th>
                                        <th>FullName</th>
                                        <th>Account</th>
                                        <th>Profession</th>
                                        <th>Accepted request</th>
                                        <th>Percentage completed</th>
                                        <th>Rate</th>
                                        <th>Active</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="a" items="${list}" varStatus="loop">
                                        <tr>
                                            <td>${loop.index + 1}</td>
                                            <td>${a.getID()}</td>
                                            <td>${a.getFullName()}</td>                                           
                                            <td>${a.getAccountname()}</td>
                                            <td>${a.getProfession()}</td>
                                            <td>${a.getAcceptrequest()}</td>
                                            <td>${a.getPercentcompleted()}%</td>
                                            <td>${a.getRate()}<i class="fa-solid fa-star" style="color: #FFD43B;"></i></td>

                                            <c:if test="${a.getActive() eq 1}">
                                                <td style="color: #01df1f">
                                                    <p style="font-size: large">Active</p>
                                                    <a class="btn btn-danger" href="activementor?id=${a.getID()}#mentor"  style="width: 70%;padding-right: 30px;">Inactive</a>
                                                </td>
                                            </c:if>
                                            <c:if test="${a.getActive() eq 0}">
                                                <td style="color: #ff1921">
                                                    <p style="font-size: large">Inactive</p>
                                                    <a class="btn" style="background-color: #4acd3d; color: white; width: 70%;" href="activementor?id=${a.getID()}#mentor" >Active</a>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
        </section>



        <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="mentee">
            <div class="my-auto">
                <h2 class="mb-5">Mentee</h2>
                <div class="header">             
                    <h5>Total of Mentee: ${result}</h5>            
                </div>
                <c:set var="page2" value="${requestScope.page2}"/>
                <div class="pagination">
                    <c:forEach begin="1" end="${requestScope.num2}" var="i">
                        <a class="${i==page2 ? 'active' : ''}" href="admin?page2=${i}#mentee">${i}</a>
                    </c:forEach>
                </div>
                <table border="1px" class="container">
                    <tr style="background: whitesmoke;" >
                        <td >Full Name</td>
                        <td >Username</td>
                        <td >NumRequests</td>
                        <td >TotalHours</td>
                        <td >TotalSkills</td>
                    </tr>
                    <c:forEach items="${list2}"  var="e">
                        <tr>
                            <td>${e.getFullName()}</td>
                            <td>${e.getUserName()}</td>
                            <td>${e.getNumRequests()}</td>
                            <td>${e.getTotalHours()}</td>
                            <td>${e.getTotalSkills()}</td>               
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </section>-->

        <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="skills">
            <div class="my-auto">
                <h2 class="mb-5">Skills <a href="addSkill"><i class="fa-solid fa-plus"></i></a></h2>
                        <c:set var="page" value="${requestScope.page}"/>
                <div class="pagination">
                    <c:forEach begin="1" end="${requestScope.num3}" var="i">
                        <a class="${i==page ? 'active' : ''}" href="admin?page=${i}#skills">${i}</a>
                    </c:forEach>
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="s" items="${listSkill22}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${s.getId()}</td>
                                <td>${s.getTiltle()}</td>
                                <td><img src="${s.getImage()}" width="100rem"  alt="alt"/></td>
                                <td>${s.getSkillName()}</td>
                                <td>${s.getSkill_description()}</td>
                                <c:if test="${s.getStatus() eq 'enable'}" >
                                    <td style="color: #01df1f">
                                        <p style="font-size: large">${s.getStatus()}</p>
                                        <a class="btn btn-danger" href="activeSkill?idSkill=${s.getId()}#skills" style="width: 70%">Disable</a>
                                    </td>
                                </c:if>
                                <c:if test="${s.getStatus() ne 'enable'}" >
                                    <td style="color: #ff1921">
                                        <p style="font-size: large">${s.getStatus()}</p>
                                        <a class="btn" style="background-color: #4acd3d; color: white;" href="activeSkill?idSkill=${s.getId()}#skills" style="width: 70%">Enable</a>
                                    </td>
                                </c:if>
                                <td><a href="updateSkill?idSkill=${s.getId()}#skills"><i class="fa-solid fa-pen-to-square"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>


<!--        <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="report">
            <div class="my-auto">
                <h2 class="mb-5">Report</h2>
                <c:set var="page8" value="${requestScope.page8}"/>
                <div class="pagination">
                    <c:forEach begin="1" end="${requestScope.num8}" var="i">
                        <a class="${i==page8 ? 'active' : ''}" href="admin?page8=${i}#report">${i}</a>
                    </c:forEach>
                </div>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Content</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="l" items="${amme}" varStatus="loop">
                            <tr>
                                <td>${loop.index + 1}</td>
                                <td>${l.getIdRequest()}</td>
                                <td>${l.getTitle()}</td>                                  
                                <td>${l.getContent()}</td>                                   
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>-->

        <section class="resume-section p-3 p-lg-5 d-flex flex-column" id="request">
            <div class="my-auto">
                <h2 class="mb-5">Requests</h2>
                <div class="container">
                    <div class="table-responsive">

                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Mentee</th>
                                    <th>Mentor</th>
                                    <th>Title</th>
                                    <th>Content</th>
                                    <th>Skill</th>
                                    <th>Status</th>
                                    <th>Slot</th>
                                    <th>Start Week</th>
                                    <th>End Week</th>
                                    <th>Total Hours</th>
                                    <th>Total Costs</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${allRequest}" var="ar">
                                    <tr>
                                        <td>${ar.mentee.fullname}</td>
                                        <td>${ar.mentor.fullname}</td>
                                        <td>${ar.title}</td>
                                        <td>${ar.content}</td>
                                        <td>${ar.skill}</td>
                                        <c:if test="${ar.statusId == 1}"><td>Processing</td></c:if>
                                        <c:if test="${ar.statusId == 2}"><td>Accept</td></c:if>
                                        <c:if test="${ar.statusId == 3}"><td>Reject</td></c:if>
                                        <c:if test="${ar.statusId == 11}"><td>RequestDone</td></c:if>
                                        <c:if test="${ar.statusId == 12}"><td>Done</td></c:if>
                                        <c:if test="${ar.statusId == 10}"><td>Paid</td></c:if>
                                        <td>${ar.listSlot}</td>
                                        <td>${ar.startWeek}</td>
                                        <td>${ar.endWeek}</td>
                                        <td>${ar.hour}</td>
                                        <td>${ar.totalCost} VND</td>
                                        <c:if test="${ar.statusId == 12}">
                                        <td class="btn-container" style="vertical-align: middle;">
                                            <form action="admin" method="post">
                                                <input type="hidden" name="idRequest" value="${ar.listIdRequest}"/>
                                                <input type="hidden" name="totalCost" value="${ar.totalCost}"/>
                                                <button type="submit">Payment</button>
                                            </form>
                                        </td>
                                        </c:if>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <section class="resume-section p-3 p-lg-5 d-flex d-column" id="blog">
            <div class="my-auto">
                <h1 class="mb-0">
                    <span class="text-primary">Wallet</span>
                </h1>
                <h3 class="mb-0">
                    <span class="text-primary">Wallet balance: ${walletBalance} VND</span>
                </h3>
                <div class="table-responsive">

                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Sender</th>
                                <th>Money</th>
                                <th>Date</th>
                                <th>Content</th>
                                <th>Stype</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${historyWallet}" var="h">
                                <tr>
                                    <td>${h.getNameMentee()}</td>
                                    <c:if test="${h.getStype() eq 'Deposit' || h.getStype() eq 'Recharge'}">
                                        <td style="color: green">+ ${h.getAmount()} VNÐ</td>
                                    </c:if>
                                    <c:if test="${h.getStype() eq 'Payment'}">
                                        <td style="color: red">- ${h.getAmount()} VNÐ</td>
                                    </c:if>
                                    <td>${h.getDatePay()}</td>
                                    <td>${h.getContent()}</td>
                                    <c:if test="${h.getStype() eq 'Deposit'}">
                                        <td style="color: green">${h.getStype()}</td>
                                    </c:if>
                                    <c:if test="${h.getStype() eq 'Payment'}">
                                        <td style="color: red">${h.getStype()}</td>
                                    </c:if>
                                    <c:if test="${h.getStype() eq 'Recharge'}">
                                        <td style="color: blue">${h.getStype()}</td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <script>
            function submitCombinedForm() {
                document.getElementById('combinedFilterForm').submit();
            }
            function changeStatus(selectElement) {
                var requestId = selectElement.id.split('-')[1]; // Extracting the request ID
                var selectedValue = selectElement.value; // Getting the selected value

                // Call the controller using AJAX
                // Example using jQuery AJAX
                $.get("changestatus", {requestId: requestId, status: selectedValue}, function (response) {
                    // Handle response if needed
                });
            }
            function confirmReject() {
                var result = confirm("Do you want to reject?");
                if (result) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>

    </div>
    <script>
        // Lưu vị trí cuộn khi trang bắt đầu tải lại
        window.onbeforeunload = function () {
            localStorage.setItem('scrollPosition', window.scrollY);
        };

        // Khi trang đã tải xong, cuộn đến vị trí đã lưu
        window.onload = function () {
            if (localStorage.getItem('scrollPosition')) {
                window.scrollTo(0, localStorage.getItem('scrollPosition'));
                localStorage.removeItem('scrollPosition');
            }
        }
        ;
    </script>

    <script>
        function myFunction(index) {
            var popup = document.getElementById("myPopup" + index);
            popup.classList.toggle("show");
        }
    </script>
    <script>
        // Function to toggle schedule details popup
        function toggleSchedule(mentorId) {
            var popup = document.getElementById('scheduleDetails-' + mentorId);
            if (popup.style.display === 'none' || popup.style.display === '') {
                popup.style.display = 'block';
            } else {
                popup.style.display = 'none';
            }
        }

        // Function to close schedule details popup
        function closeSchedule() {
            var popups = document.querySelectorAll('.details');
            popups.forEach(function (popup) {
                popup.style.display = 'none';
            });
        }

        // Optional: Function to confirm reject action
        function confirmReject() {
            return confirm('Are you sure you want to reject this schedule?');
        }
    </script>







</script>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/resume.min.js"></script>

</body>

</html>