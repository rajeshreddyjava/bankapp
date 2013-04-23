$(document).ready(function() {
	$("div.guess_box").click(checkForCode);

	function getRandomNum(num) {
		var discount = Math.floor(Math.random() * num);
		return discount;
	}

	var hide_code = function() {
		var randomNum = getRandomNum(4);
		$(".guess_box").each(function(index, value) {
			if (randomNum == index) {
				$(this).append("<span id='has_discount'></span>");
				return false;
			}
		});

	};

	hide_code();
	function checkForCode() {
		var discount = getRandomNum(100);
		if ($.contains(this, document.getElementById("has_discount"))) {
			discount = "<p>Your code: CODE" + discount + "%</p>";
		} else {
			discount = "<p>Sorry, no discount this time!</p>";
		}
		// alert(discount);

		$(".guess_box").each(function() {
			if ($.contains(this, document.getElementById("has_discount"))) {
				$(this).addClass("discount");
			} else {
				$(this).addClass("no_discount");
			}
			$(this).unbind();
		});
		$("#result").append(discount);
	}

	$(".guess_box").hover(function() {
		$(this).addClass("my_hover");
	}, function() {
		$(this).removeClass("my_hover");
	});
});
