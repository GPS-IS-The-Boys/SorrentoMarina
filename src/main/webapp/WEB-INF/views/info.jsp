<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/css/index.css" >
<sm:layout title="HomePage" admin="false">
  <sm:header/>
  <main>
    <!-- slider Area Start-->
    <div class="slider-area ">
      <!-- Mobile Menu -->
      <div class="single-slider slider-height2 d-flex align-items-center"
           style="background-image: url('/images/sfondoSorrento.jpg')">
        <div class="container">
          <div class="row">
            <div class="col-xl-12">
              <div class="hero-cap text-center">
                <h1>Scopri qualcosa in pi&ugrave; su di noi</h1>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- slider Area End-->
    <!-- Our Services Start -->
    <div class="our-services servic-padding">
      <div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="section-tittle text-center">
              <span>Sei il responsabile di un lido? ecco cosa possiamo offrirti</span>
              <h2>I NOSTRI SERVIZI</h2>
            </div>
          </div>
        </div>
        <div class="row d-flex justify-contnet-center">
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
            <div class="single-services text-center mb-30">
              <div class="services-ion">
                <span class="flaticon-tour"></span>
              </div>
              <div class="services-cap">
                <h5>Gestisci il tuo lido <br>dalla tua dashboard con pochi click</h5>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
            <div class="single-services text-center mb-30">
              <div class="services-ion">
                <span class="flaticon-pay"></span>
              </div>
              <div class="services-cap">
                <h5>Dati sempre al sicuro <br> e pronti per essere analizzati</h5>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
            <div class="single-services text-center mb-30">
              <div class="services-ion">
                <span class="flaticon-experience"></span>
              </div>
              <div class="services-cap">
                <h5>Servizi affidabili <br></h5>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6">
            <div class="single-services text-center mb-30">
              <div class="services-ion">
                <span class="flaticon-good"></span>
              </div>
              <div class="services-cap">
                <h5>Il 90% dei turisti<br>&egrave; soddisfatto del servizio</h5>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Support Company Start-->
    <div class="support-company-area support-padding fix">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-xl-6 col-lg-6">
            <div class="support-location-img mb-50">
              <img src="<c:url value="/images/sfondoSorrento.jpg"/>" alt="">
              <div class="support-img-cap">
                <span>Dal 2020</span>
              </div>
            </div>
          </div>
          <div class="col-xl-6 col-lg-6">
            <div class="right-caption">
              <!-- Section Tittle -->
              <div class="section-tittle section-tittle2">
                <span>Ente Balneare Marina di Sorrento <br>Napoli, Campania, Italy</span>
                <h2>Qualcosa su di noi</h2>
              </div>
              <div class="support-caption">
                <p>Sorrento Marina ti offre uno scorcio su una delle costiere pi&ugrave; belle d'Italia.
                  Scegli comodomente seduto sul tuo divano la meta perfetta tra i lidi di Sorrento. Vieni a
                  trovarci...ti aspettiamo</p>
                <div class="select-suport-items">
                  <label class="single-items">Semplicit&agrave;
                    <input type="checkbox" checked="checked" disabled>
                    <span class="checkmark"></span>
                  </label>
                  <label class="single-items">Convenienza
                    <input type="checkbox" checked="checked" disabled>
                    <span class="checkmark"></span>
                  </label>
                  <label class="single-items">Precisione
                    <input type="checkbox" checked="checked" disabled>
                    <span class="checkmark"></span>
                  </label>
                  <label class="single-items">Affidabilit&agrave;.
                    <input type="checkbox" checked="checked" disabled>
                    <span class="checkmark"></span>
                  </label>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Video Start Arera -->
    <div class="video-area video-bg pt-200 pb-200" style="background-image: url('/images/spiaggia.jpg')">
      <div class="container">
        <div class="row">
          <div class="col-xl-12">
            <div class="video-caption text-center">
              <div class="video-icon">
                <a class="popup-video" target="_blank"
                   href="https://www.youtube.com/watch?v=WPIuF0-evxo&ab_channel=ProwalkTours"
                   tabindex="0"><i class="fas fa-play"></i></a>
              </div>
              <p class="pera1">Esplora le coste spumeggianti</p>
              <p class="pera2">Prenota tutto Online</p>
              <p class="pera3">Vieni a trovarci a Marina di Sorrento</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Video Start End -->
    <section class="contact-section">
      <div class="container map-responsive">
        <iframe
            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d78096.68968497575!2d14.327883245583687!3d40.63287011348315!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133b9eb244c380c9%3A0xacedd2e0ff3ef41!2sPorto%20di%20Sorrento!5e0!3m2!1sit!2sit!4v1609582733750!5m2!1sit!2sit"
            width="900" height="600" style="position: center; margin: 20px" allowfullscreen="" aria-hidden="false"
            tabindex="0">
        </iframe>
      </div>
    </section>
  </main>
  <sm:footer/>
</sm:layout>