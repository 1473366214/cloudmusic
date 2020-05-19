let pageNum=1;
let pageSize=10;
let pages=1;
$(document).ready(function () {
    getRecommendAlbum();
    getAllAlbum();
});
//推荐专辑
function getRecommendAlbum() {
    $.ajax({
        type:"GET",
        url:"/album/getRecommendAlbum",
        success:function (data) {
            generalAlbum("#index_recommendAlbum",data);
        },error:function (data) {
            console.log(data);
        }
    });
}
//所有专辑
function getAllAlbum() {
    $.ajax({
        type:"GET",
        url:"/album/getAllAlbum",
        data:{"pageNum":pageNum,"pageSize":pageSize},
        success:function (data) {
            pages=data.pages;

            generalAlbum("#index_allAlbum",data.list);
        },error:function (data) {
            console.log(data);
        }
    });
}

function generalAlbum(box,data) {
    let select=$(box);
    select.children().remove();
    for(let i=0;i<data.length;i++){
        let html='<div class="index_item">\n' +
            '                    <img src="'+data[i].cover+'" class="album" id="album'+data[i].albumid+'">\n' +
            '                    <div>'+data[i].name+'</div>\n' +
            '                </div>';
        select.append(html);
    }
}
//点击图片
$(".index_block_cns").on("click",".album",function () {
    let id=this.id.substring(5);
    top.location.href="/album/albumInfo?albumId="+id;
});
//上一页
$("#lastPage").click(function () {
    if(pageNum===1){
        alert("这是第一页");
    }else{
        pageNum=pageNum-1;
        getAllAlbum();
    }
});
//下一页
$("#nextPage").click(function () {
    if(pageNum===pages){
        alert("这是最后一页");
    }else{
        pageNum=pageNum+1;
        getAllAlbum();
    }
});