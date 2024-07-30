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

        <title>Update Request</title>

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
                background-image: url('../assets/images/client-bg.png')
            }

            .main-banner-container {
                max-width: 600px;
                margin: 0px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding-bottom: 70px
            }

            h2 {
                text-align: center;
                margin-bottom: 30px;
            }

            label {
                font-weight: bold;
            }

            select,
            input[type="text"],
            input[type="date"],
            textarea {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }

            textarea {
                height: 100px;
                resize: none;
            }

            button[type="submit"] {
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

            button[type="submit"]:hover {
                background-color: #0056b3;
            }

            .alert {
                margin-top: 20px;
                padding: 10px 15px;
                border-radius: 5px;
            }

            .alert-success {
                background-color: #d4edda;
                border-color: #c3e6cb;
                color: #155724;
            }

            .alert-danger {
                background-color: #f8d7da;
                border-color: #f5c6cb;
                color: #721c24;
            }
            .btn {
                display: inline-block;
                padding: 0.5em 1em;
                text-decoration: none;
                background-color: #007bff; /* Button background color */
                color: #fff; /* Button text color */
                border: none;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s ease;
                line-height: 1.5em;
            }

            /* Hover effect */
            .btn:hover {
                background-color: #0056b3; /* Darker background color on hover */
            }
        </style>
    </head>
    <body style="background-image: url(../assets/images/client-bg.png)">
        <jsp:include page="../header.jsp"></jsp:include>
            <div class="main-banner-container">
                <h2>Update Request</h2>
                <form action="Request?action=update&idRequest=${request.getIdRequest()}" method="post">
                <label for="mentor" style="font-size: 20px">Mentor:</label>
                <span style="font-size: 20px">${mentor.getFullname()}</span>
                <input type="text" name="idMentor" value="${mentor.idMentor}" style="display: none">
                <br><br>
                <div class="form-group">
                    <label  style="font-size: 18px">Course: </label>
                    <span>
                        <select name="idSkill">
                            <c:forEach var="s" items="${listHaveSkill}">
                                <option value="${s.getIdSkill()}">${s.getSkillname()}</option>
                            </c:forEach>
                        </select>
                    </span>
                </div>
                <br>
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" value="${request.getTitle()}" required>

                <label for="content">Enter your Schedule: </label>
                <textarea id="content" name="content"  required >${request.getContent()}</textarea>

                <div class="row">
                    <div class="col-6">
                        <label for="startDate">Start learn in:</label>
                        <input type="date" id="startDate" name="startDate" value="${request.getStartDate()}" required>
                    </div>
                    <div class="col-6">
                        <label for="endate">Complete in:</label>
                        <input type="date" id="endDate" name="endDate" value="${request.getEndDate()}" required>
                    </div>
                    <div class="col-5">
                        <label for="deadlineHour">Total learn hour:</label>
                        <input type="text" id="learnHour" name="deadlineHour" value="${request.getDeadlineHour()}" required>
                    </div>
                    <div class="col-2">
                        <label for="totalButton">click this</label>
                        <button type="button" id="totalButton">Total</button>
                    </div>
                </div>
                <div>
                    <input name="totalCost" id="total" value="${request.getTotalCost()}" style="display: none">
                </div>
                <br>
                <div>
                    <label for="totalValue" >Total: </label>
                    <span id="totalValue">$ ${request.getTotalCost()}</span>
                </div>
                <br>
                <c:if test="${msg eq 'ok'}">
                    <div class="alert alert-success" role="alert">
                        Update successful!
                    </div>
                </c:if>
                <c:if test="${msg eq 'fail'}">
                    <div class="alert alert-danger" role="alert">
                        Update failed. Please try again.
                    </div>
                </c:if>
                <br>
                <div style="display: flex; justify-content: center;">
                    <button type="submit" style="width: 48%; margin-right: 4%;">Submit</button>
                    <!--                    <a href="home.jsp" class="btn" style="text-align: center;">Back to Homepage</a>-->
                </div>


            </form>

        </div>
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
            totalButton.addEventListener("click", function () {
                // Lấy giá trị nhập vào từ input
                var learnHourValue = parseFloat(learnHourInput.value);

                // Kiểm tra nếu giá trị nhập vào là một số hợp lệ
                if (!isNaN(learnHourValue)) {
                    // Cập nhật giá trị trong input totalValue
                    totalValueInput.value = learnHourValue *${mentor.getCost()};
                    totalValueSpan.textContent ="$ "+ (learnHourValue *${mentor.getCost()}) ;
                } else {
                    // Nếu giá trị không hợp lệ, thông báo cho người dùng
                    alert("Please enter a valid number for Total learn hour.");
                }
            });
        </script>
        <jsp:include page="../footer.jsp"></jsp:include>
       
    </body>
</html>
</html>
