<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="HomePage" admin="false">
  <sm:header/>
  <div class="container">

    <div class="row py-5 mt-4 align-items-center">
      <!-- sezione di sinistra -->
      <div class="col-md-3 pr-lg-3 mb-3 mb-md-0" style="box-shadow: 8px 8px 5px 5px #dedede;">
        <h1> menu di sinistra</h1>
        <p>Gestisci il tuo profilo.</p>
        <ul>
          <li><a href=""><span><i class="fa fa-user"></i>Modifica Credenziali</span></a></li>
          <li><a href=""><span><i class="fa fa-chart-bar"></i>Storico Prenotazioni</span></a></li>
          <li><a href=""><span><i class="fa fa-lock"></i>Dati Personali</span></a></li>
        </ul>
      </div>

      <!-- Sezione di destra -->
      <div class="col-md-9 col-lg-8 ml-auto">
        <h2>Destra</h2>
          <div class="row">
            <p>Benvenuti nella sezione dedicata al tuo profilo</p>
          </div>
          <div class="row">
            <h1> Ciao ${utente.nome} ${utente.cognome} </h1>
            <br>
            <h2> ${utente.email}</h2>
            <!-- Divider Text -->
            <div class="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
              <div class="border-bottom w-100 ml-5"></div>
              <span class="px-2 small text-muted font-weight-bold text-muted">OPPURE</span>
              <div class="border-bottom w-100 mr-5"></div>
            </div>

            <div class="container"><h1>Bootstrap  tab panel example (using nav-pills)  </h1></div>
            <div id="exTab1" class="container">
              <ul  class="nav nav-pills">
                <li class="active">
                  <a  href="#1a" data-toggle="tab">Overview</a>
                </li>
                <li><a href="#2a" data-toggle="tab">Using nav-pills</a>
                </li>
                <li><a href="#3a" data-toggle="tab">Applying clearfix</a>
                </li>
                <li><a href="#4a" data-toggle="tab">Background color</a>
                </li>
              </ul>

              <div class="tab-content clearfix">
                <div class="tab-pane active" id="1a">
                  <h3>Content's background color is the same for the tab</h3>
                </div>
                <div class="tab-pane" id="2a">
                  <h3>We use the class nav-pills instead of nav-tabs which automatically creates a background color for the tab</h3>
                </div>
                <div class="tab-pane" id="3a">
                  <h3>We applied clearfix to the tab-content to rid of the gap between the tab and the content</h3>
                </div>
                <div class="tab-pane" id="4a">
                  <h3>We use css to change the background color of the content to be equal to the tab</h3>
                </div>
              </div>
            </div>


          </div>
      </div>

    </div>

  </div>
  <sm:footer/>
</sm:layout>