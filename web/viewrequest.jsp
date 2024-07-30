<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programing</title>
        <link rel="stylesheet" href="css/viewrequestmentor.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
        <style>
            /* Import Google font - Poppins */
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: "Poppins", sans-serif;
            }

            ::selection{
                color: #fff;
                background: #4671EA;
            }
            .wrapper{
                width: 570px;
                background: #edf4f0;
                border-radius: 5px;
                padding: 25px 25px 30px;
                box-shadow: 8px 8px 10px rgba(0,0,0,0.06);
                margin-top: 10px;
                margin-left: 36%;
            }
            .wrapper h2{
                color: #4671EA;
                font-size: 28px;
                text-align: center;
            }
            .wrapper textarea{
                width: 100%;
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
            .button button{
                text-align: center;
                color: white;
                border-radius: 3px;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
            }
            .pagination {
                margin-bottom: 2px;
            }

            .pagination a {
                display: inline-block;
                padding: 8px 16px;
                text-decoration: none;
                color: #000;
                background-color: #fff;
                border: 1px solid #ddd;
                margin: 0 4px;
            }

            .pagination a.active {
                background-color: #007bff;
                color: #fff;
                border: 1px solid #007bff;
            }
            .flex-container {
                display: flex;
                flex-direction: row; /* Sắp xếp theo hàng ngang */
                flex-wrap: wrap; /* Cho phép các phần tử lớn hơn kích thước của flex container ngắt dòng xuống dòng mới */
            }

            .flex-item {
                margin-right: 20px; /* Khoảng cách bên phải giữa các phần tử */
                margin-bottom: 10px; /* Khoảng cách dưới giữa các phần tử */
            }
        </style>
    </head>
    <link href="vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <!--
    
    TemplateMo 570 Chain App Dev
    
    https://templatemo.com/tm-570-chain-app-dev
    
    -->

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
    <link rel="stylesheet" href="assets/css/animated.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>


    <jsp:include page="header.jsp"></jsp:include>


        <body>
            
            <section>

                <h1 style="text-align: center; color: white;">View </h1>

                <h1 style="color: Red; text-align: center;">${errorMessage}</h1>
            <h1 style="color: Red; text-align: center;">${error}</h1>
            <div style="margin: 100px">

                <div style="margin-bottom: 5px;">
                    <form action="reqmentor" method="post">
                        <div class="flex-container">
                            <c:forEach items="${ls}" var="checkbox">
                                <div class="flex-item">
                                    <input type="checkbox" id="${checkbox}" name="checkbox" value="${checkbox}">
                                    <label for="${checkbox}">${checkbox}</label><br>
                                </div>
                            </c:forEach>
                            <c:forEach items="${choice}" var="checkboxId">
                                <script>
                                    var checkbox = document.getElementById("${checkboxId}");
                                    if (checkbox) {
                                        checkbox.checked = true;
                                    }
                                </script>
                            </c:forEach>
                        </div>


                        <button type="submit" style="background: #b3b3b3; border: 1px; border-radius: 2px; width: 80px; height: 40px;">
                            <i style="width: 10px;"class="fas fa-search"></i>
                        </button>
                    </form>
                </div>

                <div style="margin-bottom: 5px;" class="pagination">
                    <c:if test="${totalPages > 1}">
                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <c:url value="reqmentor" var="paginationUrl">
                                <c:param name="page" value="${i}" />
                            </c:url>
                            <a href="${paginationUrl}" class="${i == currentPage ? 'active' : ''}">${i}</a>
                        </c:forEach>
                    </c:if>
                </div>


                <table border="1" style="margin:auto">
                    <thead style="border: 1px solid black; background:#48CEFA;" >
                        <tr>
                            <th style="width: 10%;text-align: center;">Full Name</th>
                            <th style="width: 10%;text-align: center;">Title</th>
                            <th style="width: 15%;text-align: center;">Content of request</th>
                            <th style="width: 10%;text-align: center;">Start Date</th>
                            <th style="width: 10%;text-align: center;">End Date</th>
                            <th style="width: 10%;text-align: center;">Total learn hour (h)</th>
                            <th style="width: 10%;text-align: center;">Skills</th>
                            <th style="width: 10%;text-align: center;">Status</th>
                            <th style="width: 15%;text-align: center;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="a" items="${listR}">
                            <tr style="height: 20%;border: 1px solid black;">
                                <td style="text-align: center;"><a style="text-decoration: none;" href="infomentee?id=${a.idMentee}">${a.fullname}</a></td>
                                <td style="text-align: center;">${a.title}</td>
                                <td style="text-align: center;">${a.content}</td>
                                <td style="text-align: center;">${a.startDate}</td>
                                <td style="text-align: center;">${a.endDate}</td>
                                <td style="text-align: center;">${a.hour}</td>
                                <td style="text-align: center;">${a.skill}</td>
                                <td style="text-align: center;">${a.status}</td>
                                <td class="btn-container" style="text-align: center;">
                                    <c:choose>
                                        <c:when test="${a.status eq 'Open'}">

                                            <a href="accept?idRequest=${a.idRequest}" onclick="return confirmAccept(event);" style="background-color: #1BA345; border-radius: 5px; height: 30px; width: 70px; display: inline-block; text-align: center; line-height: 30px; color: white; text-decoration: none;cursor: pointer">
                                                Accept
                                            </a>
                                            <a onclick="showRejectForm(${a.idRequest});" style="background-color: #DE3E44; border-radius: 5px; height: 30px; width: 70px; margin-left: 5px; display: inline-block; text-align: center; line-height: 30px; color: white; text-decoration: none;cursor: pointer">
                                                Reject
                                            </a>
                                        </c:when>
                                        <c:when test="${a.status eq 'Learning '}">
                                            <a href="endProcess?idRequest=${a.idRequest}" onclick="confirmEnd(${a.idRequest});" style="background-color:  #1BA345; border-radius: 5px; height: 30px; width: 70px; display: inline-block; text-align: center; line-height: 30px; color: white; text-decoration: none;">
                                                Finish
                                            </a>
                                        </c:when>
                                        <c:when test="${a.status eq 'Completed'}">
                                            Wait for Paid
                                        </c:when>
                                    </c:choose>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>

            <form id="rejectForm" method="post" action="reasonreject">
                <input type="text" id="idRequest" name="idRequest" style="display: none"> <!-- Input hidden để lưu idRequest -->
                <div class="wrapper" style="display:none;">
                    <h2>Reason Reject</h2>
                    <textarea id="auto-resize-textarea" name="reasonReject" spellcheck="false" placeholder="Type something here..." required></textarea>
                    <br>
                    <div class="button "style="text-align: center;">
                        <button style="background-color: #28a745; margin: 0 5px;" type="submit">Submit</button>
                        <button style="background-color: #dc3545;" type="button" onclick="cancelRejectForm()">Cancel</button>
                    </div>
                </div>
            </form>

        </section>
            <jsp:include page="footer.jsp"></jsp:include>
        <script>
            function confirmAccept(event) {
                if (!confirm('Are you sure you want to accept this request?')) {
                    event.preventDefault(); // Prevent the default behavior of the <a> element
                    return false;
                }
                return true;
            }
            function confirmEnd(event) {
                if (!confirm('Are you sure you want to end this request?')) {
                    event.preventDefault(); // Prevent the default behavior of the <a> element
                    return false;
                }
                return true;
            }
            function cancelRejectForm() {
                document.querySelector('.wrapper').style.display = 'none';
            }

            function showRejectForm(idRequest) {
                document.getElementById('idRequest').value = idRequest;
                document.querySelector('.wrapper').style.display = 'block';
            }



            const textarea = document.getElementById("auto-resize-textarea");
            textarea.addEventListener("input", function () {
                this.style.height = "auto";
                this.style.height = (this.scrollHeight) + "px";
            });
        </script>
     
    </body>
</html>
