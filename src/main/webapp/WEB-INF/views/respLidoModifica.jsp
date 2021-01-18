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
              <h2 class="mb-30">MODIFICA IL TUO LIDO</h2>
              <p class="mb-20">Cambia le caratteristiche del tuo lido con questo semplice form</p>
              <p>${messaggio}</p>
            </div>
            <form name="modificaLido" action="modificaLido" method="post">
              <div class="row md-1">
                <div class="col">
                  <div class="row">
                    <!-- Nome -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user-circle text-muted"></i>
                            </span>
                      </div>
                      <input type="text" name="nomeLido" value="${lido.nome}"
                             class="form-control bg-white border-left-0 border-md" id="nomeLido" placeholder="Nome del lido"
                             required>
                    </div>

                    <!-- Indirizzo -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-info text-muted"></i>
                            </span>
                      </div>
                      <input type="text" name="indirizzoLido" value="${lido.indirizzo}"
                             class="form-control bg-white border-left-0 border-md" id="indirizzoLido"
                             placeholder="Indirizzo del lido" required>
                    </div>

                    <!-- Email Address -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-envelope text-muted"></i>
                            </span>
                      </div>
                      <input type="email" class="form-control bg-white border-left-0 border-md"
                             value="${lido.email}"
                             name="emailLido" placeholder="Email del lido" required id="emailLido">
                    </div>

                    <!-- Telefono -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-phone text-muted"></i>
                            </span>
                      </div>
                      <input type="tel" name="telefonoLido" value="${lido.telefono}"
                             class="form-control bg-white border-left-0 border-md" id="telefonoLido"
                             placeholder="Telefono del lido" required>
                    </div>

                    <!-- Logo -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-landmark text-muted"></i>
                            </span>
                      </div>
                      <input type="text" name="logoLido" value="${lido.logo}"
                             class="form-control bg-white border-left-0 border-md" placeholder="Path del logo"
                             id="logoLido">
                    </div>

                    <!-- Prezzo Singolo Ombrellone -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-star text-muted"></i>
                            </span>
                      </div>
                      <input type="number" value="${lido.prezzo_singolo}" class="form-control bg-white border-left-0 border-md" name="prezzoLido"
                             placeholder="Prezzo del singolo ombrellone" required id="prezzoLido">
                    </div>

                    <!-- num righe -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-columns text-muted"></i>
                            </span>
                      </div>
                      <input type="number" value="${lido.num_righe}" class="form-control bg-white border-left-0 border-md" name="righeLido"
                             placeholder="Righe di ombrelloni" required id="righeLido">
                    </div>

                    <!-- num colonne -->
                    <div class="input-group col-lg-6 mb-4">
                      <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-columns text-muted"></i>
                            </span>
                      </div>
                      <input type="number" value="${lido.num_colonne}" class="form-control bg-white border-left-0 border-md" name="colonneLido"
                             placeholder="Colonne di ombrelloni" required id="colonneLido">
                    </div>


                    <!-- Divider Text -->
                    <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
                      <div class="border-bottom w-100 ml-5"></div>
                      <span class="px-2 small text-muted font-weight-bold text-muted">Aggiungi o rimuovi servizi</span>
                      <div class="border-bottom w-100 mr-5"></div>
                    </div>

                    <!-- Sei già registrato -->
                    <div class="row md-2">
                      <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                          <!-- Default checked -->
                          <div class="custom-control custom-checkbox">
                            <input type="checkbox" <c:if test="${servizi.bar == true}"> checked </c:if>
                                   class="custom-control-input" id="servizio1" name="servizio1">
                            <label class="custom-control-label" for="servizio1">Bar</label>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <!-- Default checked -->
                          <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input"
                            <c:if test="${servizi.ristorante == true}"> checked </c:if>
                                    id="servizio2" name="servizio2">
                            <label class="custom-control-label" for="servizio2">Ristorante</label>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <!-- Default checked -->
                          <div class="custom-control custom-checkbox">
                            <input type="checkbox"
                            <c:if test="${servizi.animazione == true}"> checked </c:if>
                                   class="custom-control-input" id="servizio3" name="servizio3">
                            <label class="custom-control-label" for="servizio3">Animazione</label>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <!-- Default checked -->
                          <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input"
                            <c:if test="${servizi.wifi == true}"> checked </c:if>
                                   id="servizio4" name="servizio4">
                            <label class="custom-control-label" for="servizio4">Wi-fi</label>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <!-- Default checked -->
                          <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input"
                            <c:if test="${servizi.cabina == true}"> checked </c:if>
                                   id="servizio5" name="servizio5">
                            <label class="custom-control-label" for="servizio5">Cabina</label>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <!-- Default checked -->
                          <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input"
                            <c:if test="${servizi.beach_volley == true}"> checked </c:if>
                                   id="servizio6" name="servizio6">
                            <label class="custom-control-label" for="servizio6">Beach Volley</label>
                          </div>
                        </li>
                        <li class="list-group-item">
                          <!-- Default checked -->
                          <div class="custom-control custom-checkbox">
                            <input type="checkbox" class="custom-control-input"
                            <c:if test="${servizi.canoa == true}"> checked </c:if>
                                   id="servizio7" name="servizio7">
                            <label class="custom-control-label" for="servizio7">Canoa</label>
                          </div>
                        </li>

                      </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row" style="margin: 15px">
                <div class="form-group col-lg-12 mx-auto mb-0">
                  <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Modifica il lido</button>
                </div>
              </div>
            </form>
        </div>
      </div>
    </div>
  </div>

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

</sm:layout>
