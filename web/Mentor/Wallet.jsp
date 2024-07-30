<%-- 
    Document   : listallreq
    Created on : Jan 18, 2024, 11:43:47 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap core CSS -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">

        <title>Happy Programming</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">


        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>

        <title>My Wallet</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;

                /*                background-color: #f4f4f4;*/
            }
            section {
                margin: 20px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: center;
            }

            th {
                background-color: #48CEFA;
                color: #fff;
            }

            .btn-container {
                margin-top: 10px;
            }

            .update-btn, .delete-btn {
                padding: 8px 16px;
                margin-right: 10px;
                cursor: pointer;
            }

            .update-btn {
                background-color: #4caf50;
                color: #fff;
                border: none;
            }

            .delete-btn {
                background-color: #f44336;
                color: #fff;
                border: none;
            }
            .rate-link {
                text-decoration: none;
                font-size: 20px;
            }

            .wrapper{
                width: 470px;
                background: #ddd;
                border-radius: 5px;
                padding: 25px 25px 30px;
                box-shadow: 8px 8px 10px rgba(0,0,0,0.06);
                margin-top: 10px;
                margin-left: 36%;
                margin-bottom: 20px;
            }
            .wrapper h3{
                color: #4671EA;
                font-size: 28px;
                text-align: center;
            }
            .wrapper textarea{
                width: 80%;
                resize: none;
                height: 59px;
                outline: none;
                padding: 15px;
                font-size: 16px;
                margin-top: 20px;
                border-radius: 5px;
                max-height: 330px;
                caret-color: #4671EA;
                border: 1px solid #bfbfbf;
                padding-right: 0px;
                padding-left: 2px;
            }
            textarea::placeholder{
                color: #b3b3b3;
            }
            textarea:isfocus, :valid{
                padding: 14px;
                border: 2px solid #4671EA;
            }
            textarea::-webkit-scrollbar{
                width: 0px;
            }
            .notice{
                font-size: 15px;
                color: red;

            }


            #contact:hover {
                background: #666;
            }
            #contact:active {
                background: #444;
            }

            #contactForm {
                display: none;

                border: 1px solid #41A6F4;
                padding: 2em;
                width: 400px;
                text-align: center;
                background: #fff;
                position: fixed;
                top:50%;
                left:50%;
                transform: translate(-50%,-50%);
                -webkit-transform: translate(-50%,-50%)

            }

            input, textarea {
                margin: .8em auto;
                font-family: inherit;
                text-transform: inherit;
                font-size: inherit;

                display: block;
                width: 280px;
                padding: .4em;
            }
            textarea {
                height: 80px;
                resize: none;
            }

            .formBtn {
                width: 140px;
                display: inline-block;

                background: teal;
                color: #fff;
                font-weight: 100;
                font-size: 1.2em;
                border: none;
                height: 30px;
            }
            .notification {
                display: none;
                position: fixed;
                top: 100px;
                right: 20px;
                padding: 20px 80px;
                border-radius: 5px;
                z-index: 1000;
            }

            .success {
                background-color: #7DE276;
                color: white;
            }

            .error {
                background-color: #f44336;
                color: white;
            }

            .close-btn {
                cursor: pointer;
                float: right;
                font-weight: bold;
                font-size: 20px;
                line-height: 20px;
            }

        </style>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    </head>
    <body>
        <jsp:include page="../header.jsp"></jsp:include>
            <div id="notification" class="notification">
                <span id="notificationText"></span>
                <!--                <span class="close-btn" onclick="closeNotification()">×</span>-->
            </div>
            <div class="container row" style="width: 1150px;">
                <div class="col-6">
                    <h3>Wallet balance : ${walletBalance} VNÐ</h3>
                <div style="font-size: smaller;color: #8A7A7A">Welcome to your wallet !</div>
            </div>
<!--            <div class="col-6" style="position: absolute;right: 0">
                <h3>Total Income : ${totalIncome} VNÐ</h3>
            </div>-->
            <br><br>
            <div style="display: flex;align-items: center;justify-content: space-between">
                <span>History Payment</span>
<!--                <button type="button" id="contact" class="btn btn-primary">Withdraw money</button>-->
            </div>
            <br><br><br>
            <section>
                <table border="1" style="margin:auto">
                    <thead style="border: 1px solid black; background:#48CEFA;">
                        <tr>
                            <th style="width: 10%;text-align: center;">Sender</th>
                            <th style="width: 10%;text-align: center;">Money</th>
                            <th style="width: 10%;text-align: center;">Date</th>
                            <th style="width: 10%;text-align: center;">Content</th>
                            <th style="width: 10%;text-align: center;">Stype</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="h" items="${historyWallet}">
                            <tr>
                                <td>${h.getNameMentee()}</td>
                                <c:if test="${h.getStype() eq 'Deposit'}">
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
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </section>
        </div>

        <div id="contactForm">


            <form action="takeMoney?idAccount=${idAccount}" method="post" onsubmit="return validateForm()">
                <h4>Enter the money: </h4>
                <div style="font-size: smaller;color: #8A7A7A">The money more than 50000</div>
                <input id="money" name="money" placeholder="50000" type="text" required />
                <div id="amountAlert" style="color: red;"></div>
                <button class="formBtn" type="submit" >Request</button>
            </form>
        </div>
        <jsp:include page="../footer.jsp"></jsp:include>
            <script src="assets/jquery-1.11.3.min.js"></script>
            <script>
                function validateForm() {
                    var amountInput = document.getElementById("money");
                    var amount = amountInput.value;
                    var amountAlert = document.getElementById("amountAlert");

                    if (isNaN(amount)||amount<50000) {
                        amountAlert.textContent = "Please enter a valid number.";
                        return false;
                    }

                    if (amount > ${walletBalance}) {
                        amountAlert.textContent = "The money exceed the wallet balance";
                        return false;
                    }

                    // Clear the alert if the input is valid
                    amountAlert.textContent = "";

                    return true;
                }

            </script>
            <script>

                $(function () {

                    // contact form animations
                    $('#contact').click(function () {
                        $('#contactForm').fadeToggle();
                    })
                    $(document).mouseup(function (e) {
                        var container = $("#contactForm");

                        if (!container.is(e.target) // if the target of the click isn't the container...
                                && container.has(e.target).length === 0) // ... nor a descendant of the container
                        {
                            container.fadeOut();
                        }
                    });

                });
            </script>
            <script>
                // Extracting the value of 'mess' from the request attribute
                var message = '<%= request.getAttribute("mess") %>';

                // Function to show notification based on the value of 'mess'
                function showNotification(message) {
                    var notification = document.getElementById("notification");
                    var notificationText = document.getElementById("notificationText");

                    if (message === 'ok') {
                        notification.className = "notification success";
                        notificationText.textContent = "Send request successfully!";
                    } else if (message === 'ko') {
                        notification.className = "notification error";
                        notificationText.textContent = "Error when send request, try again!";
                    }

                    notification.style.display = "block";
                    setTimeout(function () {
                        notification.style.display = "none";
                    }, 3000); // 3 seconds
                }

                function closeNotification() {
                    var notification = document.getElementById("notification");
                    notification.style.display = "none";
                }

                // Calling the function to show notification
                showNotification(message);
        </script>
    </body>


</html>
