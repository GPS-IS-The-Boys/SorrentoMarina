(function($) {
var firstSeatLabel = 1;
	var seatMap = [];




		var sc;

        var righe = parseInt(document.getElementById("1").getAttribute("value"));
		var colonne = parseInt(document.getElementById("2").getAttribute("value"));
		var prezzoSingolo = parseFloat(document.getElementById("3").getAttribute("value"));
		var totalePosti=0;
		var numPosti=0;
		var dataInizio;
		var dataFine;
	    numPosti= parseInt(sessionStorage.getItem("numPosti"));
		//sessionStorage.clear();



		var i,j;
		for (i = 0 ; i < righe ; i++){
			var row = "'";
			for (j = 0 ; j < colonne ; j++){
				row += 'f';
			}
			row+= "',";
			seatMap.push(row);
		}

		$('.front-indicator').css('width',j*30);

	function  totalPersone(){
		totalePosti=0;
		totalePosti = numPosti*prezzoSingolo;
		return totalePosti;
	}

	var posti = [];



$(document).ajaxComplete(function () {
	posti = sessionStorage.getItem("postiOccupati");
	if (posti != null && posti != undefined && posti.length >= 1) {

	posti = posti.split(',');
	for(var i in posti){
		console.log(posti[i]);
	}
	console.log("create grid");
	createGrid();

}
	else {
	console.log("clear grid");
	clearGrid();
	}

});




$(document).ready(function() {

	jQuery.ajax({
		url: "/js/jquery.seat-charts.js",
		dataType: "script",
		async: true,
	});
	var $cart = $('#selected-seats'),
		$counter = $('#counter'),
		$total = $('#total');
	sc = $('#seat-map').seatCharts({
		map: seatMap,
		seats: {
			f: {
				price: 10,
				classes: 'first-class', //your custom CSS class
				category: 'Ombrellone'
			},
			e: {
				price: 40,
				classes: 'economy-class', //your custom CSS class
				category: 'Economy Class'
			}

		},
		naming: {
			top: false,
			getLabel: function (character, row, column) {
				return firstSeatLabel++;
			},
		},
		legend: {
			node: $('#legend'),
			items: [
				['f', 'available', 'Disponibili'],
				['e', 'available', 'Selezionato'],
				['f', 'unavailable', 'Non disponibile']
			]
		},
		click: function () {

			if (this.status() == 'available') {
				//let's create a new <li> which we'll add to the cart items
				$('<li>' + this.data().category + ' Num: # ' + this.settings.label + '<a href="#" class="cancel-cart-item">[cancel]</a></li>')
					.attr('id', 'cart-item-' + this.settings.id)
					.data('seatId', this.settings.id)
					.appendTo($cart);

				/*
                 * Lets update the counter and total
                 *
                 * .find function will not find the current seat, because it will change its stauts only after return
                 * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
                 */
				console.log(sc.find('selected'));
				$counter.text(sc.find('selected').length + 1);
				//$total.text(recalculateTotal(sc)+this.data().price);

				return 'selected';
			} else if (this.status() == 'selected') {
				//update the counter
				$counter.text(sc.find('selected').length - 1);
				//and total
				//$total.text(recalculateTotal(sc)-this.data().price);

				//remove the item from our cart
				$('#cart-item-' + this.settings.id).remove();

				//seat has been vacated
				return 'available';
			} else if (this.status() == 'unavailable') {
				//seat has been already booked
				return 'unavailable';
			} else {
				return this.style();
			}
		}
	});
	recalculateTotal(sc);
	//this will handle "[cancel]" link clicks
	$('#selected-seats').on('click', '.cancel-cart-item', function () {
		//let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
		sc.get($(this).parents('li:first').data('seatId')).click();
	});

	//let's pretend some seats have already been booked
	//sc.get(['1_2', '4_1', '6_1', '6_2']).status('unavailable');

	$total.text(totalPersone());

});




function recalculateTotal(sc) {
	var total = 0;

	//basically find every selected seat and sum its price
	$(sc).find('selected').each(function () {
		total += this.data().price;

	});
	total += totalPersone();
	return total;
}

function clearGrid() {
	if (sc != null) {
	sc.find('unavailable').status('available');
	console.log('clear ok');
	}
}

function createGrid(){
	var i;
	if( sc != null) {
		for (i in posti) {
				sc.get(posti[i]).status('unavailable');
				console.log(posti[i]);

		}

	}
}

var selezionabili = Math.ceil(numPosti/3);



})(jQuery);

