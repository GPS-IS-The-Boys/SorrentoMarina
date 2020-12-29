<%--
  Created by IntelliJ IDEA.
  User: Daniele
  Date: 29/12/2020
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="HomePage" admin="false">
    <sm:header/>
    <main>
    <div class="favourite-place place-padding">
    <div class="container">
    <!-- Section Tittle -->
    <div class="row">
    <div class="col-lg-12">
    <div class="section-tittle text-center">
    <h2>LE MIE PRENOTAZIONI</h2>
    </div>
    </div>
    </div>
        <c:choose>
            <c:when test="${prenotazioni == null || prenotazioni.size() == 0}">
                <div class="section-tittle text-center">
                    <h4>Non sono presenti prenotazioni nel tuo account</h4>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${prenotazioni}" var="prenotazione">
                    <div class="row">
            <div class="col-xl-4 col-lg-4 col-md-6">
                <div class="single-place mb-30">
                    <div class="place-img">
                        <img src="<c:url value="/images/sorrentoFooter.jpg"/>" alt="">
                    </div>
                    <div class="place-cap">
                        <div class="place-cap-top">
                            <h3><a href="#">The Dark Forest Adventure</a></h3>
                            <p class="dolor">€${prenotazione.getCosto()} <span>/ ${prenotazione.getNum_posti()} Person</span></p>
                        </div>
                        <div class="place-cap-bottom">
                            <ul>
                                <li><i class="far fa-clock"></i>Data inizio: ${prenotazione.getData_inizio()}</li>
                                <li><i class="far fa-clock"></i>Data fine: ${prenotazione.getData_fine()}</li>
                                <li><i class="fas fa-map-marker-alt"></i>Sorrento</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

                </c:forEach>
            </c:otherwise>
        </c:choose>

    </div>
    </div>
    </div>
    </main>
    <sm:footer/>
</sm:layout>