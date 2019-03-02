	$(window).scroll(function(){
		//获取滚动条滚动的位置
		var top = $(window).scrollTop();
		
		if(top > 100){
			$("img.logo").attr("src","img/common/logo-show.png");
		 	$(".headTop").css({
		 		"position":"fixed",
		 		"background":"#fff",
				"padding":"10px 0 10px 0",
				"box-shadow": "0 1px 6px rgba(0, 0, 0, .1)"
		 	});
		 	$(".headTop ul li").not(".select").children("a,span").css({
		 		"color":"#333",
		 	});
		 	$(".login-reg").css({
		 		"border-color":"#333"
		 	})
		}else{
			$("img.logo").attr("src","img/common/logo.png");
			$(".headTop").css({
				"position":"absolute",
				"background":"transparent",
				"box-shadow": "none"
				});
			$(".headTop ul li").not(".select").children("a,span").css({
		 		"color":"#ffffff",
		 	});
		 	$(".login-reg").css({
		 		"border-color":"#ffffff"
		 	})
		}
	})

	$(function(){
 		$("#nav_pro").parent("li").mouseover(function (){  
            $(".nav_pro_list").show();  
        }).mouseout(function (){  
            $(".nav_pro_list").hide();  
        });
        
        $(".headTop-content ul li a").not(".lr").each(function(){
        	$this = $(this);
        	if(($this[0]).href == String(window.location)){
	     		$this.parents("li").addClass("select").siblings().removeClass("select");
//      		$this.parents("li").find("div dl a").addClass("avsle")
//      		.siblings().removeClass("avsle");
        	}
        })
    })    