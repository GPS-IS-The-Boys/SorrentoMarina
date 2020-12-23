<%@taglib prefix="sm" tagdir="/WEB-INF/tags/" %>


<sm:layout title="HomePage" admin="false">
<sm:header/>
    <main>
        <!--? Hero Area Start-->
        <div class="slider-area hero-bg1 hero-overly" style="background-image: url('/images/sfondoSorrento.jpg')">
            <div class="single-slider hero-overly  slider-height1 d-flex align-items-center">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-xl-10 col-lg-10">
                            <!-- Hero Caption -->
                            <div class="hero__caption pt-100">
                                <h1>Cerca il tuo lido...</h1>
                                <p>Scopri i lidi migliori vicino a te in pochi click.</p>
                            </div>
                            <!--Hero form -->
                            <form action="#" class="search-box mb-100">
                                <div class="input-form">
                                    <input id="nomeLido" type="text" placeholder="Cosa stai cercando?">
                                </div>
                                <div>
                                    <input type="date">
                                </div>
                                <div class="search-form">
                                    <a href="#" class="btn f-right sm-left"><i class="fa fa-search"></i>Cerca</a>
                                </div>
                            </form>
                            <!-- hero category1 img -->
                            <div class="category-img text-center">
                                <a href=""> <img src="/images/sfondoSorrento.jpg" alt=""></a>
                                <a href=""> <img src="/images/sfondoSorrento.jpg" alt=""></a>
                                <a href=""> <img src="/images/sfondoSorrento.jpg" alt=""></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Hero Area End-->
        <!--? Popular Locations Start 01-->
        <div class="popular-location border-bottom section-padding40">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <!-- Section Tittle -->
                        <div class="section-tittle text-center mb-80">
                            <h2>I più popolari</h2>
                            <p>Esplora le località più cercate di Sorrento.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="/images/sorrentoMarina.png" alt="">
                            </div>
                            <div class="location-details">
                                <p>Lido 1</p>
                                <a href="#" class="location-btn">65 <i class="fa fa-plus"></i> Listing</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="/images/sorrentoMarina.png" alt="">
                            </div>
                            <div class="location-details">
                                <p>Lido 2</p>
                                <a href="#" class="location-btn">65 <i class="fa fa-plus"></i> Listing</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="/images/sorrentoMarina.png" alt="">
                            </div>
                            <div class="location-details">
                                <p>Lido 3</p>
                                <a href="#" class="location-btn">65 <i class="fa fa-plus"></i> Listing</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="/images/sorrentoMarina.png" alt="">
                            </div>
                            <div class="location-details">
                                <p>Lido 4</p>
                                <a href="#" class="location-btn">65 <i class="fa fa-plus"></i> Listing</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="/images/sorrentoMarina.png" alt="">
                            </div>
                            <div class="location-details">
                                <p>Lido 5</p>
                                <a href="#" class="location-btn">65 <i class="fa fa-plus"></i> Listing</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="single-location mb-30">
                            <div class="location-img">
                                <img src="/images/sorrentoMarina.png" alt="">
                            </div>
                            <div class="location-details">
                                <p>Lido 6</p>
                                <a href="#" class="location-btn">65 <i class="fa fa-plus"></i> Listing</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Popular Locations End -->
        <!--? Want To work 01-->
        <section class="wantToWork-area">
            <div class="container">
                <div class="wants-wrapper w-padding2">
                    <div class="row align-items-center justify-content-between">
                        <div class="col-xl-7 col-lg-9 col-md-8">
                            <div class="wantToWork-caption wantToWork-caption2">
                                <h2>Hai un lido? Cosa possiamo fare per te</h2>
                                <p>Scopri come aggiungere il tuo lido alla piattaforma e usufruire
                                    di tutti i servizi.</p>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-3 col-md-4">
                            <a href="#" class="btn f-right sm-left">Esplora</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Want To work End -->
        <!--? Our Services Start -->
        <div class="our-services  border-bottom">
            <div class="container">
                <div class="row">
                    <div class=" col-lg-4 col-md-6 col-sm-6">
                        <div class="single-services mb-30">
                            <div class="services-ion">
                                <span>01</span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="#">Trova nuovi turisti</a></h5>
                                <p>Scopri e connetti nuovi turisti al tuo business con semplicità.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class=" col-lg-4 col-md-6 col-sm-6">
                        <div class="single-services mb-30">
                            <div class="services-ion">
                                <span>02</span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="#">Controllo totale del lido</a></h5>
                                <p>Gestisci con una dashboard a te dedicata tutti i dettagli del tuo lido.</p>
                            </div>
                        </div>
                    </div>
                    <div class=" col-lg-4 col-md-6 col-sm-6">
                        <div class="single-services mb-30">
                            <div class="services-ion">
                                <span>03</span>
                            </div>
                            <div class="services-cap">
                                <h5><a href="#">Affidabilità e Riservatezza</a></h5>
                                <p>Le prenotazioni avvengono in completa sicurezza.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Our Services End -->

    </main>
<sm:footer/>
</sm:layout>