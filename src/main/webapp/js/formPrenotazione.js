function nextPrenotazione2() {


    var numPosti = $('#numPosti option:selected').val();

    var date = new Date($("#dataInizio").val());
    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();
    var dataInizio = ([year, month, day].join('-'));

    var fine = new Date($("#dataFine").val());
    var dayFine = fine.getDate();
    var monthFine = fine.getMonth() + 1;
    var yearFine = fine.getFullYear();
    var dataFine = ([yearFine, monthFine, dayFine].join('-'));
    var lista = "";


    var _MS_PER_DAY = 1000 * 60 * 60 * 24;

    // a e b sono oggetti Data
    function dateDiffInDays(a, b) {
        // Esclude l'ora ed il fuso orario
        var utc1 = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
        var utc2 = Date.UTC(b.getFullYear(), b.getMonth(), b.getDate());

        return Math.floor((utc2 - utc1) / _MS_PER_DAY);
    }

    var giorni_pren = dateDiffInDays(date,fine) + 1;
    localStorage.setItem('giorni',giorni_pren);




    if (numPosti == 0 || isNaN(date)  || isNaN(fine)) {
        alert("Compila tutti i campi");
    }
    else if(giorni_pren <= 0){
        alert('date non corrette');
    }

    else {
        $('#prenotazione1').slideToggle(500);
        $('#prenotazione2').slideToggle(500);
        var div = document.getElementById("step2");
        div.classList.add("active");

        $.post("postiOccupati?dataInizio=" + dataInizio + "&dataFine=" + dataFine, function (data) {
            //alert(data.occupati + " status:" +status);
            lista = data.occupati.join(",");
            console.log(lista);
            sessionStorage.setItem("postiOccupati", lista);
        });


        // sessionStorage.clear();
        sessionStorage.setItem("dataInizio", dataInizio);
        sessionStorage.setItem("dataFine", dataFine);
        sessionStorage.setItem("numPosti", numPosti);

        jQuery.ajax({
            url: "/js/griglia.js",
            dataType: "script",
            async: true,
        });

    }
}
function selectChange(){

    jQuery.ajax({
        url: "/js/griglia.js",
        dataType: "script",
        async: true
    });
}

function nextPrenotazione3(){

    var selezionabili = localStorage.getItem('selezionabili');
    var selezionati = localStorage.getItem('selezionati');
    if(selezionabili == selezionati) {
        $('#prenotazione2').slideToggle(500);
        $('#prenotazione3').slideToggle(500);
        var div = document.getElementById("step3");
        div.classList.add("active")
    }
    else {
        alert("Ombrelloni da selezionare: " + selezionabili);
    }
}

function nextPrenotazione4(){
    $('#prenotazione3').slideToggle(500);
    $('#prenotazione4').slideToggle(500);
    var div = document.getElementById("step4");
    div.classList.add("active")

    var lista = localStorage.getItem('listaSelezionati');

    $.post("listaSelezionati?lista=" + lista, function (data) {

    });
}

function prevPrenotazione1(){
    $('#prenotazione2').slideToggle(500);
    $('#prenotazione1').slideToggle(500);
    var div = document.getElementById("step2");
    div.classList.remove("active")
    sessionStorage.clear();

}

function prevPrenotazione2(){
    $('#prenotazione3').slideToggle(500);
    $('#prenotazione2').slideToggle(500);
    var div = document.getElementById("step3");
    div.classList.remove("active")
}

function prevPrenotazione3(){
    $('#prenotazione4').slideToggle(500);
    $('#prenotazione3').slideToggle(500);
    var div = document.getElementById("step4");
    div.classList.remove("active")
}