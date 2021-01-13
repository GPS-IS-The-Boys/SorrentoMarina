<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Dashboard" admin="true">
  <div id="wrapper">
    <sm:sidebar/>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column ">

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
                <img class="img-profile rounded-circle"
                     src="/images/sorrentoMarina.png">
              </a>
              <!-- Dropdown - User Information -->
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <div class="container">
          <div class="row">
            <div class="col-lg-8 mb-5 mb-lg-0">
              <!-- Form di ricerca -->
              <div class="title">
                <h2 class="mb-30">Disponibilit&agrave; attuale del tuo lido </h2>
                <p>Puoi dare un occhiata al numero di ombrelloni occupati in base al periodo</p>
              </div>
                <form action="mostraDisponibilita" method="get">
                  <div class="row m-1">
                    <div class="col m-1">
                      <label for="dataInizio">Data di inizio intervallo</label>
                      <input id="dataInizio" name="dataInizio" type="date" class="date form-control">
                    </div>
                    <div class="col m-1">
                      <label for="dataFine">Data di fine intervallo</label>
                      <input id="dataFine" name="dataFine" type="date" class="date form-control">
                    </div>
                    <div class="col m-1">
                      <button type="submit" class="btn-block btn-primary py-2">Mostra i risultati</button>
                    </div>
                  </div>
                </form>

            </div>

          </div>
          <div class="row m-1">
                <c:choose>
                  <c:when test="${ombrelloni == null}">
                    <p>
                      Abbiamo controllato le prenotazioni per il lido <c:out value="${lido.nome}"/>.<br>
                      Non ci sono ombrelloni attualmente occupati :(
                    </p>
                  </c:when>
                  <c:when test="${ombrelloni != null}">
                    <p>
                      Abbiamo controllato le prenotazioni per il lido <c:out value="${lido.nome}"/>.<br>
                      Nel periodo da te scelto ci sono <c:out value="${size}"/> ombrelloni occupati<br>
                    </p>

                    <c:forEach var="ombrellone" items="${ombrelloni}">
                      <div class="row m1">
                        <i class="fa fa-umbrella-beach"></i>
                        POSTO riga:${ombrellone.num_righe}, colonna:${ombrellone.num_colonne}<br>
                      </div>
                    </c:forEach>
                  </c:when>
                </c:choose>
        </div>

      </div>

    </div>

  </div>

</div>

</sm:layout>
