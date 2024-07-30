<%-- 
    Document   : createnews
    Created on : Feb 26, 2024, 10:45:10 AM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREATE NEWS</title>
        <link rel="stylesheet" href="fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
        <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet"> <!-- https://fonts.google.com/ -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/UserDetailStyle.css" rel="stylesheet">
        <link href="css/UserDetail.css" rel="stylesheet" />
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js"
            referrerpolicy="origin"
        ></script>
        <script src="https://cdn.jsdelivr.net/npm/@tinymce/tinymce-jquery@2/dist/tinymce-jquery.min.js"></script>

    </head>
    <body>
        <div class="container h-100">
            <div class="row d-flex justify-content-around align-items-center h-100">
                <div class="col-xl-9 col-lg-8 col-xl-5 offset-xl-1">       
                    <form method="POST" action="addnews" enctype="multipart/form-data" style="margin-top: 30px" id="form">
                        <div class="card" style="border-radius: 15px;">
                            <h1 class="mb-4" style="text-align: center; margin-top: 20px">CREATE NEWS</h1>
                            <p  style="color: green; text-align: center">${message}</p>
                            <div class="card-body">
                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">             
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <p style="color: red; text-align: right">(*) is required</p>                                                    
                                    </div>
                                </div>

                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="form3Example4">News Title <label style="color: red">(*)</label></label>                  
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <input type="text" name="blogtitle" id="form3Example4" class="form-control form-control-lg" value="" required>
                                    </div>
                                </div>
                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="form3Example4">News Summary <label style="color: red">(*)</label></label>                  
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <input type="text" name="Summary" id="form3Example4" class="form-control form-control-lg" value="" required>
                                    </div>
                                </div>
                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="form3Example4"> Event Start in:                 
                                    </div>

                                </div>

                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-2 ps-5">
                                        <label class="form-label" for="form3Example4">Day <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-2 pe-5">
                                        <select name="ndays" id="form3Example4" class="form-control form-control-lg" >
                                            <option value="">Day</option> <!-- Option mặc định -->
                                            <!-- Tạo các option cho ngày từ 1 đến 31 -->
                                            <% for (int i = 1; i <= 31; i++) { %>
                                            <option value="<%= i %>"><%= i %></option>
                                            <% } %>
                                        </select>
                                    </div>
                                    <div class="col-md-2 ps-5">
                                        <label class="form-label" for="form3Example4">Month <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-2 pe-5">
                                        <select name="nmonth" id="form3Example4" class="form-control form-control-lg" >
                                            <option value="">Month</option> <!-- Option mặc định -->
                                            <!-- Tạo các option cho các tháng từ tháng 1 đến tháng 12 -->
                                            <option value="January">January</option>
                                            <option value="February">February</option>
                                            <option value="March">March</option>
                                            <option value="April">April</option>
                                            <option value="May">May</option>
                                            <option value="June">June</option>
                                            <option value="July">July</option>
                                            <option value="August">August</option>
                                            <option value="September">September</option>
                                            <option value="October">October</option>
                                            <option value="November">November</option>
                                            <option value="December">December</option>
                                        </select>
                                    </div>
                                    <div class="col-md-2 ps-5">
                                        <label class="form-label" for="form3Example4">Year <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-2 pe-5">
                                        <select name="nyear" id="form3Example4" class="form-control form-control-lg" >
                                            <option value="">Select Year</option>
                                            <% 
                                                int currentYear = java.time.Year.now().getValue();
                                                for (int year = 2024; year <= 2030; year++) {
                                                    String selected = "";
                                                    if (year == currentYear) {
                                                        selected = "selected"; // Hiển thị năm hiện tại là mặc định
                                                    }
                                            %>
                                            <option value="<%= year %>" <%= selected %>><%= year %></option>
                                            <% } %>
                                        </select>
                                    </div>
                                </div>


                                <div class="row align-items-center py-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="form3Example4">Cover Image</label><br>                                
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <input type="file" name="coverimage" >
                                        <p style="color: red">${ERR}</p>
                                    </div>
                                </div>   
                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="form3Example4">Content <label style="color: red">(*)</label></label>                  
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <textarea id="form3Example4" name="content" class="form-control form-control-lg" rows="5" required></textarea>
                                    </div>
                                </div>

                                <div class="row align-items-center py-3" style="display: flex;justify-content: end"> 
                                    <div class="col-md-3 ps-5">
                                        <button type="submit"  value="0"class="btn btn-primary btn-lg" onclick="confirm('Are you sure to post this blog to main page')"style=" color: white; background: red">Post</button>
                                    </div>
                                </div>



                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
        <script>

        </script>
    </body>
</body>
</html>
