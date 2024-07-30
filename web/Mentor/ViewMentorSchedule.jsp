<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <title>Happy Programming</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            h2 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }

            .center {
                display: flex;
                justify-content: space-around;
                margin-bottom: 20px;
            }

            label {
                margin-right: 10px;
                color: #555;
            }

            select {
                padding: 5px;
                border-radius: 5px;
                border: 1px solid #ccc;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            th, td {
                border: 1px solid #ddd;
                padding: 12px;
                text-align: center;
            }

            th {
                background-color: #f4f4f4;
                color: #333;
                font-weight: bold;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tr:hover {
                background-color: #f1f1f1;
            }

            button {
                display: block;
                width: 100px;
                padding: 10px;
                background-color: #00FFFF;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin: 0 auto;
            }

            button:hover {
                background-color: #00cccc;
            }


        </style>
    </head>

    <body>
        <form class="container" action="scheduleRequest?idMentor=${cx.getId()}" method="post">
            <h2>My Schedule</h2>

            <div style="text-align:  center">${time}</div>
            <div style="text-align:  right">Status: ${status}</div>
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

                            <c:set var="isCheckedMon" value="false" />
                            <c:set var="isCheckedTue" value="false" />
                            <c:set var="isCheckedWed" value="false" />
                            <c:set var="isCheckedThu" value="false" />
                            <c:set var="isCheckedFri" value="false" />
                            <c:set var="isCheckedSat" value="false" />
                            <c:set var="isCheckedSun" value="false" />

                            <c:forEach var="list" items="${scheduleList}">
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

                            <td><input type="checkbox"  disabled readonly name="schedule" value="mon-${timeSlot.time_slot_id}" data-day="mon" data-slot="${timeSlot.time}" <c:if test="${isCheckedMon}">checked</c:if>></td>
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
            <div style="display: flex; padding-left: 500px">
                <c:if test="${status.equals('Approve')}">
                    <div> 
                        <button type="submit" value="submit" name="submit"><a href="updateSchedule">Request Update</a></button>
                    </div>  
                </c:if>
            </div>
        </form>

    </body>

</html>
