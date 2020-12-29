<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sm:layout title="Lido ${lido.nome}" admin="false">
    <sm:header/>
<div id="wrapper">
        <sm:sidebarLido/>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <section class="blog_area section-padding">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mb-5 mb-lg-0">

                            <div class="blog_center_sidebar">

                                <article class="blog_item">
                                    <div>
                                        <img src="<c:url value="/images/sorrentoMarina.png"/>" width="150" height="150" alt="">
                                        <h3 class="text-heading"> Lido Marinella</h3>
                                    </div>
                                    <div class="blog_details">
                                            <h2>Descrizione</h2>
                                        <p>That dominion stars lights dominion divide years for fourth have don't stars is that
                                            he earth it first without heaven in place seed it second morning saying.</p>
                                        <ul class="blog-info-link">
                                            <li><a href="#"><i class="fa fa-user"></i> Travel, Lifestyle</a></li>
                                            <li><a href="#"><i class="fa fa-comments"></i> 03 Comments</a></li>
                                        </ul>
                                    </div>
                                </article>

                                <nav class="blog-pagination justify-content-center d-flex">
                                    <ul class="pagination">
                                        <li class="page-item">
                                            <a href="#" class="page-link" aria-label="Previous">
                                                <i class="ti-angle-left"></i>
                                            </a>
                                        </li>
                                        <li class="page-item">
                                            <a href="#" class="page-link" aria-label="Next">
                                                <i class="ti-angle-right"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </nav>

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