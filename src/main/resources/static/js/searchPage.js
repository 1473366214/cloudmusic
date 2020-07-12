let pageSize=10;
//点击图片
$(".music").click(function () {
    let id=this.id.substring(5);
    window.location.href="/music/musicPlay/"+id;
});
//上一页
$("#lastPage").click(function () {
    if((pageNum-1)===0){
        alert("这已经是第一页了");
    }else {
        pageNum-=1;
        getMusicPage();
    }
});
//下一页
$("#nextPage").click(function () {
    if ((pageNum+1)>pages){
        alert("这已经是最后一页了");
    }else {
        pageNum+=1;
        getMusicPage();
    }
});
function getMusicPage() {
    $.ajax({
        type:"GET",
        url:"/music/searchMusicPage",
        data:{"pageNum":pageNum,"pageSize":pageSize,"key":key},
        success:function (data) {
            pageNum=data.pageNum;
            generalHtml(data.list);
        },error:function (data) {
            console.log(data);
        }
    });
}
//生成列表html
function generalHtml(data) {
    $(".music_item").remove();
    let box=$("#searchMusicPage");
    for (let i=0;i<data.length;i++){
        let html='<div class="music_item">\n' +
            '                        <img class="music" id="music'+data[i].musicid+'" src="'+data[i].cover+'">\n' +
            '                        <div>'+data[i].name+'</div>\n' +
            '                    </div>';
        box.append(html);
    }
}

<!--导航栏-->
$(".g").click(function () {
    let ids='/index/'+this.id;
    window.location.href=ids;
});
$("#index_home").click(function () {
    window.location.href="/index/otherHome";
});