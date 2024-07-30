<%@ page import="java.util.List" %>
<%@ page import="dal.ViewStatisticRequestDAO" %>
<%@ page import="model.Mentor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        <title>Create Request</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!--
        
        TemplateMo 570 Chain App Dev
        
        https://templatemo.com/tm-570-chain-app-dev
        
        -->

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>

        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
                background-image: url('../assets/images/client-bg.png');
            }

            .main-banner-container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding-bottom: 70px;
                display: flex;
                justify-content: space-between;
                flex-wrap: wrap; /* Ensure wrapping on small screens */
            }

            h2 {
                text-align: center;
                margin-bottom: 30px;
                width: 100%;
            }

            .form-container,
            .schedule-container {
                flex: 1;
                margin: 10px;
            }

            .form-container label {
                font-weight: bold;
            }

            .form-container select,
            .form-container input[type="text"],
            .form-container input[type="date"],
            .form-container textarea {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }

            .form-container textarea {
                height: 100px;
                resize: none;
            }

            .form-container button[type="submit"] {
                display: block;
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 16px;
            }

            .form-container button[type="submit"]:hover {
                background-color: #0056b3;
            }

            .form-container .alert {
                margin-top: 20px;
                padding: 10px 15px;
                border-radius: 5px;
            }

            .form-container .alert-success {
                background-color: #d4edda;
                border-color: #c3e6cb;
                color: #155724;
            }

            .form-container .alert-danger {
                background-color: #f8d7da;
                border-color: #f5c6cb;
                color: #721c24;
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
        </style>
    </head>
    <body>
        <jsp:include page="../header.jsp"></jsp:include>
            <div class="main-banner-container">
                <div class="form-container">
                    <h2>Create Request</h2>
                    <form action="Request?action=create" method="post">
                        <label for="mentor" style="font-size: 20px">Mentor:</label>
                        <span style="font-size: 20px">${mentor.getFullname()}</span>
                    <input type="text" name="idMentor" value="${mentor.idMentor}" style="display: none">
                    <br><br>
                    <div class="form-group">
                        <label style="font-size: 18px">Course: </label>
                        <c:if test="${skillMentor ne null}">
                            <span style="font-size: 18px">${skillMentor.getSkillName()}</span>
                            <input type="text" name="idSkill" value="${skillMentor.getId()}" style="display: none">
                        </c:if>

                        <c:if test="${skillMentor eq null}">
                            <span>
                                <select name="idSkill">
                                    <c:forEach var="s" items="${listHaveSkill}">
                                        <option value="${s.getIdSkill()}">${s.getSkillname()}</option>
                                    </c:forEach>
                                </select>
                            </span>
                        </c:if>
                    </div>
                    <br>
                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" required>

                    <label for="content">Description: </label>
                    <textarea id="content" name="content" required></textarea>
                    <br>
                    <c:if test="${msg != null}">
                        <div class="alert alert-success" role="alert">
                            Create successful!
                        </div>
                    </c:if>
                    <c:if test="${param.fail != null}">
                        <div class="alert alert-danger" role="alert">
                            Create failed. Please try again.
                        </div>
                    </c:if>
                    <br>
                    <div style="display: flex; justify-content: center;">
                        <button type="submit" style="width: 48%; margin-right: 4%;">Create Request</button>
                        <!--                    <a href="home.jsp" class="btn" style="text-align: center;">Back to Homepage</a>-->
                    </div>
                </form>
            </div>
            <div class="schedule-container">
                <h2>Mentor's Schedule</h2>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Year</th>
                            <th>Week</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>2024</td>
                            <td>${time}</td>
                        </tr>
                    </tbody>
                </table>
                <table>
                    <thead>
                        <tr>
                            <th>Slot</th>
                            <th>Mon</th>
                            <th>Tue</th>
                            <th>Wed</th>
                            <th>Thu</th>
                            <th>Fri</th>
                            <th>Sat</th>
                            <th>Sun</th>
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

                                <c:forEach var="list" items="${listSchedule1}">
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

                                <td>
                                    <c:if test="${isCheckedMon}">
                                        <input type="checkbox" name="schedule" value="mon-${timeSlot.time_slot_id}" data-day="mon" data-slot="${timeSlot.time}" checked>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${isCheckedTue}">
                                        <input type="checkbox" name="schedule" value="tue-${timeSlot.time_slot_id}" data-day="tue" data-slot="${timeSlot.time}" checked>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${isCheckedWed}">
                                        <input type="checkbox" name="schedule" value="wed-${timeSlot.time_slot_id}" data-day="wed" data-slot="${timeSlot.time}" checked>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${isCheckedThu}">
                                        <input type="checkbox" name="schedule" value="thu-${timeSlot.time_slot_id}" data-day="thu" data-slot="${timeSlot.time}" checked>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${isCheckedFri}">
                                        <input type="checkbox" name="schedule" value="fri-${timeSlot.time_slot_id}" data-day="fri" data-slot="${timeSlot.time}" checked>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${isCheckedSat}">
                                        <input type="checkbox" name="schedule" value="sat-${timeSlot.time_slot_id}" data-day="sat" data-slot="${timeSlot.time}" checked>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${isCheckedSun}">
                                        <input type="checkbox" name="schedule" value="sun-${timeSlot.time_slot_id}" data-day="sun" data-slot="${timeSlot.time}" checked>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>



                    </tbody>
                </table>
            </div>
        </div>
        <script>
            // Get references to the input fields
            const startDateInput = document.getElementById('startDate');
            const endDateInput = document.getElementById('endDate');

            // Get the current date
            const currentDate = new Date();

            // Format the date as YYYY-MM-DD
            const formattedDate = currentDate.toISOString().split('T')[0];

            // Set the value of the start and end date inputs to the current date
            startDateInput.value = formattedDate;
            endDateInput.value = formattedDate;
        </script>
        <script>
            // Lấy thẻ input và button
            var learnHourInput = document.getElementById("learnHour");
            var totalButton = document.getElementById("totalButton");
            var totalValueInput = document.getElementById("total");
            var totalValueSpan = document.getElementById("totalValue");

            learnHourInput.addEventListener("blur", function (event) {
                var inputValue = event.target.value;

                if (!Number.isInteger(Number(inputValue))) {
                    alert("Please enter an integer.");
                    inputElement.value = "";
                    inputElement.focus(); // Focus lại vào trường input sau khi hiển thị cảnh báo
                }
            });
            // Thêm sự kiện click vào button "Total"
            learnHourInput.addEventListener("input", function () {
                // Lấy giá trị nhập vào từ input
                var learnHourValue = parseFloat(learnHourInput.value);

                // Kiểm tra nếu giá trị nhập vào là một số hợp lệ
                if (!isNaN(learnHourValue)) {
                    // Cập nhật giá trị trong input totalValue
                    totalValueInput.value = learnHourValue *${mentor.getCost()};
                    totalValueSpan.textContent = (learnHourValue *${mentor.getCost()}) + "$";
                } else {
                    // Nếu giá trị không hợp lệ, thông báo cho người dùng
                    alert("Please enter a valid number for Total learn hour.");
                }
            });
        </script>

    </body>
</html>
</html>