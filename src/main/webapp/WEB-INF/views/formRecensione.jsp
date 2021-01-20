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
                                        <div class="blog_details">
                                            <p>${messaggio}</p>
                                            <form action="addRecensione" id="addRecensione">
                                                <div class="title">
                                                    <h2 class="mb-30">VALUTA LA TUA ESPERIENZA</h2>
                                                </div>
                                                <label for="textarea">Recensione</label>
                                                <textarea class="form-control" maxlength="256" id="textarea" name="contenutoRecensione" rows="3"></textarea>
                                                <label class="form-label" for="customRange2">Giudizio<br>
                                                    <span><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i></span>
                                                </label>
                                                <div class="col-6">
                                                    <input type="range" class="form-range" min="1" max="5" id="customRange2" name="giudizioRecensione" />
                                                </div>
                                                <div class="text-right">
                                                    <button type="submit" class="genric-btn primary circle">Aggiungi recensione</button>
                                                </div>
                                            </form>
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