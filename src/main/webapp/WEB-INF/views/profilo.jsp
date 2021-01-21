<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="HomePage" admin="false">
  <sm:header/>
  <div class="container m-1">
    <div class="row m-1">
      <p class="card-text">
        Questa &egrave; la sezione dedicata al tuo profilo.
        Puoi controllare i tuoi dati personali, modificare le tue credenziali e
        visualizzare le prenotazioni effettuate.
      </p>
    </div>
    <div class="row m-1">
      <div class="col-sm-6">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fa fa-lock"></i>Dati Personali</h5>
            <p class="card-text">
              <c:choose>
                <c:when test="${adminLido != null}">
                  Nome: ${adminLido.nome}
                  <br>Cognome: ${adminLido.cognome}
                  <br>Username: ${adminLido.username}
                  <br>E-mail: ${adminLido.email}
                </c:when>
                <c:when test="${adminEnte != null}">
                  Nome: ${adminEnte.nome}
                  <br>Cognome: ${adminEnte.cognome}
                  <br>Username: ${adminEnte.username}
                  <br>E-mail: ${adminEnte.email}
                </c:when>
                <c:when test="${utente != null}">
                  Nome: ${utente.nome}
                  <br>Cognome: ${utente.cognome}
                  <br>Username: ${utente.username}
                  <br>E-mail: ${utente.email}
                </c:when>
              </c:choose>
            </p>
          </div>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fa fa-chart-bar"></i>Storico Prenotazioni</h5>
            <p class="card-text">Vuoi visualizzare tutte le tue prenotazioni?</p>
            <a href="prenotazioniTurista" class="btn-primary btn-lg">Visualizza</a>
          </div>
        </div>
      </div>
    </div>
    <div class="row m-1">
      <div class="col-sm-12">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title"><i class="fa fa-user"></i>Modifica Credenziali</h5>
            <form action="modificaCredenziali" name="modificaCredenzialiForm" id="modificaCredenzialiForm"
                  method="post">
              <div class="row">
                <p class="card-text">Inserisci la vecchia password e la nuova
                  <br> *ricorda* la password di almeno 6 lettere, contenente almeno una maiuscola e un numero
                </p>
                <p class="card-text" a style="color: red">${messaggio}</p>
              </div>
              <div class="row">
                <!-- vecchia password -->
                <div class="input-group col-lg-6 mb-4">
                  <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock-open text-muted"></i>
                            </span>
                  </div>
                  <input type="password" name="oldPassword" class="form-control bg-white border-left-0 border-md"
                         id="oldPassword" placeholder="Password Attuale" required oninput="validaOldPassword()">
                </div>

                <!-- nuova password -->
                <div class="input-group col-lg-6 mb-4">
                  <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                  </div>
                  <input type="password" name="newPassword" oninput="validaNewPassword()"
                         class="form-control bg-white border-left-0 border-md" placeholder="Password Nuova" required
                         id="newPassword">
                </div>

                <!-- Submit Button -->
                <div class="form-group col-lg-12 mx-auto mb-0">
                  <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Modifica</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <c:choose>
      <c:when test="${adminLido != null}">
        <div class="row m-1">
          <div class="col-sm-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title"><i class="fa fa-user"></i>Dashboard</h5>
                <p class="card-text">Come responsabile lido puoi visualizzare tutte le statistiche del
                  tuo lido nella dashboard a te dedicata</p>
                <a href="dashboard" class="btn-primary btn-lg">Vai alla dashboard</a>
              </div>
            </div>
          </div>
        </div>
      </c:when>
      <c:when test="${adminEnte != null}">
        <div class="row m-1">
          <div class="col-sm-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title"><i class="fa fa-user"></i>Dashboard</h5>
                <p class="card-text">Come responsabile dell'ente puoi visualizzare le statistiche
                  di tutti i lidi della piattaforma nella dashboard a te dedicata </p>
                <a href="dashboardEnte" class="btn-primary btn-lg">Vai alla dashboard</a>
              </div>
            </div>
          </div>
        </div>
      </c:when>
    </c:choose>
  </div>
<script src="/js/formControl.js"></script>
  <sm:footer/>
</sm:layout>