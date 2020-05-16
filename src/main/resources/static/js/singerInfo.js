//播放按钮hover
let listUl=$("#listUl");
listUl.on("mouseenter",".icons",function () {
    let id="#"+this.id;
    $(id).removeClass("fa-play-circle-o");
    $(id).addClass("fa-play-circle");
});
listUl.on("mouseleave",".icons",function () {
    let id="#"+this.id;
    $(id).removeClass("fa-play-circle");
    $(id).addClass("fa-play-circle-o");
});
//播放按钮点击
listUl.on("click",".icons",function () {
    let id=this.id.substring(5);
    window.location.href="/music/musicPlay/"+id;
})
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
        "          <div class=\"listInfo\"><i class=\"fa fa-play-circle-o icons\" style=\"font-size: 26px;\" id=\"music"+data.musicid+"\"></i></div>" +
        "    </li>";
    $("#listUl").append(html);
}