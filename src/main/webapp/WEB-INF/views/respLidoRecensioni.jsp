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
              <h2 class="mb-30">RECENSIONI del lido ${lido.nome}</h2>
            </div>
            <c:forEach items="${mapRecensioni}" var="entry">
              <article class="blog_item">
                <div class="blog_details inline_div" >
                  <div class="row">
                    <div class="col-md-3 text-center">
                      <i class="fa fa-user-circle"></i>
                      <h4 class="list-group-item-heading"> <c:out value="${entry.value}"/> </h4>
                    </div>
                    <div class="col-md-6">
                      <h4 class="list-group-item-heading"> Contenuto </h4>
                      <p class="list-group-item-text">
                        <c:out value="${entry.key.contenuto}"/>

                      </p>
                    </div>
                    <div class="col-md-3 text-center">
                      <h4 class="list-group-item-heading"> Giudizio </h4>
                      <div class="">
                        <c:forEach begin="1" end="${entry.key.giudizio}" step="1" varStatus="loop">
                          <i class="fas fa-star"></i>
                        </c:forEach>
                      </div>
                    </div>
                    <div class="col-md-3">
                      <a class="btn-lg btn-primary" href="cancellaRecensione?id=${entry.key.id}">Cancella recensione</a>
                    </div>
                  </div>
                </div>
              </article>
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
