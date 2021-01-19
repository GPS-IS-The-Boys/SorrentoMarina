<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Lido ${lido.nome}" admin="false">
    <sm:header/>
<div id="wrapper" >
        <sm:sidebarLido/>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column ">

        <!-- Main Content -->
        <div id="content">
            <section class="blog_area section-padding">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mb-5 mb-lg-0">

                            <div class="blog_center_sidebar">

                                <article class="blog_item">
                                    <div class="place-img ">
                                        <img src="${lido.logo}" alt="" width="40%" height="40%">
                                        <h3 class="mb-30"> Lido ${lido.nome}</h3>
                                    </div>
                                    <div class="blog_details">
                                        <h4>Descrizione</h4>
                                        <p>
                                            ${lido.nome}, stabilimento balneare situato a Marina Di Sorrento. La sua meravigliosa spiaggia, accompagnata dalle comodit&agrave; offerte dal
                                            lido contribuiranno a rende piacevole il tuo meritato relax.
                                        </p>
                                        <div>
                                            <i class="fas fa-map-marker-alt"></i>     Indirizzo: ${lido.indirizzo}
                                        </div>
                                        <div>
                                            <i class="fas fa-phone-alt"></i>    Telefono: ${lido.telefono}
                                        </div>
                                        <div>
                                            <i class="fas fa-envelope"></i>    Email: ${lido.email}
                                        </div>
                                        <div class="-align-right">
                                            <i class="fas fa-money-bill-alt"></i>    Prezzo a persona: ${lido.prezzo_singolo}&euro;
                                        </div>
                                    </div>
                                    <div class="blog_details">
                                        <h4>Servizi</h4>
                                        <p>
                                            Il lido ${lido.nome} offre alla sua clientela questi servizi:
                                        </p>
                                        <c:if test="${serviziLido.bar}">
                                            <div>
                                                <i class="fas fa-coffee"></i>Bar
                                            </div>
                                        </c:if>
                                        <c:if test="${serviziLido.ristorante}">
                                            <div>
                                                <i class="fas fa-pizza-slice"></i>Ristorante
                                            </div>
                                        </c:if>
                                        <c:if test="${serviziLido.animazione}">
                                            <div>
                                                <i class="fas fa-gamepad"></i>Animazione
                                            </div>
                                        </c:if>
                                        <c:if test="${serviziLido.wifi}">
                                            <div>
                                                <i class="fas fa-wifi"></i>Wi-Fi
                                            </div>
                                        </c:if>
                                        <c:if test="${serviziLido.cabina}">
                                            <div>
                                                <i class="fas fa-home"></i>Cabina
                                            </div>
                                        </c:if>
                                        <c:if test="${serviziLido.beach_volley}">
                                            <div>
                                                <i class="fas fa-volleyball-ball"></i>Beach-Volley
                                            </div>
                                        </c:if>
                                        <c:if test="${serviziLido.canoa}">
                                            <div>
                                                <i class="fas fa-ship"></i>Canoa
                                            </div>
                                        </c:if>
                                    </div>
                                </article>



                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    <sm:footer/>
    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->
</sm:layout>