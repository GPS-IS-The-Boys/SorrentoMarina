<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Lido ${lido.nome}" admin="false">
    <link rel="stylesheet" href="<c:url value="/css/formPrenotazione.css"/>" type="text/css">
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
                                <!-- Step  -->
                                <div class="button-group-area mt-40 text-center ">
                                    <div class="text-center">
                                        <div class="progressbar-wrapper">
                                            <ul class="progressbar text-center">
                                                <li class="active"></li>
                                                <li class="active"> </li>
                                                <li class="active"> </li>
                                                <li> </li>
                                                <li> </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <div class="blog_center_sidebar">
                                    <article class="blog_item">
                                        <div class="blog_details">

                                            <!-- Contenitore principale -->
                                            <div class="text-center blog_details">
                                                <!-- Form dati personali -->
                                                <form action="eseguiPrenotazione3">
                                                    <div class="form-group row">
                                                        <label for="nome" class="col-sm-3 col-form-label">Nome</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" id="nome" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="cognome" class="col-sm-3 col-form-label">Cognome</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" id="cognome" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                        <label for="email" class="col-sm-3 col-form-label">E-mail</label>
                                                        <div class="col-sm-8">
                                                            <input type="email" class="form-control" id="email" placeholder="">
                                                        </div>
                                                    </div>
                                                    <!-- Tasti prec next -->
                                                    <nav class="blog-pagination justify-content-center d-flex">
                                                        <ul class="pagination" >
                                                            <li class="page-item -align-left">
                                                                <a href="mostraPrenotazione2" class="page-link" aria-label="Previous">
                                                                    <i class="ti-angle-left"></i>
                                                                </a>
                                                            </li>
                                                            <li class="page-item -align-right">
                                                                <button type="submit" class="page-link" aria-label="Next">
                                                                    <i class="ti-angle-right"></i>
                                                                </button>
                                                            </li>
                                                        </ul>
                                                    </nav>
                                                </form>
                                            </div>


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