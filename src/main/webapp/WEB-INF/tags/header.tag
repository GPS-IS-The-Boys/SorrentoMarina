<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <!-- Header Start -->
    <div class="header-area">
        <div class="main-header ">
            <div class="header-top top-bg d-none d-lg-block">
                <div class="container">
                    <div class="row justify-content-between align-items-center">
                        <div class="col-lg-8">
                            <div class="header-info-left">
                                <ul>
                                    <li>sorrentoMarina@gmail.com</li>
                                    <li>0826 43 289</li>
                                    <li>Marina di Sorrento, Italy</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-4">
                            <div class="header-info-right f-right">
                                <ul class="header-social">
                                    <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                                    <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                    <li> <a href="#"><i class="fab fa-pinterest-p"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-bottom  header-sticky">
                <div class="container">
                    <div class="row align-items-center">
                        <!-- Logo -->
                        <div class="col-xl-2 col-lg-2 col-md-1">
                            <div class="logo">
                                <a href="#"><img src="<c:url value="/images/sorrentoMarina.png"/>" width="60px" height="60px" alt=""></a>
                            </div>
                        </div>
                        <div class="col-xl-10 col-lg-10 col-md-10">
                            <!-- Main-menu -->
                            <div class="main-menu f-right d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href=".">Home</a></li>
                                        <li><a href="">Info</a></li>
                                        <li><a href="#">Log in</a>
                                          <form method="post" action="" name="login">
                                            <ul class="submenu">
                                              <li style="margin-bottom: 2px">
                                                <label for="email"></label>
                                                <input type="email" id="email" name="e-mail" placeholder="E-mail"
                                                       onfocus="this.placeholder = ''" onblur="this.placeholder = 'E-mail'" required
                                                       class="single-input-primary">
                                              </li>
                                              <li style="margin-bottom: 2px">
                                                <label for="password"></label>
                                                <input type="password" id="password" name="password" placeholder="Password"
                                                       onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'" required
                                                       class="single-input-primary">
                                              </li>
                                              <li style="margin: 2px"><button type="submit" class="genric-btn default circle arrow">Login</button></li>
                                            </ul>
                                          </form>
                                        </li>
                                        <li><a href="#">Pages</a>
                                            <ul class="submenu">
                                                <li><a href="#">Submenu</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">Registrati</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <!-- Mobile Menu -->
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->
</header>