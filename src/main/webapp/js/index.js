var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};

if(getUrlParameter("nomeRicerca") ||
    getUrlParameter("servizio1") ||
    getUrlParameter("servizio2") ||
    getUrlParameter("servizio3") ||
    getUrlParameter("servizio4") ||
    getUrlParameter("servizio5") ||
    getUrlParameter("servizio6") ||
    getUrlParameter("servizio7")){
    $([document.documentElement, document.body]).animate({
        scrollTop: $("#resultList").offset().top - 256
    }, 1000);
}