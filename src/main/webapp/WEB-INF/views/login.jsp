<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sm:layout title="Login" admin="false">
  <script src="<c:url value="/js/formControl.js"/>"></script>
  <link href="<c:url value="/css/formRegister.css"/>" type="text/css">

  <div class="container">
    <div class="row py-5 mt-4 align-items-center">
      <!--  -->
      <div class="col-md-5 pr-lg-5 mb-5 mb-md-0">
        <img src="<c:url value="/images/sorrentoMarina.png"/>" alt="" class="img-fluid mb-3 d-none d-md-block">
        <h1>Accedi al tuo account</h1>
        <p class="font-italic text-muted mb-1">Usufruisci di tutti i servizi della piattaforma.</p>
      </div>

      <!-- Form -->
      <div class="col-md-7 col-lg-6 ml-auto">
        <form action="login_account" name="LoginForm" id="LoginForm" method="post">
          <div class="row">
            <h2 style="margin-bottom: 5px">Inserisci le credenziali d'accesso</h2>
            <p class="font-italic text-muted mb-1">${messaggio}</p>
          </div>
          <div class="row">
            <!-- Username -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
              </div>
              <input type="text" name="username" class="form-control bg-white border-left-0 border-md" id="username" placeholder="Username" required>
            </div>

            <!-- Password -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
              </div>
              <input type="password" name="password"
                     class="form-control bg-white border-left-0 border-md" placeholder="Password" required
                     id="password">
            </div>

            <!-- Submit Button -->
            <div class="form-group col-lg-12 mx-auto mb-0">
              <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Accedi</button>
            </div>

            <!-- Divider Text -->
            <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
              <div class="border-bottom w-100 ml-5"></div>
              <span class="px-2 small text-muted font-weight-bold text-muted">OPPURE</span>
              <div class="border-bottom w-100 mr-5"></div>
            </div>

            <!-- Se non hai un account -->
            <div class="text-center w-100">
              <p class="text-muted font-weight-bold">Non hai un account? <a href="registrazione" class="text-primary ml-2">Registrati</a>
              </p>
            </div>
          </div>

        </form>
      </div>
    </div>
  </div>

  <sm:footer/>
</sm:layout>