function nextPrenotazione2(){
    $('#prenotazione1').slideToggle(500);
    $('#prenotazione2').slideToggle(500);
    var div = document.getElementById("step2");
    div.classList.add("active")
}

function nextPrenotazione3(){
    $('#prenotazione2').slideToggle(500);
    $('#prenotazione3').slideToggle(500);
    var div = document.getElementById("step3");
    div.classList.add("active")
}

function nextPrenotazione4(){
    $('#prenotazione3').slideToggle(500);
    $('#prenotazione4').slideToggle(500);
    var div = document.getElementById("step4");
    div.classList.add("active")
}

function prevPrenotazione1(){
    $('#prenotazione2').slideToggle(500);
    $('#prenotazione1').slideToggle(500);
    var div = document.getElementById("step2");
    div.classList.remove("active")
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