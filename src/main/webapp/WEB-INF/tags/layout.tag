<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Define layout" pageEncoding="UTF-8" %>
<%@attribute name="title" required="true" type="java.lang.String" %>
<%@attribute name="admin" required="true" type="java.lang.Boolean" %>
<%@attribute name="script" required="false" type="java.lang.String" %>
<%@attribute name="style" required="false" type="java.lang.String" %>

<!doctype html>
<html lang="it" dir="ltr">
<head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Sito Prenotazioni Spiaggie di Marina di Sorrento">
    <link rel="icon" type="image/png" href="images/sorrentoMarina.png">
    <link rel="apple-touch-icon" href="images/sorrentoMarina.png">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="msapplication-config" content="browserconfig.xml">
    <c:choose>
        <c:when test="${admin}">
            <link rel="stylesheet" href="/webjars/startbootstrap-sb-admin-2/4.0.6/css/sb-admin-2.min.css">
            <link rel="stylesheet"
                  href="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/fontawesome-free/css/all.min.css">
            <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/jquery/jquery.min.js"
                    defer="true"></script>
            <script type="text/javascript"
                    src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/bootstrap/js/bootstrap.bundle.min.js"
                    defer="true"></script>
            <script type="text/javascript"
                    src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/jquery-easing/jquery.easing.min.js"
                    defer="true"></script>
            <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/js/sb-admin-2.min.js"
                    defer="true"></script>
        </c:when>
        <c:otherwise>
            <link rel="stylesheet" href="/webjars/startbootstrap-sb-admin-2/4.0.6/css/sb-admin-2.min.css">
            <link rel="stylesheet"
                  href="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/fontawesome-free/css/all.min.css">
            <script type="text/javascript" src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/jquery/jquery.min.js"
                    defer="true"></script>
            <script type="text/javascript"
                    src="/webjars/startbootstrap-sb-admin-2/4.0.6/vendor/bootstrap/js/bootstrap.bundle.min.js"
                    defer="true"></script>
        </c:otherwise>
    </c:choose>
    <c:if test="${not empty style}">
        <link rel="stylesheet" href="${style}">
    </c:if>
    <c:if test="${not empty script}">
        <script type="text/javascript" src="${script}" defer="true"></script>
    </c:if>
</head>
<body id="page-top">
<jsp:doBody/>
</body>
</html>
