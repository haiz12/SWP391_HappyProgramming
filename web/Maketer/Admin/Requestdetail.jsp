<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/pro.css"/>
        <style>
            .custom-container {
                margin-left: 15px;
                margin-right: 15px;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid custom-container rounded bg-white mt-5 mb-5">
            <div class="row mx-2 my-2">
                <div class="col-md-3 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                        <img class="rounded-circle mt-5 mb-5" width="150px" src="${requestScope.requestDetail.avatar}">
                        <span class="font-weight-bold">Fullname: ${requestScope.requestDetail.fullname}</span>
                        <span class="font-weight-bold">Dob: ${requestScope.requestDetail.dob}</span>
                        <span class="font-weight-bold">Sex: ${requestScope.requestDetail.sex}</span>
                        <span class="font-weight-bold">Phone: ${requestScope.requestDetail.phone}</span>
                        <span class="font-weight-bold">Address: ${requestScope.requestDetail.address}</span>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h4 class="text-right">Detail Request</h4>
                        </div>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>IdMentee</th>
                                        <th>IdRequest</th>
                                        <th>Title</th>
                                        <th>Content</th>
                                        <th>Status</th>
                                        <th>Skill</th>
                                        <th>Start Date</th>
                                        <th>End Date</th>
                                        <th>Deadline hour</th>
                                        <th>Reason Reject</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${requestScope.requestDetail.idMentee}</td>
                                        <td>${requestScope.requestDetail.idRequest}</td>
                                        <td>${requestScope.requestDetail.title}</td>
                                        <td>${requestScope.requestDetail.content}</td>
                                        <td>${requestScope.requestDetail.status}</td>
                                        <td>${requestScope.requestDetail.skill}</td>
                                        <td>${requestScope.requestDetail.startdate}</td>
                                        <td>${requestScope.requestDetail.deadline}</td>
                                        <td>${requestScope.requestDetail.hour}</td>
                                        <td>${requestScope.requestDetail.reasonreject}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="mt-3">
                            <a href="admin#request" class="btn btn-secondary">Back</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
