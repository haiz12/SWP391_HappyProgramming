<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPDATE NEWS</title>
        <link rel="stylesheet" href="fontawesome/css/all.min.css"> <!-- https://fontawesome.com/ -->
        <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet"> <!-- https://fonts.google.com/ -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/UserDetailStyle.css" rel="stylesheet">
        <link href="css/UserDetail.css" rel="stylesheet" />
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/6/tinymce.min.js" referrerpolicy="origin"></script>
        <script src="https://cdn.jsdelivr.net/npm/@tinymce/tinymce-jquery@2/dist/tinymce-jquery.min.js"></script>
    </head>
    <body>
        <div class="container h-100">
            <div class="row d-flex justify-content-around align-items-center h-100">
                <div class="col-xl-9 col-lg-8 col-xl-5 offset-xl-1">       
                    <form method="POST" action="updatenews" enctype="multipart/form-data" style="margin-top: 30px" id="form">
                        <div class="card" style="border-radius: 15px;">
                            <h1 class="mb-4" style="text-align: center; margin-top: 20px">UPDATE NEWS</h1>
                            <div class="card-body">
                                <input type="text" name="newsID" value="${news.getNewsID()}" style="display:none; ">
                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">             
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <p style="color: red; text-align: right">(*) is required</p>                                                    
                                    </div>
                                </div>

                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="blogtitle">News Title <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <input type="text" name="blogtitle" id="blogtitle" class="form-control form-control-lg" value="${news.getTitle()}" required>
                                    </div>
                                </div>
                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="Summary">Summary <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <input type="text" name="Summary" id="Summary" class="form-control form-control-lg" value="${news.getSummary()}" required>
                                    </div>
                                </div>

                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-2 ps-5">
                                        <label class="form-label" for="ndays">Day <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-2 pe-5">
                                        <input type="number" name="ndays" id="ndays" class="form-control form-control-lg" value="${news.getEventday()}" required min="1" max="31">
                                        <p id="ndays-error" style="color: red; display: none;">Please enter a day between 1 and 31.</p>
                                    </div>


                                    <div class="col-md-2 ps-5">
                                        <label class="form-label" for="nmonth">Month <label style="color: red">*</label></label>                  
                                    </div>
                                    <div class="col-md-2 pe-5">


                                        <select name="nmonth" id="nmonth" class="form-control form-control-lg" required>
                                            <option value="">Select Month</option>
                                            <option value="January" ${news.getMonthdate().equals("January") ? "selected" : ""}>Jan</option>
                                            <option value="February" ${news.getMonthdate().equals("February") ? "selected" : ""}>Feb</option>
                                            <option value="March" ${news.getMonthdate().equals("March") ? "selected" : ""}>Mar</option>
                                            <option value="April" ${news.getMonthdate().equals("April") ? "selected" : ""}>Apr</option>
                                            <option value="May" ${news.getMonthdate().equals("May") ? "selected" : ""}>May</option>
                                            <option value="June" ${news.getMonthdate().equals("June") ? "selected" : ""}>Jun</option>
                                            <option value="July" ${news.getMonthdate().equals("July") ? "selected" : ""}>Jul</option>
                                            <option value="August" ${news.getMonthdate().equals("August") ? "selected" : ""}>Aug</option>
                                            <option value="September" ${news.getMonthdate().equals("September") ? "selected" : ""}>Sep</option>
                                            <option value="October" ${news.getMonthdate().equals("October") ? "selected" : ""}>Oct</option>
                                            <option value="November" ${news.getMonthdate().equals("November") ? "selected" : ""}>Nov</option>
                                            <option value="December" ${news.getMonthdate().equals("December") ? "selected" : ""}>Dec</option>
                                        </select>


                                    </div>
                                    <div class="col-md-2 ps-5">
                                        <label class="form-label" for="nyear">Year <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-2 pe-5">
                                        <input type="number" name="nyear" id="nyear" class="form-control form-control-lg" value="${news.getYeardate()}" required min="2024">
                                        <p id="nyear-error" style="color: red; display: none;">Please enter a year greater than or equal to 2024.</p>
                                    </div>
                                </div>

                                <!-- Additional fields -->
                                <div class="row align-items-center py-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="currentCoverImage">Current Cover Image:</label><br>                                
                                    </div>        
                                    <div class="col-md-9 pe-5">
                                        <img src="${news.getImageURL()}" alt="Current Cover Image" class="img-fluid" style="max-width: 100%; height: auto;">     
                                        <p style="color: red">${ERR}</p>
                                    </div>
                                </div>

                                <div class="row align-items-center py-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="coverimage">Cover Image</label><br>                                
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <input type="file" name="coverimage" id="coverimage">
                                        <p style="color: red">${requestScope.ERR}</p>
                                    </div>
                                </div>   

                                <div class="row align-items-center pt-4 pb-3">
                                    <div class="col-md-3 ps-5">
                                        <label class="form-label" for="content">Content <label style="color: red"></label></label>                  
                                    </div>
                                    <div class="col-md-9 pe-5">
                                        <textarea id="content" value="${news.getContent()}" name="content"  class="form-control form-control-lg" rows="5" required></textarea>
                                    </div>
                                </div> 

                                <div class="row align-items-center py-3" style="display: flex;justify-content: end"> 
                                    <div class="col-md-3 ps-5">
                                        <button type="submit" value="0" class="btn btn-primary btn-lg" onclick="confirm('Are you sure to update this blog')" style="color: white; background: red">Post</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            // JavaScript code for validation
            document.getElementById("ndays").addEventListener("input", function () {
                var inputValue = parseInt(this.value);
                var daysError = document.getElementById("ndays-error");
                if (inputValue < 1 || inputValue > 31) {
                    daysError.style.display = "block";
                } else {
                    daysError.style.display = "none";
                }
            });

            document.getElementById("nyear").addEventListener("input", function () {
                var inputValue = parseInt(this.value);
                var yearError = document.getElementById("nyear-error");
                if (inputValue < 2024) {
                    yearError.style.display = "block";
                } else {
                    yearError.style.display = "none";
                }
            });
        </script>
    </body>
</html>
