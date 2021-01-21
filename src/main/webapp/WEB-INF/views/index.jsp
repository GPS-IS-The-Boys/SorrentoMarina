<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="HomePage" admin="false">
<sm:header/>
    <main>
        <!-- Form di ricerca Start-->
        <div class="slider-area ">
            <!-- Mobile Menu -->
            <div class="slider-active">
                <div class="single-slider hero-overly  slider-height d-flex align-items-center"
                     style="background-image: url('/images/sfondoSorrento.jpg')">
                    <div class="container">
                        <div class="row">
                            <div class="col-xl-9 col-lg-9 col-md-9">
                                <div class="hero__caption">
                                    <h1>Trova <span> il lido ideale!</span></h1>
                                </div>
                            </div>
                        </div>

                        <form action="" name="RicercaForm" class="search-box">
                            <div class="container">
                                <div class="row justify-content-lg-center">
                                    <div class="col-xl-9 col-lg-9 col-md-9">
                                        <div class="form-group">
                                            <label for="nomeRicerca"></label>
                                            <input id="nomeRicerca" class="form-control-lg form-control" name="nomeRicerca" type="text" placeholder="Dove ti piacerebbe andare ?">
                                        </div>
                                    </div>
                                </div>
                                <div class="row justify-content-lg-center" style="margin: 6px">
                                    <div class="col-xl-4 col-lg-4 col-md-4">
                                        <div class="select-itms justify-content-lg-center">
                                            <input type="checkbox" id="servizio1" name="servizio1" value="true">
                                            <label for="servizio1"><h4 class="mb-20">Bar</h4></label><br>
                                            <input type="checkbox" id="servizio2" name="servizio2" value="true">
                                            <label for="servizio2"><h4 class="mb-20">Ristorante</h4></label><br>
                                            <input type="checkbox" id="servizio3" name="servizio3" value="true">
                                            <label for="servizio3"><h4 class="mb-20">Animazione</h4></label><br>
                                            <input type="checkbox" id="servizio4" name="servizio4" value="true">
                                            <label for="servizio4"><h4 class="mb-20">Wi-fi</h4></label><br>
                                        </div>
                                    </div>
                                    <div class="col-xl-4 col-lg-4 col-md-4">
                                        <div class="select-itms justify-content-lg-center">
                                            <input type="checkbox" id="servizio5" name="servizio5" value="true">
                                            <label for="servizio5"><h4 class="mb-20">Cabina</h4></label><br>
                                            <input type="checkbox" id="servizio6" name="servizio6" value="true">
                                            <label for="servizio6"><h4 class="mb-20">Beach Volley</h4></label><br>
                                            <input type="checkbox" id="servizio7" name="servizio7" value="true">
                                            <label for="servizio7"><h4 class="mb-20">Canoa</h4></label><br>
                                        </div>
                                    </div>
                                </div>
                                <div class="row justify-content-lg-center">
                                    <div class="col-xl-9 col-lg-9 col-md-9 center">
                                        <Button class=" btn-block genric-btn warning radius btn-lg" type="submit" style="font-size: 20px; margin: 8px"> Cerca il tuo lido</Button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
            <!-- Mobile Menu -->
        <!-- Form di ricerca End-->
        <c:choose>
            <c:when test="${lidoRicerca != null}">
        <div class="favourite-place place-padding">
            <div class="container">
                <!-- Section Tittle -->
                <div id="resultList" class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center">
                            <span>Il lido perfetto per te</span>
                            <h2>I TUOI RISULTATI</h2>
                        </div>
                    </div>
                </div>
                <div  class="row">

                    <c:forEach items="${lidoRicerca}" var="lido">
                        <div class="col-xl-4 col-lg-4 col-md-6">
                            <div class="single-place mb-30">
                                <div class="place-img">
                                    <img src="${lido.logo}" alt="/images/defaultImageLogoLido" />
                                </div>
                                <div class="place-cap">
                                    <div class="place-cap-top">
                                        <h3><a id="${lido.nome}" href="lido?id=${lido.id}">${lido.nome}</a></h3>
                                        <p class="dolor">$${lido.prezzo_singolo} <span>/ A persona</span></p>
                                    </div>
                                    <div class="place-cap-bottom">
                                        <ul>
                                            <li><i class="far fa-clock"></i>1 giorno</li>
                                            <li><i class="fas fa-map-marker-alt"></i>${lido.indirizzo}</li>
                                            <li><a href="lido?id=${lido.id}"><button class="genric-btn warning circle">Visita</button></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>
            </c:when>
            <c:when test="${listaLidiServizi != null}">
                <div class="favourite-place place-padding">
                    <div class="container">
                        <!-- Section Tittle -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section-tittle text-center">
                                    <span>Il lido perfetto per te</span>
                                    <h2>I TUOI RISULTATI</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${listaLidiServizi}" var="lido">
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="single-place mb-30">
                                        <div class="place-img">
                                            <img src="${lido.logo}" alt="/images/defaultImageLogoLido" />
                                        </div>
                                        <div class="place-cap">
                                            <div class="place-cap-top">
                                                <h3><a href="#">${lido.nome}</a></h3>
                                                <p class="dolor">$${lido.prezzo_singolo} <span>/ A persona</span></p>
                                            </div>
                                            <div class="place-cap-bottom">
                                                <ul>
                                                    <li><i class="far fa-clock"></i>1 giorno</li>
                                                    <li><i class="fas fa-map-marker-alt"></i>${lido.indirizzo}</li>
                                                    <li><a href="lido?id=${lido.id}"><button class="genric-btn warning circle">Visita</button></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>

        <!-- Suggeriti Start -->
                <div class="favourite-place place-padding">
                    <div class="container">
                        <!-- Section Tittle -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="section-tittle text-center">
                                    <span>I lidi con maggior affluenza</span>
                                    <h2>METE POPOLARI</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${listaLidiTotali}" var="lido">
                                <div class="col-xl-4 col-lg-4 col-md-6">
                                    <div class="single-place mb-30">
                                        <div class="place-img">
                                            <img src="${lido.logo}" alt="${lido.nome}" />
                                        </div>
                                        <div class="place-cap">
                                            <div class="place-cap-top">
                                                <h3><a href="lido?id=${lido.id}">${lido.nome}</a></h3>
                                                <p class="dolor">$${lido.prezzo_singolo} <span>/ A persona</span></p>
                                            </div>
                                            <div class="place-cap-bottom">
                                                <ul>
                                                    <li><i class="far fa-clock"></i>1 giorno</li>
                                                    <li><i class="fas fa-map-marker-alt"></i>${lido.indirizzo}</li>
                                                    <li><a href="lido?id=${lido.id}"><button class="genric-btn warning circle">Visita</button></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
        <!-- Favourite Places End -->
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
                                Scegli comodomente seduto sul tuo divano la meta perfetta tra i lidi di Sorrento. Vieni a trovarci...ti aspettiamo</p>
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
        <!-- Support Company End-->
            </c:otherwise>
        </c:choose>
    </main>
<sm:footer/>
</sm:layout>