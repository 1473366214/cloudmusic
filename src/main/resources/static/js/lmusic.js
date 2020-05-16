/**
 * create by lukez 
 * @version 0.01
 */
var Lmusic = function(option){

	//创建dom
	(function(){
		var html = '<div id="lmusic">'
				+'<audio id="lmusic-core"></audio>'
				+'<div id="lmusic-cover">'
					+'<img src="/an.png" alt="">'
				+'</div>'

				+'<div style="height: 10%"></div>'

				+'<div id="lmusic-operate">'
					+'<h2 id="lmusic-name">Red Lights (Radio Edit)</h2>'
					+'<div id="lmusic-control">'
			            +'<i id="lmusic-control-prev" class="fa fa-backward" style="font-size: 24px"></i>&nbsp;'
			            +'<i id="lmusic-control-play" class="fa fa-play" style="font-size: 24px"></i>&nbsp;'
			            +'<i id="lmusic-control-next" class="fa fa-forward" style="font-size: 24px"></i>&nbsp;'
			            +'<div id="lmusic-vol">'
			            	+'<div style="width: 10%">'
			            		+'<i id="lmusic-vol-icon" class="fa fa-volume-up" ></i>'
			            	+'</div>'
			            	+'<div style="width:50%;height: 20%"></div>'
			              	+'<div class="lmusic-progress">'
			                	+'<div class="lmusic-progress-load" style="width: 50%"></div>'
			              	+'</div>'
			            +'</div>'
					+'</div>'
					+'<div id="lmusic-play-progress">'
						+'<div class="lmusic-progress" style="position: relative;">'
			            	+'<div class="lmusic-progress-load" style="width: 50%"></div>'
							+'<i class="fa fa-dot-circle-o lmusic-progress-btn" aria-hidden="true"></i>'
			          	+'</div>'
					+'</div>'
				+'</div>'
			+'</div>';
		$(option.container).append(html);
	})();


	var Core = (function(){

		var dom = document.getElementById('lmusic-core');

		var that = {

			dom : dom,

			isPlay : false,

			vol : 0.5,

			progress : 0,

			progId : null,

			play : function(){
				that.dom.play();
				that.isPlay = true;
				that.progId = setInterval(that.curProgress,100);
			},	

			pause : function(){
				that.dom.pause();
				that.isPlay = false;
				clearInterval(that.progId);
			},

			stop : function(){
				that.dom.load();
				that.isPlay = false;
				clearInterval(that.progId);
			},

			curProgress : function(){
				that.progress = that.dom.currentTime / that.dom.duration * 100;
			},

			setSrc : function(src){
				that.dom.src = src;
			},

			//var vol : 0 ~ 1
			setVol : function(vol){
				that.dom.volume = parseFloat(vol);
				that.vol = that.dom.volume;
				//console.log(that.vol);
			},

			//var progress 0 ~ 100
			setProgress : function(progress){
				//总秒数
				var size = that.dom.duration;
				//百分比每段秒数
				var section = size/100;
				that.dom.currentTime = parseFloat(progress) * section; 
				that.progress = parseFloat(progress);
				//console.log(that.progress);
			},
		}

		that.setVol(that.vol);

		return that;
	})();


	var that = {};

	that.source = option.source;

	that.current = 1;

	that.dom = {

		container : '#lmusic',

		cover : '#lmusic-cover',

		name : '#lmusic-name',

		operate : '#lmusic-operate',

		play : '#lmusic-control-play',

		prev : '#lmusic-control-prev',

		next : '#lmusic-control-next',

		vol : '#lmusic-vol .lmusic-progress',

		vol_load : '#lmusic-vol .lmusic-progress-load',

		vol_icon : '#lmusic-vol-icon',

		progress : '#lmusic-play-progress .lmusic-progress',

		progress_load : '#lmusic-play-progress .lmusic-progress-load',

		progress_load_btn : '#lmusic-play-progress .lmusic-progress-btn',

	};

	that.progId = null;

	that.playAndPause = function(){
		if (Core.isPlay) {
			that.pause();
		}else{
			that.play();
		}
	}

	that.play = function(){
		$(that.dom.play).removeClass('fa fa-play').addClass('fa fa-pause');
		Core.play();
		that.progId = setInterval(function(){
			if (Core.progress >= 100) {
				that.next();
			}
			PlayerShow.cProgress();
		},100);
	}

	that.pause = function(){
		$(that.dom.play).removeClass('fa fa-pause').addClass('fa fa-play');
		Core.pause();
		clearInterval(that.progId);
	}

	that.next = function(){
		if (that.current == that.source.length) {
			that.current = 0;
		}
		var i = ++that.current;
		that.domFill(i);
		that.play();
	}

	that.prev = function(){
		if (that.current == 1) {
			that.current = that.source.length + 1;
		}
		var i = --that.current;
		that.domFill(i);
		that.play();
	}

	that.vol = function(event){
		var x = event.OffsetX || event.layerX;  
		var allWidth = $(that.dom.vol).width();
		var vol = x/allWidth;
		Core.setVol(vol);
		PlayerShow.cVol();
	}

	that.progress = function(event){
		var x = event.OffsetX || event.layerX;  
		var allWidth = $(that.dom.progress).width();
		var prog = x/(allWidth/100);
		Core.setProgress(prog);
		PlayerShow.cProgress();
	}

	that.volOnAndOff = function(){
		if (Core.vol > 0) {
			that.volOff();
		}else{
			that.volOn();
		}
	}

	that.volOff = function(){
		$(that.dom.vol_icon).removeClass('fa fa-volume-up').addClass('fa-volume-off');
		Core.setVol(0.0);
		PlayerShow.cVol();
	}

	that.volOn = function(){
		$(that.dom.vol_icon).removeClass('fa fa-volume-off').addClass('fa-volume-up');
		Core.setVol(0.5);
		PlayerShow.cVol();
	}

	//dom处的信息 填充更改 var i 第几首
	that.domFill = function(i){
		if (i > that.source.length || i < 1) {
			i = 1;
		}
		var info = that.source[i-1];

		$(that.dom.cover).find('img').attr('src',info.cover);
		$(that.dom.name).text(info.name);
		Core.setSrc(info.url);
	}

	that.domBind = function(){
		var dom = that.dom;
		$(dom.prev).click(that.prev);
		$(dom.play).click(that.playAndPause);
		$(dom.next).click(that.next);
		$(dom.vol_icon).click(that.volOnAndOff);
		//为了使用原生event
		document.querySelector(dom.vol).onclick = that.vol;
		document.querySelector(dom.progress).onclick = that.progress;
	}

	that.init = function(){

		that.domFill(that.current);
		that.domBind();

		return that;
	}


	var PlayerShow = (function(player){

		var C = {
			coverMax : 0.25,
			defaultH : 150,
		};

		var that = {

			cSize : function(){

				//存在宽度 则固定长宽
				if (option.width) {
					var height = option.width*C.coverMax;
					$(player.dom.container).width(option.width);
				}else{	
					//否则 固定高度 宽度默认100% （优先选择配置的高度）
					var height = option.height || $(option.container).height() || C.defaultH;
				}
				$(player.dom.container).height(height);
				$(player.dom.container).css('font-size',height+'px');
			},

			cProgress : function(){
				var cur = Core.progress/100 * $(player.dom.progress).width();
				$(player.dom.progress_load).width(cur);
				$(player.dom.progress_load_btn).css('left',cur-2);
			},

			cVol : function(){
				var allWidth = $(player.dom.vol).width()
				var cur = Core.vol * $(player.dom.vol).width();
				$(player.dom.vol_load).width(cur);
			},

			/**
			 * 调整容器最小宽度
			 */
			cMinWidth : function(){
				var coverWidth = $(player.dom.cover).width();
				$(player.dom.container).css('min-width',coverWidth/C.coverMax+'px');
			},

			cCover : function(){
				var height = $(player.dom.container).height();
				$(player.dom.cover).width(height);
			},

			cOperate : function(){
				var allWidht = $(player.dom.container).width();
				var coverWidth = $(player.dom.cover).width();

				$(player.dom.operate).width(allWidht - coverWidth);

			},
			init : function(){
				// that.create();
				that.cSize();
				that.cCover();
				that.cMinWidth();
				that.cOperate();
				that.cProgress();
				that.cVol();
			}
		};

		that.init();

		return that;
	})(that);

	window.onresize = function(){
		PlayerShow.cCover();
		PlayerShow.cOperate();	
		PlayerShow.cProgress();
		PlayerShow.cVol();	
	};
	return that;
}

$.fn.extend({
    lmusic: function (option) {
    	option.container = this;
    	// console.log(option);
    	var myMusic = Lmusic(option);
    	return myMusic;
    }
});




// 示例代码

// var source = [
// 		{
// 			url : 'red.mp3',
// 			cover : 'http://p4.music.126.net/Z7JNUkL5cjZETD232S510w==/2540971372183769.jpg',
// 			name : 'Red Lights (Radio Edit)',
// 		},
// 		{
// 			url : 'avicii.flac',
// 			cover : 'http://p3.music.126.net/YyPaRiqjA2UFz-T3IXuXbw==/1308418837090130.jpg',
// 			name : 'Avicii - I Could Be the One',
// 		}
// 	];

// var myMusic = Lmusic({
// 	container : '.container',
// 	source : source
// });
// myMusic.init();
