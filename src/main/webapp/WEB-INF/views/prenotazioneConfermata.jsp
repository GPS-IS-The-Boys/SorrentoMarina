<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sm" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="grid" tagdir="/WEB-INF/tags" %>
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
    <!-- Step  -->
    <div class="button-group-area mt-40 text-center ">
        <div class="text-center">
            <div class="progressbar-wrapper">
                <ul class="progressbar text-center">
                    <li id="step1" class="active"><i class="fa fa-calendar"></i></li>
                    <li id="step2" class="active"><i class="fa fa-box-open"></i> </li>
                    <li id="step3" class="active"><i class="fa fa-user"></i> </li>
                    <li id="step4" class="active"><i class="fa fa-cc-paypal"></i> </li>
                    <li id="step5" class="active"><i class="fa fa-check-double"></i> </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="blog_center_sidebar">
    <article class="blog_item">
        <div class="blog_details">
            <!-- Contenitore principale -->
            <div class="text-center blog_details">
                <div id="prenotazioneConfermata">
                    <h3 class="mb-30">PRENOTAZIONE CONFERMATA</h3>
                    <!-- Tasto next -->
                    <nav class="blog-pagination justify-content-center d-flex">
                        <ul class="pagination" >
                            <li class="page-item -align-right">
                                <a href="index" class="page-link" aria-label="Next">
                                    <i class="ti-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
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
