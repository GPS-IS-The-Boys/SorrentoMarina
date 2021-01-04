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
                                        <h2 class="mb-30">${annuncio.titolo}</h2>
                                    </div>
                                        <article class="blog_item">
                                            <div class="blog_details">
                                                    <h4 class="mb-10">Contenuto</h4>
                                                    ${annuncio.contenuto}
                                            </div>
                                            <div class="blog_details">
                                               <img class="img-fluid" width="240" height="320" src="${annuncio.foto}" alt="">
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