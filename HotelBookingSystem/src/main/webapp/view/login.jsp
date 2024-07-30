<!doctype html>
<html class="no-js" lang="">


<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>EasyBook | Login and Register Form Html Templates</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
     <!-- Custom CSS -->
    <link rel="stylesheet" href="css/authstyle.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/fontawesome-all.min.css">
    <!-- Flaticon CSS -->
    <link rel="stylesheet" href="fonts/flaticon.css">
    <!-- Google Web Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&amp;display=swap" rel="stylesheet">
   
    
</head>

<body>
    <section class="fxt-template-animation fxt-template-layout33">
        <div class="fxt-content-wrap">
            <div class="fxt-heading-content">
                <div class="fxt-inner-wrap fxt-transformX-R-50 fxt-transition-delay-3">
                    <div class="fxt-transformX-R-50 fxt-transition-delay-10">
                        <a href="login.html" class="fxt-logo"><img src="images/logo.png" alt="Logo"></a>
                    </div>
                    <div class="fxt-transformX-R-50 fxt-transition-delay-3">
                        <div class="fxt-middle-content">
                            <div class="fxt-sub-title">Welcome to</div>
                            <h1 class="fxt-main-title">We're a Hotel Booking Platform.</h1>
                            <p class="fxt-description">We are glad to see you again! Get access to your Booking, Wishlist and Recommendations.</p>
                        </div>
                    </div>
                    <div class="fxt-transformX-R-50 fxt-transition-delay-3">
                        <div class="fxt-switcher-description">Don't have an account?<a href="register.html" class="fxt-switcher-text">Register</a></div>
                    </div>
                </div>
            </div>
            <div class="fxt-form-content">
                <div class="fxt-main-form">
                    <div class="fxt-inner-wrap fxt-opacity fxt-transition-delay-1">
                        <h2 class="fxt-page-title">Log In</h2>
                        <p class="fxt-description">Log In to try our amazing services</p>
                        <%
    String error = request.getParameter("error");
    if (error != null && !error.isEmpty()) {
    %>
        <p style="color: red;">Invalid username or password.</p>
    <%
    }
    %>
    
    <%
    String logout = request.getParameter("logout");
    if (logout != null && !logout.isEmpty()) {
    %>
        <p style="color: green;">You have been logged out successfully.</p>
    <%
    }
    %>
                        <form method="POST" action="<%= request.getContextPath() %>/perform_login">
                            <div class="form-group">
                                <label for="email" class="fxt-label">Email Address</label>
                                <input type="email" id="email" class="form-control" name="userEmail" placeholder="Enter your email" required="required" >
                            </div>
                            <div class="form-group">
                                <label for="password" class="fxt-label">Password</label>
                                <input id="password" type="password" class="form-control" name="userpassword" placeholder="Enter Password" required="required">
                            </div>
                            <div class="form-group">
                                <a href="forgotPassword.html" class="fxt-switcher-text">Forgot Password ?</a>
                            </div>
                            <div class="form-group mb-3">
                                <input type="submit" class="fxt-btn-fill" value="Log in">
                            </div>
                        </form>
                        <div class="fxt-divider-text">OR</div>
                        <div id="fxt-login-option" class="fxt-login-option">
                            <ul>
                                <li class="fxt-google active">
                                    <a href="#">
                                        <span class="fxt-option-icon"><i class="fab fa-google"></i></span>
                                        <span class="fxt-option-text ml-2">Continue with Google</span>
                                    </a>
                                </li>
                                <li class="fxt-facebook">
                                    <a href="#">
                                        <span class="fxt-option-icon"><i class="fab fa-facebook-f"></i></span>
                                        <span class="fxt-option-text ml-2">Continue with Facebook</span>
                                    </a>
                                </li>
                                <li class="fxt-apple">
                                    <a href="#">
                                        <span class="fxt-option-icon"><i class="fab fa-apple"></i></span>
                                        <span class="fxt-option-text ml-2">Continue with Apple</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- jquery-->
    <script src="js/jquery.min.js"></script>
    <!-- Bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Imagesloaded js -->
    <script src="js/imagesloaded.pkgd.min.js"></script>
    <!-- Validator js -->
    <script src="js/validator.min.js"></script>
    <!-- Custom Js -->
    <script src="js/main.js"></script>

</body>


</html>