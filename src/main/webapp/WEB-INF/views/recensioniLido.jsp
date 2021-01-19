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
                            <div class="well col-lg-8 mb-5 mb-lg-0">
                                <div class="button-group-area mt-40 text-center ">
                                    <a name="AggiungiRecensione" href="formRecensione" class="genric-btn primary circle"> Aggiungi Recensione </a>
                                </div>
                                <h2 class="mb-30">RECENSIONI</h2>
                                <div class="list-group">
                                    <c:forEach items="${mapRecensioni}" var="entry">
                                        <article class="blog_item">
                                            <div class="blog_details inline_div" >
                                                <div class="row">
                                                    <div class="col-md-3 text-center">
                                                        <i class="fa fa-user-circle"></i>
                                                        <h4 class="list-group-item-heading"> <c:out value="${entry.value}"/> </h4>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <h4 class="list-group-item-heading"> Contenuto </h4>
                                                        <p class="list-group-item-text">
                                                            <c:out value="${entry.key.contenuto}"/>

                                                        </p>
                                                    </div>
                                                    <div class="col-md-3 text-center">
                                                        <h4 class="list-group-item-heading"> Giudizio </h4>
                                                        <div class="">
                                                            <c:forEach begin="1" end="${entry.key.giudizio}" step="1" varStatus="loop">
                                                            <i class="fas fa-star"></i>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                </div>
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