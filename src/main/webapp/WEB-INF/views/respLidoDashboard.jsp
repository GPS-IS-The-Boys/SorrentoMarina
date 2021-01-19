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
                <img class="img-profile rounded-circle"
                     src="/images/sorrentoMarina.png">
              </a>
              <!-- Dropdown - User Information -->
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard Responsabile Lido: ${lido.nome}</h1>
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                        Guadagni (Mensili)
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">&euro;8,000</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                        Guadagni (Annuali)
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">&euro;195,000</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                        Prenotazioni effettuate attualmente
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">${size}</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-comments fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Crea un annuncio</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <p>${messaggio}</p>
                        <form method="post" name="CreazioneAnnuncioForm" action="creaAnnuncio">
                            <div class="form-row m-1">
                              <input type="text" name="titolo"
                                     class="form-control bg-white " maxlength="32" id="titolo" placeholder="Titolo" required>
                            </div>
                            <div class="form-row m-1">
                              <input type="text" name="foto"
                                     class="form-control bg-white" id="foto" placeholder="/images/logo.jpg">
                            </div>
                            <div class="form-row m-1">
                              <textarea class="form-control" maxlength="256" name="contenuto" id="contenuto" rows="5" placeholder="Aggiungi il contenuto dell'annuncio"></textarea>
                            </div>
                            <div class="form-row m-1">
                              <div class="form-group col-lg-12 mx-auto mb-0">
                                <button type="submit" class="btn-primary btn-primary py-2" style="border-radius: 5px">Aggiungi annuncio</button>
                              </div>
                            </div>
                        </form>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <!-- Card Body -->
                <div class="card-body">
                  <p>Il lido offre i seguenti servizi</p>
                        <c:if test="${serviziLido.bar}">
                      <div>
                        <i class="fas fa-coffee"></i>Bar
                      </div>
                      </c:if>
                      <c:if test="${serviziLido.ristorante}">
                        <div>
                          <i class="fas fa-pizza-slice"></i>Ristorante
                        </div>
                      </c:if>
                      <c:if test="${serviziLido.animazione}">
                        <div>
                          <i class="fas fa-gamepad"></i>Animazione
                        </div>
                      </c:if>
                      <c:if test="${serviziLido.wifi}">
                        <div>
                          <i class="fas fa-wifi"></i>Wi-Fi
                        </div>
                      </c:if>
                      <c:if test="${serviziLido.cabina}">
                        <div>
                          <i class="fas fa-home"></i>Cabina
                        </div>
                      </c:if>
                      <c:if test="${serviziLido.beach_volley}">
                        <div>
                          <i class="fas fa-volleyball-ball"></i>Beach-Volley
                        </div>
                      </c:if>
                      <c:if test="${serviziLido.canoa}">
                        <div>
                          <i class="fas fa-ship"></i>Canoa
                        </div>
                      </c:if>
                </div>
                </div>
            </div>
          </div>

          </div>

          <!-- Content Row -->
          <div class="row">
            <!-- Content Column -->
            <div class="col-lg-12 mb-4">

              <!-- Project Card Example -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Affluenza Settimanale Stimata</h6>
                </div>
                <div class="card-body">
                  <div class=section-top-border">
                    <div class="progress-table-wrap">
                      <div class="progress-table">
                        <div class="table-head">
                          <div class="country" style="margin: 10px">Giorni</div>
                          <div class="visit">Prenotazioni</div>
                          <div class="percentage">Grafico</div>
                        </div>
                        <div class="table-row">
                          <div class="country" style="margin: 10px">Luned&igrave;</div>
                          <div class="visit">42</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-1" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>

                        <div class="table-row">
                          <div class="country" style="margin: 10px">Marted&igrave;</div>
                          <div class="visit">32</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-2" role="progressbar" style="width: 20%" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Mercoled&igrave;</div>
                          <div class="visit">12</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-3" role="progressbar" style="width: 15%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Gioved&igrave;</div>
                          <div class="visit">50</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-4" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Venerd&igrave;</div>
                          <div class="visit">66</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-5" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Sabato</div>
                          <div class="visit">205</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-6" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                        <div class="table-row">

                          <div class="country" style="margin: 10px">Domenica</div>
                          <div class="visit">352</div>
                          <div class="percentage">
                            <div class="progress">
                              <div class="progress-bar color-7" role="progressbar" style="width: 90%" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  </div>
                </div>
              </div>
            </div>

          <div class="row">
            <div class="col">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Dati del Lido</h6>
                </div>
                <div class="card-body">
                  <p>
                    Nome Lido: ${lido.nome} <br>
                    Indirizzo: ${lido.indirizzo} <br>
                    Telefono: ${lido.telefono} <br>
                    E-mail: ${lido.email} <br>
                    Prezzo singolo posto: ${lido.prezzo_singolo} &euro;<br>
                    Righe di Ombrelloni: ${lido.num_righe} <br>
                    Colonne di Ombrelloni: ${lido.num_colonne} <br>
                  </p>

                </div>
              </div>
            </div>

            <div class="col">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Lista prenotazioni della piattaforma</h6>
                </div>
                <div class="card-body">
                  <c:forEach items="${mapPrenotazioni}" var="entry" varStatus="loop">#${loop.index+1}
                    <div class="row ">
                      <div class="col-xl-8 col-lg-8">
                        <p>Codice:${entry.codice} Da: ${entry.data_inizio}   a: ${entry.data_fine}, Costo: ${entry.costo}&euro;, Posti:${entry.num_posti}</p>
                      </div>
                    </div>
                  </c:forEach>

                </div>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; SorrentoMarina 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

</sm:layout>
