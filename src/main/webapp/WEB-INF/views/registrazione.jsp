<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sm:layout title="Registrazione" admin="false">
  <script src="<c:url value="/js/formControl.js"/>"></script>
  <link href="<c:url value="/css/formRegister.css"/>" type="text/css">

  <div class="container">
    <div class="row py-5 mt-4 align-items-center">
      <!--  -->
      <div class="col-md-5 pr-lg-5 mb-5 mb-md-0">
        <img src="<c:url value="/images/sorrentoMarina.png"/>" alt="" class="img-fluid mb-3 d-none d-md-block">
        <h1>Crea un Account</h1>
        <p class="font-italic text-muted mb-0">Usufruisci di tutti i servizi della piattaforma.</p>
      </div>

      <!-- Form -->
      <div class="col-md-7 col-lg-6 ml-auto">
        <form action="registrazione_account" name="registrazioneForm" id="registrazioneForm" method="post">
          <div class="row">
            <h2>Compila tutti i campi:</h2>
            <p>
              <br>*username di almeno 6 caratteri.
              <br>*password di almeno 8 caratteri (almeno una maiuscola ed un numero).
              <br>
              <br>
              <span id="registramimessaggio" style="color: red">${messaggio}</span>
            </p>
            <br>

          </div>
          <div class="row">

            <!-- Nome -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
              </div>
              <input type="text" name="nome" oninput="validaNome()"
                     class="form-control bg-white border-left-0 border-md" id="nome" placeholder="Nome" required>
            </div>

            <!-- Cognome -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
              </div>
              <input type="text" name="cognome" oninput="validaCognome()"
                     class="form-control bg-white border-left-0 border-md" id="cognome" placeholder="Cognome" required>
            </div>

            <!-- Email Address -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-envelope text-muted"></i>
                            </span>
              </div>
              <input type="email" class="form-control bg-white border-left-0 border-md" oninput="validaEmail()"
                     name="email" placeholder="Email address" required id="email">
            </div>

            <!-- Cognome -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
              </div>
              <input type="text" name="username" oninput="validaUsername()"
                     class="form-control bg-white border-left-0 border-md" id="username" placeholder="Username" required>
            </div>

            <!-- Password -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
              </div>
              <input type="password" name="password" oninput="validaPassword()"
                     class="form-control bg-white border-left-0 border-md" placeholder="Password" required
                     id="password">
            </div>

            <!-- Conferma Password -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
              </div>
              <input type="password" class="form-control bg-white border-left-0 border-md" name="passwordConferma"
                     placeholder="Conferma Password" required oninput="validaPassword()" id="confPassword">
            </div>

            <!-- Submit Button -->
            <div class="form-group col-lg-12 mx-auto mb-0">
                <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Crea il tuo account</button>
            </div>

            <!-- Divider Text -->
            <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
              <div class="border-bottom w-100 ml-5"></div>
              <span class="px-2 small text-muted font-weight-bold text-muted">OPPURE</span>
              <div class="border-bottom w-100 mr-5"></div>
            </div>

            <!-- Sei già registrato -->
            <div class="text-center w-100">
              <p class="text-muted font-weight-bold">Sei gi&agrave; registrato? <a href="login" class="text-primary ml-2">Login</a>
              </p>
            </div>
          </div>

        </form>
      </div>
    </div>
  </div>

  <sm:footer/>
</sm:layout>