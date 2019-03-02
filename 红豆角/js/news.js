var newsPage = {
    changeDate:function(tm){
    	if(tm<10000000000){
            tm = tm*1000;
        }
        var tt = new Date(parseInt(tm));
        var y = tt.getFullYear();
        var m = tt.getMonth() + 1;
        m = m<10?"0"+m:m;
        var d = tt.getDate();
        d = d<10?"0"+d:d;
        var h = tt.getHours();
        h = h<10?"0"+h:h;
        var f = tt.getMinutes();
        f = f<10?"0"+f:f;
        var s = tt.getSeconds();
        s = s<10?"0"+s:s;
        return y + "-" + m + "-" + d + " " + h + ":" + m + ":" + s;
    }
}
$(function(){
    $(".timeChange").each(function(){
    	$(this).html(newsPage.changeDate($(this).html()));
    })
    var pageItem = initPageArray(6,newsList.pageIndex,newsList.countNum);
    var pageButtons = "";
    for(var i=0;i<pageItem.length;i++){
    	var pageButton = '<li ';
    	if(pageItem[i].isActive){
    		pageButton += 'class="active" ';
    	}else if(pageItem[i].isHidden){
    		pageButton += 'class="page_hide" ';
    	}
    	pageButton += '>'+pageItem[i].count+'</li>';
    	pageButtons += pageButton;
    }
    $("#pageContainer").html(pageButtons);
    $("#pageContainer li:not('.page_hide')").click(function(){
    	location.href="newsList?type="+type+"&pageIndex="+(+$(this).html());
    });
})

function initPageArray(pageSize,currentPage,countNum){
	var pageArray = [];
	//页数
	var pagesCount = Math.ceil(countNum/pageSize);
	if(pagesCount<=8){
		for(var i=1;i<=pagesCount;i++){
			var pageItem = {};
			pageItem.count = i;
			pageItem.isActive = (currentPage == pageItem.count);
			pageItem.isHidden = false;
			pageArray.push(pageItem);
		}
		return pageArray;
	}else if(currentPage<=3){
		for(var i=1;i<=5;i++){
			var pageItem = {};
			pageItem.count = i;
			pageItem.isActive = (currentPage == i);
			pageItem.isHidden = false;
			pageArray.push(pageItem);
		}
		var pageItem = {};
		pageItem.count = '';
		pageItem.isActive = false;
		pageItem.isHidden = true;
		pageArray.push(pageItem);
		for(var i=1;i>=0;i--){
			var pageItem = {};
			pageItem.count = pagesCount-i;
			pageItem.isActive = false;
			pageItem.isHidden = false;
			pageArray.push(pageItem);
		}
		return pageArray;
	}else{
		if(currentPage == 4){
			var pageItem = {};
			pageItem.count = 1;
			pageItem.isActive = false;
			pageItem.isHidden = false;
			pageArray.push(pageItem);
		}else if(currentPage >4){
			var pageItem = {};
			pageItem.count = 1;
			pageItem.isActive = false;
			pageItem.isHidden = false;
			var pageItem1 = {};
			pageItem1.count = "";
			pageItem1.isActive = false;
			pageItem1.isHidden = true;
			pageArray.push(pageItem);
			pageArray.push(pageItem1);
		}
		for(var i=1;i<=5;i++){
			var pageItem = {};
			if(currentPage-3+i > pagesCount){
				break;
			}
			pageItem.count = currentPage-3+i;
			pageItem.isActive = (currentPage == pageItem.count);
			pageItem.isHidden = false;
			pageArray.push(pageItem);
		}
		if(currentPage+2 < pagesCount-3){
			//有隐藏
			var pageItem = {};
			pageItem.count = '';
			pageItem.isActive = false;
			pageItem.isHidden = true;
			pageArray.push(pageItem);
			for(var i=1;i>=0;i--){
				var pageItem = {};
				pageItem.count = pagesCount-i;
				pageItem.isActive = false;
				pageItem.isHidden = false;
				pageArray.push(pageItem);
			}
			return pageArray;
		}else{
			for(var i=currentPage+3;i<=pagesCount;i++){
				console.log(currentPage);
				var pageItem = {};
				pageItem.count = i;
				pageItem.isActive =  (currentPage == pageItem.count);
				pageItem.isHidden = false;
				pageArray.push(pageItem);
			}
			return pageArray;
		}
	}
}