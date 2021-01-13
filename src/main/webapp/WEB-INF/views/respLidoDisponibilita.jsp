<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="g" tagdir="/WEB-INF/tags" %>

<sm:layout title="DashBoard" admin="true">
  <div id="wrapper">
  <sm:sidebar/>
  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <!-- Nav Item - User Information -->
          <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <span class="mr-2 d-none d-lg-inline text-gray-600 small">${adminLido.username}</span>
              <img class="img-profile rounded-circle" alt="logo"
                   src="/images/sorrentoMarina.png">
            </a>
            <!-- Dropdown - User Information -->
          </li>

        </ul>

      </nav>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">
        <div class="title">
          <h2 class="mb-30">Disponibilit&agrave; attuale del tuo lido </h2>
          <p>Puoi dare un occhiata al numero di ombrelloni occupati in base al periodo</p>
          <p>In verde i posti liberi, in rosso quelli occupati</p>
        </div>

        <div class="container">
          <div class="row md-1">
            <div class="col-sm-auto">
              <label for="dataInizio">Data di inizio intervallo</label>
              <input id="dataInizio" type="date" class="date form-control">
            </div>
            <div class="col-sm-auto">
              <label for="dataFine">Data di fine intervallo</label>
              <input id="dataFine" type="date" class="date form-control">
            </div>
            <div class="row md-1">
              <button onclick="aggiornaDisponibilita()" type="submit" class="btn-primary">Cerca</button>
            </div>
          </div>
          <div class="row md-1">
            <div class="col-sm-auto">
              <h1>griglia</h1>

              <g:grid>
                <div style="padding: 0; margin: 0; width:800px ; height:600px;" >
                  <div class="jquery-script-clear"></div>
                  <div id="seat-map" style="margin-top: 0px">
                    <div class="front-indicator">OMBRELLONI DISPONIBILI</div>
                  </div>
                </div>
              </g:grid>
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

</sm:layout>
