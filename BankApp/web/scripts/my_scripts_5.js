$(document).ready(function() {
	var headClix = 0, eyesClix = 0, noseClix = 0, mouthClix = 0;
	lightning_one();
	lightning_two();
	lightning_three();

	$("#head").click(function() {

		if (headClix < 9) {
			$(this).animate({left:"-=367px"},500);
			headClix += 1;
		} else {
			$(this).animate({left:"0px"},500);
			headClix = 0;
		}
	});
	$("#eyes").click(function() {

		if (eyesClix < 9) {
			$(this).animate({left:"-=367px"},500);
			eyesClix += 1;
		} else {
			$(this).animate({left:"0px"},500);
			eyesClix = 0;
		}
	});
	$("#nose").click(function() {

		if (noseClix < 9) {
			$(this).animate({left:"-=367px"},500);
			noseClix += 1;
		} else {
			$(this).animate({left:"0px"},500);
			noseClix = 0;
		}
	});
	$("#mouth").click(function() {

		if (mouthClix < 9) {
			$(this).animate({left:"-=367px"},500);
			mouthClix += 1;
		} else {
			$(this).animate({left:"0px"},500);
			mouthClix = 0;
		}
	});

});

function lightning_one(){
	$("#container #lightning1").fadeIn(250).fadeOut(250);
	setTimeout("lightning_one()",4000);
};

function lightning_two(){
	$("#container #lightning2").fadeIn("fast").fadeOut("fast");
	setTimeout("lightning_two()",5000);
};

function lightning_three(){
	$("#container #lightning3").fadeIn("fast").fadeOut("fast");
	setTimeout("lightning_three()",7000);
};