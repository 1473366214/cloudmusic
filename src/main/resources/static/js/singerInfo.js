<!--导航栏-->
$(".g").click(function () {
    let ids='/index/'+this.id;
    window.location.href=ids;
});
$("#index_home").click(function () {
    window.location.href="/index/otherHome";
});
//播放按钮hover
$(".icons").hover(function () {
    let id=this.id;
    let icon = $("#"+id);
    icon.removeClass("fa-play-circle-o");
    icon.addClass("fa-play-circle");
},function () {
    let id=this.id;
    let icon = $("#"+id);
    icon.removeClass("fa-play-circle");
    icon.addClass("fa-play-circle-o");
});
//歌手的歌曲
function getMusicBySingerId(id) {
    $.ajax({
        type:"GET",
        url:"/music/getMusicBySingerId",
        data:{"singerId":id},
        success:function (data) {
            for(let i=0;i<data.length;i++){
                generalMusicList(data[i]);
            }
        },error:function (data) {
            console.log(data);
        }
    });
}
//生成html
function generalMusicList(data){
    let html="<li>" +
        "          <div class=\"listInfo\">"+data.name+"</div>" +
        "          <div class=\"listInfo\">"+data.albumname+"</div>" +
        "          <div class=\"listInfo\"><i class=\"fa fa-play-circle-o icons\" id=\"music"+data.musicid+"\"></i></div>" +
        "    </li>";
    $("#listUl").append(html).append(html);
}