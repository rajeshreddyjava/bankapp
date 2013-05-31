$(document).ready(function(){
	var $f, $m;
	$("#vegOn").click(function(){
		$f = $(".fish").parent().parent().detach();
		$(".hamburger").replaceWith("<li class='portobello'> <em>Portobello Mushroom</em></li>");
		$(".meat").after("<li class='tofu'> <em>Tofu</em></li>");
		$m = $(".meat").detach();
		$(".tofu").parent().parent().addClass("veg_leaf");
	});
	$("#restoreMe").click(function(){
		
		$(".menu_entrees li").first().before($f);
		$(".portobello").replaceWith("<li class='hamburger'>Hamburger</li>");
		$(".tofu").each(function(i){
			$(this).after($m[i]);
		});
		$(".tofu").remove();
	});
});