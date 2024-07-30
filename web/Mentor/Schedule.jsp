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
        <form class="container" action="viewMentorSchedule?idMentor=${cx.getId()}" method="post">
            <h2>My Schedule</h2>
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
            <div style="display: flex; padding-left: 500px">

                <div> 
                    <button type="submit" value="submit" name="submit">Send</button>
                </div> 
            </div>
        </form>

        <script>
            let scheduleData = JSON.parse(localStorage.getItem('scheduleData')) || {};

            function getWeekDates(year, week) {
                let date = new Date(year, 0, 1 + (week - 1) * 7);
                let startDate = new Date(date.setDate(date.getDate() - date.getDay() + 1));
                let endDate = new Date(date.setDate(date.getDate() + 6));
                return startDate.toISOString().slice(0, 10) + " To " + endDate.toISOString().slice(0, 10);
            }

            function populateWeekSelect() {
                let yearSelect = document.getElementById("yearSelect");
                let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let selectedYear = yearSelect.value;

                startWeekSelect.innerHTML = '';
                endWeekSelect.innerHTML = '';

                for (let j = 1; j <= 52; j++) {
                    let option = document.createElement("option");
                    option.text = getWeekDates(selectedYear, j);
                    option.value = j;
                    startWeekSelect.add(option);
                }
            }

            function populateEndWeekSelect() {
                let yearSelect = document.getElementById("yearSelect");
                let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let selectedYear = yearSelect.value;
                let selectedStartWeek = parseInt(startWeekSelect.value);

                endWeekSelect.innerHTML = '';

                for (let j = selectedStartWeek; j <= 52; j++) {
                    let option = document.createElement("option");
                    option.text = getWeekDates(selectedYear, j);
                    option.value = j;
                    endWeekSelect.add(option);
                }
            }

            function saveSchedule() {
                let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let yearSelect = document.getElementById("yearSelect");
                let selectedYear = yearSelect.value;
                let selectedStartWeek = startWeekSelect.value;
                let selectedEndWeek = endWeekSelect.value;
                let checkboxes = document.querySelectorAll("input[type='checkbox']");

                scheduleData[selectedYear] = scheduleData[selectedYear] || {};
                scheduleData[selectedYear][selectedStartWeek] = scheduleData[selectedYear][selectedStartWeek] || {};
                scheduleData[selectedYear][selectedEndWeek] = scheduleData[selectedYear][selectedEndWeek] || {};

                checkboxes.forEach(checkbox => {
                    let day = checkbox.getAttribute("data-day");
                    let slot = checkbox.getAttribute("data-slot");
                    let week = checkbox.getAttribute("data-week");
                    let weekType = week === "start" ? selectedStartWeek : selectedEndWeek;

                    scheduleData[selectedYear][weekType][`\${day}-\${slot}`] = checkbox.checked;
                });

                localStorage.setItem('scheduleData', JSON.stringify(scheduleData));
                alert("Schedule saved!");
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
                    checkbox.addEventListener('change', function () {
                    let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let yearSelect = document.getElementById("yearSelect");
                let selectedYear = yearSelect.value;
                let selectedStartWeek = startWeekSelect.value;
                let selectedEndWeek = endWeekSelect.value;
                let checkboxes = document.querySelectorAll("input[type='checkbox']");

                scheduleData[selectedYear] = scheduleData[selectedYear] || {};
                scheduleData[selectedYear][selectedStartWeek] = scheduleData[selectedYear][selectedStartWeek] || {};
                scheduleData[selectedYear][selectedEndWeek] = scheduleData[selectedYear][selectedEndWeek] || {};

                checkboxes.forEach(checkbox => {
                    let day = checkbox.getAttribute("data-day");
                    let slot = checkbox.getAttribute("data-slot");
                    let week = checkbox.getAttribute("data-week");
                    let weekType = week === "start" ? selectedStartWeek : selectedEndWeek;

                    scheduleData[selectedYear][weekType][`\${day}-\${slot}`] = checkbox.checked;
                });

                localStorage.setItem('scheduleData', JSON.stringify(scheduleData));
                populateWeekSelect();
                setWeekDates();
                loadSchedule();
            });
                    let day = checkbox.getAttribute("data-day");
                    let slot = checkbox.getAttribute("data-slot");
                    let week = checkbox.getAttribute("data-week");
                    let weekType = week === "start" ? selectedStartWeek : selectedEndWeek;

                    let key = `\${day}-\${slot}`;
                    checkbox.checked = (scheduleData[selectedYear][weekType][key]) || false;
                });
            }

            // Populate year select and initialize week select
            let yearSelect = document.getElementById("yearSelect");
            let currentYear = new Date().getFullYear();
            for (let i = currentYear; i >= currentYear - 10; i--) {
                let option = document.createElement("option");
                option.text = i;
                option.value = i;
                yearSelect.add(option);
            }
            populateWeekSelect();
// Gọi hàm loadFromLocalStorage khi trang được load
            document.addEventListener("DOMContentLoaded", function () {

                loadSchedule(); // Load the data from localStorage

            });


            




            // Event listener for year select change
            yearSelect.addEventListener("change", function () {
                saveSchedule();
                populateWeekSelect();
                setWeekDates();
                loadSchedule();
            });

            // Event listener for start week select change
            document.getElementById("startWeekSelect").addEventListener("change", function () {
                saveSchedule();
                populateEndWeekSelect();
                setWeekDates();
                loadSchedule();
            });

            // Event listener for end week select change
            document.getElementById("endWeekSelect").addEventListener("change", function () {
                saveSchedule();
                setWeekDates();
                loadSchedule();
            });

            // Function to set the dates for the week
            function setWeekDates() {
                let startWeekSelect = document.getElementById("startWeekSelect");
                let endWeekSelect = document.getElementById("endWeekSelect");
                let yearSelect = document.getElementById("yearSelect");
                let selectedYear = yearSelect.value;
                let selectedStartWeek = parseInt(startWeekSelect.value);
                let selectedEndWeek = parseInt(endWeekSelect.value);

                // Check if start week is less than or equal to end week
                if (selectedStartWeek > selectedEndWeek) {
                    alert("Start week must be less than or equal to end week.");
                    return;
                }

                // Calculate dates for the start week
                let startDate = new Date(selectedYear, 0, 1 + (selectedStartWeek - 1) * 7);
                let startMonDate = new Date(startDate.setDate(startDate.getDate() - startDate.getDay() + 1)).toISOString().slice(0, 10);
                document.getElementById("startMonDate").innerText = startMonDate;
                document.getElementById("startTueDate").innerText = new Date(new Date(startMonDate).setDate(new Date(startMonDate).getDate() + 1)).toISOString().slice(0, 10);
                document.getElementById("startWedDate").innerText = new Date(new Date(startMonDate).setDate(new Date(startMonDate).getDate() + 2)).toISOString().slice(0, 10);
                document.getElementById("startThuDate").innerText = new Date(new Date(startMonDate).setDate(new Date(startMonDate).getDate() + 3)).toISOString().slice(0, 10);
                document.getElementById("startFriDate").innerText = new Date(new Date(startMonDate).setDate(new Date(startMonDate).getDate() + 4)).toISOString().slice(0, 10);
                document.getElementById("startSatDate").innerText = new Date(new Date(startMonDate).setDate(new Date(startMonDate).getDate() + 5)).toISOString().slice(0, 10);
                document.getElementById("startSunDate").innerText = new Date(new Date(startMonDate).setDate(new Date(startMonDate).getDate() + 6)).toISOString().slice(0, 10);

                // Calculate dates for the end week
                let endDate = new Date(selectedYear, 0, 1 + (selectedEndWeek - 1) * 7);
                let endMonDate = new Date(endDate.setDate(endDate.getDate() - endDate.getDay() + 1)).toISOString().slice(0, 10);
                document.getElementById("endMonDate").innerText = endMonDate;
                document.getElementById("endTueDate").innerText = new Date(new Date(endMonDate).setDate(new Date(endMonDate).getDate() + 1)).toISOString().slice(0, 10);
                document.getElementById("endWedDate").innerText = new Date(new Date(endMonDate).setDate(new Date(endMonDate).getDate() + 2)).toISOString().slice(0, 10);
                document.getElementById("endThuDate").innerText = new Date(new Date(endMonDate).setDate(new Date(endMonDate).getDate() + 3)).toISOString().slice(0, 10);
                document.getElementById("endFriDate").innerText = new Date(new Date(endMonDate).setDate(new Date(endMonDate).getDate() + 4)).toISOString().slice(0, 10);
                document.getElementById("endSatDate").innerText = new Date(new Date(endMonDate).setDate(new Date(endMonDate).getDate() + 5)).toISOString().slice(0, 10);
                document.getElementById("endSunDate").innerText = new Date(new Date(endMonDate).setDate(new Date(endMonDate).getDate() + 6)).toISOString().slice(0, 10);
            }
            // Hàm để lấy giá trị của các phần tử select
            function getSelectedWeekValues() {
                // Lấy phần tử select có name là 'startWeek'
                const startWeekSelect = document.querySelector("select[name='startWeek']");
                // Lấy giá trị được chọn của startWeek
                const selectedStartWeek = startWeekSelect.value;

                // Lấy phần tử select có name là 'endWeek'
                const endWeekSelect = document.querySelector("select[name='endWeek']");
                // Lấy giá trị được chọn của endWeek
                const selectedEndWeek = endWeekSelect.value;

                // Hiển thị giá trị trong console (hoặc thực hiện hành động khác)
                console.log('Start Week:', selectedStartWeek);
                console.log('End Week:', selectedEndWeek);

                // Trả về giá trị nếu cần sử dụng trong hàm khác
                return {
                    startWeek: selectedStartWeek,
                    endWeek: selectedEndWeek
                };
            }

// Gọi hàm để lấy giá trị khi cần thiết, ví dụ khi người dùng thay đổi lựa chọn
            document.getElementById("startWeekSelect").addEventListener("change", getSelectedWeekValues);
            document.getElementById("endWeekSelect").addEventListener("change", getSelectedWeekValues);

        </script>
    </body>

</html>
