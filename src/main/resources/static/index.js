

$(document).ready(function(){
	
	$("input[value='show/hide']").click(function(){
		$(".a").toggle();
	});
	$("input[value='fade/fadeToogle/fadeTo']").click(function(){
		$(".b").fadeToggle("slow");
	});
	$("input[value='slideUp-Down-Toogle']").click(function(){
		$(".c").slideToggle();
	});
	$("input[value='animate({param},speed,callback)']").click(function(){
		$(".d").animate({
			height: '100px',
			width: '400px'
		}, 2000);
	});
	$("input[value='show/hide']").click(function(){
		$(".a").toggle();
	});
	$("input[value='show/hide']").click(function(){
		$(".a").toggle();
	});
	
	
	
	
});