<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="DashBoard" admin="true">
<script src="/js/formControl.js"></script>
  <div id="wrapper">
    <sm:sidebarEnte/>
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
                <span class="mr-2 d-none d-lg-inline text-gray-600">${adminEnte.username}</span>
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
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
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
                        Guadagni Ente (Mensili)
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">$400,000</div>
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
                        Guadagni Ente (Annuali)
                      </div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800">$2 015,000</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks
                      </div>
                      <div class="row no-gutters align-items-center">
                        <div class="col-auto">
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">80%</div>
                        </div>
                        <div class="col">
                          <div class="progress progress-sm mr-2">
                            <div class="progress-bar bg-info" role="progressbar"
                                 style="width: 50%" aria-valuenow="80" aria-valuemin="0"
                                 aria-valuemax="100"></div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
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
                      <div class="h5 mb-0 font-weight-bold text-gray-800">58</div>
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
                  <h6 class="m-0 font-weight-bold text-primary">Nuovo Lido?</h6>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <p>Aggiungi un nuovo lido alla piattaforma con relativo responsabile</p>
                  <a href="mostraCreaLido" class="btn-primary btn-lg">Aggiungi</a>
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
                    <h6 class="m-0 font-weight-bold text-primary">Affluenza Settimanale Totale</h6>
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
                            <div class="visit">642</div>
                            <div class="percentage">
                              <div class="progress">
                                <div class="progress-bar color-1" role="progressbar" style="width: 80%"
                                     aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>

                          <div class="table-row">
                            <div class="country" style="margin: 10px">Marted&igrave;</div>
                            <div class="visit">5032</div>
                            <div class="percentage">
                              <div class="progress">
                                <div class="progress-bar color-2" role="progressbar" style="width: 30%"
                                     aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>
                          <div class="table-row">

                            <div class="country" style="margin: 10px">Mercoled&igrave;</div>
                            <div class="visit">32</div>
                            <div class="percentage">
                              <div class="progress">
                                <div class="progress-bar color-3" role="progressbar" style="width: 55%"
                                     aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>
                          <div class="table-row">

                            <div class="country" style="margin: 10px">Gioved&igrave;</div>
                            <div class="visit">503</div>
                            <div class="percentage">
                              <div class="progress">
                                <div class="progress-bar color-4" role="progressbar" style="width: 60%"
                                     aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>
                          <div class="table-row">

                            <div class="country" style="margin: 10px">Venerd&igrave;</div>
                            <div class="visit">632</div>
                            <div class="percentage">
                              <div class="progress">
                                <div class="progress-bar color-5" role="progressbar" style="width: 40%"
                                     aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>
                          <div class="table-row">

                            <div class="country" style="margin: 10px">Sabato</div>
                            <div class="visit">555</div>
                            <div class="percentage">
                              <div class="progress">
                                <div class="progress-bar color-6" role="progressbar" style="width: 70%"
                                     aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
                              </div>
                            </div>
                          </div>
                          <div class="table-row">

                            <div class="country" style="margin: 10px">Domenica</div>
                            <div class="visit">4502</div>
                            <div class="percentage">
                              <div class="progress">
                                <div class="progress-bar color-7" role="progressbar" style="width: 30%"
                                     aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
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

            <div class="col-lg-6 mb-4">

              <!-- Illustrations -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Rimuovi un lido dalla piattaforma</h6>
                </div>
                <div class="card-body">
                  <c:forEach items="${lidiEnte}" var="lido">
                    <div class="row md-1 gray-bg d-inline">
                      <div class="col">
                        <p>${lido.nome}, ${lido.indirizzo}, ${lido.email}</p>
                      </div>
                      <div class="col">
                        <a name="deleteLido" id="deleteLido" href="rimuoviLido?id=${lido.id}" onclick="return confirm('Sei sicuro di voler rimuovere il lido?')">Rimuovi ${lido.nome}</a>
                      </div>
                    </div>
                  </c:forEach>
                  <div id="confirm" class="modal">
                    <div class="modal-body">
                      Sei sicuro di voler eliminare questo Lido dalla piattaforma?
                    </div>
                    <div class="modal-footer">
                      <button type="button" data-dismiss="modal" class="btn-primary btn-lg" id="delete">Elimina lido</button>
                      <button type="button" data-dismiss="modal" class="btn-lg">Annulla</button>
                    </div>
                  </div>
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
