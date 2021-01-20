<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
          <div class="blog_center_sidebar">
            <div class="title">
              <h2 class="mb-30">ANNUNCI del lido ${lido.nome}</h2>
              <p>${messaggio}</p>
            </div>
            <c:forEach items="${listaAnnunci}" var="annuncio">
              <div class="row md-1">
                <h2>
                  <i class="fa fa-ad"></i>${annuncio.titolo}
                </h2>
              </div>
              <div class="row md-1">
                <div class="col-sm-1">
                  <img class="img-fluid" width="240" height="320" src="${annuncio.foto}" alt="">
                </div>
                <div class="col-sm-9">
                  <p>${annuncio.contenuto}</p>
                </div>
              </div>
              <div class="row md-1">
                <a href="cancellaAnnuncio?id=${annuncio.id}" class="btn-primary btn-lg" style="margin: 5px">Cancella
                  annuncio</a>
                <a class="btn-lg btn-primary" data-toggle="collapse" name="modifica${annuncio.id}"
                   href="#collapseModifica${annuncio.id}"
                   style="margin: 5px" role="button"
                   aria-expanded="false" aria-controls="collapseModifica${annuncio.id}">
                  Modifica annuncio
                </a>
              </div>
              <div class="row md-1">
                <div class="collapse" id="collapseModifica${annuncio.id}">
                  <form method="post" name="ModificaAnnuncio" action="modificaAnnuncio">
                    <div class="form-row m-1">
                      <input type="hidden" name="id" id="id" value="${annuncio.id}">
                      <input type="text" name="titolo" value="${annuncio.titolo}"
                             class="form-control bg-white " id="titolo" placeholder="Titolo" required>
                    </div>
                    <div class="form-row m-1">
                      <input type="text" name="foto" value="${annuncio.foto}"
                             class="form-control bg-white" id="foto" placeholder="/images/logo.jpg">
                    </div>
                    <div class="form-row m-1">
                          <textarea class="form-control" maxlength="256" name="contenuto" id="contenuto" rows="5"
                                    placeholder="Aggiungi il contenuto dell'annuncio">${annuncio.contenuto}</textarea>
                    </div>
                    <div class="form-row m-1">
                      <div class="form-group col-lg-12 mx-auto mb-0">
                        <button type="submit" class="btn-primary btn-primary py-2" style="border-radius: 5px">
                          Modifica
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
              </div>
            </c:forEach>
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
