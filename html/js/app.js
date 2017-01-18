$(function(){
	var index = 100;
	$(".container .app").mousedown(function (event) {
		$(this).css("z-index", index++);
	});

	$(".container .app .head").mousedown(function (event) {
		var app = $(this).parents(".app");
		var isMove = true;  
		var abs_x = event.pageX - app.offset().left;  
		var abs_y = event.pageY - app.offset().top;  
		$(document).mousemove(function (event) {  
			if (isMove) {
				app.css({'left':event.pageX - abs_x, 'top':event.pageY - abs_y});  
			}  
		}).mouseup(  
			function () {  
				isMove = false;  
			}  
		);
	});

	$(".container .app .head .operate .close").click(function(event){
		//console.log("close");
		//console.log($(this).parents(".app"));
		$(this).parents(".app").remove();
	});

	function setTime(){
		var date = new Date();
		var min = date.getMinutes();
		if(min < 10) min = "0" + min;
		var sec = date.getSeconds();
		if(sec < 10) sec = "0" + sec;
		$(".bar-time").text(date.getHours() + ":" + min + ":" + sec);
		$(".bar-date").text(date.getFullYear() + "年" + (date.getMonth() + 1) + "月" + date.getDate() + "日");
		setTimeout(setTime, 1000);
	}
	setTime();
	
	$(".os-bar .start i").click(function(event){
		$(".start-menu").slideToggle(function(){
			if($(".start-menu").css("display") != "none"){
				$(".os-bar .start").addClass("active");
			} else {
				$(".os-bar .start").removeClass("active");
			}
		});
	});
});