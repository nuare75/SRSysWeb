function ConvertFormToJSON (form) {
	var array = jQuery (form).serializeArray ();
	var json = {};

	jQuery.each (array, function () {
		if (this.name.indexOf ("_") != 0) {
			// json[this.name] = this.value.toUpperCase() || '';
			json[this.name] = this.value || '';
		}
	});

	return json;
}

function ConvertFormToJSONString (form) {
	// Call convertformtojson
	var serialdata = ConvertFormToJSON (form);
	// Return the json object converted as JSON data
	return JSON.stringify (serialdata);
}

function autotab (original, destination) {
	if (original.getAttribute && original.value.length == original.getAttribute ("maxlength")) {
		destination.focus ();
		destination.select ();
	}
}

function multiplyInteger (evt, clientID) {
	var theEvent = evt || window.event;
	var key = theEvent.keyCode || theEvent.which;
	key = String.fromCharCode (key);
	if (key == 'k' || key == 'K' || key == 'm' || key == 'M') {
		var nStr = document.getElementById (clientID).value;
		nStr = nStr.replace (/,/g, '');
		var amt = 0;
		var newAmt = 0;
		if (nStr != '') {
			amt = parseInt (nStr);
			if (key == 'k' || key == 'K') newAmt = amt * 1000;
			if (key == 'm' || key == 'M') newAmt = amt * 1000000;
			document.getElementById (clientID).value = newAmt;
			addCommasUni (clientID);
		}
	}
	var regex = /[0-9]|\./;
	if (!regex.test (key)) {
		theEvent.returnValue = false;
		if (theEvent.preventDefault) theEvent.preventDefault ();
	}
}

function addCommasUni (clientID) {
	// alert("Test " + clientID);
	removeCommasUni (clientID);
	var nStr = document.getElementById (clientID).value;
	nStr += '';
	x = nStr.split ('.');
	if (!x[0]) {
		x[0] = "0";
	}
	x1 = x[0];
	if (!x[1]) {
		x[1] = "00";
	}
	x2 = '';// x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test (x1)) {
		x1 = x1.replace (rgx, '$1' + ',' + '$2');
	}

	document.getElementById (clientID).value = x1 + x2;
	return true;
}

function addCommasDeci (clientID) {
	// alert("Test " + clientID);
	removeCommasUni (clientID);
	var nStr = document.getElementById (clientID).value;
	nStr += '';
	x = nStr.split ('.');
	if (!x[0]) {
		x[0] = "0";
	}
	x1 = x[0];
	if (!x[1]) {
		x[1] = "00";
	}
	x2 = x.length > 1 ? '.' + x[1] : '';
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test (x1)) {
		x1 = x1.replace (rgx, '$1' + ',' + '$2');
	}

	document.getElementById (clientID).value = x1 + x2;
	return true;
}

function removeCommasUni (clientID) {
	var nStr = document.getElementById (clientID).value;
	nStr = nStr.replace (/,/g, '');
	document.getElementById (clientID).value = nStr;

	// $(clientID).select();

	return true;
}

function multiplyDecimal (evt, clientID) {
	var theEvent = evt || window.event;
	var key = theEvent.keyCode || theEvent.which;
	key = String.fromCharCode (key);
	if (key == 'k' || key == 'K' || key == 'm' || key == 'M') {
		var nStr = document.getElementById (clientID).value;
		nStr = nStr.replace (/,/g, '');
		x = nStr.split ('.');
		if (!x[0]) {
			x[0] = "0";
		}
		x1 = x[0];
		if (!x[1]) {
			x[1] = "00";
		}
		x2 = x.length > 1 ? '.' + x[1] : '';
		var amt = 0;
		var newAmt = 0;
		var newAmtStr = "";
		if (nStr != '') {
			amt = parseInt (nStr);
			if (key == 'k' || key == 'K') newAmt = amt * 1000;
			if (key == 'm' || key == 'M') newAmt = amt * 1000000;
			newAmtStr = newAmt.toString ().replace (/\B(?=(\d{3})+(?!\d))/g, ",");
			document.getElementById (clientID).value = newAmtStr + x2;
		}
	}
	var regex = /[0-9]|\./;
	if (!regex.test (key)) {
		theEvent.returnValue = false;
		if (theEvent.preventDefault) theEvent.preventDefault ();
	}
}

/*
 * function timer(count) { var sec = 59; var sum = "";
 * 
 * if(count >= 0) { if(sec >= 0) { return sum += count + ":" + sec; sec--; } } }
 */

function startTimer (totalDuration, display) {
	var seconds = totalDuration;
	function secondPassed () {
		var minutes = Math.round ((seconds - 30) / 60);
		var remainingSeconds = seconds % 60;

		if (remainingSeconds < 10) {
			remainingSeconds = "0" + remainingSeconds;
		}

		if (minutes < 10) {
			minutes = "0" + minutes;
		}

		display.textContent = minutes + ":" + remainingSeconds;
		if (seconds == 0) {
			/* clearInterval("countdownTimer"); */
			display.textContent = "00:00";
		} else
			seconds--;
	}
	;
	timer ();
	setInterval ('timer()', 1000);
}

function FuncDeciPoint (e, obj) {
	/*
	 * var x = document.getElementById(obj);
	 * 
	 * var result2 = true;
	 * 
	 * if(result2) { if(parseFloat(x.value) >= 1000.000) { x.value =
	 * x.value.substring(0, x.value.length-1); return false; }
	 * if(parseFloat(x.value) <= -100.000) { x.value = x.value.substring(0,
	 * x.value.length-1); return false; }
	 * 
	 * var regex = /\.$/g; var result = regex.test(String(x.value)); if(result) {
	 * if(String(x.value).substring(1,2) == ".") {
	 * document.getElementById(obj).maxLength = 5; } else
	 * if(String(x.value).substring(2,3) == ".") {
	 * document.getElementById(obj).maxLength = 6; } else {
	 * document.getElementById(obj).maxLength = 7; } } } else { x.value =
	 * x.value.substring(0, x.value.length-1); }
	 */

	var x = document.getElementById (obj);
	var result = false;
	var regex = /^-/g;
	var regex2 = /[A-z]/g;
	var regex3 = /[!$%^&*()_+|~=`{}\[\]@#:";'<>?,\/]/g;

	if (regex.test (x.value)) result = true;

	if (result) {
		var y = String (x.value).search (regex2);
		if (y >= 0) {
			if (y == 0)
				x.value = x.value.substring (1, x.value.length);
			else
				x.value = x.value.substring (0, y) + x.value.substring (y + 1, x.value.length);
		} else {
			var z = String (x.value).search (regex3);
			if (z >= 0) {
				if (z == 0)
					x.value = x.value.substring (1, x.value.length);
				else
					x.value = x.value.substring (0, z) + x.value.substring (z + 1, x.value.length);
			}
		}
	} else {
		var y = String (x.value).search (regex2);
		if (y >= 0) {
			if (y == 0)
				x.value = x.value.substring (1, x.value.length);
			else
				x.value = x.value.substring (0, y) + x.value.substring (y + 1, x.value.length);
		} else {
			var z = String (x.value).search (regex3);
			if (z >= 0) {
				if (z == 0)
					x.value = x.value.substring (1, x.value.length);
				else
					x.value = x.value.substring (0, z) + x.value.substring (z + 1, x.value.length);
			}
		}
	}

	if (parseFloat (x.value) >= 1000.000) {
		x.value = x.value.substring (0, x.value.length - 1);
		return false;
	} else if (parseFloat (x.value) <= -100.000) {
		x.value = x.value.substring (0, x.value.length - 1);
		return false;
	} else {
		var str;
		if (x.value.indexOf ('.') > 0) {
			str = String (x.value).split (".");
			if (str[1].length > 3) {
				str[1] = str[1].substring (0, 3);
				var sring = str[0] + "." + str[1];
				x.value = sring;
			}
		}
	}
}

function LotDeci (obj) {
	var x = document.getElementById (obj);
	var regex2 = /[A-z]/g;
	var regex3 = /[!$%^&*()_+|~=`{}\[\]@#:";'<>?.,\/]/g;
	
	if(regex2.test(x.value))
		x.value = x.value.substring(0, x.value.length-1);
	if(regex3.test(x.value))
		x.value = x.value.substring(0, x.value.length-1);
}