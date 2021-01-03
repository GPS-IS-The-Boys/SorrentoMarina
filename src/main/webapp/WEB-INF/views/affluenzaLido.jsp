<%--
  Created by IntelliJ IDEA.
  User: Daniele
  Date: 02/01/2021
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Lido ${lido.nome}" admin="false">
    <sm:header/>
    <div id="wrapper" >
        <sm:sidebarLido/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column ">

            <!-- Main Content -->
            <div class=section-top-border">
                <h3 class="mb-30">Affluenza settimanale per il lido: <b>${lido.nome}</b></h3>
            <div class="progress-table-wrap">
                <div class="progress-table">
                    <div class="table-head">
                    <div class="country" style="margin: 10px">Giorni</div>
                    <div class="visit">Prenotazioni</div>
                    <div class="percentage">Grafico</div>
                </div>
                <div class="table-row">
                    <div class="country" style="margin: 10px">Lunedì</div>
                    <div class="visit">642</div>
                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-1" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>

                <div class="table-row">
                    <div class="country" style="margin: 10px">Martedì</div>
                    <div class="visit">5032</div>
                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-2" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
                <div class="table-row">

                    <div class="country" style="margin: 10px">Mercoledì</div>
                    <div class="visit">32</div>
                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-3" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
                <div class="table-row">

                    <div class="country" style="margin: 10px">Giovedì</div>
                    <div class="visit">503</div>
                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-4" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
                <div class="table-row">

                    <div class="country" style="margin: 10px">Venerdì</div>
                    <div class="visit">645032</div>
                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-5" role="progressbar" style="width: 40%" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
                <div class="table-row">

                    <div class="country" style="margin: 10px">Sabato</div>
                    <div class="visit">555</div>
                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-6" role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
                <div class="table-row">

                    <div class="country" style="margin: 10px">Domenica</div>
                    <div class="visit">445032</div>
                    <div class="percentage">
                        <div class="progress">
                            <div class="progress-bar color-7" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
            <sm:footer/>
        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->
</sm:layout>
