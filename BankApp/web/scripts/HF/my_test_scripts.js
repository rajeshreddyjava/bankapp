$(document).ready(function() {
	$("#btn1").click(function() {
		$("#header").addClass("hover");
		$("#header").removeClass("no_hover");
	});
	$("#btn2").click(function() {
		$("#header").removeClass("hover");
		$("#header").addClass("no_hover");
	});
});