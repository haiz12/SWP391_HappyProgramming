<%-- 
    Document   : newjsp
    Created on : Jan 14, 2024, 5:50:31 PM
    Author     : phatvv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
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
                width: 35%;
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
            label {
                font-size: 10px;
            }

            input[type="checkbox"] {
                display: none;
            }

            input[type="checkbox"] + label {
                display: inline-block;
                width: 20px;
                height: 20px;
                background-color: #fff;
                border: 2px solid #ccc;
                border-radius: 4px;
                position: relative;
                cursor: pointer;
            }

            input[type="checkbox"]:checked + label {
                background-color: #00c6ff;
                border-color: #00c6ff;
            }

            input[type="checkbox"]:checked + label::after {
                content: '';
                position: absolute;
                top: 4px;
                left: 4px;
                width: 8px;
                height: 8px;
                background-color: #fff;
                border-radius: 2px;
            }


            /* CSS cho bảng */
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            }

            th, td {
                border: 1px solid #ddd;
                text-align: center;
                padding: 8px;
            }

            th {
                background-color: #f4f4f4;
                color: #333;
                font-weight: bold;
                font-size: 10px;
            }

            tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tr:hover {
                background-color: #f1f1f1;
            }

            .year{
                font-size: 10px;
            }
            .center {
                display: flex;
                justify-content: center;
                align-items: center;
                gap: 10px;
            }
            select , option {
                font-size: 12px;
            }
            .modal {
                display: none;
                position: fixed;
                z-index: 1000; /* Ensure the modal is above other elements */
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgb(0,0,0);
                background-color: rgba(0,0,0,0.4);
            }
            .modal-content {
                background-color: #fefefe;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 40%;
                text-align: center;
                position: relative; /* For positioning the close button */
                z-index: 1001; /* Ensure the modal content is above the modal background */
            }
            .close {
                color: #aaa;
                position: absolute;
                top: 10px;
                right: 20px;
                font-size: 28px;
                font-weight: bold;
                cursor: pointer;
            }
            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }
            .modal-buttons {
                display: flex;
                justify-content: center;
                gap: 20px;
            }
        </style>


    </head>
    <body>

        <div class="background gradient">

        </div>
        <div class="page">
            <form action="menteeRequest" method="post">
                <main>
                    <section id="presentation" class="profile">
                        <div class="profile-background"></div>
                        <div>
                            <input type="hidden" name="idMentor" id="idMentor" value="${mentor.idMentor}"/>
                            <script>
                                document.addEventListener("DOMContentLoaded", function () {
                                    const idMentor = document.getElementById("idMentor").value;
                                    console.log("idMentor:", idMentor);
                                });
                            </script>
                            <div class="profile-image">
                                <img src="${mentor.getAvatar()}" alt="">
                            </div>
                            <h1 class="profile-name" id="nombre"> ${mentor.fullname}</h1>
                            <h2 class="profile-profession"> ${mentor.profession}</h2> 
                            <div class="row">
                                <div class="column left">Pay/1h :</div>
                                <div class="column right">${mentor.cost}VNĐ</div>
                                <input type="hidden" name="cost" id="cost" value="${mentor.cost}"/>
                                <script>
                                    document.addEventListener("DOMContentLoaded", function () {
                                        const cost = document.getElementById("cost").value;
                                        console.log("cost:", cost);
                                    });
                                </script>
                            </div>
                            <div class="row">
                                <div class="column left">Skill :</div>
                                <div class="column right">
                                    <select name="skillId" id="skillId">
                                        <c:forEach var="skill" items="${listHS}">
                                            <option value="${skill.idSkill}">${skill.skillname}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <script>
                                document.addEventListener("DOMContentLoaded", function () {
                                    const skillId = document.getElementById("skillId").value;
                                    console.log("skillId:", skillId);
                                });
                            </script>
                            <div class="row">
                                <div class="column left">Hour :</div>
                                <div class="column right" name="hour" id="hour" >2h</div>
                            </div>
                            <script>
                                document.addEventListener("DOMContentLoaded", function () {
                                    const hour = document.getElementById("hour").value;
                                    console.log("hour:", hour);
                                });
                            </script>
                            <div class="row">
                                <div class="column left">Total Cost :</div>
                                <div class="column right" id="totalCost"></div>
                            </div>
                    </section>
                    <section id="about" class="about view">
                        <div class="center">
                            <label for="yearSelect" >YEAR</label>
                            <select name="year" id="yearSelect"></select>
                            <label for="startWeekSelect">START WEEK</label>
                            <select name="startWeek" id="startWeekSelect">
                                <c:forEach var="week" items="${weeks}">
                                    <option value="${week}">${week}</option>
                                </c:forEach>
                            </select>
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
                                <c:forEach var="slot" items="${listTS}">
                                    <tr>
                                        <td><label class="form-check-label" for="timeSlotId">${slot.time_slot_id}</label></td>
                                        <td>
                                            <c:forEach var="sc" items="${schedule}">
                                                <c:set var="mon_slot" value="mon-${slot.time_slot_id}"/>
                                                <c:if test="${sc eq mon_slot}">
                                                    <input type="checkbox" name="schedule" value="mon-${slot.time_slot_id}" id="mon-${slot.time_slot_id}" data-day="mon"  >
                                                    <label for="mon-${slot.time_slot_id}"></label>
                                                </c:if>
                                            </c:forEach>                                        
                                        </td>
                                        <td>
                                            <c:forEach var="sc" items="${schedule}">
                                                <c:set var="tue_slot" value="tue-${slot.time_slot_id}"/>
                                                <c:if test="${sc eq tue_slot}">
                                                    <input type="checkbox" name="schedule" value="tue-${slot.time_slot_id}" id="tue-${slot.time_slot_id}" data-day="tue" >
                                                </c:if>
                                            </c:forEach>                                        
                                            <label for="tue-${slot.time_slot_id}"></label>
                                        </td>
                                        <td>
                                            <c:forEach var="sc" items="${schedule}">
                                                <c:set var="wed_slot" value="wed-${slot.time_slot_id}"/>
                                                <c:if test="${sc eq wed_slot}">
                                                    <input type="checkbox" name="schedule" value="wed-${slot.time_slot_id}" id="wed-${slot.time_slot_id}" data-day="wed" >
                                                </c:if>
                                            </c:forEach>                                        
                                            <label for="wed-${slot.time_slot_id}"></label>
                                        </td>
                                        <td>
                                            <c:forEach var="sc" items="${schedule}">
                                                <c:set var="thu_slot" value="thu-${slot.time_slot_id}"/>
                                                <c:if test="${sc eq thu_slot}">
                                                    <input type="checkbox" name="schedule" value="thu-${slot.time_slot_id}" id="thu-${slot.time_slot_id}" data-day="thu" >
                                                </c:if>
                                            </c:forEach>                                        
                                            <label for="thu-${slot.time_slot_id}"></label>
                                        </td>
                                        <td>
                                            <c:forEach var="sc" items="${schedule}">
                                                <c:set var="fri_slot" value="fri-${slot.time_slot_id}"/>
                                                <c:if test="${sc eq fri_slot}">
                                                    <input type="checkbox" name="schedule" value="fri-${slot.time_slot_id}" id="fri-${slot.time_slot_id}" data-day="fri" >
                                                </c:if>
                                            </c:forEach>                                        
                                            <label for="fri-${slot.time_slot_id}"></label>
                                        </td>
                                        <td>
                                            <c:forEach var="sc" items="${schedule}">
                                                <c:set var="sat_slot" value="sat-${slot.time_slot_id}"/>
                                                <c:if test="${sc eq sat_slot}">
                                                    <input type="checkbox" name="schedule" value="sat-${slot.time_slot_id}" id="sat-${slot.time_slot_id}" data-day="sat" >
                                                </c:if>
                                            </c:forEach>                                        
                                            <label for="sat-${slot.time_slot_id}"></label>
                                        </td>
                                        <td>
                                            <c:forEach var="sc" items="${schedule}">
                                                <c:set var="sun_slot" value="sun-${slot.time_slot_id}"/>
                                                <c:if test="${sc eq sun_slot}">
                                                    <input type="checkbox" name="schedule" value="sun-${slot.time_slot_id}" id="sun-${slot.time_slot_id}" data-day="sun" >
                                                </c:if>
                                            </c:forEach>                                        
                                            <label for="sun-${slot.time_slot_id}"></label>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="row">
                            <div class="column left" style="text-align: center; width: 30%">Title:</div>
                            <div class="column right" style="width: 70%"><input type="text" name="title"/></div>
                        </div>
                        <div class="row">
                            <div class="column left" style="text-align: center; width: 30%">Content:</div>
                            <div class="column right" style="width: 70%"><input type="text" name="content"/></div>
                        </div>
                        <input type="hidden" name="statusId" value="1"/>
                        <div style="display: flex; justify-content: center; gap: 20px;">
                            <button type="submit" onclick="saveSchedule()">Request</button>
                        </div>
                    </section>
                </main>
            </form>
            <div id="messModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <p id="modalMessage">${mess}</p>
                    <div class="modal-buttons">
                        <button onclick="redirectToPayment()">Payment</button>
                    </div>
                </div>
            </div>
        </div>
        <script>

            let scheduleData = JSON.parse(localStorage.getItem('scheduleData')) || {};

            function getWeekDates(year, week) {
                let date = new Date(year, 0, 1 + (week - 1) * 7);
                let startDate = new Date(date.setDate(date.getDate() - date.getDay() + 1));
                let endDate = new Date(date.setDate(date.getDate() + 6));
                return startDate.toISOString().slice(0, 10) + " To " + endDate.toISOString().slice(0, 10);
            }

            const weeks = ${weeks};

            function populateWeekSelect() {
                let yearSelect = document.getElementById("yearSelect");
                let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let selectedYear = yearSelect.value;

                startWeekSelect.innerHTML = '';
                endWeekSelect.innerHTML = '';
                for (let i = 0; i < weeks.length - 1; i++) {
                    let week = weeks[i];
                    let option = document.createElement("option");
                    option.text = getWeekDates(selectedYear, week);
                    option.value = week;
                    startWeekSelect.add(option);
                }

                populateEndWeekSelect();
            }

            function populateEndWeekSelect() {
                let yearSelect = document.getElementById("yearSelect");
                let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let selectedYear = yearSelect.value;
                let selectedStartWeek = parseInt(startWeekSelect.value);

                endWeekSelect.innerHTML = '';
                weeks.forEach(week => {
                    if (week > selectedStartWeek) {
                        let option = document.createElement("option");
                        option.text = getWeekDates(selectedYear, week);
                        option.value = week;
                        endWeekSelect.add(option);
                    }
                });
            }


            function loadSchedule() {
                let yearSelect = document.getElementById("yearSelect");
                let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let selectedYear = yearSelect.value;
                let selectedStartWeek = startWeekSelect.value;
                let selectedEndWeek = endWeekSelect.value;
                let checkboxes = document.querySelectorAll("input[type='checkbox']");

                checkboxes.forEach(checkbox => {
                    let value = checkbox.value;
                    let [day, slot] = value.split('-');
                    let weekType = selectedStartWeek;

                    if (scheduleData[selectedYear] && scheduleData[selectedYear][weekType]) {
                        let key = `${day}-${slot}`;
                                        checkbox.checked = (scheduleData[selectedYear][weekType][key]) || false;
                                    }
                                });
                            }

                            document.addEventListener("DOMContentLoaded", function () {
                                let yearSelect = document.getElementById("yearSelect");
                                let currentYear = new Date().getFullYear();
                                for (let i = currentYear; i >= currentYear - 10; i--) {
                                    let option = document.createElement("option");
                                    option.text = i;
                                    option.value = i;
                                    yearSelect.add(option);
                                }

                                populateWeekSelect();
                                loadSchedule();
                            });

                            document.getElementById("yearSelect").addEventListener("change", function () {
                                populateWeekSelect();
                                loadSchedule();
                            });
                            document.getElementById("startWeekSelect").addEventListener("change", function () {
                                populateEndWeekSelect();
                                loadSchedule();
                            });
                            document.getElementById("endWeekSelect").addEventListener("change", function () {
                                loadSchedule();
                            });

                            function getSelectedWeekValues() {
                                const startWeekSelect = document.querySelector("select[name='startWeek']");
                                const selectedStartWeek = startWeekSelect.value;
                                const endWeekSelect = document.querySelector("select[name='endWeek']");
                                const selectedEndWeek = endWeekSelect.value;

                                console.log('Start Week:', selectedStartWeek);
                                console.log('End Week:', selectedEndWeek);

                                return {
                                    startWeek: selectedStartWeek,
                                    endWeek: selectedEndWeek
                                };
                            }

                            document.getElementById("startWeekSelect").addEventListener("change", getSelectedWeekValues);
                            document.getElementById("endWeekSelect").addEventListener("change", getSelectedWeekValues);

                            function saveSchedule() {
                                let startWeekSelect = document.getElementById("startWeekSelect");
                                let endWeekSelect = document.getElementById("endWeekSelect");
                                let yearSelect = document.getElementById("yearSelect");
                                let selectedYear = yearSelect.value;
                                let selectedStartWeek = startWeekSelect.value;
                                let selectedEndWeek = endWeekSelect.value;
                                let checkboxes = document.querySelectorAll("input[type='checkbox']:checked");
                                let selectedSchedules = [];
                                checkboxes.forEach(checkbox => {
                                    let value = checkbox.value;
                                    selectedSchedules.push(value);
                                });
                                let schedulesString = selectedSchedules.join(',');

                                let form = document.createElement('form');
                                form.method = 'POST';
                                form.action = 'menteeRequest';

                                let yearInput = document.createElement('input');
                                yearInput.type = 'hidden';
                                yearInput.name = 'year';
                                yearInput.value = selectedYear;
                                form.appendChild(yearInput);

                                let startWeekInput = document.createElement('input');
                                startWeekInput.type = 'hidden';
                                startWeekInput.name = 'startWeek';
                                startWeekInput.value = selectedStartWeek;
                                form.appendChild(startWeekInput);

                                let endWeekInput = document.createElement('input');
                                endWeekInput.type = 'hidden';
                                endWeekInput.name = 'endWeek';
                                endWeekInput.value = selectedEndWeek;
                                form.appendChild(endWeekInput);

                                let schedulesInput = document.createElement('input');
                                schedulesInput.type = 'hidden';
                                schedulesInput.name = 'schedules';
                                schedulesInput.value = schedulesString;
                                form.appendChild(schedulesInput);

                                document.body.appendChild(form);
                                let formData = new FormData(form);
                                formData.forEach((value, key) => {
                                    console.log(key + ": " + value);
                                });
                                form.submit();
                            }
                            window.addEventListener('beforeunload', function () {
                                localStorage.removeItem('scheduleData');
                            });
        </script>
        <script>
            // Function to calculate total cost
            function calculateTotalCost() {
                const payPerHour = parseFloat(document.getElementById("cost").value); // Get the pay per hour
                const hours = 2; // Get the selected hours
                const startWeek = parseInt(document.getElementById("startWeekSelect").value); // Get the start week
                const endWeek = parseInt(document.getElementById("endWeekSelect").value); // Get the end week

                const weekDifference = endWeek - startWeek + 1; // Calculate the week difference
                const checkboxes = document.querySelectorAll("input[type='checkbox']:checked"); // Get all checked checkboxes
                const numChecked = checkboxes.length; // Count the number of checked checkboxes

                const totalCost = weekDifference * payPerHour * hours * numChecked; // Calculate the total cost
                document.getElementById("totalCost").textContent = totalCost.toLocaleString('vi-VN') + " VNĐ"; // Update the total cost in the UI
            }

            // Add event listeners to recalculate total cost when relevant inputs change
            document.getElementById("hour").addEventListener("change", calculateTotalCost);
            document.getElementById("startWeekSelect").addEventListener("change", calculateTotalCost);
            document.getElementById("endWeekSelect").addEventListener("change", calculateTotalCost);

            // Add event listeners to recalculate total cost when checkboxes are checked/unchecked
            const checkboxes = document.querySelectorAll("input[type='checkbox']");
            checkboxes.forEach(checkbox => {
                checkbox.addEventListener("change", calculateTotalCost);
            });

            // Initial calculation
            document.addEventListener("DOMContentLoaded", function () {
                calculateTotalCost();
            });
        </script>

        <script>
        // Function to open modal and set message
        function showModal(message) {
            var modal = document.getElementById("messModal");
            var modalMessage = document.getElementById("modalMessage");
            modalMessage.textContent = message;
            modal.style.display = "block";
        }

        // Function to redirect to payment page with POST method
        function redirectToPayment() {
            var amount = '${amount}';
            console.log(amount);
            amount = parseFloat(amount); // Chuyển đổi amount sang số
            if (isNaN(amount)) {
                alert('Invalid amount');
                return;
            }

            var form = document.createElement("form");
            form.method = "POST";
            form.action = "vnpay"; // URL của trang thanh toán

            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "amount";
            input.value = amount;
            form.appendChild(input);

            document.body.appendChild(form);
            form.submit();
        }

        // Get the modal and close button
        var modal = document.getElementById("messModal");
        var closeButton = document.getElementsByClassName("close")[0];

        // Close the modal when the user clicks on <span> (x)
        closeButton.onclick = function() {
            modal.style.display = "none";
        }

        // Close the modal when the user clicks anywhere outside of the modal
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }

        // Check if message exists and show modal
        window.onload = function() {
            var mess = "${mess}";
            if (mess && mess !== "null") {
                showModal(mess);
            }
        }
    </script>

    </body>
</html>




