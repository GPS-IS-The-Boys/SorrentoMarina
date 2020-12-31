<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="HomePage" admin="false">
  <sm:header/>
  <c:choose>
    <c:when test="${adminLido != null}">
      <div class="container">

        <div class="row py-5 mt-4 align-items-center">
          <!-- sezione di sinistra -->
          <div class="col-md-3 pr-lg-3 mb-3" style="box-shadow: 8px 8px 5px 5px #dedede;">
            <h1>Il tuo men&ugrave;</h1>
            <p>Gestisci il tuo profilo.</p>
            <div id="exTab1" class="container">
              <ul class="nav nav-pills">
                <li class="active">
                  <a href="#1a" style="font-size: 20px" data-toggle="tab"><span><i class="fa fa-lock"></i>Dati Personali</span></a>
                </li>
                <li><a href="#2a" style="font-size: 20px" data-toggle="tab"><span><i class="fa fa-user"></i>Modifica Credenziali</span></a>
                </li>
                <li><a href="dashboard" style="font-size: 20px"><span><i class="fa fa-chart-bar"></i>Dashboard</span></a>
                </li>
              </ul>
            </div>
          </div>
          <!-- Sezione di destra -->
          <div class="col-md-9 col-lg-8 ml-auto">
            <h1> Ciao ${adminLido.nome} ${adminLido.cognome}!</h1>
            <div class="row">
              <p>Questa &egrave; la sezione dedicata al tuo profilo.
                <br> Puoi controllare i tuoi dati personali, modificare le tue credenziali.
                <br> Se vuoi controllare lo stato del tuo lido vai alla dashboard.
              </p>
            </div>
            <div class="row">
              <div class="tab-content clearfix">
                <div class="tab-pane active" id="1a">
                  <h3>Email: ${adminLido.email}</h3><br>
                  <h3>Username: ${adminLido.username}</h3><br>
                </div>
                <div class="tab-pane" id="2a">
                  <h2>Modifica Credenziali</h2>
                  <form action="modificaCredenziali" name="modificaCredenzialiForm" id="modificaCredenzialiForm" method="post">
                    <div class="row">
                      <p>Inserisci la vecchia password e la nuova
                        <br> *ricorda* la password di almeno 6 lettere, contenente almeno una maiuscola e un numero
                      </p>
                    </div>
                    <div class="row">
                      <!-- vecchia password -->
                      <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock-open text-muted"></i>
                            </span>
                        </div>
                        <input type="password" name="oldPassword" class="form-control bg-white border-left-0 border-md" id="oldPassword" placeholder="Password Attuale" required>
                      </div>

                      <!-- nuova password -->
                      <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <input type="password" name="newPassword"
                               class="form-control bg-white border-left-0 border-md" placeholder="Password Nuova" required
                               id="newPassword">
                      </div>

                      <!-- Submit Button -->
                      <div class="form-group col-lg-12 mx-auto mb-0">
                        <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Modifica</button>
                      </div>
                    </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </c:when>
    <c:when test="${adminEnte != null}">
      <div class="container">

        <div class="row py-5 mt-4 align-items-center">
          <!-- sezione di sinistra -->
          <div class="col-md-3 pr-lg-3 mb-3" style="box-shadow: 8px 8px 5px 5px #dedede;">
            <h1>Il tuo men&ugrave;</h1>
            <p>Gestisci il tuo profilo.</p>
            <div id="exTab2" class="container">
              <ul class="nav nav-pills">
                <li class="active">
                  <a href="#1b" style="font-size: 20px" data-toggle="tab"><span><i class="fa fa-lock"></i>Dati Personali</span></a>
                </li>
                <li><a href="#2b" style="font-size: 20px" data-toggle="tab"><span><i class="fa fa-user"></i>Modifica Credenziali</span></a>
                </li>
                <li><a href="dashboard" style="font-size: 20px"><span><i class="fa fa-chart-bar"></i>Dashboard</span></a>
                </li>
              </ul>
            </div>
          </div>
          <!-- Sezione di destra -->
          <div class="col-md-9 col-lg-8 ml-auto">
            <h1> Ciao ${adminEnte.nome} ${adminEnte.cognome}!</h1>
            <div class="row">
              <p>Questa &egrave; la sezione dedicata al tuo profilo.
                <br> Puoi controllare i tuoi dati personali, modificare le tue credenziali.
                <br> Per visualizzare tutte le info sull'ente vai alla dashboard.
              </p>
            </div>
            <div class="row">
              <div class="tab-content clearfix">
                <div class="tab-pane active" id="1b">
                  <h3>Email: ${utente.email}</h3><br>
                  <h3>Username: ${utente.username}</h3><br>
                </div>
                <div class="tab-pane" id="2b">
                  <h2>Modifica Credenziali</h2>
                  <form action="modificaCredenziali" name="modificaCredenzialiForm" id="modificaCredenzialiForm" method="post">
                    <div class="row">
                      <p>Inserisci la vecchia password e la nuova
                        <br> *ricorda* la password di almeno 6 lettere, contenente almeno una maiuscola e un numero
                      </p>
                    </div>
                    <div class="row">
                      <!-- vecchia password -->
                      <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock-open text-muted"></i>
                            </span>
                        </div>
                        <input type="password" name="oldPassword" class="form-control bg-white border-left-0 border-md" id="oldPassword" placeholder="Password Attuale" required>
                      </div>

                      <!-- nuova password -->
                      <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <input type="password" name="newPassword"
                               class="form-control bg-white border-left-0 border-md" placeholder="Password Nuova" required
                               id="newPassword">
                      </div>

                      <!-- Submit Button -->
                      <div class="form-group col-lg-12 mx-auto mb-0">
                        <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Modifica</button>
                      </div>
                    </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </c:when>
    <c:when test="${utente != null}">
      <div class="container">

        <div class="row py-5 mt-4 align-items-center">
          <!-- sezione di sinistra -->
          <div class="col-md-3 pr-lg-3 mb-3" style="box-shadow: 8px 8px 5px 5px #dedede;">
            <h1>Il tuo men&ugrave;</h1>
            <p>Gestisci il tuo profilo.</p>
            <div id="exTab3" class="container">
              <ul class="nav nav-pills">
                <li class="active">
                  <a href="#1c" style="font-size: 20px" data-toggle="tab"><span><i class="fa fa-lock"></i>Dati Personali</span></a>
                </li>
                <li><a href="#2c" style="font-size: 20px" data-toggle="tab"><span><i class="fa fa-user"></i>Modifica Credenziali</span></a>
                </li>
                <li><a href="prenotazioniTurista" style="font-size: 20px"><span><i class="fa fa-chart-bar"></i>Storico Prenotazioni</span></a>
                </li>
              </ul>
            </div>
          </div>
          <!-- Sezione di destra -->
          <div class="col-md-9 col-lg-8 ml-auto">
            <h1> Ciao ${utente.nome} ${utente.cognome}!</h1>
            <div class="row">
              <p>Questa &egrave; la sezione dedicata al tuo profilo.
                <br> Puoi controllare i tuoi dati personali, modificare le tue credenziali e
                <br> visualizzare le prenotazioni effettuate.
              </p>
            </div>
            <div class="row">
              <div class="tab-content clearfix">
                <div class="tab-pane active" id="1c">
                  <h3>Email: ${utente.email}</h3><br>
                  <h3>Username: ${utente.username}</h3><br>
                </div>
                <div class="tab-pane" id="2c">
                  <h2>Modifica Credenziali</h2>
                  <form action="modificaCredenziali" name="modificaCredenzialiForm" id="modificaCredenzialiForm" method="post">
                    <div class="row">
                      <p>Inserisci la vecchia password e la nuova
                        <br> *ricorda* la password di almeno 6 lettere, contenente almeno una maiuscola e un numero
                      </p>
                    </div>
                    <div class="row">
                      <!-- vecchia password -->
                      <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock-open text-muted"></i>
                            </span>
                        </div>
                        <input type="password" name="oldPassword" class="form-control bg-white border-left-0 border-md" id="oldPassword" placeholder="Password Attuale" required>
                      </div>

                      <!-- nuova password -->
                      <div class="input-group col-lg-6 mb-4">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-white px-4 border-md border-right-0">
                                <i class="fa fa-lock text-muted"></i>
                            </span>
                        </div>
                        <input type="password" name="newPassword"
                               class="form-control bg-white border-left-0 border-md" placeholder="Password Nuova" required
                               id="newPassword">
                      </div>

                      <!-- Submit Button -->
                      <div class="form-group col-lg-12 mx-auto mb-0">
                        <button type="submit" class="btn-primary btn-block py-2" style="border-radius: 5px">Modifica</button>
                      </div>
                    </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
    </c:when>
  </c:choose>
  <sm:footer/>
</sm:layout>