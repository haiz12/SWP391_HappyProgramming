<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="css/style_rate.css"/>
        <title>Happy Programing</title>
        <style>
            .btn.cancel {
                background-color: #ff0000; /* Red background color */
                color: #ffffff; /* White text color */
                border: none; /* No border */
                padding: 10px 20px; /* Padding around the text */
                text-decoration: none; /* Remove underline from link */
                cursor: pointer; /* Change cursor to pointer on hover */
            }

            .btn.cancel:hover {
                background-color: #cc0000; /* Darker red background color on hover */
            }

        </style>
    </head>
    <body>
        <div class="wrapper">
            <div class="back"><a href="listrequest"><i class="fa fa-home" style="font-size: 24px;color: black; margin-left: -95%;"></i></a></div>

            <p style="text-align: center; color: green;"> ${messsuccess}</p> 
            <p style="text-align: center; color: red;"> ${messerror}</p> 
            <p style="text-align: center; color: red;"> ${errorM}</p> 
            <p style="text-align: center; color: red;"> ${errorMess}</p> 
            <h3>Rating form</h3>
            <form action="rate?idrequest=${idreq}&idMentor=${req}&idMentee=${idreqd}" method="post">
                <div class="rating">                  
                    <input type="number" name="rating" hidden value="${rate.star}">
                    <i class='bx bx-star star' style="--i: 1;"></i>
                    <i class='bx bx-star star' style="--i: 2;"></i>
                    <i class='bx bx-star star' style="--i: 3;"></i>
                    <i class='bx bx-star star' style="--i: 4;"></i>
                    <i class='bx bx-star star' style="--i: 5;"></i>
                </div>
                <textarea name="opinion" cols="30" rows="5">${rate.comment}</textarea>
                <div class="btn-group">
                    <button type="submit" class="btn submit">Submit</button>
                    <button class="btn cancel"><a href="listrequest">Cancel</a></button>
                </div>
            </form>

        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const allStar = document.querySelectorAll('.rating .star');
                const ratingValue = document.querySelector('.rating input');

                allStar.forEach((item, idx) => {
                    item.addEventListener('click', function () {
                        let click = 0;
                        ratingValue.value = idx + 1;

                        allStar.forEach(i => {
                            i.classList.replace('bxs-star', 'bx-star');
                            i.classList.remove('active');
                        });

                        for (let i = 0; i < allStar.length; i++) {
                            if (i <= idx) {
                                allStar[i].classList.replace('bx-star', 'bxs-star');
                                allStar[i].classList.add('active');
                            } else {
                                allStar[i].style.setProperty('--i', click);
                                click++;
                            }
                        }
                    });
                });
            });
        </script>
    </body>
</html>
