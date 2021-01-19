<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!--caricamento pre-pagina
  <div id="preloader-active">
    <div class="preloader d-flex align-items-center justify-content-center">
      <div class="preloader-inner position-relative">
        <div class="preloader-circle"></div>
        <div class="preloader-img pere-text">
          <img src="<c:url value="/images/sorrentoMarina.png"/>" alt="">
        </div>
      </div>
    </div>
  </div>
-->
  <header id="page-top">
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
          </div>
        </div>
      </div>
      <div class="header-bottom  header-sticky">
        <div class="container">
          <div class="row align-items-center">
            <!-- Logo -->
            <div class="col-xl-2 col-lg-2 col-md-1">
              <div>
                <a href=""><img src="<c:url value="/images/sorrentoMarina.png"/>" width="120px" height="120px"
                                 alt=""></a>
              </div>
            </div>
            <div class="col-xl-10 col-lg-10 col-md-10">
              <!-- Main-menu -->
              <div class="main-menu f-right d-none d-lg-block">
                <nav>
                  <ul id="navigation">
                    <li><a href=".">Home</a></li>
                    <li><a href="info">Info</a></li>
                    <c:choose>
                      <c:when test="${utente != null}">
                        <li><a href="#">Account</a>
                          <ul class="submenu">
                            <li><p>Benvenuto ${utente.username}</p></li>
                            <li><a href="prenotazioniTurista">Le mie prenotazioni</a></li>
                            <li><a id="profilo" href="profilo">Il mio profilo</a></li>
                            <li><a name="logout" href="logout">logout</a></li>
                          </ul>
                        </li>
                      </c:when>
                      <c:when test="${adminLido != null}">
                        <li><a href="#">Account</a>
                          <ul class="submenu">
                            <li><p>Benvenuto ${adminLido.username}</p></li>
                            <li><a href="dashboard">Sezione Admin</a></li>
                            <li><a id="profilo" href="profilo">Il mio profilo</a></li>
                            <li><a name="logout" href="logout">logout</a></li>
                          </ul>
                        </li>
                      </c:when>
                      <c:when test="${adminEnte != null}">
                        <li><a href="#">Account</a>
                          <ul class="submenu">
                            <li><p>Benvenuto ${adminEnte.username}</p></li>
                            <li><a href="dashboardEnte">Sezione Admin</a></li>
                            <li><a id="profilo" href="profilo">Il mio profilo</a></li>
                            <li><a name="logout" href="logout">logout</a></li>
                          </ul>
                        </li>
                      </c:when>
                      <c:otherwise>
                        <li><a href="login">Login</a></li>
                        <li><a href="registrazione">Registrati</a></li>
                      </c:otherwise>
                    </c:choose>

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
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>
</header>