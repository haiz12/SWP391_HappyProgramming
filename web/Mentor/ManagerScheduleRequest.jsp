<%-- 
    Document   : newjsp
    Created on : Jan 14, 2024, 5:50:31 PM
    Author     : phatvv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name ="viewport" content="width = device-width, initial-scale = 1" >
        <title>Happy Programming</title>
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
              rel="stylesheet" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
              crossorigin="anonymous" />
        <!--        <link rel="stylesheet"  type="text/css" href="../css/style_2.css"/>-->
        <link rel="shortcut icon" href="./favicon.ico">
<!--        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_2.css"/>-->
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            body {
                background: linear-gradient(to bottom right, #50a3a2 0%, #2eca7f 100%);
                padding: 0;
                margin: 0;
                border: none;
                font-family: 'Poppins';
                font-size: 14px;
                color: #626262;
                letter-spacing: 0em;
                font-weight: 400;
                -webkit-font-smoothing: antialiased;
            }

            a {
                text-decoration: none;
                color: #171717;
            }

            .background.gradient {
                background: #50a3a2;
                background: -webkit-linear-gradient(left, #3931af, #00c6ff);
                position: fixed;
                overflow: hidden;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
            }

            input, textarea, button {
                margin: 0;
                padding: 0;
                display: block;
                font-family: 'Poppins';
                font-size: 13px;
                width: 100%;
                color: #171717;
                background: none;
                border: none;
                border-bottom: 1px solid #d8dbe2;
                appearance: none;
                resize: none;
                outline: 0;
                transition: all 0.3s ease 0s;
                border-radius: 0px;
            }

            input:focus, textarea:focus, button:focus {
                color: #171717;
                border-bottom: 1px solid #2eca7f;
            }

            .title {
                text-align: left;
                margin: 0 0 15px 20px;
                padding: 0 0 5px 0;
                position: relative;
                font-size: 17px;
                color: #171717;
                line-height: 21px;
                font-weight: 500;
            }

            .title::before {
                content: '';
                position: absolute;
                left: -12px;
                top: 0;
                width: 30px;
                height: 30px;
                background: linear-gradient(135deg, rgba(46, 202, 127, 0.4) 0%, rgba(46, 202, 127, 0.01) 100%);
                z-index: -1;
                border-radius: 30px;
            }

            .title::after {
                content: '';
                position: absolute;
                left: -40px;
                bottom: -15px;
                width: 95%;
                height: 1px;
                background: radial-gradient(ellipse at left, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
            }

            .line-left {
                position: relative;
            }

            .line-left::before {
                content: '';
                position: absolute;
                left: 0;
                top: 0;
                width: 1px;
                height: 100%;
                background: radial-gradient(ellipse at top, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
            }

            .line-down {
                position: relative;
            }

            .line-down::after {
                content: '';
                position: absolute;
                left: 0;
                bottom: 0;
                width: 100%;
                height: 1px;
                background: radial-gradient(ellipse at left, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
            }

            header {
                background-color: white;
                border-radius: 0 0 5px 5px;
                width: 100%;
                max-width: 540px;
                box-shadow: 0 0 25px rgba(0, 0, 0, 0.05);
                position: fixed;
                top: 0;
                z-index: 100;
            }

            header nav {
                display: flex;
                justify-content: space-between;
                align-items: center;
                width: 100%;
            }

            header nav a {
                width: 100%;
                height: 72px;
                text-align: center;
                position: relative;
                display: flex;
                flex-direction: column;
                justify-content: center;
                transition: color 0.3s ease 0s;
                font-size: 20px;
            }

            header nav a::before {
                content: '';
                position: absolute;
                left: 0;
                bottom: 0;
                width: 1px;
                height: 100%;
                background: radial-gradient(ellipse at top, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
            }

            header nav a .link {
                font-size: 11px;
                font-weight: 500;
                text-transform: uppercase;
                margin-top: 4px;
            }

            header nav a:hover {
                color: #2eca7f;
            }

            main {
                margin-top: 88px;
            }

            main .profile, main .about, main .resume, main .works, main .blog, main .schedule, main .paid {
                box-sizing: border-box;
                position: relative;
                background: #ffffff;
                text-align: center;
                z-index: 10;
                border-radius: 4px;
                max-width: 100%; /* Adjusted to 100% */
                width: 70%; /* Added */
                margin: 0 auto;
            }

            main .about, main .resume, main .works, main .blog, main .schedule, main .paid {
                padding: 30px 20px 30px 20px;
                margin-top: 15px;
            }

            main .profile {
                margin-top: 18px;
                overflow: hidden;
            }

            .profile-background {
                height: 300px;
            }

            .profile-image {
                position: relative;
                height: 84px;
            }

            .profile-image img {
                position: relative;
                top: -82px;
                border-radius: 50%;
                border: 3px solid white;
                width: 134px;
            }

            .profile-image::before {
                content: '';
                position: absolute;
                top: -69px;
                left: calc(50% - 78px);
                width: 134px;
                height: 134px;
                background: linear-gradient(135deg, rgba(46, 202, 127, 0.4) 0%, rgba(46, 202, 127, 0.01) 100%);
                border-radius: 100%;
            }

            .profile-name {
                font-size: 32px;
                color: #171717;
                line-height: 32px;
                font-weight: 400;
                margin: 0 auto 0 auto;
            }

            .profile-profession {
                font-size: 14px;
                color: #2eca7f;
                line-height: 14px;
                font-weight: 400;
            }

            .profile-social a {
                transition: color 0.3s ease 0s;
                margin: 0 6px;
                font-size: 16px;
            }

            .profile-social a:hover {
                text-decoration: none;
                color: #2eca7f;
            }

            .profile-buttons {
                position: relative;
                display: flex;
                margin-top: 58px;
            }

            .profile-buttons::before {
                content: '';
                position: absolute;
                left: 0;
                top: 0;
                width: 100%;
                height: 1px;
                background: radial-gradient(ellipse at left, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
            }

            .profile-buttons a {
                position: relative;
                width: 50%;
                height: 70px;
                display: flex;
                align-items: center;
                justify-content: center;
                transition: color 0.3s ease;
                line-height: 70px;
                font-size: 12px;
                font-weight: 500;
                color: #171717;
            }

            .profile-buttons a:hover {
                color: #2eca7f;
            }

            .profile-buttons a:first-child::before, .profile-buttons a:first-child::after {
                content: '';
                position: absolute;
                right: 0;
                top: 0;
                width: 1px;
                height: 100%;
                background: radial-gradient(ellipse at top, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
            }

            .profile-buttons a i {
                margin-left: 10px;
                font-size: 15px;
            }

            .about-aboutMe > div {
                padding: 5px 17px;
                position: relative;
            }

            .about-aboutMe > div > div {
                display: flex;
                flex-wrap: wrap;
            }

            .about-aboutMe > div > div > div {
                width: 50%;
                text-align: left;
            }

            .about-aboutMe > div > div > div span {
                font-weight: 500;
                font-size: 13px;
            }

            .about-aboutMe p {
                text-align: left;
            }

            .about-services {
                margin-top: 50px;
            }

            .about-services > div {
                display: flex;
                flex-wrap: wrap;
                position: relative;
            }

            .about-services > div::after {
                content: '';
                position: absolute;
                left: 50%;
                top: 0;
                width: 1px;
                height: 100%;
                background: radial-gradient(ellipse at top, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
            }

            .about-services article {
                position: relative;
                width: 50%;
                text-align: left;
                padding: 15px 20px;
                box-sizing: border-box;
            }

            .about-services article .fas {
                margin: 0;
                width: 60px;
                height: 60px;
                text-align: center;
                font-size: 32px;
                color: #2eca7f;
                background: linear-gradient(135deg, rgba(46, 202, 127, 0.4) 0%, rgba(46, 202, 127, 0.01) 100%);
                border-radius: 60px;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            .about-services article h4 {
                font-size: 13px;
                color: #171717;
                font-weight: 500;
                text-transform: uppercase;
            }

            .about-services article p {
                font-size: 14px;
                line-height: 1.6;
                padding: 0;
            }

            .resume-lines {
                display: flex;
            }

            .resume-line h4 {
                margin: 0;
                text-align: left;
                padding: 20px 18px;
                font-size: 13px;
                line-height: 13px;
                color: #171717;
                font-weight: 500;
                text-transform: uppercase;
            }

            .resume-line h4 .fas {
                position: relative;
                float: left;
                top: -7px;
                width: 40px;
                height: 40px;
                font-size: 26px;
                color: #2eca7f;
            }

            .resume-line {
                flex: 1;
                text-align: left;
            }

            .resume-line article {
                padding: 15px 15px;
            }

            .resume-line .date {
                margin: 0 0 10px 0;
                padding: 0;
                position: relative;
                display: inline-block;
                font-size: 11px;
                line-height: 18px;
                color: #d8dbe2;
                font-weight: 500;
                text-transform: uppercase;
                border-radius: 4px;
            }

            .resume-line .date::before {
                content: '';
                position: absolute;
                left: -19px;
                top: 4px;
                width: 9px;
                height: 9px;
                background: #d8dbe2;
                border-radius: 9px;
            }

            .resume-line .date.active {
                color: #2eca7f;
            }

            .resume-line .date.active::before {
                background: #2eca7f;
            }

            .resume-line .name {
                margin: 0;
                font-size: 13px;
                color: #171717;
                font-weight: 500;
                text-transform: uppercase;
            }

            .resume-line .company {
                margin: 0 0 10px 0;
                font-size: 11px;
                color: #999999;
                font-weight: 300;
                text-transform: uppercase;
            }

            .resume-skills {
                margin-top: 50px;
            }

            .resume-skills > div {
                display: flex;
            }

            .resume-skills > div section {
                flex: 1;
                text-align: left;
            }

            .resume-skills > div section > div {
                padding: 18px 20px;
            }

            .resume-skills > div section > div > div:first-child {
                margin: 0 0 8px 0;
                font-size: 14px;
                line-height: 14px;
                color: #626262;
                text-align: left;
            }

            .resume-skills > div section > div > div:last-child {
                width: 100%;
                background: #d8dbe2;
                height: 4px;
            }

            .resume-skills > div section > div > div > div {
                background: #2eca7f;
                height: 4px;
            }

            .resume-skills h4 {
                margin: 0;
                text-align: left;
                padding: 20px 18px;
                font-size: 13px;
                line-height: 13px;
                color: #171717;
                font-weight: 500;
                text-transform: uppercase;
            }

            .resume-skills h4 .fas {
                position: relative;
                float: left;
                top: -7px;
                width: 40px;
                height: 40px;
                font-size: 26px;
                color: #2eca7f;
            }

            main .schedule {
                margin-bottom: 40px;
            }

            .contact-information {
                display: flex;
                flex-wrap: wrap;
                padding: 11px 18px;
            }

            .contact-information > div {
                width: 50%;
                text-align: left;
            }

            .contact-information > div span {
                font-weight: 500;
                font-size: 13px;
            }

            @media only screen and (min-width: 540px) {
                header {
                    left: calc(50% - 270px);
                }
            }

            @media only screen and (min-width: 1040px) {
                .selected {
                    color: #2eca7f;
                }
                .page {
                    position: absolute;
                    top: 0;
                    bottom: 0;
                    left: 0;
                    right: 0;
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    background: -webkit-linear-gradient(left, #3931af, #00c6ff);
                }
                header {
                    max-width: 80px;
                    position: relative;
                    border-radius: 5px;
                    left: -6px;
                }
                header nav {
                    display: flex;
                    flex-direction: column;
                }
                header nav a::before {
                    content: '';
                    position: absolute;
                    left: 0;
                    bottom: 0;
                    width: 100%;
                    height: 1px;
                    background: radial-gradient(ellipse at left, rgba(197, 202, 213, 0.7) 0%, rgba(255, 255, 255, 0) 70%);
                }

                main {
                    display: flex;
                    margin: 0;
                    width: 1020px;
                }

                main .about, main .resume, main .schedule, main .paid {
                    width: 0;
                    height: 0;
                    opacity: 0;
                    overflow: hidden;
                    position: relative;
                    top: 16px;
                    transform: translateX(-450px);
                    transition: opacity 1s ease, transform 1s ease;
                    z-index: 0;
                    margin: 0;
                    padding: 0;
                }

                main .profile {
                    width: 480px;
                    height: 600px;
                    box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.05);
                    margin: 0;
                }

                main .view {
                    height: 574px;
                    width: 100%; /* Changed to 70% */
                    padding: 30px 20px 30px 20px;
                    opacity: 1;
                    transform: translateX(-8px);
                }

                main .view::-webkit-scrollbar {
                    width: 5px;
                }

                main .view::-webkit-scrollbar-track {
                    background: #ddd;
                }

                main .view::-webkit-scrollbar-thumb {
                    background: #666;
                }

                main .schedule {
                    margin-bottom: 0;
                }
            }
            .page {
                top: 0;
                bottom: 0;
                left: 0;
                right: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                background: -webkit-linear-gradient(left, #3931af, #00c6ff);
                width: 100%;
            }
            .profile-background {
                height: 200px;
            }
            .profile-name {
                margin-top: 20px;
                margin-bottom: 30px;
            }
            .profile-profession {
                margin-top: 30px;
                margin-bottom: 30px;
                font-size: larger;
            }
            .profile-image img {
                width: 40%;
                height: 200%;
            }
            section {
                position: relative;
                width: 100%;
                height: 300px;
            }
            .gradient-button {
                bottom: 0;
                right: 0;
                margin: 10px;
            }
            .gradient-button a {
                display: inline-block;
                padding: 10px 20px;
                background: linear-gradient(to right, #00C4FE, #3145BA);
                text-decoration: none;
                border-radius: 5px;
            }
            .about-aboutMe p {
                font-weight: bold;
                white-space: pre-line;
            }
            .line-down p {
                font-weight: bold;
                white-space: pre-line;
            }
            .row {
                display: flex;
                justify-content: space-around;
            }
            .column {
                width: 45%;
            }
            .left {
                text-align: right;
            }
            .right {
                text-align: left;
            }
            .about-aboutMe, .about-services, .resume-lines, .resume-skills {
                margin-bottom: 20px;
            }
            .line-down {
                margin-top: 10px;
                margin-bottom: 10px;
            }
            .view {
                width: 70%;
                margin: 0 auto;
            }
            .pagination-container {
                position: fixed;
                bottom: 20px;
                left: 50%;
                transform: translateX(-50%);
                background-color: white;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <div class="page">
            <header>
                <nav>
                    <a href="#about" class="selected" id='getAbout'>
                        <span class="fas fa-spinner"></span>
                        <span class="link">Processing</span>
                    </a>
                    <a href="#resume" id='getResume'>
                        <span class="fas fa-check"></span>
                        <span class="link">Accept</span>
                    </a>
                    <a href="#schedule" id="getSchedule">
                        <span class="fa fa-times"></span>
                        <span class="link">Reject</span>
                    </a>
                    <a href="#paid" id="getPaid">
                        <span class="fa fa-bank"></span>
                        <span class="link">Paid</span>
                    </a>   
                    <a href="home">
                        <span class="fa fa-home"></span>
                        <span class="link">Home</span>
                    </a>
                </nav>
            </header>
            <main>
                <%
                    String pageRP = request.getParameter("pageRP");
                %>
                <c:set var="pageRP" value="<%= (pageRP != null) ? pageRP : '1' %>" />
                <section id="about" class="about view">
                    <h3 class="title">Processing</h3>
                    <table id="myTable" class="table table-striped">
                        <thead>
                            <tr>
                                <th>Mentee</th>
                                <th>Skill</th>
                                <th>Title</th>
                                <th>Content</th>
                                <th>Status</th>
                                <th>StartWeek</th>
                                <th>EndWeek</th>
                                <th>Year</th>
                                <th>Day-Slot</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="pageRP" value="${requestScope.pageRP}"/>
                            <c:forEach items="${requestScope.dataRP}" var="s" varStatus="loop">
                                <tr>
                                    <td>${s.mentee.fullname}</td>
                                    <td>${s.skill}</td>
                                    <td>${s.title}</td>
                                    <td>${s.content}</td>
                                    <td>Processing</td>
                                    <td style="font-size: 10px" class="start-week" data-week="${s.startWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td style="font-size: 10px" class="end-week" data-week="${s.endWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td>${s.timeSchedule.year}</td>
                                    <td>${s.timeSchedule.day}-${s.timeSchedule.timeSlot.time}</td>
                                    <c:if test="${loop.index == 0 || !s.mentee.fullname.equals(requestScope.dataRP[loop.index-1].mentee.fullname) ||
                                                  !s.title.equals(requestScope.dataRP[loop.index-1].title) ||
                                                  !s.content.equals(requestScope.dataRP[loop.index-1].content) ||
                                                  s.startWeek != requestScope.dataRP[loop.index-1].startWeek ||
                                                  s.endWeek != requestScope.dataRP[loop.index-1].endWeek ||
                                                  s.timeSchedule.year != requestScope.dataRP[loop.index-1].timeSchedule.year }">
                                          <td>
                                              <form action="reqmentor" method="post">
                                                  <input type="hidden" name="idRequest" value="${s.idRequest}"/>
                                                  <input type="hidden" name="statusId" value="2"/>
                                                  <button type="submit">Accept</button>
                                              </form>
                                          </td>
                                          <td>
                                              <form action="reqmentor" method="post" onsubmit="return validateRejectForm(this);">
                                                  <input type="hidden" name="idRequest" value="${s.idRequest}"/>
                                                  <input type="hidden" name="statusId" value="3"/>
                                                  <button type="button" onclick="showRejectReason(this);">Reject</button>
                                                  <div class="reject-reason" style="display: none;">
                                                      <input type="text" name="reasonReject" placeholder="Enter rejection reason"/>
                                                      <button type="submit">Submit Rejection</button>
                                                  </div>
                                              </form>
                                          </td> 
                                    </c:if>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <script>
                        function showRejectReason(button) {
                            var form = button.closest('form');
                            var reasonDiv = form.querySelector('.reject-reason');
                            reasonDiv.style.display = 'block';
                            button.style.display = 'none';
                        }

                        function validateRejectForm(form) {
                            var reasonInput = form.querySelector('input[name="reasonReject"]');
                            if (!reasonInput.value.trim()) {
                                alert("Please enter a rejection reason.");
                                return false;
                            }
                            return true;
                        }
                    </script>
                    <div class="pagination-container">
                        <div style="display: flex; justify-content: center; align-items: center;">
                            <c:forEach begin="${1}" end="${requestScope.numRP}" var="i">
                                <p class="dispage" style="background-color: #000;  width: 20px; height: 30px; display: block; margin-right: 5px; cursor: pointer; clear: both"><a class="${i==pageRP?'active':''}" style="color: white; padding-left: 0px; justify-content: center;align-items: center;" href="reqmentor?pageRP=${i}">${i}</a></p>                                
                                </c:forEach>
                        </div>
                    </div>
                </section>
                <section id="resume" class="resume">
                    <h3 class="title">Accept</h3>
                    <table id="myTable" class="table table-striped">
                        <thead>
                            <tr>
                                <th>Mentee</th>
                                <th>Skill</th>
                                <th>Title</th>
                                <th>Content</th>
                                <th>Status</th>
                                <th>StartWeek</th>
                                <th>EndWeek</th>
                                <th>Year</th>
                                <th>Day-Slot</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="pageRA" value="${requestScope.pageRA}"/>
                            <c:forEach items="${requestScope.dataRA}" var="s" varStatus="loop">
                                <tr>
                                    <td>${s.mentee.fullname}</td>
                                    <td>${s.skill}</td>
                                    <td>${s.title}</td>
                                    <td>${s.content}</td>
                                    <td>Accept</td>
                                    <td style="font-size: 10px" class="start-week" data-week="${s.startWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td style="font-size: 10px" class="end-week" data-week="${s.endWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td>${s.timeSchedule.year}</td>
                                    <td>${s.timeSchedule.day}-${s.timeSchedule.timeSlot.time}</td>
                                    <c:if test="${loop.index == 0 || !s.mentee.fullname.equals(requestScope.dataRA[loop.index-1].mentee.fullname) ||
                                                  !s.title.equals(requestScope.dataRA[loop.index-1].title) ||
                                                  !s.content.equals(requestScope.dataRA[loop.index-1].content) ||
                                                  s.startWeek != requestScope.dataRA[loop.index-1].startWeek ||
                                                  s.endWeek != requestScope.dataRA[loop.index-1].endWeek ||
                                                  s.timeSchedule.year != requestScope.dataRA[loop.index-1].timeSchedule.year }">
                                          <td>
                                          <td>
                                              <form id="confirmForm-${s.idRequest}" action="reqmentor" method="post" onsubmit="return confirmCompletion(this);">
                                                  <input type="hidden" name="idRequest" value="${s.idRequest}"/>
                                                  <input type="hidden" name="statusId" value="11"/>
                                                  <button type="submit">Done</button>
                                              </form>
                                          </td> 
                                <script>
                                    function confirmCompletion(form) {
                                        var confirmed = confirm("Are you sure you have completed the course?");
                                        return confirmed;
                                    }
                                </script>
                            </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="pagination-container">
                        <div style="display: flex; justify-content: center; align-items: center;">
                            <c:forEach begin="${1}" end="${requestScope.numRA}" var="i">
                                <p class="dispage" style="background-color: #000;  width: 20px; height: 30px; display: block; margin-right: 5px; cursor: pointer; clear: both"><a class="${i==pageRA?'active':''}" style="color: white; padding-left: 0px; justify-content: center;align-items: center;" href="reqmentor?pageRA=${i}">${i}</a></p>                                
                                </c:forEach>
                        </div>
                    </div>
                </section>
                <section id="schedule" class="schedule">
                    <h3 class="title">Reject</h3>
                    <table id="myTable" class="table table-striped">
                        <thead>
                            <tr>
                                <th>Mentee</th>
                                <th>Skill</th>
                                <th>Title</th>
                                <th>Content</th>
                                <th>Status</th>
                                <th>ReasonReject</th>
                                <th>StartWeek</th>
                                <th>EndWeek</th>
                                <th>Year</th>
                                <th>Day-Slot</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="pageRR" value="${requestScope.pageRR}"/>
                            <c:forEach items="${requestScope.dataRR}" var="s" varStatus="loop">
                                <tr>
                                    <td>${s.mentee.fullname}</td>
                                    <td>${s.skill}</td>
                                    <td>${s.title}</td>
                                    <td>${s.content}</td>
                                    <td>Reject</td>
                                    <td>${s.reasonReject}</td>
                                    <td style="font-size: 10px" class="start-week" data-week="${s.startWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td style="font-size: 10px" class="end-week" data-week="${s.endWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td>${s.timeSchedule.year}</td>
                                    <td>${s.timeSchedule.day}-${s.timeSchedule.timeSlot.time}</td>
                                </tr>
                            </c:forEach>
                            <c:if test="${requestScope.messHandle != null}">
                            <td>${requestScope.messHandle}</td>
                        </c:if>
                        </tbody>
                    </table>
                    <div class="pagination-container">
                        <div style="display: flex; justify-content: center; align-items: center;">
                            <c:forEach begin="${1}" end="${requestScope.numRR}" var="i">
                                <p class="dispage" style="background-color: #000;  width: 20px; height: 30px; display: block; margin-right: 5px; cursor: pointer; clear: both"><a class="${i==pageRR?'active':''}" style="color: white; padding-left: 0px; justify-content: center;align-items: center;" href="reqmentor?pageRR=${i}">${i}</a></p>                                
                                </c:forEach>
                        </div>
                    </div>
                </section>
                <section id="paid" class="paid">
                    <h3 class="title">Paid</h3>
                    <table id="myTable" class="table table-striped">
                        <thead>
                            <tr>
                                <th>Mentor</th>
                                <th>Skill</th>
                                <th>Title</th>
                                <th>Content</th>
                                <th>Status</th>
                                <th>StartWeek</th>
                                <th>EndWeek</th>
                                <th>Year</th>
                                <th>Day-Slot</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:set var="pageRPa" value="${requestScope.pageRPa}"/>
                            <c:forEach items="${requestScope.dataRPa}" var="s" varStatus="loop">
                                <tr>
                                    <td>${s.mentee.fullname}</td>
                                    <td>${s.skill}</td>
                                    <td>${s.title}</td>
                                    <td>${s.content}</td>
                                    <td>Paid</td>
                                    <td style="font-size: 10px" class="start-week" data-week="${s.startWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td style="font-size: 10px" class="end-week" data-week="${s.endWeek}" data-year="${s.timeSchedule.year}"></td>
                                    <td>${s.timeSchedule.year}</td>
                                    <td>${s.timeSchedule.day}-${s.timeSchedule.timeSlot.time}</td>
                                </tr>
                            </c:forEach>
                            <c:if test="${requestScope.messHandle != null}">
                            <td>${requestScope.messHandle}</td>
                        </c:if>
                        </tbody>
                    </table>
                    <div class="pagination-container">
                        <div style="display: flex; justify-content: center; align-items: center;">
                            <c:forEach begin="${1}" end="${requestScope.numRPa}" var="i">
                                <p class="dispage" style="background-color: #000;  width: 20px; height: 30px; display: block; margin-right: 5px; cursor: pointer; clear: both"><a class="${i==pageRPa?'active':''}" style="color: white; padding-left: 0px; justify-content: center;align-items: center;" href="reqmentor?pageRPa=${i}">${i}</a></p>                                
                                </c:forEach>
                        </div>
                    </div>
                </section>
            </main>
        </div>
    </body>
    <script>
        let getAbout = document.getElementById("getAbout");
        let getResume = document.getElementById("getResume");
        let getSchedule = document.getElementById("getSchedule");
        let getPaid = document.getElementById("getPaid");

        // Sections
        let about = document.getElementById("about");
        let resume = document.getElementById("resume");
        let schedule = document.getElementById("schedule");
        let paid = document.getElementById("paid");

        function removeClass() {
            // Links
            getAbout.classList.remove('selected');
            if (getResume)
                getResume.classList.remove('selected');
            if (getSchedule)
                getSchedule.classList.remove('selected');
            if (getPaid)
                getPaid.classList.remove('selected');
            // Sections
            about.classList.remove('view');
            if (resume)
                resume.classList.remove('view');
            if (schedule)
                schedule.classList.remove('view');
            if (paid)
                paid.classList.remove('view');
        }

        getAbout.addEventListener('click', function (e) {
            if (window.innerWidth > 1040) {
                e.preventDefault();
                removeClass();
                about.classList.add('view');
                getAbout.classList.add('selected');
            }
        });

        if (getResume) {
            getResume.addEventListener('click', function (e) {
                if (window.innerWidth > 1040) {
                    e.preventDefault();
                    removeClass();
                    resume.classList.add('view');
                    getResume.classList.add('selected');
                }
            });
        }
        if (getSchedule) {
            getSchedule.addEventListener('click', function (e) {
                if (window.innerWidth > 1040) {
                    e.preventDefault();
                    removeClass();
                    schedule.classList.add('view');
                    getSchedule.classList.add('selected');
                }
            });
        }
        if (getPaid) {
            getPaid.addEventListener('click', function (e) {
                if (window.innerWidth > 1040) {
                    e.preventDefault();
                    removeClass();
                    paid.classList.add('view');
                    getPaid.classList.add('selected');
                }
            });
        }

        function getWeekDates(year, week) {
            let date = new Date(year, 0, 1 + (week - 1) * 7);
            let startDate = new Date(date.setDate(date.getDate() - date.getDay() + 1));
            let endDate = new Date(date.setDate(date.getDate() + 6));
            return startDate.toISOString().slice(0, 10) + "<br>To<br>" + endDate.toISOString().slice(0, 10);
        }

        function updateWeekDisplay() {
            document.querySelectorAll('.start-week').forEach(function (element) {
                let week = element.getAttribute('data-week');
                let year = element.getAttribute('data-year');
                element.innerHTML = getWeekDates(year, week);
            });
            document.querySelectorAll('.end-week').forEach(function (element) {
                let week = element.getAttribute('data-week');
                let year = element.getAttribute('data-year');
                element.innerHTML = getWeekDates(year, week);
            });
        }

        document.addEventListener("DOMContentLoaded", function () {
            updateWeekDisplay();
        });
    </script>

</html>




