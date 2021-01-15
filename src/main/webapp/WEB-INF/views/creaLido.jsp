<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sm:layout title="Aggiunta Lido" admin="true">
  <script src="<c:url value="/js/formControl.js"/>"></script>
  <link href="<c:url value="/css/formRegister.css"/>" type="text/css">
  <sm:header/>
  <div class="container">

    <div class="row md-1">
      <p>
      Aggiunta di un nuovo lido<i class="fa fa-umbrella-beach"></i><br>
        Compila tutti i campi per aggiungere un nuovo lido alla piattaforma con relativo responsabile
      </p>
      <p>${messaggio}</p>
    </div>
    <form action="creaLido" method="post">
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
              <input type="text" name="nomeLido"
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
              <input type="text" name="indirizzoLido"
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
                     name="emailLido" placeholder="Email del lido" required id="emailLido">
            </div>

            <!-- Telefono -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-phone text-muted"></i>
                            </span>
              </div>
              <input type="tel" name="telefonoLido"
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
              <input type="text" name="logoLido"
                     class="form-control bg-white border-left-0 border-md" placeholder="/images/logo.jpg"
                     id="logoLido">
            </div>

            <!-- Prezzo Singolo Ombrellone -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-star text-muted"></i>
                            </span>
              </div>
              <input type="number" class="form-control bg-white border-left-0 border-md" name="prezzoLido"
                     placeholder="Prezzo del singolo ombrellone" required id="prezzoLido">
            </div>

            <!-- num righe -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-columns text-muted"></i>
                            </span>
              </div>
              <input type="number" class="form-control bg-white border-left-0 border-md" name="righeLido"
                     placeholder="Righe di ombrelloni" required id="righeLido">
            </div>

            <!-- num colonne -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-columns text-muted"></i>
                            </span>
              </div>
              <input type="number" class="form-control bg-white border-left-0 border-md" name="colonneLido"
                     placeholder="Colonne di ombrelloni" required id="colonneLido">
            </div>


            <!-- Divider Text -->
            <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
              <div class="border-bottom w-100 ml-5"></div>
              <span class="px-2 small text-muted font-weight-bold text-muted">Aggiungi i servizi</span>
              <div class="border-bottom w-100 mr-5"></div>
            </div>

            <!-- Sei già registrato -->
            <div class="row">
              <ul class="list-group list-group-flush">
                <li class="list-group-item">
                  <!-- Default checked -->
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="servizio1" name="servizio1">
                    <label class="custom-control-label" for="servizio1">Bar</label>
                  </div>
                </li>
                <li class="list-group-item">
                  <!-- Default checked -->
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="servizio2" name="servizio2">
                    <label class="custom-control-label" for="servizio2">Ristorante</label>
                  </div>
                </li>
                <li class="list-group-item">
                  <!-- Default checked -->
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="servizio3" name="servizio3">
                    <label class="custom-control-label" for="servizio3">Animazione</label>
                  </div>
                </li>
                <li class="list-group-item">
                  <!-- Default checked -->
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="servizio4" name="servizio4">
                    <label class="custom-control-label" for="servizio4">Wi-fi</label>
                  </div>
                </li>
                <li class="list-group-item">
                  <!-- Default checked -->
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="servizio5" name="servizio5">
                    <label class="custom-control-label" for="servizio5">Cabina</label>
                  </div>
                </li>
                <li class="list-group-item">
                  <!-- Default checked -->
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="servizio6" name="servizio6">
                    <label class="custom-control-label" for="servizio6">Beach Volley</label>
                  </div>
                </li>
                <li class="list-group-item">
                  <!-- Default checked -->
                  <div class="custom-control custom-checkbox">
                    <input type="checkbox" class="custom-control-input" id="servizio7" name="servizio7">
                    <label class="custom-control-label" for="servizio7">Canoa</label>
                  </div>
                </li>

              </ul>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="row">
            <p>
              Compila tutti i campi:
              <br>*username di almeno 6 caratteri.
              <br>*password di almeno 8 caratteri (almeno una maiuscola ed un numero).
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
              <input type="text" name="nomeResp"
                     class="form-control bg-white border-left-0 border-md" id="nomeResp"
                     placeholder="Nome Responsabile lido" required>
            </div>

            <!-- Cognome -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
              </div>
              <input type="text" name="cognomeResp"
                     class="form-control bg-white border-left-0 border-md" id="cognomeResp"
                     placeholder="Cognome Responsabile lido" required>
            </div>

            <!-- Email Address -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-envelope text-muted"></i>
                            </span>
              </div>
              <input type="email" class="form-control bg-white border-left-0 border-md"
                     name="emailResp" placeholder="Email Responsabile lido" required id="emailResp">
            </div>

            <!-- Username -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-user text-muted"></i>
                            </span>
              </div>
              <input type="text" name="usernameResp"
                     class="form-control bg-white border-left-0 border-md" id="usernameResp"
                     placeholder="Username Responsabile lido" required>
            </div>

            <!-- Password -->
            <div class="input-group col-lg-6 mb-4">
              <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
              </div>
              <input type="password" name="passwordResp" oninput="validaPassword()"
                     class="form-control bg-white border-left-0 border-md" placeholder="Password Responsabile lido"
                     required
                     id="passwordResp">
            </div>


          </div>
        </div>
      </div>
      <div class="row" style="margin: 15px">
        <div class="form-group col-lg-12 mx-auto mb-0">
          <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Crea il lido</button>
        </div>
      </div>
    </form>
  </div>
  <sm:footer/>
</sm:layout>