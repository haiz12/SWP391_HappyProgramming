<%-- 
    Document   : login
    Created on : Jan 8, 2024, 9:26:26 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
        <!-- ***** Preloader Start ***** -->
        <div id="js-preloader" class="js-preloader">
            <div class="preloader-inner">
                <span class="dot"></span>
                <div class="dots">
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </div>
        </div>
        <!-- ***** Preloader End ***** -->
        <div class="wapper">
            <div class="back"><a href="home.jsp"><i class="fa fa-home" style="font-size: 24px;color: black;"></i></a></div>
            <form action="signin" method="post">
                <p style="text-align: center; color: green;"> ${messsucces}</p>
                <h1>Sign in</h1>
                <div class="input-box">
                    <input type="text" id="username" name="username" placeholder="Username" required>   
                </div>    
                <div class="input-box">
                    <input type="password" id="password" name="password" placeholder="Password" required>   
                </div> 
                <p style="margin-bottom: 10px;color: red;font-size: large">${mess}</p>
                <div class="remember">
                    <label style="text-align: left;font-size: small"><input type="checkbox" id="remember" name="remember pass" >Remember password</label> 
<!--                    <a href="reset-password" style="font-size: small">Reset password</a> -->
                </div>

                <button class="button" type="submit" name="signup">
                    LOGIN
                </button>
                <div class="resiter-link">
                    <p>Forgot your password ? </p> <a href="reset-password" style="font-size: small"> click to reset</a> 
                </div>
                <div class="resiter-link">
                    <p>Don't have an account? </p>
                    <a ><a href="signup" >Register</a>
                </div>

            </form>

        </div>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var usernameInput = document.getElementById('username');
                var passwordInput = document.getElementById('password');
                var rememberCheckbox = document.getElementById('remember');

                // Kiểm tra xem có cookies đã lưu không
                var savedUsername = getCookie('savedUsername');
                var savedPassword = getCookie('savedPassword');

                if (savedUsername && savedPassword) {
                    usernameInput.value = savedUsername;
                    passwordInput.value = savedPassword;
                    rememberCheckbox.checked = true;
                }
            });

            function login() {
                var username = usernameInput.value;
                var password = passwordInput.value;

                if (rememberCheckbox.checked) {
                    // Lưu thông tin đăng nhập vào cookies trong 30 ngày
                    setCookie('savedUsername', username, 30);
                    setCookie('savedPassword', password, 30);
                } else {
                    // Nếu không nhớ mật khẩu, xóa cookies
                    eraseCookie('savedUsername');
                    eraseCookie('savedPassword');
                }

                // Thực hiện xử lý đăng nhập
            }

// Hàm để lấy cookie
            function getCookie(name) {
                var nameEQ = name + "=";
                var ca = document.cookie.split(';');
                for (var i = 0; i < ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) == ' ')
                        c = c.substring(1, c.length);
                    if (c.indexOf(nameEQ) == 0)
                        return c.substring(nameEQ.length, c.length);
                }
                return null;
            }

// Hàm để thiết lập cookie
            function setCookie(name, value, days) {
                var expires = "";
                if (days) {
                    var date = new Date();
                    date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
                    expires = "; expires=" + date.toUTCString();
                }
                document.cookie = name + "=" + (value || "") + expires + "; path=/";
            }

// Hàm để xóa cookie
            function eraseCookie(name) {
                document.cookie = name + '=; Max-Age=-99999999;';
            }


        </script>
    </body>
</html>
