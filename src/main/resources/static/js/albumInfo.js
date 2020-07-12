let icon=$(".icons");
icon.hover(function () {
    // over
    let id=this.id;
    id="#"+id;
    $(id).removeClass("fa-play-circle-o");
    $(id).addClass("fa-play-circle");
}, function () {
    // out
    let id=this.id;
    id="#"+id;
    $(id).removeClass("fa-play-circle");
    $(id).addClass("fa-play-circle-o");
}
);
icon.click(function () {
    let id=this.id.substring(5);
    window.location.href="/music/musicPlay/"+id;
});

<!--导航栏-->
$(".g").click(function () {
    let ids='/index/'+this.id;
    window.location.href=ids;
});
$("#index_home").click(function () {
    window.location.href="/index/otherHome";
});