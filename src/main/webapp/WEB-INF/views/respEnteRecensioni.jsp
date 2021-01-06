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
            <div class="col-xl-12 col-lg-12">
              <!-- Illustrations -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Lista delle recensioni per ogni lido della
                    piattaforma</h6>
                </div>
                <div class="card-body">
                  <c:forEach items="${mapRecensioni}" var="entry" varStatus="loop">#${loop.index+1}
                    <div class="row md-1">
                        <h3>Recensioni del lido: ${entry.key}</h3>
                    </div>
                      <c:forEach items="${entry.value}" var="rec">
                        <div class="row md-1">
                          <article class="blog_item">
                            <div class="blog_details inline_div">
                              <div class="row">
                                <div class="col-md-6">
                                  <h4 class="list-group-item-heading"> Contenuto </h4>
                                  <p class="list-group-item-text">
                                    <c:out value="${rec.contenuto}"/>
                                  </p>
                                </div>
                                <div class="col-md-3 text-center">
                                  <h4 class="list-group-item-heading"> Giudizio </h4>
                                  <div class="">
                                    <c:forEach begin="1" end="${rec.giudizio}" step="1" varStatus="loop">
                                      <i class="fas fa-star"></i>
                                    </c:forEach>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </article>
                        </div>
                      </c:forEach>
                  </c:forEach>
                </div>
              </div>
            </div>
          </div>
          <!-- chiusura row -->

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

  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

</sm:layout>
