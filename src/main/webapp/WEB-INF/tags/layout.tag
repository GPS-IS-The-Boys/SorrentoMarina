<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Define layout" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" type="java.lang.String"%>
<%@attribute name="admin" required="true" type="java.lang.Boolean"%>
<%@attribute name="script" required="false" type="java.lang.String"%>
<%@attribute name="style" required="false" type="java.lang.String"%>

<!doctype html>
<html lang="it" dir="ltr">
    <head id="12345">
        <title>${title}</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Sito Prenotazioni Spiaggie di Marina di Sorrento">
        <link rel="icon" type="image/png" href="images/sorrentoMarina.png">
        <link rel="apple-touch-icon" href="images/sorrentoMarina.png">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="msapplication-config" content="browserconfig.xml">
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/owl.carousel.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/flaticon.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/slicknav.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/animate.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/magnific-popup.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/fontawesome-all.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/themify-icons.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/slick.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/nice-select.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>">

        <link rel="stylesheet" href="<c:url value="/css/formPrenotazione.css"/>" type="text/css">
        <!-- JS here -->

        <!-- All JS Custom Plugins Link Here here -->
        <script src="<c:url value="/assets/js/vendor/modernizr-3.5.0.min.js"/>"></script>

        <!-- Jquery, Popper, Bootstrap -->
        <script src="/assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="/assets/js/popper.min.js"></script>
        <script src="/assets/js/bootstrap.min.js"></script>
        <!-- Jquery Mobile Menu -->
        <script src="/assets/js/jquery.slicknav.min.js"></script>

        <!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="/assets/js/owl.carousel.min.js"></script>
        <script src="/assets/js/slick.min.js"></script>
        <!-- One Page, Animated-HeadLin -->
        <script src="/assets/js/wow.min.js"></script>
        <script src="/assets/js/animated.headline.js"></script>
        <script src="/assets/js/jquery.magnific-popup.js"></script>

        <!-- Scrollup, nice-select, sticky -->
        <script src="<c:url value="/assets/js/jquery.scrollUp.min.js"/>"></script>
        <script src="/assets/js/jquery.nice-select.min.js"></script>
        <script src="/assets/js/jquery.sticky.js"></script>

        <!-- contact js -->
        <script src="/assets/js/contact.js"></script>
        <script src="/assets/js/jquery.form.js"></script>
        <script src="/assets/js/jquery.validate.min.js"></script>
        <script src="/assets/js/mail-script.js"></script>
        <script src="/assets/js/jquery.ajaxchimp.min.js"></script>

        <!-- Jquery Plugins, main Jquery -->
        <script src="<c:url value="/assets/js/plugins.js"/>"></script>
        <script src="<c:url value="/assets/js/main.js"/>"></script>
                <link rel="stylesheet" href="<c:url value="/webjars/startbootstrap-sb-admin-2/4.0.6/css/sb-admin-2.min.css"/>">
                <link rel="stylesheet" href="<c:url value="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/fontawesome-free/css/all.min.css"/>">
                <script type="text/javascript" src="<c:url value="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/jquery/jquery.min.js"/>" defer="true"></script>
                <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/bootstrap/js/bootstrap.bundle.min.js" defer="true"></script>
                <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/jquery-easing/jquery.easing.min.js" defer="true"></script>
                <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/js/sb-admin-2.min.js" defer="true"></script>
                <link rel="stylesheet" href="/webjars/startbootstrap-sb-admin-2/4.0.6/css/sb-admin-2.min.css">
                <link rel="stylesheet" href="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/fontawesome-free/css/all.min.css">
                <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/jquery/jquery.min.js" defer="true"></script>
                <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/bootstrap/js/bootstrap.bundle.min.js" defer="true"></script>
        <c:if test="${not empty style}">
            <link rel="stylesheet" href="${style}">
        </c:if>
        <c:if test="${not empty script}">
            <script type="text/javascript" src="${script}" defer="true"></script>
        </c:if>
    </head>
    <body id="page-top">
        <jsp:doBody/>
        <script src="/js/index.js"></script>
    </body>
</html>
