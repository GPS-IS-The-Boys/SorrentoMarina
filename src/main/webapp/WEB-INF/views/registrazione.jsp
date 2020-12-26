<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sm:layout title="Registrazione" admin="false">
<sm:header/>
  <!-- slider Area Start-->
  <div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="slider-active">
      <div class="single-slider hero-overly  slider-height d-flex align-items-center" style="background-image: url('/images/sfondoSorrento.jpg')">
        <div class="container">
          <!-- Form Box -->
          <div class="row">
            <div class="col-xl-12">
              <!-- form -->
              <h2>Non sei registrato? Dai su ti stiamo aspettando!</h2>
              <h3>*Ricordati di riempire tutti i campi*</h3>
              <form action="avviaRegistrazione" name="registrazione" method="post">
                <div class="form-row">
                  <div class="form-group col-md-4">
                    <label for="username" style="color: black">Username</label>
                    <input type="text" name="username" oninput="validaUsername()" class="form-control" id="username">
                  </div>
                  <div class="form-group col-md-4">
                    <label for="email" style="color: black">Email</label>
                    <input type="email" class="form-control" oninput="validaEmail()" name="email"  id="email">
                  </div>
                </div>
                <div class="form-row">
                  <div class="form-group col-md-4">
                    <label for="password" style="color: black">Password (8 caratteri, maiuscola, cifra)</label>
                    <input type="password" name="password" oninput="validaPassword()" class="form-control" id="password">
                  </div>
                  <div class="form-group col-md-4">
                    <label for="confPassword" style="color: black">Conferma Password</label>
                    <input type="password" class="form-control" name="passwordConferma" oninput="validaPassword()" id="confPassword">
                  </div>
                </div>
                <div class="form-row">
                  <div class="form-group col-md-4">
                    <label for="nome" style="color: black">Nome</label>
                    <input type="text" name="nome" oninput="validaNome()" class="form-control" id="nome">
                  </div>
                  <div class="form-group col-md-4">
                    <label for="cognome" style="color: black">Cognome</label>
                    <input type="text" name="cognome" oninput="validaCognome()" class="form-control" id="cognome">
                  </div>
                </div>
                <div class="form-row">
                </div>
                <input id="registrami" class="btn-lg btn-light" type="submit" value="REGISTRAMI">
                <span id="registramimessaggio">${messaggio}</span>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- slider Area End-->
<sm:footer/>
</sm:layout>