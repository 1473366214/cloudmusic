let recommendedMusicId=1;
$(document).ready(function () {
    getRecommendedMusic();
    index_music_play();
    $(window.parent.$("#my-iframe")).attr("height","1880px");
});
//获取推荐音乐
function getRecommendedMusic(){
    $.ajax({
        type:"GET",
        data:{"songlistid":recommendedMusicId},
        url:"/music/getMusicFormSongList.do",
        success:function (data) {
            fillBox("#index_block_cns_music","'index_item index_index_music'",data);
        },error:function (data) {
            alert("connect error");
        }
    });
}
function index_music_play(){
    let item=$("#index_block_cns_music");
    item.on("click",".index_index_music",null,function () {
        top.location.href="music/musicPlay/"+this.id;
        //frame.attr("src","music/musicPlay/"+this.id);
        //frame.height("500px");
    });
}
/* 轮播图*/
/*定义位置：由于图片个数与下侧顺序按钮数量一致，可通过位置进行关联*/
var index=1;
/*当鼠标放到顺序按钮上时：
1.将当前这个顺序按钮增加样式为红色背景
2.移除周围其他同级元素红色背景样式
3.获取当前顺序按钮的index
4.通过index获取该位置图片
5.一秒钟渐入该图片
6.一秒钟渐出其他相邻图片
7.防止移动过快导致的效果闪现，使用stop方法
*/

/*设置每一秒钟自动轮播：
1.获取当前位置序号：自加操作；当超过图片最大序号时序号设置为0
2.设置下侧顺序按钮及轮播图显示
*/
var time=setInterval(move,4000);
function move() {
   index++;
   if (index==2){
       index=0
   }
   $(".lunbo_page li").eq(index).addClass("current").siblings().removeClass("current");
   $(".lunbotu li").eq(index).stop().fadeIn(500).siblings().stop().fadeOut(500);
};
/*当鼠标划入、划出轮播图区域时：
1.划入时停止自动轮播
2.划出时继续自动轮播
*/
$("#index_cns1_right").hover(function () {
   clearInterval(time);
},
function () {
   time=setInterval(move,4000);
});