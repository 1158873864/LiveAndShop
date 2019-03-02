$(function () {
  var arr = [
    {
      "width": "14%",
      "height": 370,
      "bottom": 0,
      "left": 0,
      "opacity": 0.5,
      "zIndex": 2,
      "margin-left":0
    },
    {
      "width": "14%",
      "height": 370,
      "bottom": 0,
      "left": 0,
      "opacity": 0.5,
      "zIndex": 2,
      "margin-left":0
    },{
      "width": "70%",
      "height": 450,
      "bottom": 0,
      "left": "50%",
      "margin-left":"-35%",
      "opacity": 1,
      "zIndex": 4
    },{
      "width": "14%",
      "height": 370,
      "bottom": 0,
      "left": "86%",
      "opacity": .5,
      "zIndex": 3,
      "margin-left":0
    },{
      "width": "14%",
      "height": 370,
      "bottom": 0,
      "left": "86%",
      "opacity": .5,
      "zIndex": 3,
      "margin-left":0
    }
  ];
  var lis = $('#div-box>figure')
  var wrap = $('#div-box')[0]
  var title = $('.index_block_2 .small_font_size>p.h1>span')
  var address = $('.index_block_2 .small_font_size>p.h3')
  var $timer = null
  for(var i = 0; i < lis.length; i++) {
    $(lis[i]).animate(arr[i]);
  }
  var lock = true;
  var ste = 2
  function start_move() {
    if(lock){
      lock = false;
      for (let j = 0; j < $('#indictor button').length; j++) {
        $('#indictor button')[j].className = ''
      }
      if (ste == 4) {
        ste = 0
      } else {
        ste++
      }
      if (ste == 0) {
        title.html('中国(赣州)第五届家居产业博览会')
        address.html('地址：赣州市南康区家居特色小镇')
      } else if (ste == 1) {
        title.html('集设计、制造于一体的大型实木家具品牌厂家。')
        address.html('地址：赣州市南康区工业大道南康国际家具城中心市场3层')
      }else if (ste == 2) {
        title.html('被誉为“设计师之家”的家具设计中心。')
        address.html('地址：赣州市南康区工业大道鸿泰产业园')
      }else if (ste == 3) {
        title.html('专业设计、生产高档橡木套房系列家具的企业。')
        address.html('地址：赣州市南康区工业大道南康国际家具城中心市场3层')
      }else if (ste == 4) {
        title.html('以人为本的设计理念，追求品质、功能及美学的和谐统一。')
        address.html('地址：赣州市南康区工业大道南康国际家具博览中心2层')
      }
      $('#indictor button')[ste].className = 'active'
      //把最后一个放到第一个
      arr.unshift(arr.pop());
      for (var i = 0; i < lis.length; i++) {
        $(lis[i]).animate(arr[i], function () {
          lock = true;
        });
      }
    }
  }
  $timer = setInterval(start_move, 5000);
  wrap.addEventListener("mouseover", function () {
    clearInterval($timer)
  });
  wrap.addEventListener("mouseout", function () {
    $timer = setInterval(start_move, 5000);
  });
  function swapArray(arr, index1, index2) {
    arr[index1] = arr.splice(index2, 1, arr[index1])[0];
    return arr;
  }
  $('#indictor button').hover(function (e) {
    clearInterval($timer);
    $(e.currentTarget).addClass('active').siblings().removeClass('active');
    index = $(e.currentTarget).index();
    ste = index
    if (ste == 0) {
      title.html('中国(赣州)第五届家居产业博览会')
      address.html('地址：赣州市南康区家居特色小镇')
    } else if (ste == 1) {
      title.html('集设计、制造于一体的大型实木家具品牌厂家。')
      address.html('地址：赣州市南康区工业大道南康国际家具城中心市场3层')
    }else if (ste == 2) {
      title.html('被誉为“设计师之家”的家具设计中心。')
      address.html('地址：赣州市南康区工业大道鸿泰产业园')
    }else if (ste == 3) {
      title.html('专业设计、生产高档橡木套房系列家具的企业。')
      address.html('地址：赣州市南康区工业大道南康国际家具城中心市场3层')
    }else if (ste == 4) {
      title.html('以人为本的设计理念，追求品质、功能及美学的和谐统一。')
      address.html('地址：赣州市南康区工业大道南康国际家具博览中心2层')
    }
    for (let j = 0; j < lis.length; j++) {
      if (lis[j].style.zIndex == 4) {
        arr = swapArray(arr, j, index)
        for (var i = 0; i < lis.length; i++) {
          $(lis[i]).animate(arr[i],function () {
            //回调函数：动画结束后执行。
            lock = true;
          });
        }
      }
    }
  }, function () {
    $timer=setInterval(start_move,5000);
  });
})