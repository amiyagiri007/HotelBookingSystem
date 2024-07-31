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
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Fontawesome CSS -->
    <link rel="stylesheet" href="css/fontawesome-all.min.css">
    <!-- Flaticon CSS -->
    <link rel="stylesheet" href="fonts/flaticon.css">
    <!-- Google Web Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&amp;display=swap" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/authstyle.css">
</head>

<body>
    <section class="fxt-template-animation fxt-template-layout33">
        <div class="fxt-content-wrap">
            <div class="fxt-heading-content fxt-heading-content-register">
                <div class="fxt-inner-wrap fxt-transformX-R-50 fxt-transition-delay-3">
                    <div class="fxt-transformX-R-50 fxt-transition-delay-10">
                        <a href="login.html" class="fxt-logo"><img src="images/logo.png" alt="Logo"></a>
                    </div>
                    <div class="fxt-transformX-R-50 fxt-transition-delay-10">
                        <div class="fxt-middle-content">
                            <div class="fxt-sub-title">Welcome to</div>
                            <h1 class="fxt-main-title">We're a Hotel Booking Platform.</h1>
                            <p class="fxt-description">Register to get access to your Booking, Wishlist and Recommendations.</p>
                        </div>
                    </div>
                    <div class="fxt-transformX-R-50 fxt-transition-delay-10">
                        <div class="fxt-switcher-description">Don't have an account?<a href="login.html" class="fxt-switcher-text">Sign In</a></div>
                    </div>
                </div>
            </div>
            <div class="fxt-form-content">
                <div class="fxt-main-form">
                    <div class="fxt-inner-wrap fxt-opacity fxt-transition-delay-13">
                        <h2 class="fxt-page-title">Sign Up</h2>
                        <p class="fxt-description">Sign Up to try our amazing services</p>
                        <form id="signupForm" method="POST" action="register_process">
                            <div class="form-group">
                                <label for="name" class="fxt-label">Full Name</label>
                                <input type="text" id="name" class="form-control" name="username" placeholder="Enter your name" required="required">
                                <div class="invalid-feedback">Please enter your full name.</div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="fxt-label">Email Address</label>
                                <input type="email" id="email" class="form-control" name="userEmail" placeholder="Enter your email" required="required">
                                <div class="invalid-feedback">Please enter a valid email address.</div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="fxt-label">Password</label>
                                <input id="password" type="password" class="form-control" name="userpassword" placeholder="Enter Password" required="required">
                                <div class="invalid-feedback">Please enter your password (at least 6 characters).</div>
                            </div>
                            <div class="form-group">
                                <div class="fxt-checkbox-box">
                                    <input id="checkbox1" type="checkbox" required>
                                    <label for="checkbox1" class="ps-4">I agree with Terms of Service, Terms of Payments, and Privacy Policy</label>
                                    <div class="invalid-feedback">You must agree to the terms and conditions.</div>
                                </div>
                            </div>
                            <div class="form-group mb-3">
                                <button type="submit" class="fxt-btn-fill">Sign up</button>
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
