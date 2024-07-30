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
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_2.css"/>
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
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
                width: 100%; /* hoặc bất kỳ chiều rộng nào bạn muốn */
                height: 300px; /* hoặc bất kỳ chiều cao nào bạn muốn */
            }

            .gradient-button {
                position: absolute;
                bottom: 0;
                right: 0;
                margin: 10px; /* tạo khoảng cách giữa nút và cạnh phải, dưới cùng của section */
            }

            .gradient-button a {
                display: inline-block;
                padding: 10px 20px;
                background: linear-gradient(to right, #00C4FE, #3145BA);
                text-decoration: none;
                border-radius: 5px;
            }
            .about-aboutMe p{
                font-weight: bold;
                white-space: pre-line;

            }
            .line-down p{
                font-weight: bold;
                white-space: pre-line;
            }
            .row {
                display: flex;
                justify-content: space-around;
            }
            .column {
                width: 45%; /* Adjust as needed */
            }
            .left {
                text-align: right;
            }
            .right {
                text-align: left;
            }
            .about-aboutMe, .about-services, .resume-lines, .resume-skills {
                margin-bottom: 20px; /* Adjust as needed */
            }
            .line-down {
                margin-top: 10px; /* Adjust as needed */
                margin-bottom: 10px; /* Adjust as needed */
            }
            
            

        </style>


    </head>
    <body>

        <div class="background gradient">

        </div>
        <div class="page">
            <header>
                <nav>
                    <a href="#about" class="selected" id='getAbout'>
                        <span class="fas fa-user"></span>
                        <span class="link">About</span>
                    </a>
                    <a href="#resume" id='getResume'>
                        <span class="fas fa-file"></span>
                        <span class="link">Rating</span>
                    </a>
                    <a href="#schedule" id="getSchedule">
                        <span class="fa fa-calendar"></span>
                        <span class="link">Request</span>
                    </a>                
                    <c:if test="${update eq 'accept'}">
                        <a href="createcv?idMentor=${cx.getId()}">
                            <span class="fa-solid fa-pen-nib"></span>
                            <span class="link">Update</span>
                        </a>
                    </c:if>
                    <a href="home">
                        <span class="fa fa-home"></span>
                        <span class="link">Home</span>
                    </a>
                </nav>
            </header>
            <main>
                <section id="presentation" class="profile">
                    <div class="profile-background"></div>
                    <div>
                        <div class="profile-image">
                            <img src="${cv.getAvatar()}" alt="">
                        </div>
                        <h1 class="profile-name" id="nombre"> ${cv.fullname}</h1>
                        <h2 class="profile-profession"> ${cv.profession}</h2> 
                        <div class="row">
                            <div class="column left">Sex :</div>
                            <div class="column right">${cv.sex}</div>
                        </div>
                        <div class="row">
                            <div class="column left">ADDRESS :</div>
                            <div class="column right">${cv.address}</div>
                        </div>
                        <div class="row">
                            <div class="column left">Pay/1h :</div>
                            <div class="column right">${cv.cost}VNĐ</div>
                        </div>
                        <div class="row">
                            <div class="column left">EMAIL :</div>
                            <div class="column right">${cx.email}</div>
                        </div>
                        <div class="row">
                            <div class="column left">PHONE :</div>
                            <div class="column right">${cv.phone}</div>
                        </div>
                        <c:if test="${account ne null && account.role.equals('Mentee')}">
                            <div class="gradient-button">
                                <a  href="menteeRequest?idMentor=${cv.getIdMentor()}">Create Request</a>
                            </div>
                        </c:if>
                </section>
                <section id="about" class="about view">
                    <article class="about-aboutMe">
                        <h3 class="title">About Me</h3>
                        <div class="line-left">
                            <p>${cv.pro_introduc}</p>                           
                        </div>
                    </article>
                    <article class="about-services">


                        <div class="line-left">
                            <article class="line-down">
                                <div class="fas fa-code"></div>
                                <h4>My services</h4>
                                <p>${cv.myservice}</p>
                            </article>
                            <article class="line-down">
                                <div class="fas fa-code"></div>
                                <h4>Achivements</h4>
                                <p>${cv.archivement_sescition}</p>
                            </article>
                        </div>   

                    </article>
                    <article class="resume-lines">
                        <section class="resume-line line-left">
                            <h4 class="line-down"> <i class="fas fa-briefcase"></i> Experience</h4>
                            <article class="line-down">
                                <p>${cv.experience}</p>
                            </article>
                        </section>
                        <section class="resume-line line-left">
                            <h4 class="line-down"> <i class="fas fa-university"></i> Education</h4>
                            <article class="line-down">
                                <p>${cv.education}</p>
                            </article>
                        </section>
                    </article>
                    <article class="resume-skills">
                        <h3 class="title">My Skills</h3>
                        <div>
                            <section class="line-left">
                                <h4 class="line-down"> <i class="fas fa-tv"></i> Skills</h4>
                                <c:forEach var="e" items="${cf}">
                                    <div>${e.getSkillname()}</div>
                                </c:forEach>
                            </section>
                            <section class="line-left">
                                <h4 class="line-down"><i class="fas fa-code"></i> FRAMEWORK</h4>
                                <article class="line-down">
                                    <p>${cv.framework}</p>
                                </article>
                            </section>
                        </div>
                    </article>

                </section>
                <section id="resume" class="resume">
                    <h3 class="title">Rating</h3>
                    <article class="resume-lines">
                        <section class="resume-line line-left">

                            <c:choose>
                                <c:when test="${empty rates}">
                                    <div style="font-size: 20px; text-align: center; color: red;">${message}</div>
                                </c:when>
                                <c:otherwise>
                                    <table style="table-layout: fixed; width: 100%;" >
                                        <tr style="padding: 20px; ">

                                            <th>Star</th>
                                            <th>Comment</th>
                                        </tr>
                                        <c:forEach var="rate" items="${rates}">
                                            <tr>

                                                <td style="padding: 10px;">${rate.star} <i class="fa fa-star" style="color: yellow;"></i></td>
                                                <td>${rate.comment}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </c:otherwise>
                            </c:choose>
                        </section>

                    </article>



                </section>

                <section id="schedule" class="schedule">
                    <h3 class="title">Schedule</h3>
                    <div class="center">
                        <label for="yearSelect">YEAR</label>
                        <select name="year" id="yearSelect"></select>

                        <label for="startWeekSelect">START WEEK</label>
                        <select name="startWeek" id="startWeekSelect"></select>

                        <label for="endWeekSelect">END WEEK</label>
                        <select name="endWeek" id="endWeekSelect"></select>
                    </div>
                    <table id="myTable" class="table table-striped">
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
                                    <td><input type="checkbox" name="schedule" value="mon-${timeSlot.time_slot_id}" data-day="mon" data-slot="${timeSlot.time}"></td>
                                    <td><input type="checkbox" name="schedule" value="tue-${timeSlot.time_slot_id}" data-day="tue" data-slot="${timeSlot.time}"></td>
                                    <td><input type="checkbox" name="schedule" value="wed-${timeSlot.time_slot_id}" data-day="wed" data-slot="${timeSlot.time}"></td>
                                    <td><input type="checkbox" name="schedule" value="thu-${timeSlot.time_slot_id}" data-day="thu" data-slot="${timeSlot.time}"></td>
                                    <td><input type="checkbox" name="schedule" value="fri-${timeSlot.time_slot_id}" data-day="fri" data-slot="${timeSlot.time}"></td>
                                    <td><input type="checkbox" name="schedule" value="sat-${timeSlot.time_slot_id}" data-day="sat" data-slot="${timeSlot.time}"></td>
                                    <td><input type="checkbox" name="schedule" value="sun-${timeSlot.time_slot_id}" data-day="sun" data-slot="${timeSlot.time}"></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>

        </div>
    </article>
</section>

</main>
</div>
</body>
<script>// Menu links
    // Menu links
    let getAbout = document.getElementById("getAbout");
    let getResume = document.getElementById("getResume");
    let getSchedule = document.getElementById("getSchedule");

// Sections
    let about = document.getElementById("about");
    let resume = document.getElementById("resume");
    let schedule = document.getElementById("schedule");

    function removeClass() {
// Links
        getAbout.classList.remove('selected');
        if (getResume)
            getResume.classList.remove('selected');
        if (getSchedule)
            getSchedule.classList.remove('selected');
// Sections
        about.classList.remove('view');
        if (resume)
            resume.classList.remove('view');
        if (schedule)
            schedule.classList.remove('view');
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

</script>

</html>
