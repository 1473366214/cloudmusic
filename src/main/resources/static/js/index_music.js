let pageNum=1;
let pageSize=10;
let pages=1;
let locations="";
let category="";
$(document).ready(function () {
    getMusicList(pageNum,pageSize,locations,category);
    $("#ca_all").addClass("musicLiSelected");
    $("#lo_all").addClass("musicLiSelected");
    $(window.parent.$("#my-iframe")).attr("height","595px");
    $(window.parent.gdClick("#index_music"));
});
//音乐列表
function getMusicList(n1,n2,n3,n4) {
    let Data={};
    if(n3===""&&n4===""){
        Data={"pageNum":n1,"pageSize":n2};
    }else if(n3!==""&&n4===""){
        Data={"pageNum":n1,"pageSize":n2,"location":n3};
    }else if(n3===""&&n4!==""){
        Data={"pageNum":n1,"pageSize":n2,"category":n4};
    }else if(n3!==""&&n4!==""){
        Data={"pageNum":n1,"pageSize":n2,"location":n3,"category":n4};
    }
    $.ajax({
        type:"GET",
        url:"/music/getAllMusic",
        data:Data,
        success:function (data) {
            pageNum=data.pageNum;
            pages=data.pages;
            generalHtml(data.list);
        },error:function (data) {
            console.log(data);
        }
    });
}
//生成音乐列表HTML
function generalHtml(data) {
    $(".music_item").remove();
    for(let i=0;i<data.length;i++){
        let html='<div class="music_item">' +
            '                    <img src="'+data[i].cover+'" id="music'+data[i].musicid+'" class="musicList">' +
            '                    <div>'+data[i].name+'</div>' +
            '                </div>';
        $("#musicListBlock").append(html);
    }
}
//下一页
$("#nextPage").click(function () {
    if(pageNum===pages){
        alert("这是最后一页");
    }else{
        pageNum=pageNum+1;
        getMusicList(pageNum,pageSize,locations,category);
    }
});
//上一页
$("#lastPage").click(function () {
    if(pageNum===1){
        alert("这是第一页");
    }else{
        pageNum=pageNum-1;
        getMusicList(pageNum,pageSize,locations,category);
    }
});
//歌曲点击
$("#musicListBlock").on("click",".musicList",function () {
    let id=this.id.substring(5);
    top.location.href="/music/musicPlay/"+id;
});
//点击分类
$(".musicLi").click(function () {
    let id=this.id;
    let cls=id.substring(0,2);
    id=id.substring(3);
    if(cls==="lo"){
        if(id==="all")
            locations="";
        else
            locations=id;
    }else if (cls==="ca"){
        if(id==="all")
            category="";
        else
            category=id;
    }
    pageNum=1;
    getMusicList(pageNum,pageSize,locations,category);
});
$(".ca").click(function () {
    let id=this.id;
    $(".ca").removeClass("musicLiSelected");
    $("#"+id).addClass("musicLiSelected");
});
$(".lo").click(function () {
    let id=this.id;
    $(".lo").removeClass("musicLiSelected");
    $("#"+id).addClass("musicLiSelected");
});