// 导航按钮点击
$(".guide").click(function () {
    let id='#'+this.id;
    gdClick(id);
});
gdClick("#index_home");
function gdClick(div){
    $(".guide").removeClass("gdSelect");
    $(div).addClass("gdSelect");
}
<!--导航栏-->
$(".g").click(function () {
    let ids='/index/'+this.id;
    window.location.href=ids;
});
$("#index_home").click(function () {
    window.location.href="/index/otherHome";
});

//高度自适应
let bHeight=($(window).height()-85)+"px";
let bLeft=$(".BLeft");
let bRight=$(".BRight");
bLeft.css("height", bHeight);
bRight.css("height", bHeight);
$(window).resize(function(){
    bHeight=($(window).height()-85)+"px";
    bLeft.css("height", bHeight);
    bRight.css("height", bHeight);
    bRight.css("border-right", "rgb(226, 211, 211) solid 1px");
});

//显示隐藏歌单列表
$(".ALTitle").click(function () {
    let id=this.id;
    let tri=$("#"+id+">i");
    if(id==="CALTitle"){
        $("#CAList").toggle();
    }else if(id==="CltALTitle"){
        $("#CltAList").toggle();
    }
    if(tri.hasClass("fa-caret-right")){
        tri.removeClass("fa-caret-right");
        tri.addClass("fa-caret-down");
    }else if(tri.hasClass("fa-caret-down")){
        tri.removeClass("fa-caret-down");
        tri.addClass("fa-caret-right");
    }
});

// 评论框获得焦点
$("#focusComment").click(function() {
    $("#myCommentText")[0].focus();
});