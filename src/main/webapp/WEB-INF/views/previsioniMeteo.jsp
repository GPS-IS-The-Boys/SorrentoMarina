<%--
  Created by IntelliJ IDEA.
  User: Daniele
  Date: 31/12/2020
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Lido ${lido.nome}" admin="false">

    <link href="<c:url value="/css/weather.css"/>" rel="stylesheet" type="text/css">
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
                                    <div class="title">
                                        <h2 class="mb-30">PREVISIONI METEO</h2>
                                    </div>
                                    <div class="component__weather-box">
                                        <div class="component__weather-content">
                                            <div class="weather-content__overview"></div>
                                            <div class="weather-content__temp"></div>
                                        </div>
                                        <div class="component__forecast-box"></div>
                                    </div>

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
    <script src="<c:url value="/js/weather.js"/>"></script>

    <!-- End of Page Wrapper -->
</sm:layout>