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
                                <div class="title">
                                    <h2 class="mb-30">ANNUNCI</h2>
                                </div>
                                    <c:forEach items="${listaAnnunci}" var="annuncio">
                                    <article class="blog_item">
                                        <div class="blog_details">
                                            <a class="d-inline-block" href="dettagliAnnuncio?idAnnuncio=${annuncio.id}">
                                                <h4 class="mb-10">${annuncio.titolo}</h4>
                                            </a>
                                            <ul class="blog-info-link">
                                                <li><a href="dettagliAnnuncio?idAnnuncio=${annuncio.id}"><i class="fa fa-book-reader"></i> Dettagli </a></li>
                                            </ul>
                                        </div>
                                    </article>
                                    </c:forEach>

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